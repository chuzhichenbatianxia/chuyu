<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户信息</title>
</head>
<body>
		<h3>添加用户</h3>
		<form name="form1" action="<%=request.getContextPath() %>/user/useradd.do" method="post"
			onsubmit="return isValidate(form1)">
			<table width="550" cellpadding="0" cellspacing="0"
				style="line-height: 40px">
				<tr>
					<td align="right">姓名：</td>
					<td><input name="name" type="text" id="name"
						value="" /></td>
				</tr>
				<tr>
					<td align="right">年龄：</td>
					<td><input name="age" type="text" id="age"
						value="" /></td>
				</tr>
				<tr>
					<td align="right">薪水：</td>
					<td><input name="salary" type="text" id="salary"
						value="" /></td>
				</tr>
				<tr>
					<td align="right">生日：</td>
					<td><input name="birthday" type="text" id="birthday"
						value="" /></td>
				</tr>
				<tr>
					<td align="right">分数：</td>
					<td><input name="score" type="text" id="score"></input></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input id="btn_Save" value="保存" type="submit"
						name="btn_Save" /> <input value="重置" type="reset" name="clear" />
						&nbsp;</td>
				</tr>
			</table>
		</form>
</body>
</html>