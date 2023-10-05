import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class Controller2 {
    @FXML
    Button save, back;
    @FXML
    TextField name, username;
    @FXML
    ToggleGroup group;
    @FXML
    RadioButton man, woman, other;
    @FXML
    PasswordField password;

    public void save() throws Exception {
        PersonList personList = PersonList.getInstance("qwerty.xml");

        String vards = name.getText();
        String lietotajs = username.getText();
        String parole = password.getText();
        String dzimums = "bez";
        if (man.isSelected()) {
            dzimums = "Man";
        }
        if (woman.isSelected()) {
            dzimums = "woman";
        }
        if (other.isSelected()) {
            dzimums = "other";
        }

        for (int i = 0; i < personList.getList().size(); i++) {
            Person p = personList.getList().get(i);

            if (p.getUsername().equals(lietotajs)) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Username already exists");
                alert.showAndWait();
                return;
            }
        }
                Person person = new Person(vards, lietotajs, parole, dzimums);
                personList.addPerson(person);
                try {
                        JAXBContext contextObj = JAXBContext.newInstance(PersonList.class);
                        Marshaller marshallerObj = contextObj.createMarshaller();
                        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                        marshallerObj.marshal(personList, new File("qwerty.xml"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("test_3.fxml"));
            Parent parent = loader.load();
            Stage stage = (Stage) save.getScene().getWindow();
            stage.setScene(new Scene(parent));
    }
    public void back() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("test_1.fxml"));
        Parent parent = loader.load();
        Stage stage = (Stage) back.getScene().getWindow();
        stage.setScene(new Scene(parent));
    }
}
