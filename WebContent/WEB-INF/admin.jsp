<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lounis Dynamic Admin</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
</head>

<script type="text/javascript">
	var varcount = 0;

	function verifyFields() {
		var formStatus = false;
		var emptyFieldsCount = 0;
		var searchField = document.getElementById('champRecherche').value;

		if (searchField == "") {
			document.getElementById('champRecherche').placeholder = " Champ vide";
			document.getElementById('champRecherche').style = "background-color:indianred";
			emptyFieldsCount++;
		} else {

			document.getElementById('champRecherche').style = "background-color:none";
		}

		// ------------------------------------------------------------------------
		if (emptyFieldsCount === 0) {
			formStatus = true;
		} else {
			console.log(emptyFieldsCount);
		}

		return formStatus;
	}

	function showGestionUtilisateurs() {
		var w = document.getElementById('attributionParcours');
		var x = document.getElementById('gestionUtilisateurs');
		var y = document.getElementById('gestionParcours');

		if (x.style.display === "none") {
			w.style.display = "none";
			x.style.display = "block";
			y.style.display = "none";
		} else {
			x.style.display = "none";
		}
	}
	function showGestionParcours() {
		var w = document.getElementById('attributionParcours');
		var x = document.getElementById('gestionUtilisateurs');
		var y = document.getElementById('gestionParcours');
// 		var z = document.getElementById('resultatsGestionAdmin');

		if (y.style.display === "none") {			
			y.style.display = "block";
			w.style.display = "none";
			x.style.display = "none";
		} else {
			y.style.display = "none";
		}
	}
	function showAttributionParcours() {
		var w = document.getElementById('attributionParcours');
		var x = document.getElementById('gestionUtilisateurs');
		var y = document.getElementById('gestionParcours');
		var z = document.getElementById('resultatsGestionAdmin');

		if (w.style.display === "none") {
			y.style.display = "none";
			x.style.display = "none";
			w.style.display = "block";
		} else {
			w.style.display = "none";
		}
	}
	function showSuppressionQuestion() {
		var w = document.getElementById('suppressionQuestion');

		if (w.style.display === "none") {
			w.style.display = "block";
		} else {
			w.style.display = "none";
		}
	}
</script>

