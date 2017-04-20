<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/include.jsp" %>
<div id="article">
	<h1> Nouvel Utilisateur</h1><br><br>
	<spring:url value="/adduser.htm" var="adduserUrl"/>
	<form:form method="post" modelAttribute="user" action="${adduserUrl}">
		<table >
		  <tr>
			<td >Nom :</td>
			<td><form:input path="name"/></td><td><form:errors path="name" cssClass="error"/></td>
	      </tr>
		  <tr>
			<td>Prenom :</td>
			<td><form:input path="lastName"/></td><td><form:errors path="lastName" cssClass="error"/></td>
	      </tr>
		  <tr>
			<td>Login :</td>
			<td><form:input path="userName"/></td><td  ><form:errors path="userName" cssClass="error"/></td>
	      </tr>
		  <tr>
			<td>Mot de passe :</td>
			<td><form:input path="password"/></td><td  ><form:errors path="password" cssClass="error"/></td>
	      </tr>
		  <tr>
			<td>Confirmer, mot de passe :</td>
			<td><form:input path="confPassword"/></td><td><form:errors path="confPassword" cssClass="error"/></td>
	      </tr>
		  <tr>
			<td>Email :</td>
			<td><form:input path="email"/></td><td  ><form:errors path="email" cssClass="error"/></td>
	      </tr>
		  <tr>
			<td>Tel :</td>
			<td><form:input path="tel"/></td><td  ><form:errors path="tel" cssClass="error"/></td>
	      </tr>
		</table>
		<br>
		<input type="submit" align="center" value="Enregistrer"/>
	</form:form>
	</div>	