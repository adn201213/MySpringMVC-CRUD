<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Survey</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Survey Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Survey</h3>
	
		<form:form action="saveSurvey" modelAttribute="surveys" method="POST">

			<!-- need to associate this data with Survey id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Survey Name:</label></td>
						<td><form:input path="name" /></td>
					</tr>
				
					<tr>
						<td><label>Creator Name:</label></td>
						<td><form:input path="creator" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/survey/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>









