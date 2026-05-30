import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        URL url = getClass().getClassLoader().getResource("LoginScene.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        LoginSceneController controller = loader.getController();
        controller.setloginWindow(primaryStage);
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}
