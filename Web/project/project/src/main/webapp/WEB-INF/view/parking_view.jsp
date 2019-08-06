<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>

<title>Elegant Packing Stop</title>

<!-- style, css 시작 -->
<link rel='stylesheet' href='./source/css/style.css' type='text/css'
	media='all' />

<style>
.logo {
	width: 400px;
}

.headerButton {
	float: right;
	margin-left: 15px;
	margin-bottom: 5px;
	width: 120px;
}

.parkingcentericon {
	position: relative;
	text-align: center;
}

form {
	display: inline
}

.joinicon {
	float: right;
	margin-left: 10px;
}

#joinbutton {
	margin-top: 3px;
	width: 90px;
}

#loginbutton {
	width: 90px;
}
</style>
<!-- style, css 끝 -->


</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
    function userLogout() { location.href = "logout.do" }
  </script>
<script>

$(document).ready(function() {

	$("#MyPosition").on("click",function(){
		if (navigator.geolocation) {		    
		    navigator.geolocation.getCurrentPosition(function(position) {		        
		        var lat = position.coords.latitude, // 위도
		            lon = position.coords.longitude; // 경도
		        
		        var locPosition = new kakao.maps.LatLng(lat, lon), 
		            message = '<div style="padding:5px;">여기에 계신가요?!</div>'; 
		        
		      displayMarker(locPosition, message);
		            
		      });		    
		} else { 
		    
		    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
		        message = 'geolocation을 사용할수 없어요..'		        
		    displayMarker(locPosition, message);
		}		
		function displayMarker(locPosition, message) {		   
		    var marker = new kakao.maps.Marker({  
		        map: map, 
		        position: locPosition
		    }); 
		    	var iwContent = message, 
		        iwRemoveable = true;
		 
		    var infowindow = new kakao.maps.InfoWindow({
		        content : iwContent,
		        removable : iwRemoveable
		    });
		    	    
		    infowindow.open(map, marker);		        
		    map.setCenter(locPosition);      
		}    
	});
	$("#MyParkPs").on("click",function(){
		alert("주차 위치를 클릭해주세요")	
		var center = map.getCenter();
		
	var imageSrc = "http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
		imageSize = new daum.maps.Size(24, 35); 

	var markerImage = new daum.maps.MarkerImage(imageSrc, imageSize);
		
		var marker = new kakao.maps.Marker({ 
			position: center,
			image : markerImage
		}); 
		marker.setMap(map); 
		
		kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
		    
		    // 클릭한 위도, 경도 정보를 가져옵니다 
		    var latlng = mouseEvent.latLng; 
		    
		    // 마커 위치를 클릭한 위치로 옮깁니다
		    marker.setPosition(latlng);		    
		    
		});
		
	var iwContent = '<div style="padding:5px;">주차위치</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
	iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

	// 인포윈도우를 생성합니다
	var infowindow = new kakao.maps.InfoWindow({
	    content : iwContent,
	    removable : iwRemoveable
	});
	
	kakao.maps.event.addListener(marker, 'click', function() {
	      // 마커 위에 인포윈도우를 표시합니다
	      infowindow.open(map, marker);  
	      var lat = marker.getPosition().getLat();
	      var lng = marker.getPosition().getLng();
	      console.log(lat);
	      console.log(lng);
	      var test = new kakao.maps.LatLng(lat, lng);
	      //test
	      let point = {
	    		  lat1 : lat,
	    		  lng1 : lng
	      }
	      
	      //test end
	      $.ajaxSettings.traditional = true;
	      $.ajax({
	          type: "POST",
	          url : "<c:url value='/ParkStop.do' />",
	          data : JSON.stringify(point),
	          contentType : "application/json",
	          dataType : "json",
	          success : function(data){
	              alert("성공");
	          },error : function(request,status,error){
	              //Ajax 실패시
	        	  alert("처리에 실패하였습니다.\ncode:"+request.status+"\n"+"error:"+error);
	           
	          }
	      });

	});
		
	});
});


