<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/include.jsp" %>
<html ng-app="eventApp">
  <head><title><fmt:message key="title"/>::${param.pageTitle}</title>
  <meta http-equiv="Content-Type" content="text/html; charset-UTF-8"> 
  <link rel="stylesheet" type="text/css" 
  href="<c:url value='/resources/css/home.css'/> " />     
  
  <script src="<c:url value='/resources/js/angular.js'/>" ></script>  
  <script src="<c:url value='/resources/js/angular-route.js'/>" ></script>  

  <script src="<c:url value='/resources/js/eventapp.module.js'/>" ></script>  
  <script src="<c:url value='/resources/js/component.eventfetch.js'/>" ></script>  
  <script src="<c:url value='/resources/js/component.eventdetail.js'/>" ></script>
  <script src="<c:url value='/resources/js/routeConfig.js'/>" ></script>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
  
     
  </head> 
  <body >	
	<jsp:include page="/resources/jsp/header.jsp"/>
	<jsp:include page="/resources/jsp/${param.content}.jsp"/>
	<jsp:include page="/resources/jsp/footer.jsp"/>
   </body>
</html>