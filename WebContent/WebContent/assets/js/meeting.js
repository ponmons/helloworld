var httpRequest = null;//자바스크립트 요청 객체, 전역변수로 선언 필수 
		 
function getXMLHttpRequest() {
				if (window.ActiveXObject) {//ms ie용 객체 생성 코드블록
					try {						
						return new ActiveXObject("Msxml2.XMLHTTP");//ie6부터의 parameter값
					} catch(e) {
						try {		
							return new ActiveXObject("Microsoft.XMLHTTP");//ie5까지의 parameter값
						} catch(e1) { 
							return null; 
						}
					}
				} else if (window.XMLHttpRequest) {	//non-ie, ie7버전 부터의 객채 생성 코드 블록
					return new XMLHttpRequest();
				} else {
					return null;
				}
			}

function sendRequest() {
	httpRequest = getXMLHttpRequest();		
	httpRequest.open("GET", "addpay.jsp", true);	
	httpRequest.send();		
}

function getData() {
	$.ajax({
			url : "friendSelect.do",
			type : "post",
			dataType : "json", //결과데이터타입
			data : "meetno="+2,
			success : function(data) {		//data는 파라미터로 값을 넣어 준다. 
				var table = '';
				//기존에 있는 테이블 첫행만 빼고 지우기
				//http://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_sel_gt

				$(data.list).each(
						function(index, item) {
							table += '<div class="col-md-4 mb">'+
								'<div class="darkblue-panel pn">'+
							'<div class="darkblue-header">'+
								'<h5>'+item.memno+'</h5>'+
							'</div>'+
							'<p><img src="assets/img/friends/fr-03.jpg" class="img-circle" width="80"></p>'+
							'<p><h5>'+item.memName+'</h5></p>'+
							'<div class="row">'+
								'<div class="col-md-6">'+
									'<i class="small mt">MEMBER SINCE</i>'+
									'<p>2012</p>'+
								'</div>'+
								'<div class="col-md-6">'+
									'<i class="small mt">PRICE</i>'+
									'<p>￦'+item.price+'</p>'+
								'</div>'+
							'</div>'+
						'</div>'+
					'</div><!-- /col-md-4 -->';
						});
				//테이블에 추가
				$("#fblist").after(table);
			},
			error : function(err) {//실패했을때
				alert(err + " : 모든 고객 정보보기 실패");
			}
	});//end of ajax
}//end of getData()

$(document).ready(function() {

	$("div#topbar").load("jsp/topbar.jsp");
	$("div#leftSideBar").load("jsp/leftSideBar.jsp");
	$("div#addpay").load("jsp/addpay.jsp");
	$("div#rightSideBar").load("jsp/rightSidebar.jsp");
	
	getData();
});


// onlyNumber 이거는 숫자만 텍스트필드에 들어가
function onlyNumber(event){
    event = event || window.event;
    var keyID = (event.which) ? event.which : event.keyCode;
    if ( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
        return;
    else
        return false;
}
//문자는 제거 해주는 역할 
function removeChar(event) {
    event = event || window.event;
    var keyID = (event.which) ? event.which : event.keyCode;
    if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
        return;
    else
        event.target.value = event.target.value.replace(/[^0-9]/g, "");
}

function viewData(){         
    if(httpRequest.readyState == 4){ //응답 완료 검증 조건식
        if(httpRequest.status == 200){//정상 응답 검증 조건식 
            var message = httpRequest.responseText; //json,html,csv,text
        	document.getElementById("address").value = message;
        }
    }
  }