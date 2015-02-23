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
					<div class="row mt">
          		<div class="col-lg-12">
          			<div class="form-panel">
                  	  <h4 class="mb"><i class="fa fa-angle-right"></i> 회비를 입력해 주세요.</h4>
                      <form class="form-inline" role="form" method="get" id="fee">
                          <div class="form-group">
                          	  <label> 한 사람당 회비 : <input id="price" type="text" name="price" class="form-control" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)'> 원 </label>
                          </div>
                          <br><br>
                          <div class="form-group">
                              <label> 총 회비 : <input id="totalfee" type="text" name="totalfee" class="form-control" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)'>원</label>
                          </div>
                      </form>
          			</div><!-- /form-panel -->
          		</div><!-- /col-lg-12 -->
          	</div><!-- /row -->
					

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="submit" class="btn btn-primary" id="btn" data-dismiss="modal">추가</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 회비 추가 end -->
	<script>
	$(document).ready(function() {
			//회비 값 체크 
		    $('.modal-footer').submit(function(){
		        var username = $('#price').val();
		        var password = $('#totalfee').val();
		        if(username == '') {
		       		alert("프라이스 값을 입력하세");
		            return false;
		        }
		        if(password == '') {
		        	alert("토탈 값을 입력하세");      
		            return false;
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
			$.ajax({
				url : "insertfee.do",
				type : "get",
				dataType : "text",
				data : $("#fee").serialize(),
				success : function(data) {
					if (data == "ok") {
						alert("추가 성공" +$("#fee").serialize());
						$("input[type=text]").val(""); //text박스 모두 지우기
						// 추가 하고 닫기 로직 추가 
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