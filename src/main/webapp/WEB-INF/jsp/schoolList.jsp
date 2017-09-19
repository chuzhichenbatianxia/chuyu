<%@page import="com.yu.entity.School"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <LINK 
href="css/content.css" type=text/css rel=stylesheet> -->
<title>列表页面</title>
</head>
<body>
	<div style="padding-left: 4px;">
		<table width="830" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="270" class="title">学校信息列表</td>
				<td width="30"><img src="images/title002.gif" /></td>
				<td width="534" bgcolor="#d9f0ff" class="txt">您的位置：学校信息管理 &gt;
					信息管理 &gt; 学校信息列表</td>
			</tr>
			
			<tr>
			
			<td>
			    <form action="<%=request.getContextPath() %>/scholl/importExcel.do" enctype="multipart/form-data" method="post" >
			    <input type="file" name="file" />
			    <input type="submit" value="导入" />
			    </form>	
			</td>
				<td><a href="<%=request.getContextPath() %>/scholl/exportExcel.do">导出</a></td>	
				
			</tr>
		</table>
		<table width="800" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="30" colspan="3"><table width="100%" border="1"
						align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td  height="30" align="center" bgcolor="#80C6FF">Id</td>
							<td  height="30" align="center" bgcolor="#80C6FF">镇区</td>
							<td  height="30" align="center" bgcolor="#80C6FF">代理商</td>
							<td  height="30" align="center" bgcolor="#80C6FF">学校</td>
							<td  height="30" align="center" bgcolor="#80C6FF">班级</td>
							<td  height="30" align="center" bgcolor="#80C6FF">姓名</td>
							<td  height="30" align="center" bgcolor="#80C6FF">学籍号</td>
							<td  height="30" align="center" bgcolor="#80C6FF">是否本地</td>
							<td  height="30" align="center" bgcolor="#80C6FF">业务名称</td>
						</tr>
						<%
							List<School> schoolList = (List<School>) request.getAttribute("schoolList");
							for (School scholl : schoolList) {
						%>
						<tr>
							<td  height="30" align="center" bgcolor="#FFF5D7"><%=scholl.getId()%></td>
							<td  height="30" align="center" bgcolor="#FFF5D7"><%=scholl.getTown()%></td>
							<td  height="30" align="center" bgcolor="#FFF5D7"><%=scholl.getFactor()%></td>
							<td  height="30" align="center" bgcolor="#FFF5D7"><%=scholl.getSchool()%></td>
							<td  height="30" align="center" bgcolor="#FFF5D7"><%=scholl.getClas() %></td>
							<td  height="30" align="center" bgcolor="#FFF5D7"><%=scholl.getStudentName()%></td>
							<td  height="30" align="center" bgcolor="#FFF5D7"><%=scholl.getStudentId()%></td>
							<%
								if (scholl.getLocalIs() == 0) {
							%>
							<td  height="30" align="center" bgcolor="#FFF5D7">本地</td>
							<%
								} else {
							%>
							<td  height="30" align="center" bgcolor="#FFF5D7">外地</td>
							<%
								}
							%>
							<td  height="30" align="center" bgcolor="#FFF5D7"><%=scholl.getBusinessName()%></td>
						</tr>
						<%
							}
						%>
					</table></td>

			</tr>
		</table>
</body>
</html>