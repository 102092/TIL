# Servlet, JSP

### 참고

- [한권으로 끝내는..](https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=178972777) -> 주교재



### 목록





----

## Servlet

- 톰켓(WAS) 위에서 java를 이용하여 동작하는 프로그램

- 웹에서의 요청을 받아서, 처리한다음에 처리 결과를 동적으로 응답페이지(html)를 생성하고 응답해주는것

  ![](https://t1.daumcdn.net/cfile/tistory/1258DB204C8DEAE334)

- WAS? : web server + Application server

  ​			(http listener, http daemon) + webcontainer

  

- 기본 servlet 작성코드

```java
package lab.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;//웹서버에서 수행되는 servlet이 상속받는
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
    public void init(){//override 하지 않으면 부모의 init()수행
        //서블릿이 요청되어서 컨테이너 메모리에 생성될때 1번만 수행됨
        System.out.println("init(): 초기화");
    }
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{//requset 요청시 필요한 객체, response응답시 필요한 객체
        //서블릿 요청시마다 반복적으로 수행됨.
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();
        out.print("<html>");
        out.print("<head><title>HelloServlet</title></head>");
        out.print("<body>");
        out.print("Hello 요청에 대한 Servlet 응답 <br>");
        out.print("안녕하세요? 서블릿입니다 ^^");
        out.print("</body></html>");
    }
    public void destory(){
        //override하지 않으면 부모의 destory()가 수행되고,
        //서블릿이 컨테이너로부터 소멸될때 1번만 수행됨.
        System.out.println("destroy(): 컨테이너 종료 또는 GC될때 수행");
    }
}
```

- 이클립스 이용하고, **URL mapping** 명을 따로 지정할 수 있네
- 한글이 포함된 HTML 응답처리는 `HttpServletResponse` 객체의 `getWriter()` 메서드 호출 전에 HttpSeveltResponse 객체의 `setContentType("text/html;charset=utf-8")` 필수적
- `JAVA` 안에 `HTML` 태그가 있음
- Servlet이 수정되면, 매번 java 코드를 컴파일~ .class파일 생성 한 후에 동적인 페이지를 처리하기 때문에 번거로움.
- DB와 통신하는데 유리함. 즉 데이터를 읽고 확인하는 작업에 유리함
- HTML태그를 넣기에 불편해...
- 병렬쓰레드..



1. **기본적인 동작 과정**
   - `web.xml` 확인하고 적절한 Servlet실행
   - Servlet 파일 컴파일 = .class파일 생성, Servlet 객체를 메모리에 올리고,
   - Servlet객체 초기화 = `Init()` 메서드 실행
   - WAS에서 Request가 올때마다, thread 생성(병렬로..)
   - 각 thread는 단일 객체에 대해 `service()` 메서드를 실행..

2. **Servlet Life Cycle**

   ![](https://t1.daumcdn.net/cfile/tistory/99A3353A5AD5C72122)

   - `init, destroy`는 한번만 수행.

   - `service()` 

     HTTP Method에 대해 적절한 메서드를 구현해야함.

     (GET,POST, PUT,DELETE)....(doGet,doPost,doPut....)

   - `destroy()`

     메모리에 올라간 Servlet객체를 제거하는 역할이고.

     Web Application갱신 or WAS가 종료될때

3. **Servlet 준수사항**

   - 패키지 선언

   - public class로 선언

   - `httpServlet` 상속을 받아야함

   - `life cycle` 메서드를 `override`해줘야하고

     반드시 `override`해줘야하는 메서드는? `service(), doSet(), doGet(), doPost(), doPut()` 왜? 요청처리및 응답을 위해서는 반드시 해야되는 메서드.

   - `service(httpServletRequest, requset, HttpServletResponse response) throws ServletException, IOExeception` 예외처리 꼭해줘야함.

4. **Servlet 장점**

   - 자바 기반 (자바 API 모두 사용 가능)
   - 운영체제, 하드웨어 영향을 받지 않음
   - 쓰레드 기반.. 운영에 효율적



#### Q1) Servlet을 통해 HTTP 헤더구조 가져오기.

```java
package lab.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HeaderInfo
 */
@WebServlet("/header")
public class HeaderInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeaderInfo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Request Header 정보</title></head>");
		out.print("<body>");
		out.print("<h3>Requset Header정보</h3>");
		out.print("<ul>");
		Enumeration<String> headerName = request.getHeaderNames();
		while(headerName.hasMoreElements()) {
			String name = headerName.nextElement();
			out.print("<li>"+name+" : ");
			Enumeration<String> values = request.getHeaders(name);
			while(values.hasMoreElements()) {
				out.print(values.nextElement()+", ");
			}
			out.print("</li>");
		}
		out.print("<li> 요청메소드 : "+request.getMethod()+"</li>");
		out.print("<li> 요청한 clinet IP : "+request.getRemoteAddr()+"</li>");
		out.print("<li> ContextPath : "+request.getContextPath()+"</li>");
		out.print("<li> RequestURI : "+request.getRequestURI()+"</li>");
		out.print("<li> RequestURL : "+request.getRequestURL()+"</li>");
		out.print("<li> ServletPath : "+request.getServletPath()+"</li>");
		out.print("</ui></body></html>");
	}
}
```

- 결과

![](Servlet,JSP.assets/getHeader.png)



#### Q2) Servlet을 통해 Multiple한 파일 업로드 웹페이지 만들기

1. **html**

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fileupload 실습</title>
<style>
	input{
		margin: 2px;
	}
</style>

</head>
<body>
	<h2>fileupload 실습</h2>
	<form action="upload" method="post" enctype="multipart/form-data">
	작성자 이름 : <input type="text" name="theAuthor"><br>
	작성자 나이 :  <input type="text" name="theAge"><br>
	업로드 파일 : <input type="file" name="theFile" multiple/><br>
	<input type="submit" value="전송"/>
	</form>
</body>
</html>
```

2. **java_servlet**

```java
package lab.web.controller;

//import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload")//html action에 따른 주소
@MultipartConfig (location = "c:/uploadtest", maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*5)//업로드 되는파일사이즈 5mb, 요청데이터사이즈25mb
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		String path = "C:/uploadtest";		
//		File isDir = new File(path);
//		if(!isDir.isDirectory()) {
//			isDir.mkdir();
//		} 해당 주소에 폴더가 없으면 생성할 수 있는 코드
        
		Collection<Part> parts = request.getParts();
		for(Part part : parts) {
			if(part.getContentType() !=null) { // upload된 파일은 여기로
				String fileName = part.getSubmittedFileName();
				if(fileName != null) {
					part.write(fileName.substring(0,fileName.lastIndexOf("."))+"_"+System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf(".")));
					out.print("<br>업로한 파일 이름 : "+fileName);
					out.print("<br>크기 : "+part.getSize());
					}
			}else{ //폼 파일은 여기로
				String partName = part.getName();
				String fieldValue = request.getParameter(partName);
				out.print("<br>"+partName + " : "+fieldValue);
			}
		}
			out.close();
	}
}
```

3. **결과**

![](Servlet,JSP.assets/upload.png)

#### Q3)  Resquest Dispatcher

- form에서 메세지를 받고, request 추가적인 정보을 설정하여, jsp를 통해 그 2가지 결과를 출력하기,

1. **Message.jsp**

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>message.jsp</title>
</head>
<body>
<h3>메세지 전송</h3>
	<form action = "./message" method="post">
		메세지 입력하세요 : <input type="text" name = "msg" size= 50><br>
		<br>
		<input type="submit" value="전숭">	
	</form>

</body>
</html>
```

