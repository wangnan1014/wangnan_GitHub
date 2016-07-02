$(function (){
 
});

function check(){

    if($.trim($("#ename").val())==''){
        $("#info").text("请填写姓名！").show();
        $("#ename").val("");
        $("#ename").focus();

        return  false;
    }
    if($.trim($("#dname").val())==''){
        $("#info").text("请填写部门！").show();
        $("#dname").val("");
        $("#dname").focus();

        return  false;
    }
    
    return true;
}


 