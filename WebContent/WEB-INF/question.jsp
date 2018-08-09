<form action="admin" method="post">
	<table>
		<tbody>
		<thead>
			<tr>
				<th>
					<hr>
				</th>
			</tr>
		</thead>
		
		<tr>
			<td>
				<select id="quizzSelect" name="competenceChoisie" required>
					<option value="">Veuillez selectionner une competence</option>

					<c:set var="quizzNumber" value="0" />
					<c:forEach items="${tableQuizz}" var="competenceName">
						<c:set var="quizzNumber" value="${quizzNumber+1}" />
						<option value="${competenceName.getIdCompetence()}">${competenceName.getIdCompetence()}</option>
					</c:forEach>
				</select>
			</td>
		</tr>

		<tr>



			<td>
				<textarea name="questionAInserer" placeholder="Rediger votre question" required></textarea>
			</td>
		</tr>
		<tr>
		
			<td><hr>
				Veuillez entrer les reponses 
			</td>
		</tr>
		<tr>			
			<td>
				<input type="text" style = "width:400px" id="champreponse" name="reponse1" placeholder="Cochez si bonne reponse" required />
				<input type="radio" name="bonnereponse" value="reponse1" required> 
			</td>
		</tr>
		
		<tr>
			<td>
				<input type="text" style = "width:400px" id="champreponse" name="reponse2" placeholder="Cochez si bonne reponse" required />
				<input type="radio" name="bonnereponse" value="reponse2">
			</td>
		</tr>
		
		<tr>
			<td>
				<input type="text" style = "width:400px" id="champreponse" name="reponse3" placeholder="Cochez si bonne reponse" required />
				<input type="radio" name="bonnereponse" value="reponse3">
			</td>
		</tr>
		
		<tr>
			<td>
				<input type="text" style = "width:400px" id="champreponse" name="reponse4" placeholder="Cochez si bonne reponse" required />
				<input type="radio" name="bonnereponse" value="reponse4">
			</td>
		</tr>


		<tfoot>
			<tr>
				<th>
					<hr> <label id="submitEmptyForm"></label> <input type="submit"
					name="adminStg" value="Inserer"
					style="background-color: chartreuse" /> <input type="reset"
					value="Annuler" style="background-color: hotpink" />

				</th>
			</tr>
		</tfoot>

		</tbody>
	</table>