- `/view` 폴더 안에 있어서 정상적으로 접근 불가함.

2. **result.jsp**

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
#blue {
	color: blue;
}

#green {
	color: green;
}
</style>
<title>result.jsp</title>
</head>
<body>
	<h3>메세지 전송 결과</h3>
	message.jsp에서 보낸 파라미터 메세지 :
	<p id="blue">
	<%
	out.println(request.getParameter("msg")+"<br>");
	%>
	</p>

	<p id="green">
	<%
	String msg2 = (String)request.getAttribute("msg2");
	out.println(msg2+"<br>");
	%>	
	</p>
</body>
</html>
```

3. **ForwadServlet.java**

```java
package lab.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/message")
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext sctx;
	RequestDispatcher rd;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			sctx = request.getServletContext();
			rd = sctx.getRequestDispatcher("/WEB-INF/view/message.jsp");
			rd.forward(request, response);
	}//일반적인 get으로 접근했을 때는 message.jsp로 가게 해주고


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		request.setAttribute("msg2", "email.hi@gmail.com");
		sctx = request.getServletContext();
		rd = sctx.getRequestDispatcher("/WEB-INF/view/result.jsp");
		rd.forward(request, response);
	}//post
}
```

- 일반적인 `get`으로 접근했을 때는 `message.jsp`로 가게 해주고
- `post`방식으로 접근했을 때는, `msg2` 에 새로운 속성을 추가한다음 그 결과를 `result.jsp` 에 넘겨준다

4. **결과**

- 전송전

![](Servlet,JSP.assets/forward1.png)

- 전송후

![](Servlet,JSP.assets/forward2.png)

#### Q4 Cookies 활용하여, 아이디 저장칸 만들기

- 쿠키가 저장되어있다면, 자동으로 로그인 id에 작성되도록 만들어보자



1. **login, logout.jsp**

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>사용자 로그인</title>
</head>
	<body>
	<h3 id='header'>사용자 로그인</h3>
	<div id='main' style='text-align:center'>
		<br><br> 
		<form method=post action="cookieLogin" >
		<table style='border:1px #0000FF dotted;text-align:center'>
		<tr><td>사용자 ID </td>
		     <%
		     if(request.getAttribute("userid")==null){
		   	 %>
		   	 <td><input type=text name=userid></td></tr>
		   	 <%}else{
		   		String uid = (String)request.getAttribute("userid");
		   		 %>
		   		 <td><input type=text name=userid value="<%=uid%>"></td></tr>
		   	 <%} %>		    
		  <tr><td>사용자 암호 </td>
		    <td><input type=password name=passwd></td></tr>
		  <tr><td>아이디 저장 사용 </td>
		    <td><input type=checkbox name=cookie></td></tr>			
		  <tr><td colspan=2 style='text-align:right'>
			<input type=submit value='로그인'>
			<input type=reset value='취소'></td></tr>
	</table>
</form></div></body></html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout.jsp</title>
</head>
<body>
	<script>
		alert("로그아웃되었습니다.\n 쿠키 정보 삭제되었습니다");
		location.href ="./login.jsp";
	
	</script>

</body>
</html>
```



