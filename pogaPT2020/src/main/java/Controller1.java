import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller1 {
    @FXML
    Button poga, registerPoga;
    @FXML
    TextField username;
    @FXML
    PasswordField password;

    public void click() throws Exception {
        PersonList personList = PersonList.getInstance("qwerty.xml");

        String lietotajs = username.getText();
        String parole = password.getText();

        boolean contL = personList.getList().stream().anyMatch(person -> lietotajs.equals(person.getUsername()));
        boolean contP = personList.getList().stream().anyMatch(person -> parole.equals(person.getPassword()));

        if(contL && contP) {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("test_3.fxml"));
                Parent parent = loader.load();
                Stage stage = (Stage) poga.getScene().getWindow();
                stage.setScene(new Scene(parent));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong username or password");
            alert.showAndWait();
        }
    }


    public void click2() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("test_2.fxml"));
        Parent parent = loader.load();
        Stage stage = (Stage) poga.getScene().getWindow();
        stage.setScene(new Scene(parent));
    }
}