<body style="font-family: courier">
	<div id="main_div">
		<div id="header_div">
			<h1>Welcome ${MySessionVariable}!</h1>
		</div>

		<div id="content_div" align="center">
		
			<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<!-- GESTION DES UTILISATEURS -->
			<div>
				<button type="button" onclick="showGestionUtilisateurs()"
					style="width: 250px">Gestion des Utilisateurs</button>
				<div id="gestionUtilisateurs" style="display: ${displayUtilisateurs}">
					<table>

						<!-- 					<tr> -->
						<!-- 						<td colspan="2">Gestion des Utilisateurs -->
						<!-- 							<hr> -->
						<!-- 						</td> -->
						<!-- 					</tr> -->
						<tr>
							<td colspan="2">
								<form action="admin" method="post"
									onsubmit="return verifyFields()">
									<input type="text" id="champRecherche" name="recherche"
										placeholder="Search User" /> <input type="submit"
										name="adminStg" value="Search"
										style="background-color: chartreuse" />

									<!--%@include file="stagiaireRetrouve.jsp"%-->
								</form>
								<hr>
							</td>
						</tr>
						<tr>
							<td>
								<form action="admin" method="post">
									<input type="submit" name="adminStg" value="Get New Users"
										style="background-color: chartreuse" />
								</form>
							</td>
							<td>
								<form action="admin" method="post">
									<input type="submit" name="adminStg" value="Get All Users"
										style="background-color: chartreuse" />
								</form>
							</td>
						</tr>
					</table>
					<br>
				</div>
			</div>


			<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<!-- GESTION DU PARCOURS -->
			<div>
				<button type="button" onclick="showGestionParcours()"
					style="width: 250px">Gestion des Parcours</button>
					
				<div id="gestionParcours" style="display: ${displayParcours}">
					<table>

						<!-- 					<tr> -->
						<!-- 						<td colspan="2">Gestion des Parcours -->
						<!-- 							<hr> -->
						<!-- 						</td> -->
						<!-- 					</tr> -->
						<tr>
							<td>
								<form action="admin" method="post">
									<input type="text" id="champCompetence" name="nouvelleCompetence" placeholder="Nouvelle competence" required/> 
									<input type="submit" name="adminStg" value="Ajouter" style="background-color: lightblue"  />

								</form>
								<hr>
							</td>
						</tr>
						<tr>
							<td>
								<form action="admin" method="post">
									<input type="submit" name="adminStg" value="Get Quizz" style="background-color: lightblue; width:150px" />
								</form>
							</td>
						</tr>
						<tr>
							<td>
								<form action="admin" method="post">
									<input type="submit" name="adminStg" value="Nouvelle Question" style="background-color: lightblue; width:150px" />
								</form>
							</td>
						</tr>
							<tr>
								<td>
								<form action="admin" method="post">
									<input type="button" name="adminStg" onclick="showSuppressionQuestion()" value="Suppression Question" style="background-color: lightblue; width:150px"/>
								</form>
								</td>
							</tr>
							<tr id="suppressionQuestion" style="display: none;  padding:0 auto 0 auto;">
								<td>
									<form>
										<select style="width: 150px";name="competencesChoisie" size="4" required>
											<option value="" disabled="disabled">- Competence(s) -</option>
											<c:forEach items="${tableQuizzAttr}" var="competenceName">
												<option value="${competenceName.getIdCompetence()}">${competenceName.getIdCompetence()}</option>
											</c:forEach>
										</select>
									</form>
								</td>
							</tr>
							<tr>
							<td>
								<hr>
							</td>
						</tr>
					</table>
				</div>
			</div>
			
			<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<!-- ATTRIBUTION PARCOURS UTILISATEUR -->
			<div>
				<button type="button" onclick="showAttributionParcours()"
					style="width: 250px">Attribution du Parcours</button>

				<div id="attributionParcours"
					style="display: ${displayAttributionParcours}">
					<form action="admin" method="post">
						<table>

							<tr>
								<td>
								<select style="width: 250px"  name="utilisateurChoisie" size="3" required>
										<option disabled="disabled" value=""> - Utilisateur(-trice) - </option>
										<c:forEach items="${tableUserValid}" var="stgName">
											<option value="${stgName.getIdUtilisateur()}">${stgName.getNom()} ${stgName.getPrenom()}</option>
										</c:forEach>
								</select> 
								</td>
							</tr>
							<tr>
								<td>
								<select style="width: 250px"  name="competencesChoisie" size="4" multiple required>
										<option value="" disabled="disabled"> - Competence(s) - </option>
										<c:forEach items="${tableQuizzAttr}" var="competenceName">
											<option value="${competenceName.getIdCompetence()}">${competenceName.getIdCompetence()}</option>
										</c:forEach>
								</select>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<hr>
									<!-- 								<form action="admin" method="post"> --> <input
									type="submit" name="adminStg" value="Attribuer Parcours"
									style="background-color: lightblue" />
								</td>

							</tr>
						</table>
					</form>
				</div>
			</div>


			<div>
				${! empty erreur ? erreur :'' }


				<jsp:include page="${retrouve}" flush="true" />
				<jsp:include page="${retrouveNew}" flush="true" />
			</div>

		</div>
<%-- 				<input type="hidden" name="sessionIsAdmin" value="${MySessionVariableAdmin}" /> --%>
<%-- 				<input type="hidden" name="sessionUserId" value="${MySessionVariableIdUtilisateur}" /> --%>
		<c:set var="footerText" value="session Admin" />
		<%@include file="footer.jsp"%>
	</div>

</body>
</html>