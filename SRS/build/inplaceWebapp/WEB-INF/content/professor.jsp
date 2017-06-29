<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师列表</title>
<link rel="stylesheet" type="text/css" href="styles/base.css" />
<script type="text/javascript" src="scripts/jquery-1.8.2.js"></script>
<script src="scripts/professor.js"></script>
</head>
<body>
	<div id="div_json">
		<h5>添加教师</h5>
		<br /> <br />
		<form action="#" method="post">
			<label for="name">请输入ssn：</label> <input type="text" name="ssn" />
			<label for="name">请输入name：</label> <input type="text" name="name" />
			<label for="name">请输入title：</label> <input type="text" name="title" />
			<label for="name">请输入department：</label> <input type="text" name="department" />
			<input type="button" class="btn" value="添加" />
		</form>
		<br /> <br /> <br />
		<h5>教师列表</h5>
		<br /> <br />
		<table border="1">
			<thead>
				<tr>
					<th>ssn</th>
					<th>name</th>
					<th>title</th>
					<th>department</th>					
					<th>action</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</body>
</html>