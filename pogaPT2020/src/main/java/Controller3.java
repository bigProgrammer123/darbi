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

    public class Controller3 implements Initializable {

        @FXML
        Button logOut, game1, game2, game3, game4;
        @FXML
        ImageView imageView1, imageView2, imageView3, imageView4;


        public Image bilde1() throws Exception{
            Image image1 = new Image(new FileInputStream("src/main/images/csgo.jpeg"));
            imageView1.setImage(image1);
            return image1;
        }
        public Image bilde2() throws Exception{
            Image image1 = new Image(new FileInputStream("src/main/images/soma.jpeg"));
            imageView2.setImage(image1);
            return image1;
        }
        public Image bilde3() throws Exception{
            Image image1 = new Image(new FileInputStream("src/main/images/jumpking.jpeg"));
            imageView3.setImage(image1);
            return image1;
        }
        public Image bilde4() throws Exception{
            Image image1 = new Image(new FileInputStream("src/main/images/half.jpeg"));
            imageView4.setImage(image1);
            return image1;
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            try{
                bilde1();
                bilde2();
                bilde3();
                bilde4();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

    public void back() throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getClassLoader().getResource("test_1.fxml"));
        Parent parent=loader.load();
        Stage stage=(Stage)logOut.getScene().getWindow();
        stage.setScene(new Scene(parent));
    }
        public void game1() throws Exception {
            FXMLLoader loader=new FXMLLoader(getClass().getClassLoader().getResource("Game1.fxml"));
            Parent parent=loader.load();
            Stage stage=(Stage)game1.getScene().getWindow();
            stage.setScene(new Scene(parent));
        }
        public void game2() throws Exception {
            FXMLLoader loader=new FXMLLoader(getClass().getClassLoader().getResource("Game2.fxml"));
            Parent parent=loader.load();
            Stage stage=(Stage)game2.getScene().getWindow();
            stage.setScene(new Scene(parent));
        }
        public void game3() throws Exception {
            FXMLLoader loader=new FXMLLoader(getClass().getClassLoader().getResource("Game3.fxml"));
            Parent parent=loader.load();
            Stage stage=(Stage)game3.getScene().getWindow();
            stage.setScene(new Scene(parent));
        }
        public void game4() throws Exception {
            FXMLLoader loader=new FXMLLoader(getClass().getClassLoader().getResource("Game4.fxml"));
            Parent parent=loader.load();
            Stage stage=(Stage)game4.getScene().getWindow();
            stage.setScene(new Scene(parent));
        }
}