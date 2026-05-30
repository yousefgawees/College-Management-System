import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class StudentHomeSceneController
{
    @FXML
    private Stage StudentHomeWindow;
    @FXML
    private Hyperlink gradesHL;
    @FXML
    private Hyperlink scheduleHL;
    @FXML
    private Hyperlink gpaHL;
    @FXML

    public void setStudentHomeWindow(Stage StudentHomeWindow) {
        this.StudentHomeWindow = StudentHomeWindow;
    }

    public void gotoMoodle(ActionEvent event) {
        SceneSwitcher sceneSwitcher = new SceneSwitcher();
        sceneSwitcher.switchScene("MoodleScene.fxml", event, "Moodle");
    }

    public void gotoSchedule(ActionEvent event) {
        SceneSwitcher sceneSwitcher = new SceneSwitcher();
        sceneSwitcher.switchScene("StudentScheduleScene.fxml", event, "Student's Schedule");
    }

    public void gotoGPA(ActionEvent event) {
        SceneSwitcher sceneSwitcher = new SceneSwitcher();
        sceneSwitcher.switchScene("GpaScene.fxml", event, "GPA Calculator");
    }

}
