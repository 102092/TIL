<%@ page contentType="text/html;charset=utf-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<html>
<head>
  
  <title>Elegant Packing Stop</title>  
   
  <!-- style, css 시작 --> 
  <link rel='stylesheet' href='./source/css/style.css' type='text/css' media='all'/>  
  
  <style>
    .logo{ width:400px; }
    .headerButton{ float:right; margin-left:15px; margin-bottom:5px; width:120px; }
    .mapButton{ float:right; margin-left:10px; margin-top:5px; width:90px; }
    .stopcentericon{ position:relative; text-align:center; }
    form{ display:inline }
    .joinicon { float:right; margin-left:10px; }
    #joinbutton { margin-top:3px; width:90px; }
    #loginbutton { width:90px; }  
  </style>
  <!-- style, css 끝 -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 
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
		var marker = new kakao.maps.Marker({ 
		    position: map.getCenter() 
		}); 
		
		marker.setMap(map);
		kakao.maps.event.addListener(map, 'dbclick', function(mouseEvent) {    
		    
		    var latlng = mouseEvent.latLng; 	
		    marker.setDraggable(true); 		    
		    
		});
		
	});
});

</script>
  
</head>


<!-- body 시작 -->
<body class="home page page-template page-template-template-portfolio page-template-template-portfolio-php">

  <div id="page">
    <div class="container">  
    
    <!-- header 시작 -->		
    <header id="masthead" class="site-header">
 
      <c:if test='${empty user}'>
    	<div  >
    	 <form class='joinicon' >  
             <a href="./join.do"><input type="button" id='joinbutton' value="회원가입"></a>
         </form>
                
         <form action="./login.do" method='post' class='joinicon'>
        	 아이디 : <input type="text" name="useremail" size="15" maxlength="30"/>
        	 비밀번호 : <input type="password" name="userpwd" size="15" maxlength="12"/>
        	 <input type="submit" id="loginbutton" value="로그인" />
         </form> 
        </div>
      </c:if>

	  <c:if test='${not empty user}'>
		<div style='text-align:right'>
    		${user.username}님 로그인 중 &nbsp;&nbsp;
    		<input type="submit" id="logout" onClick="userLogout()" value="로그아웃" />
		</div>
	 </c:if> 
      
      <br>
      <br>
      <br>
      <br>

    <!-- 제목 시작 -->            
    <div class="site-branding">
      <a href="./main.do"><img src="./source/img/logo.jpg" class="logo" /></a>
      <br>
      <h2 class="site-description">위치기반 &nbsp;&nbsp;&nbsp;주차장 / 주정차 &nbsp;&nbsp;&nbsp;정보</h2>
    </div>
    <!-- 제목 끝 -->
        
    <!-- 네비, nav 시작 -->    
    <nav id="site-navigation" class="main-navigation">        
        <div class="menu-container">
          <ul id="menu-1" class="menu">                        
            <li><a href="./parking.do"><img src="./source/img/parking.png" width="45px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
            <li><a href="./stop.do"><img src="./source/img/stop.png" width="45px"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
            <li><a href="./information.do"><img src="./source/img/information.png" width="45px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>                
            <li><a href="./notice.do"><img src="./source/img/notice.png" width="45px"/></a></li>           
          </ul>
         </div>
    </nav>
    <!-- 네비, nav 끝 -->
             
  </header>
  <!-- header 끝 -->    
   
      
  <!-- Main Content 시작 -->     
  <div id="content" class="site-content">
    <div id="primary" class="content-area column full">
      <main id="main" class="site-main">

        <!-- Main Content 시작 -->      
        <!-- article 시작 -->    
        <article id="post-39" class="post-39 page type-page status-publish hentry">
         
        
          <div class="stopcentericon">
            <a><img src="./source/img/stop.png" width="150px"/></a>
          </div>
              
          <br>    
              
          <div class="headerButtondiv">          
            <a href=./parking.do><input type="button" class="headerButton" value="즐겨 찾기"></a>
            <a href=./parking.do><input type="button" class="headerButton" value="주차 위치"></a>
            <input id="MyPosition" type="button" class="headerButton" value="내 위치" >    
          </div>
       
          <!-- map 시작 -->            
          <div class="entry-content">             
            <div id="map" style="width:100%;height:500px;"></div>  
            
            <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0f4f915f91717b8e6f20f6b1f4018f2a"></script>
            
            <script>
            var mapContainer = document.getElementById('map'), 
                mapOption = { 
                    center: new kakao.maps.LatLng(37.500020, 127.112212), 
                    level: 6 
                };
            
            var map = new kakao.maps.Map(mapContainer, mapOption); 
            
            
            </script>         
             
         <div class="stopmapButton"> 
          <a href=./parking.do><input type="button" class="mapButton" value="단속 현황"></a>
          <a href=./parking.do><input type="button" class="mapButton" value="모두 보기"></a>
          <a href=./parking.do><input type="button" class="mapButton" value="주정차 금지"></a>
          <a href=./parking.do><input type="button" class="mapButton" value="주정차 가능"></a>
         </div>  
                  
          </div>
          <!-- map 끝 -->          
       
          
        </article>
        
      </main>     
    </div>
  </div>
  <!-- Main Content 끝 -->    
 
        <br>
        <br>             
      
    <!-- footer 시작 -->  
    <footer id="colophon" class="site-footer">
      <div class="container">
        <div class="site-info">
        <br>
          <h3 style="font-family:'';color: #ccc;font-weight:300;text-align: center;margin-bottom:0;margin-top:0;line-height:1.4;font-size: 20px;">코.하.친 (코딩하는친구들)</h3><br>
          <a>Training for the 4th Industrial Revolution.</a><br>
          <a>2019, Open API를 활용한 빅데이터 전처리·시각화(B반)</a>
        </div>
      </div>
    </footer>
   <!-- footer 끝 -->    
  
  
  </div>
</body>
</html>