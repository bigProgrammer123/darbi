<?php
include_once "includes/logindata.php";

$tablesQuery = "SHOW TABLES";
$tablesResult = mysqli_query($conn, $tablesQuery);
$tables = [];
while ($row = mysqli_fetch_row($tablesResult)) {
    $tables[] = $row[0];
}

if (isset($_GET['table'])) {
    $selectedTable = $_GET['table'];
    $selectQuery = "SELECT * FROM $selectedTable";
    $result = mysqli_query($conn, $selectQuery);
}

if (isset($_POST['search'])) {
    $searchTerm = $_POST['search'];

    $filteredTables = array_filter($tables, function ($table) use ($searchTerm) {
        return strpos($table, $searchTerm) !== false;
    });

    if (isset($selectedTable) && !in_array($selectedTable, $filteredTables)) {
        $selectedTable = null;
    }

    $tables = $filteredTables;
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Tabulas</title>
	<link rel="stylesheet" href="includes/style.css">
</head>
<body>
<ul>
<li><a href="homepage.php">Sākumlapa</a></li>
<li><a href="scripts.php">Skripti</a></li>
<li><a href="datubaze.php">Par datubāzi</a></li>
<li><a href="insert.php">Ievade</a></li>
</ul>
    <h2>Tabulu saraksts</h2>
    
    <form method="POST">
        <label for="search">Meklēt:</label>
        <input type="text" name="search" id="search" placeholder="Tabulas nosaukumu" value="<?php echo isset($searchTerm) ? $searchTerm : ''; ?>">
        <button type="submit">Meklēt</button>
    </form>

    <ul>
        <?php foreach ($tables as $table): ?>
            <li><a href="?table=<?php echo $table; ?>"><?php echo $table; ?></a></li>
        <?php endforeach; ?>
    </ul>

    <?php if (isset($selectedTable)): ?>
        <h3>Tabula: <?php echo $selectedTable; ?></h3>
        <?php if (mysqli_num_rows($result) > 0): ?>
            <table>
                <thead>
                    <tr>
                        <?php
                        $fieldNames = mysqli_fetch_fields($result);
                        foreach ($fieldNames as $field) {
                            echo "<th>{$field->name}</th>";
                        }
                        ?>
                    </tr>
                </thead>
                <tbody>
                    <?php while ($row = mysqli_fetch_assoc($result)): ?>
                        <tr>
                            <?php foreach ($row as $value): ?>
                                <td><?php echo $value; ?></td>
                            <?php endforeach; ?>
                        </tr>
                    <?php endwhile; ?>
                </tbody>
            </table>
        <?php else: ?>
            <p>Izvelēta tabula ir tukša.</p>
        <?php endif; ?>
    <?php endif; ?>
</body>
</html>
