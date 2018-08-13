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
			<h1>Welcome ${MySessionVariable}!</h1>
		</div>

		
		<div id="content_div" align="center">
			<p>Fin questionnaire de "${competence}"</p>
			<p>Durée: ${dureeQuizz}</p>
			<form action="parcours" method="get">
			<input type="submit" value="Retour Parcours" />
			</form>
		</div>
		
		
		<c:set var="footerText" value="session Question"/>
		<%@include file="footer.jsp"%>
	</div>

</body>
</html>