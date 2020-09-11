<html>
<body>
<h1>Thank You For Your Help </h1>

<?php



$fname = $_POST["f_name"];
$lname = $_POST["l_name"];
$dateofbirth = $_POST["dob"];

//checking to see if these aren't empty
if(empty($fname) || empty($lname) || empty($dateofbirth)){
	die("Please fill all these fields:
		First Name, Last Name, Date of Birth"); 	
}



$ave_sleep = $_POST["sleep"];
$ave_eat = $_POST["eating"];
$ave_study = $_POST["studying"];
$ave_tv = $_POST["tele"];
$ave_gym = $_POST["gym"];
$ave_draw = $_POST["draw"];
$ave_read = $_POST["read"];
$ave_smedia = $_POST["s_media"];

/*
echo $ave_sleep . $ave_eat . $ave_study . $ave_tv . $ave_gym . $ave_draw . $ave_read . $ave_media; 
values trans fered over fine
 */



$servername = "www.terratoast.rocks";
$username1 = "dgallup";
$password1 = "glad*STILL*71";
$db_name = "dgallup_db";

$conn = mysqli_connect($servername, $username1, $password1,$db_name);

if(!$conn){
	die("Connection failed: " . mysqli_connect_error());
}

echo "connected sucessfully";
echo "<br>";
//connection good

/*
$sql = "INSERT INTO person (fname, lname, dob)
	VALUES ('" . $fname . "', '" . $lname . "', '" . $dateofbirth . "')";
echo nl2br ("\n$sql\n"); 
 */
$sql = "INSERT INTO person (fname, lname, dob)
	VALUES ('$fname','$lname','$dateofbirth')";


if (mysqli_query($conn, $sql)){
	echo nl2br ("new person saved\n");
}
else{
	echo "error: " . $sql . "<br>" . mysqli_error($conn);
}


$select_state = "(SELECT p_id FROM person WHERE fname = '$fname' AND lname = '$lname')";

/*
echo "<br><br>";
echo $select_state;
echo "<br>";
 */
$sql3 = "INSERT INTO person_hobby (p_id, h_id, ph_hours) 
	 VALUES 
		($select_state,1,$ave_sleep),
		($select_state,2,$ave_eat),
		($select_state,3,$ave_study),
		($select_state,4,$ave_tv),
		($select_state,5,$ave_gym),
		($select_state,6,$ave_draw),
		($select_state,7,$ave_read),
		($select_state,8,$ave_smedia)
		";





//echo "<br><br>";
//echo $sql3; 
//echo "<br>";

if (mysqli_query($conn, $sql3)){
	echo "new person_hobby entries inserted";
	echo "<br>";
}
else{
	echo "error: " . $sql3 . "<br>" . mysqli_error($conn);
}

//attempt to insert into the person_hobby table was a complete sucess
//now need to do this for the rest of the entries as well
//goal: make a list of values to insert for the rest of the hobbies
//think of a way to clearly view all the info, there was talk of a nested select statement


mysqli_close($conn);


/*
$sql = "SELECT * FROM hobby";
$result = mysqli_query($conn,$sql);

if($result){
	if($row = mysqli_num_rows($result) > 0){
		echo "<table>";
		echo "<tr>";
		echo "<th>Hobby Id | </th>";
		echo "<th>Hobby Name | </th>";
		echo "<th>Hobby Type Id | </th>";
		echo "</tr>";
		while($row = mysqli_fetch_array($result)){
			echo "<tr>";
			echo "<td>".$row['h_id']."</td>";
			echo "<td>".$row['h_name']."</td>";
			echo "<td>".$row['ht_id']."</td>";
			echo "</tr>";
		}
		echo "</table>";
		mysqli_free_res($result);
	}
	else{
		echo "no matching rec
 */
//viewing table statement good
//


?>

</body>
</html>

