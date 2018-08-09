<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lounis Dynamic Questions</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
</head>

<script type="text/javascript">
	var varcount = 0;
	
	function verifyFields() {
		var formStatus = false;
		var emptyFieldsCount = 0;
		var idField = document.getElementById('champid').value;
		var pswField = document.getElementById('champpassword').value;
		
		if(idField == ""){
			document.getElementById('champid').placeholder = " Champ vide";
			document.getElementById('champid').style = "background-color:indianred";
			emptyFieldsCount++;
		}else {

			document.getElementById('champid').style = "background-color:none";
		}
		
		if(pswField == ""){
			document.getElementById('champpassword').placeholder = " Champ vide";
			document.getElementById('champpassword').style = "background-color:indianred";
			emptyFieldsCount++;
		}else {

			document.getElementById('champpassword').style = "background-color:none";
		}
		
		// ------------------------------------------------------------------------
		if(emptyFieldsCount === 0){
			formStatus = true;
		}else{
			console.log(emptyFieldsCount);
			document.getElementById('submitEmptyForm').innerHTML = "Champ(s) Vide<br>- - -<br>";
		}
		
		return formStatus;
	}
</script>

<body style="font-family: courier">
	<div id="main_div">
		<div id="header_div">
			<h1>Welcome ${identifiantUser}!</h1>
		</div>

		
		<div id="content_div" align="center">
			<form action="questionnaire" method="post">
			
			
			<c:set var="numQuestion" value="0"/>
			<c:forEach var="question" items="${listeQuestions}">
			<c:set var="numQuestion" value="${numQuestion+1}"/>
				<div class="question_div">
				<!-- ---------------------------------------------- -->
<!-- 				<table> -->
<!-- 					<tr> -->
<!-- 				---------------------------------------------- -->
					
					
					
<!-- 				---------------------------------------------- -->
<!-- 					</tr> -->
<!-- 				</table> -->
				<!-- ---------------------------------------------- -->
				<table class="questionnaire">
					<thead>
						<tr>
							<th colspan="2">Question n°${numQuestion}
								<hr>
							</th>

						</tr>

					</thead>
					
					<tbody class="choixReponse">
						<tr>
							<td colspan="2"> ${question.getQuestion()}</td>
						</tr>
						<tr>
							<td width="150px"><input type="radio" name="reponseCoche${numQuestion}"/>${question.getReponses().getReponseA()}</td>
						
							<td width="150px"><input type="radio" name="reponseCoche${numQuestion}"/>${question.getReponses().getReponseB()}</td>
						</tr>

						<tr>
							<td><input type="radio" name="reponseCoche${numQuestion}"/>${question.getReponses().getReponseC()}</td>
						
							<td><input type="radio" name="reponseCoche${numQuestion}"/>${question.getReponses().getReponseD()}</td>
						</tr>
					</tbody>
				</table>
				</div>
				
				<p>
					- - -<br>
				</p>
				
				</c:forEach>

				<input type="submit" value="Validez"
					style="background-color: chartreuse" />
				</td>
			</form>

		</div>
		
		
		<c:set var="footerText" value="session Question"/>
		<%@include file="footer.jsp"%>
	</div>

</body>
</html>