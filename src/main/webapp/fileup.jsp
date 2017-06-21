<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/first.do" enctype="multipart/form-data" method="post" >
	   <h2>文件上传</h2>
	                文件:<input type="file" name="uploadFile"/><br/><br/>
	      <input type="submit" value="单个文件上传"/>
	 </form>
	 
	 <form action="<%=request.getContextPath() %>/second.do" enctype="multipart/form-data" method="post" >
	   <h2>文件上传</h2>
	                文件1:<input type="file" name="uploadFile"/><br/><br/>
	                文件2:<input type="file" name="uploadFile"/><br/><br/>
	                文件3:<input type="file" name="uploadFile"/><br/><br/>
	      <input type="submit" value="多个文件上传"/>
	 </form>
	 <a href="<%=request.getContextPath() %>/fileDownload.do">下载</a>
</body>
</html>