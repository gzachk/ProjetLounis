<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
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
			<h1>Welcome !</h1>
		</div>

		<div  id="content_div" align="center">
			<form action="accueil" method="post" onsubmit="return verifyFields()">
				<table>
					<tbody>
					<thead>
						<tr>
							<th colspan="2">Log In
								<hr>
							</th>
						</tr>
					</thead>

					<tr>
						<td width="150px">Identifiant</td>

						<td><input type="text" id="champid" name="identifiant"
							placeholder="john.smith@mail.com" /></td>
					</tr>
					<tr>
						<td>Mot de Passe</td>

						<td><input type="password" id="champpassword" name="password"
							placeholder="********" /></td>
					</tr>


					<tfoot align="center">
						<tr>
							<td colspan="2"><label id="submitEmptyForm"></label>
								<input type="submit" value="Log In" style="background-color: chartreuse" />
								<input type="reset" value="Cancel" style="background-color: hotpink" /></td>
						</tr>
					</tfoot>
					</tbody>
				</table>
			</form>

			<p>- - -<br>
			Don't have an account ?</p>
			<form action="/LounisProjetWeb/signup">
				<button style="background-color: PowderBlue">Inscription</button>
			</form>

		</div>
		
	<c:set var="footerText" value="session Accueil"/>
	<%@include file="footer.jsp"%>
	</div>

</body>
</html>