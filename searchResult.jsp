<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ramaiah - Self-Appraisal System</title>
<jsp:include page="styling.jsp"></jsp:include>

</head>

<body>
	<div class="container-fluid">
		<div class="container-fluid col-sm-2">&nbsp;</div>
		<div class="container-fluid col-sm-8">
			<form method="post" action="Appraisal" id="formAppraisal">
				<div class="jumbotron">
					<h2 class="text-center">Ramaiah Institute of Technology</h2>
					<p class="text-center">(Autonomous Institute, affiliated to
						VTU)</p>
				</div>
				<h2 class="text-center">Welcome to Self-Appraisal System</h2>
				
				<td>
					Annual Appraisal Form for the Year: ${StartYear} to ${EndYear}<!-- match the names to the DB -->
				</td>
				
				
				<table class="table table-bordered">
					
					<caption>General Information</caption>
					<tr>
						<td>FullName :${Fullname}</td>
						
					</tr>
					<tr>
						<td>Designation:${Desgn}</td>
						
					</tr>
					<tr>
						<td>Department:${department}</td>
						
					</tr>

				</table>
				<table class="table table-bordered">
					<caption>Details of Activities</caption>
					<tbody>
						<tr>
							<td><strong>Sl. No.</strong></td>
							<td><strong>Scoring Category</strong></td>
							<td><strong>Number</strong></td>
						</tr>
						<tr>
							<td colspan="3"><strong>&nbsp;Teaching<br>(Asst.
									Prof - 60, Assoc.Prof - 50, Prof - 40)
							</strong></td>
						</tr>
						<tr>
							<td>1</td>
							<td>FCI Score (Average of all courses handled)</td>
							<td>${FCI}</td>
							
							
						</tr>
						<tr>
							<td colspan="3"><strong>Research<br>(Asst.
									Prof - 10, Assoc.Prof - 20, Prof - 30)
							</strong></td>
							
						</tr>
						<tr>
							<td>2</td>
							<td>No. of non-paid refereed journal papers in SJR*<br>(The
								faculty should be one among first 3 authors):${SJR}
							</td><td>${SJR}</td>
							
							
						</tr>
						<tr>
							<td>3</td>
							<td>No. of indexed conference papers in SJR<br>(The
								faculty should be one among first 3 authors):${IND}
							</td><td>${IND}</td>
							
							
						</tr>
						<tr>
							<td>4</td>
							<td>No. of non-paid non-refereed journals and non-indexed
								conferences<br>(The faculty should be one among first 3
								authors):${NIND}
								</td><td>${NIND}</td>
							
							
						</tr>
						<tr>
							<td>5</td>
							<td>Books/Chapters<br>(The faculty should be one among
								first 3 authors)
							</td>
							<td>
							<table>
							<tr><td style="width: 50%;"><label for="books">Books:</label></td><td style="width: 50%;">${Num}
							</td></tr>
							<tr><td style="width: 50%;"><label
								for="booksChapters">Book Chapters:</label></td><td style="width: 50%;">${Num_chap}
								</td></tr>
							</table>
							</td>
						
								<!-- <label for="booksDisplay">Books: </label><input
								type="text" id="booksDisplay" name="booksDisplay" min="0" readonly="readonly" /><br>
								<label for="booksChaptersDisplay">Book Chapters: </label><input
								type="text" id="booksChaptersDisplay"
								name="booksChaptersDisplay" min="0" readonly="readonly" />  <input
								type="text" id="bookScoreDisplay" name="bookScoreDisplay"
								min="0" readonly="readonly" /> -->
							
						</tr>
						<tr>
							<td>6</td>
							<td>Disclosures Filed</td><td>${DISC}</td>
							
							
						</tr>
						<tr>
							<td>7</td>
							<td>Patents Granted*</td>
							<td>${Patent}</td>
							
						</tr>
						<tr>
							<td>8</td>
							<td>Research Guidance Under Graduate Program</td>
							<td>${UG}</td>
							
						</tr>
						<tr>
							<td>9</td>
							<td>Research Guidance Master's Program</td>
							<td>${MS}</td>
							
						</tr>
						<tr>
							<td>10</td>
							<td>Research Guidance Ph.D.</td>
							<td>${PHD}</td>
							
						</tr>
						<tr>
							<td>11</td>
							<td>Funded Projects*</td>
							<!-- <td><input type="number" id="fundedProjects"
								name="fundedProjects" min="0" /></td> -->
							<td>
							<table>
							
						<tr><td style="width: 50%;">&gt;= 10 Lakhs: </td> <td style="width: 50%;"> ${FTL}</td> </tr> 
						<tr><td style="width: 50%;">&gt;=5 Lakhs and &lt; 10 Lakhs:  </td> <td style="width: 50%;">${FFTL} </td> </tr>
						<tr><td style="width: 50%;">&gt;=1 Lakhs and &lt; 5 Lakhs: </td> <td style="width: 50%;"> ${FOFL} </td> </tr> 
						<tr><td style="width: 50%;"><label for="fundedProjects4">&lt;1 Lakhs: </label> </td> <td style="width: 50%;"> ${FOL} </td> </tr>
							</table>
							</td>
						
								<!-- <input type="text" id="fundedProjects1Display"
								name="fundedProjects1Display" min="0" readonly="readonly" /><br> <br> <input
								type="text" id="fundedProjects2Display"
								name="fundedProjects2Display" min="0" readonly="readonly" /><br> <br> <input
								type="text" id="fundedProjects3Display"
								name="fundedProjects3Display" min="0" readonly="readonly" /><br> <br> <input
								type="text" id="fundedProjects4Display"
								name="fundedProjects4Display" min="0" readonly="readonly"/><br> <br> -->
								
						
						</tr>

						<tr>
							<td>12</td>
							<td>Consulting Projects*</td>
							<!-- <td><input type="number" id="consultingProjects"
								name="consultingProjects" min="0" /></td> -->
							<td>
							<table>
						<tr> <td style="width: 50%;">&gt;= 10 Lakhs: </td> <td style="width: 50%;"> ${CTL} </td> </tr>
						<tr> <td style="width: 50%;">&gt;= 5 Lakhs and &lt; 10 Lakhs:  </td> <td style="width: 50%;">${CFTL}  </td> </tr>
						<tr> <td style="width: 50%;">&gt;=1 Lakhs and &lt; 5 Lakhs:  </td> <td style="width: 50%;"> ${COFL}</td> </tr>
						<tr> <td style="width: 50%;">&lt;1 Lakhs: </td> <td style="width: 50%;">${COL} </td></tr>
							</table>	
							</td>
							
								<!-- <input type="text" id="consultingProjects1Display"
								name="consultingProjects1Display" min="0" readonly="readonly" /><br> <br>
								<input type="text" id="consultingProjects2Display"
								name="consultingProjects2Display" min="0" readonly="readonly" /><br> <br>
								<input type="text" id="consultingProjects3Display"
								name="consultingProjects3Display" min="0" readonly="readonly" /><br> <br>
								<input type="text" id="consultingProjects4Display"
								name="consultingProjects4Display" min="0" readonly="readonly" /><br> <br> -->
								
							
						</tr>
						<tr>
							<td colspan="3"><strong>Service and Professional
									Development<br>(Asst. Prof - 30, Assoc.Prof - 30, Prof -
									30)
							</strong></td>
						</tr>
						<tr>
							<td>13</td>
							<td>No. of Conference Chair, Session Chair, Reviewer of Q1
								or Q2 Journal</td>
							<td>${Journal}</td>
							
						</tr>
						<tr>
							<td>14</td>
							<td>No. of FDP/ Seminar/ Workshop organized as coordinator</td>
							<!-- <td><input type="number" id="fswCoordinator"
								name="fswCoordinator" min="0" /></td> -->
							<td>
							<table>
						<tr> <td style="width: 50%;">5 Days:  </td> <td style="width: 50%;">${Fivedays} </td> </tr> 
						<tr> <td style="width: 50%;">3 Days:  </td> <td style="width: 50%;">${Threedays}  </td> </tr>
							</table>
							</td>
							
								<!-- <input type="text" id="fiveDayWorkShopDisplay"
								name="fiveDayWorkShopDisplay" min="0" readonly="readonly"/><br> <br> <input
								type="text" id="threeDayWorkShopDisplay"
								name="threeDayWorkShopDisplay" min="0" readonly="readonly" /><br> <br> -->
								
							
						</tr>
						<tr>
							<td>15</td>
							<td>No. of invited technical talks outside the institute</td>
							<td>${TECH}</td>
							
						</tr>
						<tr>
							<td>16</td>
							<td>No. of events participation outside the institute<br>(FDP/Seminar/Workshop/Conference)
							</td>
							<td>${EOUT}</td>
							
						</tr>
						<tr>
							<td>17</td>
							<td>No. of events participation inside the institute<br>(FDP/Seminar/Workshop/Conference)
							</td>
							<td>${EIN}</td>
							
						</tr>

						<tr>
							<td>18</td>
							<td>Industry Relations<br>(MoU, Co-hosted event,
								Technical Talk Series)
							</td>
							<td>${Industry}</td>
							
						</tr>
						<tr>
							<td>19</td>
							<td>Institutional/Departmental Services such as NBA/NIRF</td>
							<td>
							<table>
						<tr> <td style="width: 50%;"> Coordinator:  </td> <td style="width: 50%;"> ${Coordinate}  </td> </tr> 
						<tr> <td style="width: 50%;"> Others:  </td> <td style="width: 50%;"> ${NOther}</td></tr>
							</table>
							</td>
							
								<!-- <input type="text"
								id="instDeptServicesCoordinatorDisplay"
								name="instDeptServicesCoordinatorDisplay" min="0" readonly="readonly" /><br> <br>
								<input type="text" id="instDeptServicesOthersDisplay"
								name="instDeptServicesOthersDisplay" min="0" readonly="readonly" /><br> <br> -->
								
							
						</tr>
						<tr>
							<td>20</td>
							<td>Other Services to the institution or society
								contribution</td>
							<td>${Society}</td>
							
						</tr>
						<tr>
							<td>21</td>
							<td>Awards and Honours</td>
							<td>${Award}</td>
							
						</tr>
						<!-- <tr>
							<td>20</td>
							<td>FDP attended outside of RIT</td>
							<td><input type="number" id="fdpOutside" name="fdpOutside" /></td>
						</tr>
						<tr>
							<td>21</td>
							<td>Conferences/Workshops attended without presentation</td>
							<td><input type="number" id="confWorkAttended"
								name="confWorkAttended" /></td>
						</tr> -->
						<tr>
							<td>22</td>
							<td>Professionalism / Team spirit</td>
							<td>${Team}</td>
							
						</tr>
						<tr>
							<td>23</td>
							<td>Any other major contributions: (Max 500 characters)</td>
							<td>${Other}</td>
						</tr>
					
					</tbody>
				</table>
			</form>
		</div>
		<div class="container-fluid col-sm-2">&nbsp;</div>
	</div>
</body>
</html>