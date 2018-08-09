<hr>
<div id="listeQuizz">
	<form action="admin" method="post">
		<table>

			<thead>
				<tr>
				<th width="45px">Id:</th>
				<th width="100px">Competence:</th>
				<th></th>
				</tr>
			</thead>
			<tbody>
			
				<c:set  var="quizzNumber" value="0" />
				<c:forEach items="${tableQuizz}" var="competenceName">
					<tr>
						<td name="${competenceName.getIdQuizz()}">
							${competenceName.getIdQuizz()}
						</td>
						
						<td>${competenceName.getIdCompetence()}</td>

						<td>
							<input type="checkbox" name="delQuizz${quizzNumber}" value="${competenceName.getIdCompetence()}"/>
						</td>
					</tr>
					<c:set var="quizzNumber" value="${quizzNumber+1}" />
				</c:forEach>

			</tbody>
		</table>
		
		<input type="hidden" name="nbrOfRowsInTable" value="${quizzNumber}" />
		- - -<br>
		<input type="submit" value="SupprimerQuizz" name ="adminStg"
					style="background-color: chartreuse" />
	</form>
</div>