//ajax成功回调函数
function fnSuccess(msg) {
    if (msg == "success")
    {
        //用户名和密码正确，可以登录，检查是否勾选“记住用户名”按钮，如果是则调用SaveCookie
        if (vm.checked)
        {
            SaveCookie();
            //window.location.href = "index.html";
            alert("login success");
        }
    }
    else
    {
        vm.showMes = true;
        alert("username or password incorrect");
    }
}

//保存用户名和密码到cookie
function SaveCookie(){
        var str_username = vm.userName;//用户名
        var str_password = vm.pwd;//密码
        $.cookie("rmbUser", "true", { expires: 7 }); //存储一个带7天期限的cookie
        $.cookie("username", str_username, { expires: 7 });
        $.cookie("password", str_password, { expires: 7 });
}

window.onload = function () {

    window.vm = new Vue({
        el:'#login',
        data:{
            showMes:false,
            userName:"",
            pwd:"",
            checked:false
        },
        methods:{
            submit:function () {
                var u = this.userName; //用户名
                var p = this.pwd; //密码
                var c = this.checked; //是否记住用户名
                var params = {"userName":u,"password":p};

                $.ajax({
                    type:"post",
                    url:"/login/login",
                    data:params,
                    timeout:3000,
                    success:function (msg) {
                       fnSuccess(msg);
                    },
                    error:function (msg) {
                        console.log(msg.toString());
                    }
                });
            },
        }
    }) ;

    //自动填充用户名和密码
    if ($.cookie("rmbUser") == "true") {
        vm.userName = $.cookie("username");
        vm.pwd = $.cookie("password");
        vm.checked = true;
    }


}

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
            console.log(msg);
            fnSuccess(msg);
        },
        error:function (msg) {
            console.log(msg.toString());
        }
    });
}

