<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/include.jsp" %>
<html >
  <head><title><fmt:message key="title"/></title>
  <meta http-equiv="Content-Type" content="text/html; charset-UTF-8"> 
  <link rel="stylesheet" type="text/css" 
  href="<c:url value='/resources/css/home.css'/> " />
  </head> 
  <body>
	<div id="header" >	
	<ul >
	  <li ><a href="<c:url value="/home.htm" ></c:url>">Home</a></li>
	  <li ><a href="<c:url value="/profil.htm" ></c:url>">Profil</a></li>
	  <li ><a href="<c:url value="/event.htm" ></c:url>">Nouvel Evenement</a></li>
	  <li ><a href="<c:url value="/find_ev.htm" ></c:url>">Trouver un Evenement</a></li>	  
	  <div class="menu">
	  <li ><a  href="#">Mon compte</a>		
	  <div class="sb">
		<table>
		<form action="#" th:action="@{/home}" th:object="${user}" method="post">
		<tr>
		 <td>Login    </td><td><input  type="text" th:field="*{name}"/></td>
		</tr>
        <tr>		
		 <td>Password </td><td><input type="password" th:field="*{pass}"/></td>
		</tr>
		<tr>
		<td></td><td><input type="submit" value="Submit"/></td>
		</tr>
		<tr>
		 <td></td><td><a  href="<c:url value="create_user.htm"></c:url>"><i>Inscription</i></a></td>
		</tr>
		</form>
	    </table>
	   </div>
	  </li>
	  </div>
	</ul>
	<div id="connect">
	  
	</div>
	</div>
	<div id="article">
	
	</div>
	<div id="footer" >
	Footer
	</div>
	
  </body>
</html>