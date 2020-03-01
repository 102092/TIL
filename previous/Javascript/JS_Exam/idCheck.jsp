<%@ page contentType="text/plain;charset=utf-8" %>
<%
  String[] ids = new String[]{"test", "admin", "guest"};
  String uid = request.getParameter("userid");
  String result = "valid";
  for(int i=0;i<ids.length;i++){
	  if(ids[i].equals(uid)){
		  result ="invalid"; 
		  break;
	  }
  }
   
		  out.println(result);
 
%>