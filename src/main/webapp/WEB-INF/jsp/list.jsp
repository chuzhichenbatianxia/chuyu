<%@page import="com.yu.entity.Pager"%>
<%@page import="javax.json.JsonObject"%>
<%@page import="javax.json.Json"%>
<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@page import="com.yu.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="css/content.css" type=text/css rel=stylesheet>
<title>列表页面</title>
</head>
<body>
	<div style="padding-left: 4px;">
		<table width="830" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="270" class="title">用户信息列表</td>
				<td width="30"><img src="images/title002.gif" /></td>
				<td width="534" bgcolor="#d9f0ff" class="txt">您的位置：用户信息管理 &gt;
					信息管理 &gt; 用户信息列表</td>
			</tr>

		</table>
		<table width="800" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="30" colspan="3"><table width="100%" border="1"
						align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td height="30" align="center" bgcolor="#80C6FF"><span
								class="txt"><span class="titletxt">Id</span></span></td>
							<td height="30" align="center" bgcolor="#80C6FF"><span
								class="txt"><span class="titletxt">姓名</span></span></td>
							<td height="30" align="center" bgcolor="#80C6FF" class="titletxt">年龄</td>
							<td height="30" align="center" bgcolor="#80C6FF" class="titletxt">薪水</td>
							<td height="30" align="center" bgcolor="#80C6FF" class="titletxt">生日</td>
							<td height="30" align="center" bgcolor="#80C6FF" class="titletxt">分数</td>
							<td height="30" align="center" bgcolor="#80C6FF" class="titletxt">相关操作</td>
						</tr>
						<%
							Pager<User> result = (Pager<User>) request.getAttribute("listuser");
							List<User> listUsers = result.getDataList();
							for (User user : listUsers) {
						%>
						<tr>
							<td height="30" align="center" bgcolor="#FFF5D7"><span
								class="txt"><%=user.getId()%></span></td>
							<td height="30" align="center" bgcolor="#FFF5D7"><span
								class="txt"><%=user.getName()%></span></td>
							<td height="30" align="center" bgcolor="#FFF5D7"><span
								class="txt"><%=user.getAge()%></span></td>
							<td height="30" align="center" bgcolor="#FFF5D7"><span
								class="txt"><%=user.getSalary()%></span></td>
							<td height="30" align="center" bgcolor="#FFF5D7"><span
								class="txt"><%=user.getBirthday()%></span></td>
							<td height="30" align="center" bgcolor="#FFF5D7"><span
								class="txt"><%=user.getScore()%></span></td>
							<td height="30" align="center" bgcolor="#FFF5D7"><span
								class="txt"> <a
									href="deleteuser.do?id=<%=user.getId()%>">【删除】</a> &nbsp <a
									href="<%=request.getContextPath()%>/update.jsp?id=<%=user.getId()%>&name=<%=user.getName()%>&age=<%=user.getAge()%>
							&salary=<%=user.getSalary()%>&birthday=<%=user.getBirthday()%>&score=<%=user.getScore()%>">【修改】</a>
							</span></td>
						</tr>
						<%
							}
						%>
					</table>
					<div>
						<a href="userlist.do?pageNumStr=<%=result.getCurrentPage() - 1%>">上一页</a>
						<%
							for (int i = 1; i <= result.getTotalPage(); i++) {
						%>
						<a href="userlist.do?pageNumStr=<%=i%>">第<%=i%>页
						</a>
						<%
							}
						%>
						<a href="userlist.do?pageNumStr=<%=result.getCurrentPage() + 1%>">下一页</a>
					</div></td>

			</tr>
		</table>
</body>
</html>