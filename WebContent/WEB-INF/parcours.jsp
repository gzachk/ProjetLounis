<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Parcours</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>

<script type="text/javascript">
function showScore() {
		var x = document.getElementById('scoreUtilisateur');

		if (x.style.display === "none") {
			x.style.display = "block";
		} else {
			x.style.display = "none";
		}
	}
</script>

	
<body style="font-family: courier">
	<div id="main_div">
		<div id="header_div">
			<h1>Welcome ${MySessionVariable}!</h1>
		</div>

		<div id="content_div" align="center">
		
				<table>
					<thead>
						<tr>
							<th colspan="3">Competences
								<hr>
							</th>

						</tr>
					</thead>
					<tbody>
					
					<c:set  var="competNumber" value="0" />
					<c:forEach items="${listeDesCompets}" var="varCompetence">
							<c:if test="${competNumber == 0}" >
							<tr>
							</c:if>
							
								<td>
									<form action="quizz" method="get">
									<input type="submit" style="width:150px" name="competence" value="${varCompetence.getIdCompetence()}"/>
									</form>
									<c:set  var="competNumber" value="${competNumber+1}" />
								</td>
								
							<c:if test="${competNumber == 3}">
							</tr>
							<c:set  var="competNumber" value="0" />
							</c:if>
					</c:forEach>
					
					<c:if test="${competNumber!=0 }">
							</tr>
							<c:set  var="competNumber" value="0" />
					</c:if>
						
						<tr>
							<td colspan="3"><hr></td>
						</tr>

					</tbody>
				</table>
			<button type="button" onclick="showScore()" style="width: 100px">Mon
				Score</button>
			<br>
			<div id="scoreUtilisateur" style="display: none">
				<table>
					<thead>
						<th>Competence</th>
						<th>Score</th>
						<th>Duree</th>
					</thead>
					<c:forEach items="${listeDesCompetsValider}"
						var="varCompetenceValider">
						<tr>
							<td>${varCompetenceValider.getSujetQuizz()}</td>
							<td>${varCompetenceValider.getScore()}/${varCompetenceValider.getNombreQuestion()}</td>
							<td>${varCompetenceValider.getDureeParcours()}</td>
						</tr>
					</c:forEach>
				</table>
				
				
<%-- 				<%@include file="graph.jsp"%> --%>
			</div>

		</div>
		
		
		<c:set var="footerText" value="session Parcours" />
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>
<%-- 				<input type="hidden" name="sessionIsAdmin" value="${MySessionVariableAdmin}" /> --%>
<%-- 				<input type="hidden" name="sessionUserId" value="${MySessionVariableIdUtilisateur}" /> --%>
