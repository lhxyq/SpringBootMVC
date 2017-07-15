<#import "/templates/template/template.ftl" as form />

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>home</title>
    <link rel="stylesheet" type="text/css" href="/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/static/css/common/common.css">
</head>
<body>
<form class="form-horizontal text-center" id="loginForm">
    <div class="login panel panel-primary radius">
        <div class="panel-heading radius">
            <span class="panel-title"><h3>用户登录</h3></span>
        </div>
        <div class="panel-body">
        <@form.text id="name" name="name" label="" labelCss="col-lg-2 control-label" textCss="col-lg-8" componetCss="input-lg" required="required" placeholder="用户名"/>
        <@form.text id="pass" name="pass" type="password" label="" labelCss="col-lg-2 control-label" textCss="col-lg-8" componetCss="input-lg" required="required" placeholder="密码"/>
            <br/>
            <div class="form-group text-left">
                <div class="col-sm-offset-2 col-lg-8">
                    <button type="submit" class="btn btn-info btn-block active btn-lg radius">登录</button>
                </div>
            </div>
            <div class="form-group text-center">
                <div class="col-sm-offset-2 col-lg-8">
                    <button id="register" type="button" class="btn btn-link">还没账户，马上注册</button>
                </div>
            </div>
        </div>
    </div>
</form>

<!-- modal -->
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel">
    <form class="form-horizontal text-center" id="registerForm">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="registerModalLabel">注册账户</h4>
                </div>
                <div class="modal-body">
                <@form.text id="registerName" name="registerName" label="用户名" labelCss="control-label col-lg-2 " textCss="col-lg-8" componetCss="input-lg" required="required" placeholder="用户名"/>
                <@form.text id="registEmail" name="registEmail" type="email" label="邮箱" labelCss="control-label col-lg-2 " textCss="col-lg-8" componetCss="input-lg" required="required" placeholder="邮箱"/>
                <@form.text id="registPass" name="registPass" type="password" label="密码" labelCss="control-label col-lg-2 " textCss="col-lg-8" componetCss="input-lg" required="required" placeholder="密码"/>
                <@form.text id="comfirmPass" name="comfirmPass" type="password" label="确认密码" labelCss="control-label col-lg-2 " textCss="col-lg-8" componetCss="input-lg" required="required" placeholder="确认密码" equalTo="#registPass"/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary" id="registerUser">注册</button>
                </div>
            </div>
        </div>
    </form>
</div>

</body>
<script type="text/javascript" src="/static/js/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/static/js/jquery/jquery.validate.min.js"></script>
<script type="text/javascript" src="/static/js/jquery/messages_zh.js"></script>
<script type="text/javascript" src="/static/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/js/common/common.js"></script>
<script>
    $(document).ready(function () {
        $("#register").click(function () {
            $('#registerModal').modal();
        });

        $("#registerUser").click(function () {
            validate("#registerForm");
        })
//        validate("#loginForm");
    })
</script>
</html>