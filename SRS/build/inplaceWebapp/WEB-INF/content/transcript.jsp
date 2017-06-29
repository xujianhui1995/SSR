<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成绩列表</title>
<link rel="stylesheet" type="text/css" href="styles/base.css" />
<script type="text/javascript" src="scripts/jquery-1.8.2.js"></script>
<script src="scripts/transcript.js"></script>
</head>
<body>
	<div id="div_json">	
		<h5>选课情况</h5>
		<br/><br/><br/>
		<table border="1">
			<thead>
				<tr>
					<th>SSn</th>
					<th>StudentName</th>
					<th>Course</th>					
				</tr>
			</thead>
			<tbody class="selected">
			</tbody>
		</table>
		<br/><br/><br/><br/><br/><br/><br/>
		<h5>成绩列表</h5>
		<br /> <br />
		<table border="1">
			<thead>
				<tr>
					<th>student</th>
					<th>section</th>
					<th>grade</th>				
				</tr>
			</thead>
			<tbody  class="grade">
			</tbody>
		</table>
	</div>
</body>
</html>