<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
		<h1>HOME</h1>
		         <c:if test="${not empty loggedInUser }">
                    	<p id="success">${loggedInUser }</p>
                    	<c:remove var="loggedInUser" scope="session" />
         </c:if>
         <c:if test="${not empty errorMessage }">
                    	<p id="fail" >${errorMessage }</p>
                    	<c:remove var="errorMessage" scope="session" />
         </c:if>
		
	</body>
</html>