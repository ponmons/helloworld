$(document).ready(function() {
	$("#btn").click(function() {
		$.ajax({
			url : "addpay.jsp",
			type : "post",
			dataType : "html",
			sucess :function(data){
				var text = $(this).text();
				alert(text);
			},
			error : function(x){
				var text = $(this).text();
				alert(text);
			}
			
		}); //end of ajax
	});//end of 가입로직
});