<html>
<body>

WELCOME ...  <?php echo $_POST["name"]; ?> <br><br>

mysql database protocol:<br>
<?php


echo nl2br("hostname:  $_POST[hostname] \n");
echo nl2br("username:  $_POST[username] \n");
//echo nl2br("password:  $_POST[password] \n");
?>



<?php
$servername = $_POST["hostname"];
$username1 = $_POST["username"];
$password1 = $_POST["password"];

$conn = mysqli_connect($servername, $username1, $password1);
if(!$conn){
	die("Connection failed: " . mysqli_connect_error());
}
echo "connected sucessfully";
//connection good


$sql = "USE dgallup_db;";

$result = mysqli_query($conn,$sql);

if(!$result)
	die("Query failed: " . mysqli_connect_error());


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
		echo "no matching records";
	}
}
 */
//viewing table statement good
//


mysqli_close($conn);
?>



<br>THANK YOU FOR YOUR TESTING<br>


</body>
</html>

