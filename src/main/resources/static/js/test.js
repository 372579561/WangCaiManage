//ajax外部函数
function SubmitTest() {
    var u = vm.userName; //用户名
    var p = vm.pwd; //密码
    //var c = this.checked; //是否记住用户名
    var params = {"userName":u,"password":p};

    $.ajax({
        type:"post",
        //contentType:"application/json; charset=utf-8",
        url:"/login/login",
        data:params,
        //dataType:"json",
        timeout:3000,
        success:function (msg) {
            console.log(msg.data)
        },
        error:function (msg) {
            console.log(msg.toString());
        }
    });
}
