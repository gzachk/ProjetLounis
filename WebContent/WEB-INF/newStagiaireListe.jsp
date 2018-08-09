<hr>
<div id="listeStagiaire">
	<form action="admin" method="post">
		<table>

			<thead>
				<th width="100px">Nom:</th>
				<th width="100px">Prenom:</th>
				<th width="150px">Email:</th>
				<th width="150px">Tel:</th>
				<th width="150px">Societe:</th>
				<th>Valider:</th>
				<th>admin:</th>
			</thead>
			<tbody>

				<c:set var="userNumber" value="0" />
				<c:forEach items="${tableUser}" var="stgName">
					<tr name="user${userNumber}">
						<td>${stgName.getNom()}</td>
						<td>${stgName.getPrenom()}</td>
						<td>${stgName.getEmail()}</td>
						<td>${stgName.getTelephone()}</td>
						<td>${stgName.getSociete()}</td>
						<td><input type="checkbox" name="validerUser${userNumber}" /></td>
						<td><input type="checkbox" name="user${userNumber}IsAdmin" /></td>
					</tr>
					
					<c:set var="userNumber" value="${userNumber+1}" />
				</c:forEach>

			</tbody>
		</table>
		
		- - -<br>
		<input type="submit" value="Valider" name ="adminStg"
					style="background-color: chartreuse" />
	</form>
</div>
