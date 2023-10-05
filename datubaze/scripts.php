<!DOCTYPE html>
<html>
<head>
<title>Skripti</title>
<link rel="stylesheet" href="includes/style.css">
</head>
<body>
<ul>
	<li><a href="homepage.php">Sākumlapa</a></li>
	<li><a href="datubaze.php">Par datubāzi</a></li>
	<li><a href="tables.php">Tabulas</a></li>
	<li><a href="insert.php">Ievade</a></li>
</ul>
    <h2>Skripti</h2>
    
    <?php
	include_once "includes/logindata.php";
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $script = $_POST["script"];
        
        $result = $conn->multi_query($script);
        
        if ($result) {
            echo "<p>Skripts veiksmīgi izpildīts.</p>";
            
            do {
                if ($resultSet = $conn->store_result()) {
                    while ($row = $resultSet->fetch_assoc()) {
                        foreach ($row as $key => $value) {
                            echo "<p>$key: $value</p>";
                        }
                        echo "<br>";
                    }
                    $resultSet->free();
                }
            } while ($conn->more_results() && $conn->next_result());
        } else {
            echo "<p>Kļūda izpildot skriptu: " . $conn->error . "</p>";
        }
        
        $conn->close();
    }
    ?>
    
    <form method="POST" action="">
        <label for="script" >Ievadiet vaicājumu:</label>
        <br>
        <textarea id="script" name="script" rows="8" cols="50" required></textarea>
        <br>
        <input type="submit" value="Izpildīt">
    </form>
</body>
</html>
