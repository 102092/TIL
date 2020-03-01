<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<html>
<head>  
    
  <title>Elegant Packing Stop</title>
   
  <!-- style, css 시작 -->  
  <link rel='stylesheet' href='./source/css/style.css' type='text/css' media='all'/> 
  
  <style>  
    table { width: 60%; margin: auto; padding : 10px; }
    .logo{ width:auto; height:auto; width:400px; }
    .inputButton{ float:right; margin-left:15px; width:120px; }  
  </style>
   <!-- style, css 끝 -->
   
</head>

<!-- body 시작 -->
<body class="home page page-template page-template-template-portfolio page-template-template-portfolio-php">

<div id="page">
  <div class="container">
  
  <!-- header 시작 -->    
  <header id="masthead" class="site-header">

  <!-- 제목 시작 -->
  <div class="site-branding">       
    <a href="./main.do"><img src="./source/img/logo.jpg" class="logo" /></a>
    <br>
    <h2 class="site-description">위치기반 &nbsp;&nbsp;&nbsp;주차장 / 주정차 &nbsp;&nbsp;&nbsp;정보</h2>
  </div>
  <!-- 제목 끝 -->  
  
  <!-- 회원가입 내용시작 -->
  <div id="main">
  <form method='post' action='./join.do' >
    <table >     
      <tr><td colspan=2 height=1 background=./source/img/dotline.gif></td></tr>
        
        <tr>
         <th style="width:100;text-align:left;">이 름</th>
         <td><input type="text" name="username"> </td>
        </tr>
        
        <tr>
          <th style="width:100;text-align:left;">이메일</th>
            <td>
              <input type='text' name="email">&nbsp;@
              <input type='text' name="email_dns">
                <select name="dns_Add">
                   <option value="">직접입력</option>
                   <option value="daum.net">daum.net</option>
                   <option value="empal.com">empal.com</option>
                   <option value="gmail.com">gmail.com</option>
                   <option value="hanmail.net">hanmail.net</option>
                   <option value="msn.com">msn.com</option>
                   <option value="naver.com">naver.com</option>
                   <option value="nate.com">nate.com</option>
                </select>
           </td>
       </tr>
      
       <tr>
         <th style="width:100;text-align:left;">비밀번호</th>
         <td><input type="password" name="userpwd"> </td>
       </tr>
      
       <tr>
         <th>비밀번호 확인</th>
         <td><input type="password" name="mbpw_re"></td>
        </tr>
       
       <tr><td colspan=2 height=1 background=./source/img/dotline.gif></td></tr>     
   </table>
   <br>
         
   <table>      
       <tr>
         <td colspan="2" align="center">               
            <input type="reset" value="취소" class="inputButton">
            <input type="submit" value="회원가입" class="inputButton">
         </td>
       </tr>           
   </table>
           
</form>
</div>
<!-- 회원가입 내용끝 -->

</header>
<!-- header 끝 -->

</div>
</div>

</body>
</html>