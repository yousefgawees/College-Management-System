import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
// import java.io.IOException;
import javafx.application.Platform;
import javafx.concurrent.Task;

public class SceneSwitcher implements SceneSwitcherInterface {
    private Stage stage;
    private Scene scene;

    public void switchScene(String fxmlFile, ActionEvent event, String fileName) 
    {
        Task<Void> task = new Task<Void>() {
            protected Void call() throws Exception {
                Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));    // Load the new scene's FXML file
                Platform.runLater(() -> 
                {
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  // Get the current stage
                    scene = new Scene(root);    // Create a new scene with the loaded content
                    stage.setScene(scene);  // Set the new scene on the stage
                    stage.show();   // Show the stage
                    stage.setTitle(fileName);
                    System.out.println("Scene loaded and displayed.");
                });
                return null;
            }
        };
        task.setOnFailed(e -> {
            e.getSource().getException().printStackTrace();
            System.out.println("FILE ERROR!");
        });
        new Thread(task).start();
    }
}
