import javafx.beans.value.ChangeListener;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.Region;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ControllerTable {
    @FXML
    private BarChart<String, Double> barChart;
    @FXML
    private Button acceptOptions;

    @FXML
    private Region array1;

    @FXML
    private Button bubbleSort;

    @FXML
    private ComboBox<?> choiceDataStructure;

    @FXML
    private ComboBox<Diagrams> comboBoxDiagrams;
    @FXML
    private ComboBox<Diagrams> comboBoxTable;

    @FXML
    private Button javaSort;

    @FXML
    private Button loadData;

    @FXML
    private RadioButton manyThreads;

    @FXML
    private Button mergeSort;

    @FXML
    private RadioButton micro;

    @FXML
    private RadioButton mili;

    @FXML
    private RadioButton nano;

    @FXML
    private TextField numberOfElements;

    @FXML
    private TextField numberOfMeasurements;

    @FXML
    private RadioButton oneThread;

    @FXML
    private Button quickSort;

    @FXML
    private RadioButton radioBubbleSort;

    @FXML
    private RadioButton radioJavaSort;

    @FXML
    private RadioButton radioMergeSort;

    @FXML
    private RadioButton radioQuickSort;

    @FXML
    private RadioButton radioSelectionSort;

    @FXML
    private RadioButton radioShellSort;

    @FXML
    private RadioButton radioSimpleSort;

    @FXML
    private Button saveData;

    @FXML
    private RadioButton second;

    @FXML
    private Button selectionSort;

    @FXML
    private Button shellSort;

    @FXML
    private Button simple;

    @FXML
    private ToggleGroup sortAlgorithmsToggleGroup;

    @FXML
    private TableView<Map> table;

    @FXML
    private ToggleGroup threadToggleGroup;

    @FXML
    private TableColumn<Map, Long> timeColumn;
    @FXML
    private TableColumn<Map, Integer> nrColumn;

    @FXML
    private ToggleGroup timeToggleGroup;

    private boolean bubbleSortActivity, javaSortActivity, mergeSortActivity, quickSortActivity,
            selectionSortActivity, shellSortActivity, simpleSortActivity;

    ArrayList<Diagrams> listOfDiagrams = new ArrayList<>();
    //ObservableList<Diagrams> listOfDiagrams = FXCollections.<Diagrams>observableArrayList();


    @FXML
    void bubbleSortFunction(ActionEvent event) {
        if(bubbleSortActivity == false){
            bubbleSortActivity = true;
            bubbleSort.setStyle("-fx-background-color: #FFD700");
        }
        else{
            bubbleSortActivity = false;
            bubbleSort.setStyle("-fx-background-color:  #F0FFF0");
        }
    }

    @FXML
    void javaSortFunction(ActionEvent event) {
        if(javaSortActivity == false){
            javaSortActivity = true;
            javaSort.setStyle("-fx-background-color: #FFD700");
        }
        else{
            javaSortActivity = false;
            javaSort.setStyle("-fx-background-color:  #F0FFF0");
        }
    }
    @FXML
    void simpleSortFunction(ActionEvent event) {

        if(simpleSortActivity == false){
            simpleSortActivity = true;
            simple.setStyle("-fx-background-color: #FFD700");
        }
        else{
            simpleSortActivity = false;
            simple.setStyle("-fx-background-color:  #F0FFF0");
        }
    }
    @FXML
    void mergeSortFunction(ActionEvent event) {
        if(mergeSortActivity == false){
            mergeSortActivity = true;
            mergeSort.setStyle("-fx-background-color: #FFD700");
        }
        else{
            mergeSortActivity = false;
            mergeSort.setStyle("-fx-background-color:  #F0FFF0");
        }
    }

    @FXML
    void quickSortFunction(ActionEvent event) {
        if(quickSortActivity == false){
            quickSortActivity = true;
            quickSort.setStyle("-fx-background-color: #FFD700");
        }
        else{
            quickSortActivity = false;
            quickSort.setStyle("-fx-background-color:  #F0FFF0");
        }
    }

    @FXML
    void selectionSortFunction(ActionEvent event) {
        if(selectionSortActivity == false){
            selectionSortActivity = true;
            selectionSort.setStyle("-fx-background-color: #FFD700");
        }
        else{
            selectionSortActivity = false;
            selectionSort.setStyle("-fx-background-color:  #F0FFF0");
        }
    }

    @FXML
    void shellSortFunction(ActionEvent event) {
        if(shellSortActivity == false){
            shellSortActivity = true;
            shellSort.setStyle("-fx-background-color: #FFD700");
        }
        else{
            shellSortActivity = false;
            shellSort.setStyle("-fx-background-color:  #F0FFF0");
        }
    }


    @FXML
    void acceptOptionsFunction(){

        int amountOfElements = Integer.parseInt(numberOfElements.getText()) ;
        int amountOfMeasurements = Integer.parseInt(numberOfMeasurements.getText());

        SortWithArray arraySort = new SortWithArray(amountOfElements); // Kartošanas algoritma objekts
        Diagrams diagrams = new Diagrams(); // Laiku ievāceja objekts
        long simpleSortTime, bubbleSortTime, selectionSortTime, mergeSortTime, quickSortTime, shellSortTime, javaSortTime;

        Map<String, Object> map = new HashMap<>();

        for (int i = 0; i < amountOfMeasurements; i++) {
            if (simpleSortActivity == true) {
                simpleSortTime = arraySort.simpleSort();
                diagrams.getSimpleSortTime().add(simpleSortTime);
                System.out.println(simpleSortTime);
            }
            if (bubbleSortActivity == true){
                bubbleSortTime = arraySort.bubbleSort();
                diagrams.getBubbleSortTime().add(bubbleSortTime);
                System.out.println(bubbleSortTime);
            }
            if (selectionSortActivity == true){
                selectionSortTime = arraySort.selectionSort();
                diagrams.getSelectionSortTime().add(selectionSortTime);
                System.out.println(selectionSortTime);
            }
            if (mergeSortActivity == true){
                mergeSortTime = arraySort.mergeSort();
                diagrams.getMergeSortTime().add(mergeSortTime);
                System.out.println(mergeSortTime);
            }
            if (quickSortActivity == true){
                quickSortTime = arraySort.quickSort();
                diagrams.getQuickSortTime().add(quickSortTime);
                System.out.println(quickSortTime);
            }
            if (shellSortActivity == true){
                shellSortTime = arraySort.shellSort();
                diagrams.getShellSortTime().add(shellSortTime);
                System.out.println(shellSortTime);
            }
            if (javaSortActivity == true){
                javaSortTime = arraySort.javaSort();
                diagrams.getJavaSortTime().add(javaSortTime);
                System.out.println(javaSortTime);
            }
            arraySort.generate(); //Jauna vērtibu virkne
            System.out.println("============================================================");

        }
        System.out.println("Videjais laiks BubbleSort");
        //System.out.println(diagrams.getSortTimeAverage().get("bubbleSortTimeAverage"));

        listOfDiagrams.add(diagrams);
        comboBoxTable.getItems().add(diagrams);
        comboBoxDiagrams.getItems().add(diagrams);


    }




    // TABULA
    void tableInitialize(Diagrams diagrams){
        table.getItems().clear();
        //table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        nrColumn.setCellValueFactory(new MapValueFactory<>("nr"));
        timeColumn.setCellValueFactory(new MapValueFactory<>("time"));
        HashMap<String, Double> values = diagrams.calculateSortTimeAverage();

        //THIS IS NOT WORK:
        /*The reason your code snippet using sortAlgorithmsToggleGroup.getToggles().addListener(...)
         *doesn't work as expected is because the getToggles() method returns an unmodifiable list of
         *the radio buttons within the ToggleGroup, and the addListener method is intended for observing
         *changes in an ObservableList. Since getToggles() returns an unmodifiable list,
         *you cannot add a listener to it using the addListener method.

        sortAlgorithmsToggleGroup.getToggles().addListener(new ChangeListener<Toggle>(){

            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {

            }
        });*/

        sortAlgorithmsToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){

            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                table.getItems().clear();
                RadioButton radioButton = (RadioButton) sortAlgorithmsToggleGroup.getSelectedToggle();
                Map<String, Object> map;
                try{
                    switch (radioButton.getText()){
                        case "Simple Sort" ->{
                            for (int i = 0; i < diagrams.getSimpleSortTime().size(); i++) {
                                map =new HashMap<>() ;
                                map.put("nr", i+1 );
                                map.put("time", diagrams.getSimpleSortTime().get(i));
                                table.getItems().add(map);
                            }
                            map =new HashMap<>() ;
                            map.put("nr", "*");
                            map.put("time", "AVERAGE TIME");
                            table.getItems().add(map);
                            map =new HashMap<>() ;
                            map.put("nr", "*");
                            map.put("time", values.get("simpleSortTimeAverage"));
                            table.getItems().add(map);
                        }
                        case "Bubble Sort" ->{
                            for (int i = 0; i < diagrams.getBubbleSortTime().size(); i++) {
                                map =new HashMap<>() ;
                                map.put("nr", i+1 );
                                map.put("time", diagrams.getBubbleSortTime().get(i));
                                table.getItems().add(map);
                            }
                            map =new HashMap<>() ;
                            map.put("nr", "*");
                            map.put("time", "AVERAGE TIME");
                            table.getItems().add(map);
                            map =new HashMap<>() ;
                            map.put("nr", "*");
                            map.put("time", values.get("bubbleSortTimeAverage"));
                            table.getItems().add(map);
                        }
                        case "Selection Sort" ->{
                            for (int i = 0; i < diagrams.getSelectionSortTime().size(); i++) {
                                map =new HashMap<>() ;
                                map.put("nr", i+1 );
                                map.put("time", diagrams.getSelectionSortTime().get(i));
                                table.getItems().add(map);
                            }
                            map =new HashMap<>() ;
                            map.put("nr", "*");
                            map.put("time", "AVERAGE TIME");
                            table.getItems().add(map);
                            map =new HashMap<>() ;
                            map.put("nr", "*");
                            map.put("time", values.get("selectionSortTimeAverage"));
                            table.getItems().add(map);
                        }
                        case "Merge Sort" ->{
                            System.out.println("MERGE");
                            for (int i = 0; i < diagrams.getMergeSortTime().size(); i++) {
                                map =new HashMap<>() ;
                                map.put("nr", i+1 );
                                map.put("time", diagrams.getMergeSortTime().get(i));
                                table.getItems().add(map);
                            }
                            map =new HashMap<>() ;
                            map.put("nr", "*");
                            map.put("time", "AVERAGE TIME");
                            table.getItems().add(map);
                            map =new HashMap<>() ;
                            map.put("nr", "*");
                            map.put("time", values.get("mergeSortTimeAverage"));
                            table.getItems().add(map);
                        }
                        case "Quick Sort" ->{
                            for (int i = 0; i < diagrams.getQuickSortTime().size(); i++) {
                                map =new HashMap<>() ;
                                map.put("nr", i+1 );
                                map.put("time", diagrams.getQuickSortTime().get(i));
                                table.getItems().add(map);
                            }
                            map =new HashMap<>() ;
                            map.put("nr", "*");
                            map.put("time", "AVERAGE TIME");
                            table.getItems().add(map);
                            map =new HashMap<>() ;
                            map.put("nr", "*");
                            map.put("time", values.get("quickSortTimeAverage"));
                            table.getItems().add(map);
                        }
                        case "Shell Sort" ->{
                            for (int i = 0; i < diagrams.getShellSortTime().size(); i++) {
                                map =new HashMap<>() ;
                                map.put("nr", i+1 );
                                map.put("time", diagrams.getShellSortTime().get(i));
                                table.getItems().add(map);
                            }
                            map =new HashMap<>() ;
                            map.put("nr", "*");
                            map.put("time", "AVERAGE TIME");
                            table.getItems().add(map);
                            map =new HashMap<>() ;
                            map.put("nr", "*");
                            map.put("time", values.get("shellSortTimeAverage"));
                            table.getItems().add(map);
                        }
                        case "Java Sort" ->{
                            for (int i = 0; i < diagrams.getJavaSortTime().size(); i++) {
                                map =new HashMap<>() ;
                                map.put("nr", i+1 );
                                map.put("time", diagrams.getJavaSortTime().get(i));
                                table.getItems().add(map);
                            }
                            map =new HashMap<>() ;
                            map.put("nr", "*");
                            map.put("time", "AVERAGE TIME");
                            table.getItems().add(map);
                            map =new HashMap<>() ;
                            map.put("nr", "*");
                            map.put("time", values.get("javaSortTimeAverage"));
                            table.getItems().add(map);
                        }

                    }
                }
                catch (Exception exception){
                    exception.printStackTrace();
                }

            }
        });
    }

    // DIAGRAMMA

    void diagramInitialize(Diagrams diagrams){
        if(diagrams == null){
            System.out.println("NAV NEKA");
        }
        barChart.getData().clear();
        ArrayList<String> listOfSortingAlgorithms = new ArrayList<>(); // Algoritmu nosaukumi priekš diagrammas
        ArrayList<String> listOfSortingAlgorithmsKeys = new ArrayList<>();
        HashMap<String, Double> values = diagrams.calculateSortTimeAverage(); // Videjais laiks

        if(diagrams.getSimpleSortTime().size() != 0) {
            listOfSortingAlgorithms.add("Simple sort");
            listOfSortingAlgorithmsKeys.add("simpleSortTimeAverage"); // Atslega priekš HashMap klase Diagrams
        }
        if(diagrams.getBubbleSortTime().size() != 0) {
            listOfSortingAlgorithms.add("Bubble sort");
            listOfSortingAlgorithmsKeys.add("bubbleSortTimeAverage");
        }
        if (diagrams.getSelectionSortTime().size() != 0){
            listOfSortingAlgorithms.add("Selection sort");
            listOfSortingAlgorithmsKeys.add("selectionSortTimeAverage");
        }
        if(diagrams.getMergeSortTime().size() != 0){
            listOfSortingAlgorithms.add("Merge sort");
            listOfSortingAlgorithmsKeys.add("mergeSortTimeAverage");
        }
        if(diagrams.getQuickSortTime().size() != 0){
            listOfSortingAlgorithms.add("Quick sort");
            listOfSortingAlgorithmsKeys.add("quickSortTimeAverage");
        }
        if(diagrams.getShellSortTime().size() != 0){
            listOfSortingAlgorithms.add("Shell sort");
            listOfSortingAlgorithmsKeys.add("shellSortTimeAverage");
        }
        if(diagrams.getJavaSortTime().size() != 0){
            listOfSortingAlgorithms.add("Java sort");
            listOfSortingAlgorithmsKeys.add("javaSortTimeAverage");
        }



        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(listOfSortingAlgorithms));
        xAxis.setLabel("Sorting Algorithms");

        XYChart.Series<String, Double> series;
        ArrayList<XYChart.Series<String, Double>> listOfSeries = new ArrayList<>();
        for (int i = 0; i < listOfSortingAlgorithms.size(); i++) {
            series = new XYChart.Series<>();
            series.setName(listOfSortingAlgorithms.get(i));
            series.getData().add(new XYChart.Data<>(listOfSortingAlgorithms.get(i), values.get(listOfSortingAlgorithmsKeys.get(i))));
            listOfSeries.add(series);
        }

        barChart.getData().addAll(listOfSeries);
    }


    @FXML
    void chooseDiagrams(ActionEvent event) {
        Diagrams choiceOfDiagram = comboBoxDiagrams.getValue();
        diagramInitialize(choiceOfDiagram);
    }
    @FXML
    void chooseTable(ActionEvent event) {
        radioSimpleSort.setSelected(false);
        radioBubbleSort.setSelected(false);
        radioSelectionSort.setSelected(false);
        radioMergeSort.setSelected(false);
        radioQuickSort.setSelected(false);
        radioShellSort.setSelected(false);
        radioJavaSort.setSelected(false);
        Diagrams choiceOfTable = comboBoxTable.getValue();
        tableInitialize(choiceOfTable);
    }


    @FXML
    public void initialize(){

    }


}

