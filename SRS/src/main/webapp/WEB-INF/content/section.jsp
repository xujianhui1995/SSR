<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选课列表</title>
<link rel="stylesheet" type="text/css" href="styles/base.css" />
<script type="text/javascript" src="scripts/jquery-1.8.2.js"></script>
<script src="scripts/section.js"></script>
</head>
<body>
	<div id="div_json">
		<p>欢迎，${requestScope.user.ssn}</p>
		<br/>
		<h5>选课学期</h5>
		<br /> <br />
		<form action="#" method="post">
			<label for="name">请输入选课学期：</label> <input type="text" name="semester" />
			<input type="button" class="btn" value="查询" />
		</form>
		<br /> <br /> <br />
		<h5>选课列表</h5>
		<br /> <br />
		<table border="1">
			<thead>
				<tr>
					<th>sectionNo</th>
					<th>dayOfWeek</th>
					<th>timeOfDay</th>
					<th>room</th>
					<th>seatingCapacity</th>
					<th>representedCourse</th>
					<th>action</th>
				</tr>
			</thead>
			<tbody class="select">
			</tbody>
		</table>
		<br /> <br /> <br />
		<h5>已选课程</h5>
		<br /> <br />
		<table border="1">
			<thead>
				<tr>
					<th>sectionNo</th>
					<th>dayOfWeek</th>
					<th>timeOfDay</th>
					<th>room</th>
					<th>representedCourse</th>
					<th>action</th>
				</tr>
			</thead>
			<tbody class="selected">
			</tbody>
		</table>
		<br /><br /><br /><br />
	</div>
</body>
</html>