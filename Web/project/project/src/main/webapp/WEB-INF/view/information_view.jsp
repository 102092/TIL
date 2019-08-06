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
    form{ display:inline }
    .joinicon { float:right; margin-left:10px; }
    #joinbutton { margin-top:3px; width:90px; }
    #loginbutton { width:90px; }  
  </style>
  <!-- style, css 끝 -->
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
 
  <div id="main">
  <h2>이용 안내</h2>
  <h4>본 프로잭트는 오픈API를 활용하여</h4>
  <h4>주차장 및 주정차 정보를 제공하는 웹페이지로</h4>
  <h4>누구나 자유롭게 사용가능합니다.</h4>
  <br>
  <h4>공공데이터 활용 현황</h4>
  <p>전국 주차장 현황</p>
  <p>주정차 금지구역 현황</p>  
  <p>주정차 단속현황</p>    
  </div>
    
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