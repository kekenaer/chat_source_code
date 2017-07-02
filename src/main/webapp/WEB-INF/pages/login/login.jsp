
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 聊天室登陆系统</title>
	<%@ include file="../common/header.jsp" %>
</head>
<body class="login_bg">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>聊天室登陆系统</h1>
        </header>
        <section class="loginCont">
            <form class="loginForm" action="<%=basePath%>user/login/check.html" method="post">
                <div class="inputbox">
                    <label for="user">用户名：</label>
                    <input id="user" type="text" name="userNickname" placeholder="请输入用户名" required/>
                </div>
                <div class="inputbox">
                    <label for="mima">密码：</label>
                    <input id="mima" type="password" name="userPassword" placeholder="请输入密码" required/>
                </div>
                <div class="subBtn">
                    <input class="login-button" type="submit" value="登录" />
                    <input class="reset-button" type="reset" value="重置"/>
                </div>
            </form>
        </section>
    </section>
</body>
<script type="text/javascript" src="<%=basePath%>static/js/customer/login.js"></script>
</html>
