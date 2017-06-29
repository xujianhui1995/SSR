<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script type="text/javascript" src="scripts/jquery-1.8.2.js"></script>
<script src="scripts/login.js"></script>
<style>
.container {
	position: absolute;
	width: 400px;
	height: 300px;
	left: 50%;
	top: 30%;
	margin-left: -200px;
	margin-top: -20px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form class="form-horizontal" action="UserActionlogin.action" method="post">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">SSN：</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="ssn" />
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-3 control-label">密码：</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" name="password" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								<label><input type="radio" name="role" value="student"/>学生</label>
							</div>
							<div class="checkbox">
								<label><input type="radio" name="role" value="professor"/>教授</label>
							</div>
							<div class="checkbox">
								<label><input type="radio" name="role" value="dean"/>系主任</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">登录</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>