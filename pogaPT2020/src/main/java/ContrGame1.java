import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class ContrGame1 implements Initializable {
    @FXML
    Button back;
    @FXML
    ImageView imageView;

    public Image bildes() throws Exception{
        Image image1 = new Image(new FileInputStream("src/main/images/csgo.jpeg"));
        imageView.setImage(image1);
        return image1;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            bildes();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void back() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("test_3.fxml"));
        Parent parent = loader.load();
        Stage stage = (Stage) back.getScene().getWindow();
        stage.setScene(new Scene(parent));
    }
}
