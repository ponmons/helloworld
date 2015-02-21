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
								<form class="form-horizontal style-form" method="get">
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">장소</label>
										<div class="col-sm-10">
											<input type="text" class="form-control"
												placeholder="장소를 입력하여 주세요.">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">회비 방식</label>
										
										<div class="col-sm-10">
										
											<div class="radio" align="center">
												<input type="radio" name="optionsRadios" id="optionsRadios1"	value="option1" checked>
												 한 사람당 회비 : <input id="op1" type="text"  onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)'> 원
												
											</div>
											<div class="radio" align="center">
												<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
												 총 회비 : <input	id="op2" type="text"  onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' disabled>원
											</div>
											
											<span class="help-block">한 사람당 회비 방식과 총 회비 방식</span>
										</div>
										
									</div>
								
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">받을 계좌 </label>
										<div class="col-sm-10">
											<input type="text" class="form-control" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)'	placeholder="계좌를 입력하여 주세요.">
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
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">추가</button>
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
				$("input:text[id=op1]").removeAttr("disabled", "disabled");
				$("input:text[id=op2]").attr("disabled", "disabled");
			}else{
				$("input:text[id=op2]").removeAttr("disabled", "disabled");
				$("input:text[id=op1]").attr("disabled", "disabled");
			}
		});
		
		$("#op1").blur(function(){
			$("input:text[id=op2]").val($("input:text[id=op1]").val()*4); 
		});
		$("#op2").blur(function(){
			$("input:text[id=op1]").val($("input:text[id=op2]").val()/4); 
		});
	});
	</script>