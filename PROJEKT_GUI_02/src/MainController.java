
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController{

    @FXML
    private Button start;

    @FXML
    private Button exit;

    @FXML
    private CheckMenuItem checkMenuItem1;


@FXML
public void openNewWindow(ActionEvent event) {

          if (checkMenuItem1.isSelected()) {
              if (event.getSource() == start) {
                  try {
                      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gameScene.fxml"));
                      Parent root1 = fxmlLoader.load();
                      Stage stage = new Stage();
                      stage.setTitle("Game Stage");
                      stage.setScene(new Scene(root1));
                      stage.show();

                  } catch (Exception ex) {
                      ex.printStackTrace();
                  }
              }
          }

}
    @FXML
    public void closeWindow(){
        Stage stage=(Stage) exit.getScene().getWindow();
        stage.close();
    }


    public void initialize() {

    }


}
