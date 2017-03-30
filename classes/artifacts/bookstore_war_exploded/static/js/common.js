$(function(){
    $(".delBook").click(function(){
        //删除图书
        var bookName = $(this).parents("tr").find("td:eq(0)").html();
        if(confirm("确定要删除《"+bookName+"》吗？")){
            var href = $(this).attr("href");
            $("#delForm").attr("action",href).submit();
        }
        return false;
    });

    //$("input[type='button']").click(function(){
    //    var pageNumber = $("#pn_input").val();
    //    window.location = "findBook?pageNumber="+pageNumber;
    //});
});

function searchPage(value){
    var pageNumber = $("#pn_input").val();
    window.location =value+"?pageNumber="+pageNumber;
}

//添加购物
$(function(){
    $(".btn").click(function(){
        var url = contextPath+"/cart/addCartItem";
        var bookId =$(this).parents("div").find("input:eq(0)").val();
        $.post(url,{bookId:bookId},function(data){
            alert(data);
        });
    });
});