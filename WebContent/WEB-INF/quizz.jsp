<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quizz</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
</head>

<body style="font-family: courier">

	<div id="main_div">
		<div id="header_div">
			<h1> ${competenceQuizz}!</h1>
		</div>

		<div id="content_div" align="center">
			<form action="quizz" method="post">


				<c:set var="numQuestion" value="0" />
				<c:forEach var="question" items="${listeQuestions}">
					<c:set var="numQuestion" value="${numQuestion+1}" />
					<div class="question_div">
						<!-- ---------------------------------------------- -->
						<table class="questionnaire">
							<thead>
								<tr>
									<th colspan="2">Question n°${numQuestion}
									
									<input type="hidden" name="nbrOfReponses${numQuestion}" value="${question.getListeReponses().size()}" />
										<hr>
									</th>
								</tr>
							</thead>

							<tbody class="choixReponse">
								<tr>
									<td colspan="2">${question.getTexte()}</td>
								</tr>

								<c:set var="numReponse" value="0" />
								<c:forEach var="reponse" items="${question.getListeReponses()}">
									<c:set var="numReponse" value="${numReponse+1}" />
									<tr>
										<td width="150px"><input type="radio" value="${reponse.getIdReponse()}" name="reponseCoche${numQuestion}" required /> ${reponse.getTexte()}</td>
									</tr>
								</c:forEach>



							</tbody>
						</table>
						<!-- ---------------------------------------------- -->
					</div>

					<p>
						- - -<br>
					</p>

				</c:forEach>
				
				<input type="hidden" name="nbrOfQuestions" value="${numQuestion}" />
				<input type="submit" value="Validez"
					style="background-color: chartreuse" />
			</form>

		</div>

		<c:set var="footerText" value="session Quizz" />
		<%@include file="footer.jsp"%>
	</div>

</body>
</html>