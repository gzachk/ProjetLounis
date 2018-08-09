<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lounis Dynamic Sign-Up</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>

<script type="text/javascript">
	var varcount = 0;
	
	function testLeave() {

		var formStatus = false;
		var emptyFieldsCount = 0;
		var nomField = document.getElementById('champnom').value;
		
		if(nomField == ""){
			document.getElementById('champnom').placeholder = " Champ vide";
			document.getElementById('champnom').style = "background-color:indianred";
			emptyFieldsCount++;
		}else {

			document.getElementById('champnom').style = "background-color:none";
		}

		return formStatus;
	}
	
	function verifyFields() {
		var formStatus = false;
		var emptyFieldsCount = 0;
		var nomField = document.getElementById('champnom').value;
		var prenomField = document.getElementById('champprenom').value;
		var emailField = document.getElementById('champemail').value;
		var telephoneField = document.getElementById('champtelephone').value;
		var societeField = document.getElementById('champsociete').value;
		var passwordField = document.getElementById('champpassword').value;
		
		if(nomField == ""){
			document.getElementById('champnom').placeholder = " Champ vide";
			document.getElementById('champnom').style = "background-color:indianred";
			emptyFieldsCount++;
		}else {

			document.getElementById('champnom').style = "background-color:none";
		}
		
		if(prenomField == ""){
			document.getElementById('champprenom').placeholder = " Champ vide";
			document.getElementById('champprenom').style = "background-color:indianred";
			emptyFieldsCount++;
		}else {

			document.getElementById('champprenom').style = "background-color:none";
		}
		

		if(emailField == ""){
			document.getElementById('champemail').placeholder = " Champ vide";
			document.getElementById('champemail').style = "background-color:indianred";
			emptyFieldsCount++;
		}else {

			document.getElementById('champemail').style = "background-color:none";
		}

		if(telephoneField == ""){
			document.getElementById('champtelephone').placeholder = " Champ vide";
			document.getElementById('champtelephone').style = "background-color:indianred";
			emptyFieldsCount++;
		}else {

			document.getElementById('champtelephone').style = "background-color:none";
		}

		if(societeField == ""){
			document.getElementById('champsociete').placeholder = " Champ vide";
			document.getElementById('champsociete').style = "background-color:indianred";
			emptyFieldsCount++;
		}else {

			document.getElementById('champsociete').style = "background-color:none";
		}
		if(passwordField == ""){
			document.getElementById('champpassword').placeholder = " Champ vide";
			document.getElementById('champpassword').style = "background-color:indianred";
			emptyFieldsCount++;
		}else {

			document.getElementById('champpassword').style = "background-color:none";
		}
		
		if(emptyFieldsCount === 0){
			formStatus = true;
		}else{
			console.log(emptyFieldsCount);
			document.getElementById('submitEmptyForm').innerHTML = "Formulaire Incomplet<br>- - -<br>";
		}
		
		return formStatus;
	}
</script>

<body style="font-family:courier">
<div id="main_div">
	<div id="header_div">
		<h1>Create an account</h1>
	</div>
	
	
	<div  id="content_div" align="center">
		<form action="signup" method="post" onsubmit="return verifyFields()" >
		<table>
			<tbody>
				<thead>
					<tr>
						<th colspan="2">
							All fields must be filled
							<hr>
						</th>
					</tr>
				</thead>
				<tr>
					<td>Mot de Passe</td>
					
					<td>
						<input type="password" id="champpassword" name="password" placeholder="***********"/>
					</td>
				</tr>
				
				<tr>
					<td width="100px">Nom</td>
					
					<td>
						<input type="text" id="champnom" name="nom" placeholder="Smith" onfocusout="testLeave()" />
					</td>
				</tr>
				<tr>
					<td>Prenom</td>
					
					<td>
						<input type="text" id="champprenom" name="prenom" placeholder="John"/>
					</td>
				</tr>
				
				<tr>
					<td>Email</td>
					
					<td>
						<input type="text" id="champemail" name="email" placeholder="john.smith@email.com"/>
					</td>
				</tr>
				
				<tr>
					<td>Telephone</td>
					
					<td>
						<input type="text" id="champtelephone" name="telephone" placeholder="xxxx.xx.xx.xx"/>
					</td>
				</tr>
				<tr>
					<td>Societe</td>
					
					<td>
						<input type="text" id="champsociete" name="societe" placeholder="Smith Company"/>
					</td>
				</tr>
				
				
				<tfoot>
					<tr>
						<th colspan="2">
							<hr>
							<label id="submitEmptyForm"></label>
							<input type="submit" value="Sign In" style="background-color:chartreuse" />
							<input type="reset" value="Reset"  style="background-color:hotpink" />
							${! empty erreur ? erreur :'' }
						</th>
					</tr>
				</tfoot>
				
			</tbody>
		</table>
		</form>
	</div>
	
	<!-- hr width="750px"-->
<c:set var="footerText" value="session Sign Up"/>
<%@include file="footer.jsp"%>
</div>

</body>
</html>