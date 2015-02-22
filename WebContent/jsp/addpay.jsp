<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 회비 추가 팝업창 on-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">회비 추가</h4>
				</div>
				<div class="modal-body">
					<!-- BASIC FORM ELELEMNTS -->
					<div class="row">
						<div class="col-lg-12">
							<div class="form-panel">
								<form class="form-horizontal style-form" method="get" id="fee">
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">회비 방식</label>
										<div class="col-sm-10">
										
											<div class="radio" align="justify">
												<input type="radio" name="optionsRadios" id="optionsRadios1"	value="option1" checked>
												 한 사람당 회비 : <input id="price" type="text" name="price" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)'> 원
											</div>
											<div class="radio" align="justify">
												<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
												 총 회비 : <input id="totalfee" type="text" name="totalfee"  onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' disabled>원
											</div>
											
											<span class="help-block">한 사람당 회비 방식과 총 회비 방식</span>
										</div>
									</div>
								</form>
							</div>
						</div>
						<!-- col-lg-12-->
					</div>
					<!-- /row -->

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" id="btn">추가</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 회비 추가 end -->
	<script>
	$(document).ready(function() {
		// 회비를 나누는 방식 한사람당 회비 , 사람 수
		$('input:radio[name=optionsRadios]').change(function(){
			if($('input:radio[name=optionsRadios]:checked').val() == 'option1'){
				$("input:text[id=price]").removeAttr("disabled", "disabled");
				$("input:text[id=totalfee]").attr("disabled", "disabled");
			}else{
				$("input:text[id=totalfee]").removeAttr("disabled", "disabled");
				$("input:text[id=price]").attr("disabled", "disabled");
			}
		});
		//회비 나누고 총액 확인 로직
		$("#price").blur(function(){
			$("input:text[id=totalfee]").val($("input:text[id=price]").val()*4); 
		});
		$("#totalfee").blur(function(){
			$("input:text[id=price]").val($("input:text[id=totalfee]").val()/4); 
		});
		
		//추가하기
		$("#btn").click(function() {
			alert($("#fee").serialize());
			$.ajax({
				url : "insert.do",
				type : "get",
				dataType : "text",
				data : $("#fee").serialize(),
				success : function(data) {
					if (data == "ok") {
						alert("추가 성공" +$("#fee").serialize());
						$("input[type=text]").val(""); //text박스 모두 지우기
						// 추가 하고 닫기 
					} else {
						alert("추가 실패");
					}
				},
				error : function(data) {
					alert(data + ' : 추가로직 실행시 에러 발생');
				}
			}); //end of ajax
		});// 회비 추가 로직 
	});
	</script>