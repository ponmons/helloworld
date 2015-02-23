    <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ChoiSeongJun">
    <meta name="keyword" content="alarm, credit, system, friends">

    <title>N-BBANG</title>
	<link rel="shortcut icon" href="favicon.ico">
    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">   
   
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

  </head>

  <body>

  <section id="container" >
      	<div id="topbar"></div>
    	<div id="leftSideBar"></div>
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
          
          	<!-- BASIC FORM ELELEMNTS -->
          	<div class="row mt">
          		<div class="col-lg-12">
                  <div class="form-panel">
                  	  <h4 class="mb"><i class="fa fa-angle-right"></i></h4>
                      <form class="form-horizontal style-form" action="addMeeting.do" method="post">
                              <div>
                              	<div>
									<label class="col-sm-2 col-sm-2 control-label">유형</label>
									<select class="form-control" name="meetingType" id="meetingType">
										<option value="2">행사</option>
										<option value="3">회식</option>
									</select>
								</div>
                              <label class="col-sm-2 col-sm-2 control-label">모임명</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="meetName" id="meetName" placeholder="모임명이 무엇인가요."><br/><br/>
                              </div>
                              
                              <label class="col-sm-2 col-sm-2 control-label">장소</label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name="place" id="place" placeholder="장소를 작성해 주세요."><br/><br/>
                              </div>
                              
                              <label class="col-sm-2 col-sm-2 control-label">날짜</label>
                              <div class="col-sm-10">
                                  <input type="date" class="form-control" name="meetDate" id="meetDate" placeholder="날짜를 선택해 주세요."><br/><br/>
                              </div>
									<center>
										<button type="submit" class="btn btn-info" name="command" value="addSpend">추가</button>
										<button type="button" class="btn btn-default" onclick="history.back()">취소</button>
									</center>
                          </div>
                       </form>
          			</div>
          		</div>
          	</div><!-- /row -->
          	
          	
		</section><!--/wrapper -->
      </section><!-- /MAIN CONTENT -->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/jquery-1.8.3.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>
   
    <script type="text/javascript" src="assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="assets/js/gritter-conf.js"></script>

    <!--script for this page-->
	 <script src="assets/js/chart-master/Chart.js"></script>
    <script src="assets/js/chartjs-conf.js"></script>	
	<script src="assets/js/meeting.js"></script>
	<script src="assets/js/form-component.js"></script>    
    
    
  <script>
      //custom select box
      $(function(){
          $('select.styled').customSelect();
      });

  </script>

  </body>
</html>