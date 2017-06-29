/* 提交结果，执行ajax */
function btn() {
	var $btn = $("input.btn");// 获取按钮元素
	// 给按钮绑定点击事件
	$btn.bind("click", function() {
		$.ajax({
			type : "post",
			url : "PersonActionaddProfessor",// 需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
			data : {// 设置数据源
				ssn : $("input[name=ssn]").val(),
				name : $("input[name=name]").val(),
				title : $("input[name=title]").val(),
				department : $("input[name=department]").val()

			// 这里不要加"," 不然会报错，而且根本不会提示错误地方
			},
			// dataType : "json",// 设置需要返回的数据类型
			success : function(data) {
				loandata();
			},
			error : function() {
				// alert("系统异常，请稍后重试！");
			}// 这里不要加","
		});
	});
}
// 加载教师列表
function loandata() {
	$.ajax({
		type : "post",
		url : "json/findAllProfessorsPersonAction",// 需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
		data : {// 设置数据源

		// 这里不要加"," 不然会报错，而且根本不会提示错误地方
		},
		dataType : "json",// 设置需要返回的数据类型
		success : function(data) {
			$("tbody").empty();
			var d = eval("(" + data + ")");// 将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
			for (var i = 0; i < d.length; i++) {
				$("tbody").append(
						"<tr><td>" + d[i].ssn + "</td><td>" + d[i].name
								+ "</td><td>" + d[i].title + "</td><td>"
								+ d[i].department
								+ "</td><td><a href='PersonActiondelProfessor?ssn="+d[i].ssn+"'>删除</td></tr>");
			}
			console.log(data);
		},
		error : function() {
			// alert("系统异常，请稍后重试！");
		}// 这里不要加","
	});
}
/* 页面加载完成，绑定事件 */
$(document).ready(function() {
	btn();// 点击提交，执行ajax
	loandata();
});