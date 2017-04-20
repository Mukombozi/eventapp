<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/include.jsp" %>
<div id="article">
<c:if test="${!visa}">
<h1>Il faut d'abord se connecter!!</h1>
</c:if>

<c:if test="${visa}">
Nom :      <c:out value="${name}"/><br>
Prenom :   <c:out value="${lastname}"/><br>
Login :    <c:out value="${username}"/><br>
email :    <c:out value="${email}"/><br>
Téléphone :<c:out value="${telephone}"/><br>  
<br><br>
<h1> Mes Evenements,</h1><br> 
<table target="_apart">
<th>Title</th>
<th>Le lieu</th>
<th>La date</th>
<th>l'heure de debut</th>
<th>l'heure de fin</th>
<th>La description</th>
 <c:forEach items="${userEv}" var="event">
	<tr>
	<td><c:out value="${event.getEventTitle()}"/></td>
	<td><c:out value="${event.getEventPlace()}"/></td>
	<td><c:out value="${event.getEventDate()}"/></td>
	<td><c:out value="${event.getEventHrs()}" /></td>
	<td><c:out value="${event.getEventEH()}" /></td>
	<td><c:out value="${event.getEventDesc()}"/></td>
	</tr>
 </c:forEach>
</table>
</c:if>
</div>
