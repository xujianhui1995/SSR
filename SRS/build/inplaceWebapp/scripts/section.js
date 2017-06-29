/* 提交结果，执行ajax */
function btn() {
	var $btn = $("input.btn"); // 获取按钮元素
	// 给按钮绑定点击事件
	$btn
			.bind(
					"click",
					function() {
						$
								.ajax({
									type : "post",
									url : "json/findAllBySemesterSectionAction",
									// 需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
									data : { // 设置数据源
										semester : $("input[name=semester]")
												.val()
									// 这里不要加"," 不然会报错，而且根本不会提示错误地方
									},
									dataType : "json",
									// 设置需要返回的数据类型
									success : function(data) {
										$(".select").empty();
										var d = eval("(" + data + ")"); // 将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
										for (var i = 0; i < d.length; i++) {
											$(".select")
													.append(
															"<tr><td>"
																	+ d[i].sections[0].sectionNo
																	+ "</td><td>"
																	+ d[i].sections[0].dayOfWeek
																	+ "</td><td>"
																	+ d[i].sections[0].timeOfDay
																	+ "</td><td>"
																	+ d[i].sections[0].room
																	+ "</td><td>"
																	+ d[i].sections[0].seatingCapacity
																	+ "</td><td>"
																	+ d[i].sections[0].representedCourse.courseName
																	+ "</td></td><td><a href='#'  onclick='enroll()'>选课</td></tr>");
										}
										console.log(data);
									},
									error : function() {
										alert("系统异常，请稍后重试！");
									} // 这里不要加","
								});
					});
}
function loadselect() {
	$
	.ajax({
		type : "post",
		url : "json/findAllBySemesterSectionAction",
		// 需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
		data : { // 设置数据源
			semester : $("input[name=semester]")
					.val()
		// 这里不要加"," 不然会报错，而且根本不会提示错误地方
		},
		dataType : "json",
		// 设置需要返回的数据类型
		success : function(data) {
			$(".select").empty();
			var d = eval("(" + data + ")"); // 将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
			for (var i = 0; i < d.length; i++) {
				$(".select")
						.append(
								"<tr><td>"
										+ d[i].sections[0].sectionNo
										+ "</td><td>"
										+ d[i].sections[0].dayOfWeek
										+ "</td><td>"
										+ d[i].sections[0].timeOfDay
										+ "</td><td>"
										+ d[i].sections[0].room
										+ "</td><td>"
										+ d[i].sections[0].seatingCapacity
										+ "</td><td>"
										+ d[i].sections[0].representedCourse.courseName
										+ "</td></td><td><a href='#' onclick='enroll()'>选课</td></tr>");
			}
		},
		error : function() {
			alert("系统异常，请稍后重试！");
		} // 这里不要加","
	});
}
function enroll() {
	$.ajax({
		type : "post",
		url : "SectionActionenroll",
		// 需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
		data : { // 设置数据源
			"sectionFullNo" : "CMP101 - 1",
			studentSsn : "111-11-1111"
		// 这里不要加"," 不然会报错，而且根本不会提示错误地方
		},
		dataType : "json",
		// 设置需要返回的数据类型
		success : function(data) {
			loanselected();
			loadselect();
		},
		error : function() {
			loanselected();
			loadselect();
		} // 这里不要加","
	});
}
// 加载已选课程列表
function loanselected() {
	$.ajax({
		type : "post",
		url : "json/getSectionsByStudentSectionAction",
		dataType : "json",
		data : { // 设置数据源
			studentSsn : "111-11-1111"
		},
		// 设置需要返回的数据类型
		success : function(data) {
			$(".selected").empty();
			var d = eval("(" + data + ")"); // 将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
			for (var i = 0; i < d.length; i++) {
				$(".selected").append(
						"<tr><td>" + d[i].sections[0].sectionNo + "</td><td>"
								+ d[i].sections[0].dayOfWeek + "</td><td>"
								+ d[i].sections[0].timeOfDay + "</td><td>"
								+ d[i].sections[0].room + "</td><td>"
								+ d[i].sections[0].representedCourse.courseName
								+ "</td></td><td><a href='#'>退选</td></tr>");
			}
		},
		error : function() {
			alert("系统异常，请稍后重试！");
		} // 这里不要加","
	});
}
/* 页面加载完成，绑定事件 */
$(document).ready(function() {
	btn(); // 点击提交，执行ajax
	loanselected();
});