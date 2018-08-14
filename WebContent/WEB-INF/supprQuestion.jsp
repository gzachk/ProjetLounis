<hr>
<div id="listeQuizz">
	<form action="admin" method="post">
		<table>

			<tr>
				<td><select style="width: 250px" name="competencesChoisie"
					size="4" multiple required>
						<option value="" disabled="disabled">- Competence(s) -</option>
						<c:forEach items="${tableQuizzAttr}" var="competenceName">
							<option value="${competenceName.getIdCompetence()}">${competenceName.getIdCompetence()}</option>
						</c:forEach>
				</select></td>
			</tr>
		</table>

		<input type="hidden" name="nbrOfRowsInTable" value="${quizzNumber}" />
		- - -<br> 
		<input type="button" value="SupprQuestion" name="adminStg" style="background-color: chartreuse" />
	</form>
</div>