	<%@page contentType="text/html" pageEncoding="UTF-8"%>
	<%@ include file="/resources/jsp/include.jsp" %>
	<div id="header">	
	<ul id="table_1">
	  <li ><a href="<c:url value="/home.htm" ></c:url>">Home </a></li> 
	  <li ><a href="<c:url value="/profil.htm" ></c:url>">Profil </a></li>
	  <li ><a href="<c:url value="/event.htm" ></c:url>">Nouvel Evenement</a></li>
	  <li ><a href="<c:url value="/event.htm" ></c:url>">Tous les Evenement</a></li>	  	  
	  <li class="menu"><a href="#"><c:choose>
						 <c:when test="${!visa}">	                    
		                  <p>Mon compte</p>
						 </c:when>
						 <c:when test="${visa}">
		                 <p>Bienvenue <c:out value="${username}" /></p>
						 </c:when>	                     
						</c:choose>  
	                    </a>
      					
	  <div class="sb">
	  
		<table id="conTable">
		<spring:url value="/home.htm" var="loginUrl"/>
		<form:form modelAttribute="user" action="${loginUrl}" method="post">
		<tr>
		 <td>Login    </td><td><form:input   path="userName"/></td>
		</tr>
        <tr>		
		 <td>Password </td><td><form:password path="password"/></td>
		</tr>
		<tr>
		<td></td><td><input type="submit" value="Submit"/></td>
		</tr>
		</form:form>
		<tr>
		 <td></td><td><a href="<c:url value="adduser.htm"></c:url>"><i>Inscription</i></a></td>
		</tr>
        </table>
		
	    </li>	  
	  </div>	  
	</ul>	
	</div>