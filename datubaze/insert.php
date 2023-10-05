<!DOCTYPE html>
<html>
<head>
    <title>Ievade</title>
	<link rel="stylesheet" href="includes/style.css">
</head>
<body>
<ul>
<li><a href="homepage.php">Sākumlapa</a></li>
<li><a href="scripts.php">Skripti</a></li>
<li><a href="tables.php">Tabulas</a></li>
<li><a href="datubaze.php">Par datubāzi</a></li>
</ul>

    <?php
    include_once "includes/logindata.php";

    $tables = [];
    $result = mysqli_query($conn, "SHOW TABLES");
    while ($row = mysqli_fetch_array($result)) {
        $tables[] = $row[0];
    }
	?>
	
    <h2>Ievadīt datus</h2>
    <form method="POST">
        <label for="table">Izvēlēties tabulu:</label>
        <select name="table">
            <?php foreach ($tables as $table): ?>
                <option value="<?php echo $table; ?>"><?php echo $table; ?></option>
<?php endforeach; ?>
</select>
<input type="submit" value="Izvēlēties">
</form>
	<?php
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        if (isset($_POST['table']) && isset($_POST['insert_data'])) {
            $table = $_POST['table'];
            $columns = [];
            $values = [];
            foreach ($_POST as $key => $value) {
                if ($key !== 'table' && $key !== 'insert_data') {
                    $columns[] = $key;
                    $values[] = "'" . mysqli_real_escape_string($conn, $value) . "'";
                }
            }

            $columnsString = implode(', ', $columns);
            $valuesString = implode(', ', $values);
            $query = "INSERT INTO $table ($columnsString) VALUES ($valuesString)";

            if (mysqli_query($conn, $query)) {
                echo "Dati veiksmīgi ievietoti: $table.";
            } else {
                echo "Kļūda: " . $query . "<br>" . mysqli_error($conn);
            }
        } elseif (isset($_POST['table'])) {
            $table = $_POST['table'];

            echo "<h2>Ievietot datus tabulā: $table</h2>";
            echo "<form method='POST'>";
            echo "<input type='hidden' name='table' value='$table'>";

            $result = mysqli_query($conn, "DESCRIBE $table");
            while ($row = mysqli_fetch_array($result)) {
                $column = $row['Field'];
                echo "<label for='$column'>$column:</label>";
                echo "<input type='text' name='$column' required><br>";
            }

            echo "<input type='submit' name='insert_data' value='Ievadī datus'>";
            echo "</form>";
        }
    }
    mysqli_close($conn);
    ?>
</body>
</html>