function callFunction() {
	console.log('call function');
    var lat = marker.getPosition().getLat();
    var lng = marker.getPosition().getLng();
    console.log(lat);
    console.log(lng);
	

	      //test
 	      let point = {
	    		  lat1 : lat,
	    		  lng1 : lng
	      }
	      
	      //test end
	      $.ajaxSettings.traditional = true;
	      $.ajax({
	          type: "POST",
	          url : "<c:url value='/Fav.do' />",
	          data : JSON.stringify(point),
	          contentType : "application/json",
	          dataType : "json",
	          success : function(data){
	              alert("성공");
	          },error : function(request,status,error){
	              //Ajax 실패시
	        	  alert("처리에 실패하였습니다.\ncode:"+request.status+"\n"+"error:"+error);
	           
	          }
	      });
 

}	

</script>


<!-- body 시작 -->
<body
	class="home page page-template page-template-template-portfolio page-template-template-portfolio-php">

	<div id="page">
		<div class="container">

			<!-- header 시작 -->
			<header id="masthead" class="site-header">

				<c:if test='${empty user}'>
					<div>
						<form class='joinicon'>
							<a href="./join.do"><input type="button" id='joinbutton'
								value="회원가입"></a>
						</form>

						<form action="./login.do" method='post' class='joinicon'>
							아이디 : <input type="text" name="useremail" size="15"
								maxlength="30" /> 비밀번호 : <input type="password" name="userpwd"
								size="15" maxlength="12" /> <input type="submit"
								id="loginbutton" value="로그인" />
						</form>
					</div>
				</c:if>

				<c:if test='${not empty user}'>
					<div style='text-align: right'>
						${user.username}님 로그인 중 &nbsp;&nbsp; <input type="submit"
							id="logout" onClick="userLogout()" value="로그아웃" />
					</div>
				</c:if>

				<br> <br> <br> <br>

				<!-- 제목 시작 -->
				<div class="site-branding">
					<a href="./main.do"><img src="./source/img/logo.jpg"
						class="logo" /></a> <br>
					<h2 class="site-description">위치기반 &nbsp;&nbsp;&nbsp;주차장 / 주정차
						&nbsp;&nbsp;&nbsp;정보</h2>
				</div>
				<!-- 제목 끝 -->

				<!-- 네비, nav 시작 -->
				<nav id="site-navigation" class="main-navigation">
					<div class="menu-container">
						<ul id="menu-1" class="menu">
							<li><a href="./parking.do"><img
									src="./source/img/parking.png" width="45px" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
							<li><a href="./stop.do"><img src="./source/img/stop.png"
									width="45px" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
							<li><a href="./information.do"><img
									src="./source/img/information.png" width="45px" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
							<li><a href="./notice.do"><img
									src="./source/img/notice.png" width="45px" /></a></li>
						</ul>
					</div>
				</nav>
				<!-- 네비, nav 끝 -->

			</header>
			<!-- header 끝 -->


			<!-- Main Content 시작 -->
			<div id="content" class="site-content">
				<div id="primary" class="content-area column full">
					<main id="main" class="site-main"> <!-- Main Content 시작 -->
					<!-- article 시작 -->
					<article id="post-39"
						class="post-39 page type-page status-publish hentry">


						<div class="parkingcentericon">
							<a><img src="./source/img/parking.png" width="150px" /></a>
						</div>

						<br>

						<div class="headerButtondiv">
							<a href=./parking.do><input type="button"class="headerButton" value="즐겨 찾기"></a>
							 <input id="MyParkPs"	type="button" class="headerButton" value="주차 위치"> 
							 <input
								id="MyPosition" type="button" class="headerButton" value="내 위치">
						</div>

						<!-- map 시작 -->
						<div class="entry-content">
							<div id="map" style="width: 100%; height: 500px;"></div>

							<script type="text/javascript"
								src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0f4f915f91717b8e6f20f6b1f4018f2a"></script>

							<script>
            var mapContainer = document.getElementById('map'), 
                mapOption = { 
                    center: new kakao.maps.LatLng(35.162307, 128.985956), 
                    level: 3
                };
            
            var map = new kakao.maps.Map(mapContainer, mapOption); 
            var mapTypeControl = new kakao.maps.MapTypeControl();

         map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

         var zoomControl = new kakao.maps.ZoomControl();
         map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
            
            var positions = [];
            
            <c:forEach var="lots" items="${lots}">
            positions.push({content:'<div>${lots.prkplceNm}</div><br><a href="javascript:callFunction();" style="color:red" target="_blank">즐겨찾기</a> <a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></div>', latlng: new kakao.maps.LatLng(${lots.latitude}, ${lots.longitude})})
            </c:forEach>
            
            
            for (var i = 0; i < positions.length; i ++) {
            
                var marker = new kakao.maps.Marker({
                    map: map, 
                    position: positions[i].latlng // 마커의 위치
                });
            
            	
                var infowindow = new kakao.maps.InfoWindow({
                    content: positions[i].content // 인포윈도우에 표시할 내용
                });
            
                kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
                //kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
            }
            
            function makeOverListener(map, marker, infowindow) {
                return function() {
                    infowindow.open(map, marker);
                };
            }
            
            function makeOutListener(infowindow) {
                return function() {
                    infowindow.close();
                };
            }              
            </script>

						</div>
						<!-- map 끝 -->

					</article>

					</main>
				</div>
			</div>
			<!-- Main Content 끝 -->


			<!-- 댓글 읽기 -->
			<table width='99%'>
				<c:forEach var="comment" items="${article.comments}">
					<tr>
						<td colspan=2 height=1 background=./source/img/dotline.gif></td>
					</tr>
					<tr>
						<td width=100><b>${comment.writer}</b><br> <span
							style='font-size: 70%'>${comment.idate}<br>
								${comment.ip} &nbsp; &nbsp;
								<button id='b${comment.cmid}'
									onClick='mydelete(${comment.cmid})'>x</button>
						</span> <!-- 댓글 삭제 폼 --> <span id='${comment.cmid}' style='display: none'>
								<form method=post action=./delete_comment.do>
									<input type='hidden' name='page' value='${page}'> 암호 <input
										type=password name=password size=5> <input type=hidden
										name='num' value='${comment.cmid}'> <input type=hidden
										name='read_num' value='${article.bid}'> <input
										type=submit value='삭제'>
								</form>
						</span></td>
						<td>${comment.contents}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan=2 height=1 background=./source/dotline.gif></td>
				</tr>
			</table>

			<!-- 댓글쓰기 -->
			<form id='comment' action='./comment.do' method='post'>
				<input type='hidden' name='bid' value='${article.bid}'> <input
					type='hidden' name='page' value='${page}'>
				<div style='text-align: center'>
					<table width='95%'>
						<tr>
							<td align=center><textarea name='contents' cols='65'
									rows='5' onFocus='edit()'>    
    </textarea></td>
						</tr>
						<tr>
							<td align=right>이름<input type='text' name='writer' size='10'>
								비밀번호<input type='password' name='password' size='10'> <input
								type='submit' value='등록'></td>
						</tr>
					</table>
				</div>
			</form>

			<br> <br>

			<!-- footer 시작 -->
			<footer id="colophon" class="site-footer">
				<div class="container">
					<div class="site-info">
						<br>
						<h3
							style="font-family: ''; color: #ccc; font-weight: 300; text-align: center; margin-bottom: 0; margin-top: 0; line-height: 1.4; font-size: 20px;">코.하.친
							(코딩하는친구들)</h3>
						<br> <a>Training for the 4th Industrial Revolution.</a><br>
						<a>2019, Open API를 활용한 빅데이터 전처리·시각화(B반)</a>
					</div>
				</div>
			</footer>
			<!-- footer 끝 -->


		</div>
</body>
</html>