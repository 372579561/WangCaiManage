//ajax成功回调函数
function fnSuccess(msg) {
    if (msg == "success")
    {
        //用户名和密码正确，可以登录，检查是否勾选“记住用户名”按钮，如果是则调用SaveCookie
        if (vm.checked)
        {
            SaveCookie();
        }
        $('#home')[0].click();
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


function UserBlur(){
    if (vm.ifRegister === true){


    var u = vm.userName;
    var params = {"userName":u};
    $.ajax({
        type:"post",
        url:"/login/register/remote",
        data:params,
        //dataType:"json",
        timeout:3000,
        success:function (msg) {
            if (msg !== "success"){
                //$.validate()
                alert("用户名重复，请重新输入");
                vm.disable = true;
            }
            else{
                vm.disable = false;
                console.log("success_user");
            }

        },
        error:function (msg) {
            console.log(msg.toString());
        }
    });
    }
}

//注册
function Register(){
    vm.userName = "";
    vm.pwd = "";
    vm.checked = false;
    vm.ifRegister = true;
    vm.disable = true;
    vm.RegORLogin = "注册";

}

window.onload = function () {

    window.vm = new Vue({
        el:'#login',
        data:{
            showMes:false,
            userName:"",
            pwd:"",
            pwd2:"",
            checked:false,
            ifRegister:false,
            RegORLogin:"登录",
            disable:false
        },
        methods:{
            submit:function () {
                var u = this.userName; //用户名
                var p = this.pwd; //密码
                var c = this.checked; //是否记住用户名
                var params = {"userName":u,"password":p};
                var url;
                if (this.ifRegister){
                    url = "/login/register";
                }
                else
                {
                    url = "/login/login";
                }

                $.ajax({
                    type:"post",
                    url:url,
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
        url:"/login/login",
        data:params,
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

