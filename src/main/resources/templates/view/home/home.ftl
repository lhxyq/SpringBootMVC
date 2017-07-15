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
<@form.text id="name" name="name" label="用户名" labelCss="col-lg-4 control-label" textCss="col-lg-4" required="required" placeholder="用户名"/>
    <div class="form-group text-left">
        <div class="col-sm-offset-4 col-lg-8">
            <button type="submit" class="btn btn-default">登录</button>
        </div>
    </div>
</form>
</body>
<script type="text/javascript" src="/static/js/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/static/js/jquery/jquery.validate.min.js"></script>
<script type="text/javascript" src="/static/js/jquery/messages_zh.js"></script>
<script type="text/javascript" src="/static/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/js/common/common.js"></script>
<script>
    $(document).ready(function () {
        validate("#loginForm");
    })
</script>
</html>