2. **main.jsp**

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
<%=request.getAttribute("userid") %> 님 환영합니다! :) <br>
<a href="cookieLogout"><button>로그아웃</button></a><br> 
</body>
</html>
```

- `login` 에 성공하였을 때 보여줄 페이지. 로그아웃 선택하면 `cookieLogout` servlet을 실행하도록 만들었다.



3. **CookieLogin , Logout servlet**

```java
package lab.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieLogin")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String uid = null, passwd = null;
	ServletContext sctx = null;
	RequestDispatcher rd = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		uid = request.getParameter("userid");
		passwd = request.getParameter("passwd");
		String userCookie = request.getParameter("cookie");
		
		if(userCookie != null) {
			Cookie uidCookie = new Cookie("userid", uid);
			uidCookie.setMaxAge(60*60*24*365); //1년간 저장한다.
			response.addCookie(uidCookie);
		}
		if(uid.equals("admin") && passwd.equals("1234")) {
			request.setAttribute("userid", uid);
			sctx = request.getServletContext();
			rd = sctx.getRequestDispatcher("/main.jsp");
			rd.forward(request, response);
		}
		else {
			out.println("<script>");
			out.println("alert(\'아이디 또는 비밀번호 오류입니다.\')");
			out.println("location.href=\"./login.jsp\"");
			out.println("</script>");
		}

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
		
		Cookie cookies[] = request.getCookies();
		if(cookies!=null) {
			for(int i =0; i < cookies.length; i++) {
				String name = cookies[i].getName();
				if(name.equals("userid")){
					uid = cookies[i].getValue();
					//System.out.println(uid); 아이디가 정상적으로 들어오는지 확인
				}
			}
			request.setAttribute("userid", uid);
		}
		sctx = request.getServletContext();
		rd = sctx.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);

	}

}
```

```java
package lab.web.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieLogout")
public class CookieLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	ServletContext sctx = null;
	RequestDispatcher rd = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(int i =0; i<cookies.length; i++) {
				if(cookies[i].getName().equals("userid")){
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}
			}
		}
		sctx = request.getServletContext();
		rd = sctx.getRequestDispatcher("/logout.jsp");
		rd.forward(request, response);
	}

}
```

- **cookieloginservlet을 실행하여 확인한다.**



4. **결과**

- login

![](Servlet,JSP.assets/login.png)

- login_success

![](Servlet,JSP.assets/loginsuccess.png)

- cookies_delete

![](Servlet,JSP.assets/deletecookies.png)

- 쿠키삭제는 개발자 도구 - > application -> cookies에서 확인..

## JSP

- 웹 콘텍스트 표준 구조

- 참고

  1.[https://gmlwjd9405.github.io/2018/10/28/servlet.html](https://gmlwjd9405.github.io/2018/10/28/servlet.html)

  2.[https://technet.tmaxsoft.com/upload/download/online/jeus/pver-20150722-000001/web-engine/chapter_context_web_application.html](https://technet.tmaxsoft.com/upload/download/online/jeus/pver-20150722-000001/web-engine/chapter_context_web_application.html)
  
  ![](https://technet.tmaxsoft.com/upload/download/online/jeus/pver-20150722-000001/web-engine/resources/sample_war_file_contents.png)
  
- WEB-INF(보안폴더)

  ​	 lib(외부 자바 library)

  ​	 web.xml(웹콘텍스트의 환경설정파일, 컨텍스트의 파라미터,리스너,웰컴페이지..)

  

- 웹페이지 콘텐츠의 정적인 내용은 `HTML` or `XML` 기술로 작성하고 동적인 내용은 `JSP,스크립트` 코드로 작성하는 기술.

  정적? 클라이언트가 서버에 요청하면, **미리** 준비된 문서를 전달하는 방식.

  동적? 클라이언트가 서버에 요청하면, **가공처리후 생성된**   문서를 전달하는 방식.

![](http://i0.wp.com/lh3.googleusercontent.com/-mFaOm0EGIvA/VqeJYe_b_yI/AAAAAAAAADA/FDiCN9Zp_hg/w720-o/static-vs-dynamic-web-inside.png?w=734&ssl=1)

- JSP 컴파일 순서

![](https://t1.daumcdn.net/cfile/tistory/2250A34E541E7D6602)

- 직접 실행되지 못함. JSP 코드에 해당되는 *Servlet 파일을 만들어서*, 그 서블릿이 실행되는 방식임.

  서블릿은 매번 생성되는 건 아니고, 컴파일된 class 파일이 없는 경우만 생성.

- **서블릿 컨테이너 Servlet Contatiner** = **WAS(web application server)**

```jsp
<%@ page import ="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello.jsp</title>
</head>
<body>
	이클립스에서 만든 hello.jsp 페이지 입니당<br>
	<%//자바코드삽입
	Date now = new Date();
	out.println(now);	
	%>
</body>
</html>
```

- 이클립스를 이용해서 JSP를 생성한다.
- `HTML` 내부에 자바 코드가 삽입됨

- 접속은? `http://localhost:8080/../hello.jsp`

- 가능한 인코딩은 `utf-8`로..
- 알아둬야할 표현
  1. 지시자 `<%@...%>`
  2. 스트립틀릿 `<% 자바코드..%>`
  3. 선언문 `<%!.... %>`
  4. 표현식` <%=....%>`

- 수정된 경우 WAS가 알아서 처리함. 쉽게 배포됨.



1. **JSP 준수사항**
   - 정적페이지 선언 `<%@ page .....%>` 

### JSP vs Servlet

- [https://gmlwjd9405.github.io/2018/11/04/servlet-vs-jsp.html](https://gmlwjd9405.github.io/2018/11/04/servlet-vs-jsp.html)

- [https://anster.tistory.com/128](https://anster.tistory.com/128)