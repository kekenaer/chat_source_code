
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册页面</title>
	<%@ include file="../common/header.jsp" %>
	<style>
		th,td{
			height:30px;
			
		}
	</style>
  </head>
  
  <body>
    <div id="main" class="col-12">
    	<form action="" method="post">
    		<table class="col-12">
				<tr>
					<th>用户注册</th>
				</tr>
				<tr>
					<td class="col-6">用户名：</td>
					<td class="col-6"><input type="text" name="userNickname" placeholder="请输入用户名"></td>
				</tr>
				<tr>
					<td class="col-6">密码：</td>
					<td class="col-6"><input type="text" name="userPassword" placeholder="请输入密码"></td>
				</tr>
				<tr>
					<td class="col-6">再次输入密码：</td>
					<td class="col-6"><input type="text" name="userPassword1" placeholder="请再次输入密码"></td>
				</tr>
				<tr>
					<td class="col-6">手机号码：</td>
					<td class="col-6"><input type="text" name="userPhone" placeholder="请输入手机号码"></td>
				</tr>
				<tr>
					<td class="col-6">选择头像：</td>
					<td class="col-6"></td>
				</tr>
			</table>
    	</form>
    </div>
  </body>
</html>
