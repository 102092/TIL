<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">  
  <meta name="viewport" content="width=device-width, initial-scale=1">
 
  <!-- title 시작 -->  
  <title>Elegant Packing Stop</title>
  <!-- title 끝 -->
   
  <!-- style, css 시작 -->
  <link rel='stylesheet' href='css/woocommerce-layout.css' type='text/css' media='all'/>
  <link rel='stylesheet' href='css/woocommerce-smallscreen.css' type='text/css' media='only screen and (max-width: 768px)'/>
  <link rel='stylesheet' href='css/woocommerce.css' type='text/css' media='all'/>
  <link rel='stylesheet' href='css/font-awesome.min.css' type='text/css' media='all'/>
  <link rel='stylesheet' href='./source/css/style.css' type='text/css' media='all'/>
  <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Oswald:400,500,700%7CRoboto:400,500,700%7CHerr+Von+Muellerhoff:400,500,700%7CQuattrocento+Sans:400,500,700' type='text/css' media='all'/>
  <link rel='stylesheet' href='css/easy-responsive-shortcodes.css' type='text/css' media='all'/>
  <!-- style, css 끝 -->
  
  <style>
  .logo{ width:auto; height:auto;
         width:400px;   
  }
  .headerButton{ float:right; margin-left:10px; width:120px;
  }  
  .parkingcentericon{ position:relative; text-align:center; }
   </style>
</head>


<!-- body 시작 -->
<body class="home page page-template page-template-template-portfolio page-template-template-portfolio-php">

  <div id="page">
    <div class="container">  
    
    <!-- header 시작 -->    
    <header id="masthead" class="site-header">
 
      <c:if test='${empty user}'>
        <div style='text-align:right'>
          <a href="./login.do">로그인</a>&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="./join.do">회원가입</a> &nbsp;&nbsp;&nbsp;&nbsp;
        </div>
      </c:if>

      <c:if test='${not empty user}'>
        <div style='text-align:right; font-size:small;'>
          ${user.username}(${user.userid})님 로그인중 &nbsp;&nbsp;&nbsp;&nbsp;
          <a href="" font-size:small;>회원정보 수정</a>&nbsp;&nbsp;&nbsp;
        </div>
      </c:if>
      
      <br>
      <br> 
 
      <!-- 제목 시작 -->            
      <div class="site-branding">
        <a href="./home_view.do"><img src="./source/logo.jpg" class="logo" /></a>
        <br>
        <h2 class="site-description">위치기반 &nbsp;&nbsp;&nbsp;주차장 / 주정차 &nbsp;&nbsp;&nbsp;정보</h2>
      </div>
      <!-- 제목 끝 -->
          
      <!-- 네비, nav 시작 -->    
      <nav id="site-navigation" class="main-navigation">        
          <div class="menu-container">
            <ul id="menu-1" class="menu">                        
                <li><a href="./parking.do"><img src="./source/parking.png" width="45px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
                <li><a href="./stop.do"><img src="./source/stop.png" width="45px"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
                <li><a href="./information.do"><img src="./source/information.png" width="45px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>                
            <li><a href="./notice.do"><img src="./source/notice.png" width="45px"/></a></li>                       
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
        
          <!-- article 시작 -->    
          <article id="post-39" class="post-39 page type-page status-publish hentry">
    
          <!-- Main Content 시작 -->      
          
          <div class="parkingcentericon">
            <a><img src="./source/parking.png" width="150px"/></a>
          </div>
                   
          <header class="entry-header">                       
            <a href=./parking.do><input type="button" class="headerButton" value="즐겨 찾기"></a>
            <a href=./parking.do><input type="button" class="headerButton" value="주차 위치"></a>
            <a href=./parking.do><input type="button" class="headerButton" value="내 위치"></a>         
          </header>
          <!-- Main Content 끝 -->
            
            <div class="entry-content">     
          <!-- map 시작 -->
<div id="map" style="width:70%;height:700px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0f4f915f91717b8e6f20f6b1f4018f2a"></script>
<script>
var mapContainer = document.getElementById('map'), 
    mapOption = { 
        center: new kakao.maps.LatLng(37.500020, 127.112212), 
        level: 6 
    };

var map = new kakao.maps.Map(mapContainer, mapOption); 


var positions = [];

<c:forEach var="lots" items="${lots}">
positions.push({content:'<div>${lots.prkplceNm}</div>', latlng: new kakao.maps.LatLng(${lots.latitude}, ${lots.longitude})})
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
    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
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
		
          <!-- map 끝 -->        
            </div>
          </article>
          
        </main>     
      </div>
    </div>
    <!-- Main Content 끝 -->
    
      <br>
      <br>
      <br>
      <br>
      
    <!-- Main Content 내용 시작 -->  
    <div class="note">
      <h4>Find Us: (888) 252 389 3571</h4>
        <p>If you want to hire me or have any feedback or questions about our service in general, please send us a message by completing our enquiry form. It’s best to call though, someone we’ll always be there for you.</p>
        <p>Monday – Friday: 9am to 5pm<br>
           Saturday: 10am to 2pm<br>
           Sunday: Closed</p>
    </div>  
    <!-- Main Content 내용 끝 -->  
      
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
    <a href="#top" class="smoothup" title="Back to top"><span class="genericon genericon-collapse"></span></a>
  </div>

  <!-- #page -->
  <script src='js/jquery.js'></script>
  <script src='js/plugins.js'></script>
  <script src='js/scripts.js'></script>
  <script src='js/masonry.pkgd.min.js'></script>
  <script src='js/validate.js'></script>
  
</body>
</html>