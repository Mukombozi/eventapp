<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/include.jsp" %>
<div id="article">
<spring:url value="/event.htm" var="homeUrl"/>
	
    <c:if test="${!visa}">
	   <h1>Il faut d'abord se connecter!!</h1>
	</c:if>	
	<c:if test="${visa}">
	<form:form  modelAttribute="event" method="post" action="${homeUrl}" >
	<table >      
	   <tr>
	   <td align="right" >Le title :</td>
	   <td> <form:input path="eventTitle"/></td><td><form:errors path="eventTitle" cssClass="error"/></td>
	   </tr>
	   <tr>
	   <td align="right" >Le lieu :</td>
	   <td> <form:input path="eventPlace"/></td><td><form:errors path="eventPlace" cssClass="error"/></td>
	   </tr>
	   <tr>
	   <td align="right" >La date :</td>
	   <td> <form:input path="eventDate"/></td><td><form:errors path="eventDate" cssClass="error"/></td>
	   </tr>
	   <tr>
	   <td align="right" >L'heure de debut :</td>
	   <td> <form:input path="eventHrs"/></td><td><form:errors path="eventHrs" cssClass="error"/></td>
	   </tr>
	   <tr>
	   <td align="right" >L'heure de fin :</td>
	   <td> <form:input path="eventEH"/></td><td><form:errors path="eventEH" cssClass="error"/></td>
	   </tr>
	   <tr>
	   <td align="right" ">Descrition :</td>
	   <td> <form:textarea   path="eventDesc" rows="20" cols="60"  /></td>
	   </tr>	   	  
    </table>
		<input type="submit"  value="Enregistrer"/>
	</form:form>
	</c:if>
</div>	