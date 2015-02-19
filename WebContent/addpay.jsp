<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<!-- 회비 추가 팝업창 on-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
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
											<div class="radio">
												<input type="radio" name="optionsRadios" id="optionsRadios1"	value="option1" checked>
												 <label>한 사람당 회비 : <input id="op1" type="text"> 원
												</label>
											</div>
											<div class="radio">
												<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
												 <label>총 회비 : <input	id="op2" type="text" disabled="">원
												</label>
											</div>
											<span class="help-block">한 사람당 회비 방식과 총 회비 방식</span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">Disabled</label>
										<div class="col-sm-10">
											<input class="form-control" id="disabledInput" type="text"
												placeholder="Disabled input here..." disabled>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">받을 계좌 </label>
										<div class="col-sm-10">
											<input type="text" class="form-control"
												placeholder="계좌를 입력하여 주세요.">
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
