<html>
<body class="page">
<h1> Welcome to <i>The Average College Survey </i> </h1>
<h2> Survey performed by Dylan Gallup </h2>
<h3> This is an assignment(Hobby Farming) for cs457: Database Processes</h3>
<form action = "db2.php" method="post">


<fieldset class="f1">
First Name:    <input type="text" name="f_name"><br>
Last Name:     <input type="text" name="l_name"><br>
Date of Birth: <input type="text" name="dob" id="t1" onclick="clearInput()" value="MM / DD / YYYY"><br>
</fieldset>
<div class="mid">
<br>The following questions ask how many hours per week (on average):<br>
Do you perform these actions? <br>
Please answer the following questions integers (ex. 1, 10, 424, etc). <br><br>
</div>

<fieldset class="f2">
Average Time Sleeping per Week:            <input type="number" name="sleep" min="0" max="168"><br>
Average Time Eating per Week:              <input type="number" name="eating" min="0" max="168"><br>
Average Time Studying per Week:            <input type="number" name="studying" min="0" max="168"><br>
Average Time Watching Television per Week: <input type="number" name="tele" min="0" max="168"><br>
Average Time Working Out per Week:         <input type="number" name="gym" min="0" max="168"><br>
Average Time Drawing/Coloring per Week:    <input type="number" name="draw" min="0" max="168"><br>
Average Time Reading per Week:             <input type="number" name="read" min="0" max="168"><br>
Average Time on Social Media:              <input type="number" name="s_media" min="0" max="168"><br>
</fieldset>




<input type = "submit" style="height: 50px; width: 100px; font-size: 20px; border-width: 5px;">
</form>

<script>
function clearInput(){
	document.getElementById("t1").value = "";
}

</script>

<style>
.f1,.f2, .mid {
 border-color: blue;
 font-size: 20px;
}
.page {
font-family: "arial";
}

</style>
Viewing Database Tables Upcoming...


</body>
</html>


