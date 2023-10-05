import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.util.*;

public class ControllerDatori implements Initializable {

    @FXML
    private Button button1;

    @FXML
    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12;

    @FXML
    private Circle C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12;

    private Map<String, Circle> circleMap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        circleMap = new HashMap<>();
        circleMap.put("1", C1);
        circleMap.put("2", C2);
        circleMap.put("3", C3);
        circleMap.put("4", C4);
        circleMap.put("5", C5);
        circleMap.put("6", C6);
        circleMap.put("7", C7);
        circleMap.put("8", C8);
        circleMap.put("9", C9);
        circleMap.put("10", C10);
        circleMap.put("11", C11);
        circleMap.put("12", C12);

        parseXMLAndColorCircles();

        try{
            bilde();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private void parseXMLAndColorCircles() {
        try {
            File xmlFile = new File("qwerty.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(PersonList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            PersonList personList = (PersonList) jaxbUnmarshaller.unmarshal(xmlFile);

            for (Person person : personList.getList()) {
                String datNum = person.getDatNum();
                if (datNum != null && !datNum.isEmpty()) {
                    Circle circle = circleMap.get(datNum);
                    if (circle != null) {
                        circle.setFill(Color.BLUE);
                    }
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    public Image bilde() {
        Image image = new Image(getClass().getResource("/images/pc.png").toExternalForm());
        image1.setImage(image);
        image2.setImage(image);
        image3.setImage(image);
        image4.setImage(image);
        image5.setImage(image);
        image6.setImage(image);
        image7.setImage(image);
        image8.setImage(image);
        image9.setImage(image);
        image10.setImage(image);
        image11.setImage(image);
        image12.setImage(image);
        return image;
    }

    public void back() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("rezervet.fxml"));
        Parent parent = loader.load();
        Stage stage = (Stage) button1.getScene().getWindow();
        stage.setScene(new Scene(parent));
    }
}