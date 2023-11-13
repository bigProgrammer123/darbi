import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.chart.XYChart;

public class Controller {
    @FXML
    private TableView<AlgorithmResult> tableView;
    @FXML
    private TableColumn<AlgorithmResult, String> algorithmTable;
    @FXML
    private TableColumn<AlgorithmResult, Long> timeTable;
    @FXML
    private TextField numberOfElm;
    @FXML
    private BarChart<String, Number> chart;

    private XYChart.Series<String, Number> bubbleSeries = new XYChart.Series<>();
    private XYChart.Series<String, Number> selectionSeries = new XYChart.Series<>();
    private XYChart.Series<String, Number> mergeSeries = new XYChart.Series<>();
    private XYChart.Series<String, Number> shellSeries = new XYChart.Series<>();
    private XYChart.Series<String, Number> javaSeries = new XYChart.Series<>();

    public void initialize() {
        algorithmTable.setCellValueFactory(new PropertyValueFactory<>("algorithmName"));
        timeTable.setCellValueFactory(new PropertyValueFactory<>("time"));

        chart.getData().addAll(bubbleSeries, selectionSeries, mergeSeries, shellSeries, javaSeries);
    }

    @FXML
    private void runAlgorithms(ActionEvent event) {
        String elementCountText = numberOfElm.getText();
        if (!elementCountText.isEmpty()) {
            int elementCount = Integer.parseInt(elementCountText);
            int[] randomArray = Algorithms.generateRandomArray(elementCount);

            tableView.getItems().clear();

            addAlgorithmResult("Bubble Sort", () -> Algorithms.bubbleSort(randomArray.clone()), bubbleSeries);
            addAlgorithmResult("Selection Sort", () -> Algorithms.selectionSort(randomArray.clone()), selectionSeries);
            addAlgorithmResult("Merge Sort", () -> Algorithms.mergeSort(randomArray.clone()), mergeSeries);
            addAlgorithmResult("Shell Sort", () -> Algorithms.shellSort(randomArray.clone()), shellSeries);
            addAlgorithmResult("Java Sort", () -> Algorithms.javaSort(randomArray.clone()), javaSeries);
        }
    }

    private void addAlgorithmResult(String algorithmName, Runnable sortingTask, XYChart.Series<String, Number> series) {
        long startTime = System.currentTimeMillis();
        sortingTask.run();
        long endTime = System.currentTimeMillis();

        tableView.getItems().add(new AlgorithmResult(algorithmName, endTime - startTime));

        series.getData().add(new XYChart.Data<>(algorithmName, endTime - startTime));
    }
}

