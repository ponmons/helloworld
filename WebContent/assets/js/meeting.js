var httpRequest = null;//자바스크립트 요청 객체, 전역변수로 선언 필수 
		var name = null;
		 
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
			url : "select.do",
			type : "post",
			dataType : "json", //결과데이터타입
			success : function(data) {
				var table = "";
				//기존에 있는 테이블 첫행만 빼고 지우기
				//http://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_sel_gt
				$("#listTable tr:gt(0)").remove();

				$(data.list).each(
						function(index, item) {
							table += "<tr><td>" + item.memno + "</td><td>"
									+ item.memname + "</td><td>" + item.memid + "</td>";
							table += "<td>" + item.account + "</td><td>" + item.phonenumber + "</td><td>";
							table += "<input type='button' value='삭제' id='del' name='"+item.memno+"'></td></tr>";
						});
				//테이블에 추가
				$("#listTable tr:eq(0)").after(table);
			},
			error : function(err) {//실패했을때
				alert(err + " : 모든 고객 정보보기 실패");
			}
		});//end of ajax
	}//end of getData()

$(document).ready(function() {
/*	$("#btn").click(function() {
		sendRequest();
	
	});//end of 가입로직*/

	if($('input:radio[name=optionsRadios]').val() == "option2"){
	alert(" 선택 하셨습니다."+$('input:radio[name=optionsRadios]:checked').val() +" "	+$("input:text[name=input1]").val());
	$("input:radio[name=optionsRadios]").removeAttr("checked");
	}
	
	getData();
});


function viewData(){         
    if(httpRequest.readyState == 4){ //응답 완료 검증 조건식
        if(httpRequest.status == 200){//정상 응답 검증 조건식 
            var message = httpRequest.responseText; //json,html,csv,text
        	document.getElementById("address").value = message;
        }
    }
  }