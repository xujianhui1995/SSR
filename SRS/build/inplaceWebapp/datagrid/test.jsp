<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CheckBox Selection on DataGrid - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../easyui/demo.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<table id="box"></table>
</body>
<script type="text/javascript">
	$(function() {
		$('#box').datagrid({
			width : 500,
			url : 'getCourse',
			// 			url : 'user.php',
			title : '用户列表',
			iconCls : 'icon-search',
			columns : [ [ {
				field : 'courseNo',
				title : 'courseNo'
			}, ] ],
			pagination : true,
			pageSize : 10,
			pageList : [ 10, 20, 30 ],
			pageNumber : 1,
			pagePosition : 'bottom',
		// 			queryParams : {
		// 				id : 1,
		// 			}
		});

	});
</script>
</html>