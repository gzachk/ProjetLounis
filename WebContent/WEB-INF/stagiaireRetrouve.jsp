<hr>
<c:set var="utilisateur" value="${utilisateur}" />
<table>

	<thead>
		<th width="45px">Id:</th>
		<th width="100px">Nom:</th>
		<th width="100px">Prenom:</th>
		<th width="150px">Email:</th>
		<th width="150px">Tel:</th>
		<th width="150px">Societe:</th>
		<th>Admin:</th>
	</thead>

	<tbody>
		<tr>
			<td>${utilisateur.getIdUtilisateur()}</td>
			<td>${utilisateur.getNom()}</td>
			<td>${utilisateur.getPrenom()}</td>
			<td>${utilisateur.getEmail()}</td>
			<td>${utilisateur.getTelephone()}</td>
			<td>${utilisateur.getSociete()}</td>
			<td><c:choose>
					<c:when test="${utilisateur.isAdmin()}">
						oui
					</c:when>
					<c:otherwise>
						non
					</c:otherwise>
				</c:choose></td>
		</tr>
	</tbody>
</table>