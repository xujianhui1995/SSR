// 加载选课情况列表
//function loadgrade() {
//	$.ajax({
//		type : "post",
//		url : "json/getTranscriptTranscriptAction",// 需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
//		data : {// 设置数据源
//
//		// 这里不要加"," 不然会报错，而且根本不会提示错误地方
//		},
//		dataType : "json",// 设置需要返回的数据类型
//		success : function(data) {
//			$("tbody").empty();
//			var d = eval("(" + data + ")");// 将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
//			for (var i = 0; i < d.length; i++) {
//				$(".grade").append(
//						"<tr><td>" + d[i].student.name + "</td><td>"
//								+ d[i].section.representedCourse.courseName
//								+ "</td><td>" + d[i].grade + "</td></tr>");
//			}
//			console.log(data);
//		},
//		error : function() {
//			alert("系统异常，请稍后重试！");
//		}// 这里不要加","
//	});
//}
function loaddata() {
	$.ajax({
		type : "post",
		url : "json/getTranscriptTranscriptAction",// 需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
		data : {// 设置数据源

		// 这里不要加"," 不然会报错，而且根本不会提示错误地方
		},
		dataType : "json",// 设置需要返回的数据类型
		success : function(data) {
//			$("tbody").empty();
			var d = eval("(" + data + ")");// 将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
			for (var i = 0; i < d.length; i++) {
				$(".grade").append(
						"<tr><td>" + d[i].student.name + "</td><td>"
								+ d[i].section.representedCourse.courseName
								+ "</td><td>" + d[i].grade + "</td></tr>");
				$(".selected").append(
						"<tr><td>" + d[i].student.ssn + "</td><td>"
								+ d[i].student.name + "</td><td>"
								+ d[i].section.representedCourse.courseName
								+ "</td></tr>");
			}
			console.log(data);
		},
		error : function() {
			alert("系统异常，请稍后重试！");
		}// 这里不要加","
	});
}
/* 页面加载完成，绑定事件 */
$(document).ready(function() {
	loaddata();
});