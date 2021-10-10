<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<body>
	<h1>Student Registration</h1>
	<br>
	<frm:form method="post" action="/doRegister"
		modelAttribute="mystudent">
	<table>
		
		<tr>
		<td>Name</td>
		<td><frm:input path="name"/></td>
		<frm:errors path="name" cssClass="error"/>
		</tr>
		
		<tr>
		<td>Email</td>
		<td><frm:input path="email"/></td>
		<frm:errors path="email" cssClass="error"/>
		</tr>
	
		<tr>
		<td>Age</td>
		<td><frm:input path="age"/>	</td>
		<frm:errors path="age" cssClass="error"/>
		</tr>
		
		
		
		<tr>
		<td>Department</td>
		<td><label for="dept"></label>
			<select id="dept" name="dept">
  				<option value="ECE">ECE</option>
  				<option value="CSE">CSE</option>
  				<option value="CIVIL">CIVIL</option>
  				<option value="MECH">MECH</option>
			</select>	</td>
		<frm:errors path="dept" cssClass="error"/>
		</tr>
		
		<tr>
		<td>Year</td>
		<td><label for="year"></label>
			<select id="year" name="year">
  				<option value="1st">1st</option>
  				<option value="2nd">2nd</option>
  				<option value="3rd">3rd</option>
  				<option value="4th">4th</option>
			</select>	</td>
		<frm:errors path="year" cssClass="error"/>
		</tr>
		
		<tr>
		<td colspan="2"><input type="submit" value="Add student"></td>
		</tr>
		
	
	

	</table>
	</frm:form>
</body>
</html>