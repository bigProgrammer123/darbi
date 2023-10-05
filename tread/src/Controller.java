import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.AnchorPane;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    @FXML
    AnchorPane pane;

    @FXML
    private Button delete, start;

    @FXML
    private TableView table;

    @FXML
    private TableColumn<Map, String> T1,T2,T3,Together;

    @FXML
    void initialize() {
        tableInitialization();
    }

    @FXML
    void start() {
        ObservableList<Map<String, Object>> items = FXCollections.<Map<String, Object>>observableArrayList();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        Map<String, Object> map = new HashMap<>();
        map.put("T1",  LocalTime.now().format(format));
        map.put("T2",  LocalTime.now().format(format));
        map.put("T3",  LocalTime.now().format(format));
        map.put("Together",  LocalTime.now().format(format));
        items.add(map);
        table.getItems().addAll(items);
    }

    @FXML
    void delete() {
        TableView.TableViewSelectionModel selectionModel = table.getSelectionModel();
        ObservableList selectedItems = selectionModel.getSelectedItems();
        //ObservableList<Map<String, Object>> items = selectedItems;

        table.getItems().removeAll(selectedItems);
        selectionModel.clearSelection();
    }
    @FXML
    void focus() {
        pane.requestFocus();
        TableView.TableViewSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.clearSelection();
    }

    public void tableInitialization() {
        T1.setCellValueFactory(new MapValueFactory<>("T1"));
        T2.setCellValueFactory(new MapValueFactory<>("T2"));
        T3.setCellValueFactory(new MapValueFactory<>("T3"));
        Together.setCellValueFactory(new MapValueFactory<>("Together"));

        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
}