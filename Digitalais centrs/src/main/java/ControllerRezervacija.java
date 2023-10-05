import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import java.io.File;
import java.time.LocalDate;
import java.util.regex.Pattern;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControllerRezervacija {

    @FXML
    private Button button2;

    @FXML
    private Circle datC;

    @FXML
    private TextField datNum;

    @FXML
    private DatePicker date;

    @FXML
    private Circle dateC;

    @FXML
    private TextField name;

    @FXML
    private Circle nameC;

    @FXML
    private TextField surname;

    @FXML
    private Circle surnameC;



    public void funkcijaName() {
        ChangeListener<String> listener = ((observableValue, oldValue, newValue) -> papildfunkcija());
        name.textProperty().addListener(listener);
        surname.textProperty().addListener(listener);
    }

    public void funkcijaDatums() {
        date.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(ObservableValue<? extends LocalDate> observableValue, LocalDate localDate, LocalDate t1) {
                localDate = date.getValue();
                int i = localDate.getYear();
                int y = localDate.now().getYear();
                Paint paint;
                if (i < y && i > 1920) {
                    paint = Color.GREEN;
                } else {
                    paint = Color.RED;
                }
                dateC.setFill(paint);
            }
        });
    }

    public void funkcijaDators() {
        datNum.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {

                datNum.setText(newValue.replaceAll("[^\\d]", ""));
            }

            int value = 0;
            try {
                value = Integer.parseInt(datNum.getText());
            } catch (NumberFormatException e) {

            }

            Paint paint;
            if (value < 1 || value > 12) {
                paint = Color.RED;
            } else {
                paint = Color.GREEN;
            }
            datC.setFill(paint);
        });
    }

    public void papildfunkcija() {
        Boolean b1 = Pattern.matches("^[A-Z][a-z]{2,20}", name.getText());
        Boolean b2 = Pattern.matches("^[A-Z][a-z]{2,20}", surname.getText());
        if (b1) {
            Paint paint = Color.GREEN;
            nameC.setFill(paint);
        } else if (name.getText().isEmpty()) {
            Paint paint = Color.WHITE;
            nameC.setFill(paint);
        } else {
            Paint paint = Color.RED;
            nameC.setFill(paint);
        }
        if (b2) {
            Paint paint = Color.GREEN;
            surnameC.setFill(paint);
        } else if (surname.getText().isEmpty()) {
            Paint paint = Color.WHITE;
            surnameC.setFill(paint);
        } else {
            Paint paint = Color.RED;
            surnameC.setFill(paint);
        }
    }

    public void nextPage() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("datori.fxml"));
        Parent parent = loader.load();
        Stage stage = (Stage) button2.getScene().getWindow();
        stage.setScene(new Scene(parent));
    }

    public void save() throws Exception {
        PersonList personList = PersonList.getInstance("qwerty.xml");

        String vards = name.getText();
        String uzvards = surname.getText();
        LocalDate datums = date.getValue();
        String dators = datNum.getText();

        if (nameC.getFill() == Color.RED || nameC.getFill() == Color.WHITE
                || surnameC.getFill() == Color.RED || surnameC.getFill() == Color.WHITE
                || datC.getFill() == Color.RED || datC.getFill() == Color.WHITE
                || dateC.getFill() == Color.RED || dateC.getFill() == Color.WHITE) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Lūdzu aizpildīt visus lauciņus.");
            alert.showAndWait();
            return;
        }

        for (int i = 0; i < personList.getList().size(); i++) {
            Person p = personList.getList().get(i);

            if (p.getDatNum() != null && p.getDatNum().equals(dators)) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Dators ir aizņemts");
                alert.showAndWait();
                return;
            }
        }

        Person person = new Person(vards, uzvards, datums, dators);
        personList.addPerson(person);

        try {
          
            JAXBContext contextObj = JAXBContext.newInstance(PersonList.class, Person.class, LocalDate.class);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerObj.marshal(personList, new File("qwerty.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("datori.fxml"));
        Parent parent = loader.load();
        Stage stage = (Stage) button2.getScene().getWindow();
        stage.setScene(new Scene(parent));
    }

    public void delete() throws Exception {
        PersonList personList = PersonList.getInstance("qwerty.xml");

        String datorsToDelete = datNum.getText();

        for (int i = 0; i < personList.getList().size(); i++) {
            Person p = personList.getList().get(i);

            if (p.getDatNum() != null && p.getDatNum().equals(datorsToDelete)) {
                personList.getList().remove(i);

                try {
                    JAXBContext contextObj = JAXBContext.newInstance(PersonList.class, LocalDate.class);
                    Marshaller marshallerObj = contextObj.createMarshaller();
                    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    marshallerObj.marshal(personList, new File("qwerty.xml"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION, "Person deleted successfully.");
                successAlert.showAndWait();
                return;
            }
        }
    }

    @FXML
    void initialize() {
        funkcijaName();
        funkcijaDatums();
    }

}
