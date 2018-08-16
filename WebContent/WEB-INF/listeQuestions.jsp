<hr>
<div id="listeQuestion">
	<form action="admin" method="post">
		<table>

			<thead>
				<tr>
				<th width="45px">Id:</th>
				<th width="450px">Question:</th>
				<th></th>
				</tr>
			</thead>
			<tbody>
			
				<c:set  var="questionNumber" value="0" />
				<c:forEach items="${tableQuestion}" var="questionName">

					<tr>
						<td colspan="3">
							<hr style="margin: 0">
						</td>
					</tr>
					<tr>
						<td name="${questionName.getIdQuestion()}">
							${questionName.getIdQuestion()}
						</td>
						
						<td style="text-align: left">&#8594; ${questionName.getTexte()}</td>

						<td>
							<input type="checkbox" name="delQuestion${questionNumber}" value="${questionName.getIdQuestion()}"/>
						</td>
					</tr>
					
					<c:set  var="reponseNumber" value="0" />
					<c:forEach items="${questionName.getListeReponses()}" var="reponseName">
					<c:set  var="reponseNumber" value="${reponseNumber+1}" />
						
						<tr>
							<td></td>
							<td colspan="2" style="text-align: left">
								&#9657; ${reponseName.getTexte()}
							</td>
						</tr>
					</c:forEach>
					
					<c:set var="questionNumber" value="${questionNumber+1}" />
				</c:forEach>

			</tbody>
		</table>
		
		<input type="hidden" name="nbrOfRowsInTable" value="${questionNumber}" />
		- - -<br>
		<input type="submit" value="SupprimerQuestion" name ="adminStg"
					style="background-color: chartreuse" />
	</form>
</div>