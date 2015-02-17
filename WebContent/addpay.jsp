<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">모임 추가 & 친구선택</h4>
				</div>
				<div class="modal-body">
					<!-- BASIC FORM ELELEMNTS -->
					<div class="row mt">
						<div class="col-lg-12">
							<div class="form-panel">
								<form class="form-horizontal style-form" method="get">
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">Default</label>
										<div class="col-sm-10">
											<input type="text" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">Help
											text</label>
										<div class="col-sm-10">
											<input type="text" class="form-control"> <span
												class="help-block">A block of help text that breaks
												onto a new line and may extend beyond one line.</span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">Rounder</label>
										<div class="col-sm-10">
											<input type="text" class="form-control round-form">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">Input
											focus</label>
										<div class="col-sm-10">
											<input class="form-control" id="focusedInput" type="text"
												value="This is focused...">
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
										<label class="col-sm-2 col-sm-2 control-label">Placeholder</label>
										<div class="col-sm-10">
											<input type="text" class="form-control"
												placeholder="placeholder">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">Password</label>
										<div class="col-sm-10">
											<input type="password" class="form-control" placeholder="">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 col-sm-2 control-label">Static
											control</label>
										<div class="col-lg-10">
											<p class="form-control-static">email@example.com</p>
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
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>