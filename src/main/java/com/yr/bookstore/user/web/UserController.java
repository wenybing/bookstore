package com.yr.bookstore.user.web;

import com.yr.bookstore.user.bean.User;
import com.yr.bookstore.user.service.IUserService;
import com.yr.bookstore.user.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/12/30.
 */
@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public String regist(User user,HttpServletRequest request){
        /**
         * 获取用户名
         *
         */
        String username = request.getParameter("username");
        /**
         * 获取密码
         */
        String password = request.getParameter("password");
        /**
         * MD5加密密码
         * String algorithmName, Object source, Object salt, int hashIterations
         */
        /**
         * 加密方式
         */
        String algorithmName = "MD5";
        /**
         * 加密的数据源
         */
        Object source = password;
        /**
         * 盐值
         */
        Object salt = ByteSource.Util.bytes(username);
        /**
         * 加密次数
         */
        int hashIterations = 1024;
        String result = new SimpleHash(algorithmName,source,salt,hashIterations).toString();
        user.setPassword(result);
        //获取验证码
        HttpSession session = request.getSession();
        String sessonCode = (String) session.getAttribute("KAPTCHA_SESSION_KEY");
        //移除session
        session.removeAttribute("KAPTCHA_SESSION_KEY");
        System.out.println(sessonCode + "*******************");
        //获取用户输入的session
        String regSession = request.getParameter("code");
       if(regSession != null && regSession.equals(sessonCode)){
           User exist = userServiceImpl.login(user);
           if(exist != null){
               //用户名已存在
               request.setAttribute("msg","用户名已存在！");
               return "pages/user/regist";
           }else{
               userServiceImpl.regist(user);
               return "redirect:jsp/pages/user/regist_success.jsp";
           }
       }else{
           request.setAttribute("msg","验证码错误！");
           return "pages/user/regist";
       }


    }

    /**
     * 登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request){
        /**
         * 获取Subject对象调用SecurityUtils的getSubject()
         */
        Subject currrentUser = SecurityUtils.getSubject();
        /**
         * 2. 测试当前的用户是否已经被认证. 即是否已经登录. 调用 Subject 的 isAuthenticated()
         * 3. 若没有被认证, 则把用户名和密码封装为 UsernamePasswordToken 对象
         */
        //获取session
        HttpSession session =  request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(!currrentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            token.setRememberMe(true);
            try {
                /**
                 * 登录
                 */
                currrentUser.login(token);
            }catch (AuthenticationException ae){
               System.out.println("认证失败"+ae.getMessage());
                request.setAttribute("msg","用户名或密码错误！");
                return "/pages/user/login";
            }
        }

        //登录成功
        session.setAttribute("login",userServiceImpl.getUserByUserName(username));
        return "redirect:jsp/pages/user/login_success.jsp";

//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        User login =userService.login(user);
//        if(login == null){
//            //登录失败
//            request.setAttribute("msg","用户名或密码错误！");
//            return "/pages/user/login";
//        }else{
//            //登录成功
//            session.setAttribute("login",login);
//            return "redirect:jsp/pages/user/login_success.jsp";
//        }

    }
    @RequestMapping(value = "/loginOut",method = RequestMethod.GET)
    public Object loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/book/findClientBook";
    }

}
