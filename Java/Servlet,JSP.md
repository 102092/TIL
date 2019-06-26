# Servlet, JSP

### 참고

- [한권으로 끝내는..](https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=178972777) -> 주교재



### 목록





----

## Servlet

- 톰켓(WAS) 위에서 java를 이용하여 동작하는 프로그램

  ![](https://t1.daumcdn.net/cfile/tistory/1258DB204C8DEAE334)

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
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
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

     (GET,POST, PUT,DELETE)....(doGet,doPost,doPut..)

     메서드가 return되면 해당 쓰레드는 GC됨.

   - `destroy()`

     메모리에 올라간 Servlet객체를 제거하는 역할이고.

     Web Application갱신 or WAS가 종료될때

## JSP

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



### JSP vs Servlet

- [https://gmlwjd9405.github.io/2018/11/04/servlet-vs-jsp.html](https://gmlwjd9405.github.io/2018/11/04/servlet-vs-jsp.html)

- [https://anster.tistory.com/128](https://anster.tistory.com/128)