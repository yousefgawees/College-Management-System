import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StudentScheduleSceneController 
{

    @FXML
    private Button goBack;

    public void goBack(ActionEvent event)
    {
        SceneSwitcher signUpSwitcher = new SceneSwitcher();
        signUpSwitcher.switchScene("StudentHomeScene.fxml", event, "Student Home Page");
    }
    
}
