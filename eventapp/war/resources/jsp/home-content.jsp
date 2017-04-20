<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/include.jsp" %>
<div id="article" >
<h3>My routing test</h3>    
	<div ng-view ></div>
		

  


<br>
<h2>Au jourd'hui le <c:out value="${now}"/>,</h2> <br><h2>A venir cette semaine : </h2><br>
<div id="weekly_event">
<display:table name="events" id="num" pagesize="10"  class="tableClass" requestURI="/home.htm" size="${size}">
	
	<display:column title="num" >
	<%=pageContext.getAttribute("num_rowNum")%></display:column>
	<display:column property="eventTitle" />
	<display:column property="eventDate"  />
	<display:column property="eventPlace" />
	<display:column property="eventHrs"  />
	<display:column property="eventEH" />
	<display:column property="eventDesc" title="Commentaires" class="comClass" />
</display:table>
</div>
<br>
<br>

</div>