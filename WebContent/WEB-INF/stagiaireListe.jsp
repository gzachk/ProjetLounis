<hr>
<div id="listeStagiaire">
	<form action="admin" method="post">
		<table>

			<thead>
				<tr><th width="45px">Id:</th>
				<th width="100px">Nom:</th>
				<th width="100px">Prenom:</th>
				<th width="150px">Email:</th>
				<th width="150px">Tel:</th>
				<th width="150px">Societe:</th>
				<th>Admin:</th>
				<th></th></tr>
			</thead>
			<tbody>
			
				<c:set  var="userNumber" value="0" />
				<c:forEach items="${tableUser}" var="stgName">
					<tr>
						<td name="${stgName.getIdUtilisateur()}">
							${stgName.getIdUtilisateur()}
						</td>
						
						<td>${stgName.getNom()}</td>
						<td>${stgName.getPrenom()}</td>
						<td>${stgName.getEmail()}</td>
						<td>${stgName.getTelephone()}</td>
						<td>${stgName.getSociete()}</td>
						<td>${stgName.isAdmin()}</td>
						<td>
							<input type="checkbox" name="delUser${userNumber}" value="${stgName.getIdUtilisateur()}"/>
						</td>
					</tr>
					<c:set var="userNumber" value="${userNumber+1}" />
				</c:forEach>


				<!-- A REVOIR -->
				<%-- 			<c:forEach items="${tableUserAll}" var="stgName"> --%>
				<!-- 				<tr> -->
				<%-- 					<td>${stgName.getIdUtilisateur()}</td> --%>
				<%-- 					<td>${stgName.getNom()}</td> --%>
				<%-- 					<td>${stgName.getPrenom()}</td> --%>
				<%-- 					<td>${stgName.getEmail()}</td> --%>
				<%-- 					<td>${stgName.getTelephone()}</td> --%>
				<%-- 					<td>${stgName.getSociete()}</td> --%>
				<%-- 					<td>${stgName.isAdmin()}</td> --%>
				<!-- 				</tr> -->
				<%-- 			</c:forEach> --%>
			</tbody>
		</table>
		
		<input type="hidden" name="nbrOfRowsInTable" value="${userNumber}" />
		- - -<br>
		<input type="submit" value="Supprimer" name ="adminStg"
					style="background-color: chartreuse" />
	</form>
</div>
