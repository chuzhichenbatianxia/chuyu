<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%;">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>单点登录</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link href="/statics/css/login2.css" rel="stylesheet" type="text/css" />
</head>

<body style="height: 100%;">
<div class="main" id="rrapp" style="height: 97%;">
    <div style="height:200px;"></div>
    <div class="login-form" >
        <h1>单点登录系统</h1>
        <div class="head">
            <img src="/statics/image/login/user.png" alt=""/>
        </div>
        <form>
            <input type="hidden" id="returnurl" value="${returnurl}" />
            <input type="text" class="text" id="username" placeholder="用户名" value="${username}"/>
            <input type="password" value="" placeholder="密码" id="password" />
            <div class="submit">
                <input type="button" id="btnLogin" value="登录" />
                <input type="reset"  value="重置" />
            </div>
        </form>
    </div>
</div>
<%--<div class="copy-right" style="height:3%;background-color: #fff;">--%>
    <%--<p>Copyright &copy; 2014.Company name All rights reserved.<a target="_blank" href=""></a></p>--%>
<%--</div>--%>

<script src="/statics/js/jquery/jquery-1.8.2.min.js"></script>
<script src="/statics/js/login/login.js?v=1"></script>
</body>

</html>
