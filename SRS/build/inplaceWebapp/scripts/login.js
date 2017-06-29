function AddHandlingFeeToRefund() {
	var AjaxURL = "../OrderManagement/AjaxModifyOrderService.aspx";
	alert($('#formAddHandlingFee').serialize());
	$.ajax({
		type : "POST",
		dataType : "json",
		url : aaaaaa,
		data : $('#formAddHandlingFee').serialize(),
		success : function(result) {
			
		},
		error : function(data) {
			alert("登录失败" + data.responseText);
		}
	});
}