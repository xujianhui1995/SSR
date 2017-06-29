<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程列表</title>
<link rel="stylesheet" type="text/css" href="styles/base.css" />
<script type="text/javascript" src="scripts/jquery-1.8.2.js"></script>
<script src="scripts/course.js"></script>
</head>
<body>
	<div id="div_json">
		<h5>添加课程</h5>
		<br /> <br />
		<form action="#" method="post">
			<label for="name">请输入courseNo：</label> <input type="text" name="courseNo" />
			<label for="name">请输入courseName：</label> <input type="text" name="courseName" />
			<label for="name">请输入credits：</label> <input type="text" name="credits" />
			<label for="name">请输入prerequisites-courseNo：</label> <input type="text" name="prerequisitescourseNo" />

			<input type="button" class="btn" value="添加" />
		</form>
		<br /> <br /> <br />
		<h5>课程列表</h5>
		<br /> <br />
		<table border="1">
			<thead>
				<tr>
					<th>courseNo</th>
					<th>courseName</th>
					<th>credits</th>
					<th>prerequisites</th>					
					<th>action</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</body>
</html>