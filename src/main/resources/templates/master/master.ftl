<#macro layout>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=true">
    <title>welcome to system</title>
    <link rel="stylesheet" type="text/css" href="/static/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/static/css/common/common.css">
</head>
<body>
<div class="container-fluid">
    <div class="row" style="background: gray; ">
        <div class="col-lg-12">
            <img class="img-circle" src="/static/image/user.jpg" alt="用户头像"/>
            <span class="h3 text-center">欢迎${myname} 签名：这家伙很懒,还木有签名~</span>
        </div>
    </div>

    <div class="row" style="height: 440px">
        <div class="col-lg-offset-0 col-lg-2">
            <ul class="list-unstyled">
                <br/>
                <li><a href="${request.contexPath}/user/userInfo/${myname}" class="h3">基本信息 </a></li>
                <br/>
                <li><a href="#" class="h3">用户管理</a></li>
            </ul>
        </div>
        <br/>
        <div class="col-lg-9">
            <#nested/>
        </div>
    </div>
    <div class="row text-center" style="clear:both;">
        <span  >@copy 2016-${.now}</span>
    </div>
</div>
</body>
<script type="text/javascript" src="/static/js/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/static/js/jquery/jquery.validate.min.js"></script>
<script type="text/javascript" src="/static/js/jquery/messages_zh.js"></script>
<script type="text/javascript" src="/static/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/js/common/common.js"></script>
</html>
</#macro>