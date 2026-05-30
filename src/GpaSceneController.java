import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class GpaSceneController {
    @FXML
    private Button goBack;
    @FXML
    private TextField credits1;
    @FXML
    private TextField credits2;
    @FXML
    private TextField credits3;
    @FXML
    private TextField credits4;
    @FXML
    private Spinner<Integer> mark1;
    @FXML
    private Spinner<Integer> mark2;
    @FXML
    private Spinner<Integer> mark3;
    @FXML
    private Spinner<Integer> mark4;
    @FXML
    private Label grade1;
    @FXML
    private Label grade2;
    @FXML
    private Label grade3;
    @FXML
    private Label grade4;
    @FXML
    private Label GPA;
    @FXML
    private Text messageT;
    @FXML
    private Button calculate;
    @FXML
    private ProgressBar gpaProgressBar;


    @FXML
    private void CourseGPA(ActionEvent event) {
        try {
            int Mark1 = mark1.getValue();
            int Mark2 = mark2.getValue();
            int Mark3 = mark3.getValue();
            int Mark4 = mark4.getValue();
            int Credits1 = Integer.parseInt(credits1.getText());
            int Credits2 = Integer.parseInt(credits2.getText());
            int Credits3 = Integer.parseInt(credits3.getText());
            int Credits4 = Integer.parseInt(credits4.getText());
            messageT.setText("");
            grade1.setText(calculateGrade(Mark1));
            grade2.setText(calculateGrade(Mark2));
            grade3.setText(calculateGrade(Mark3));
            grade4.setText(calculateGrade(Mark4));
            GPA.setText(String.valueOf(calculateGPA(Mark1, Mark2, Mark3, Mark4, Credits1,
                    Credits2, Credits3, Credits4)));
                    double gpa = calculateGPA(Mark1, Mark2, Mark3, Mark4, Credits1,
                Credits2, Credits3, Credits4);
        gpaProgressBar.setProgress(gpa / 4.0); 

        } catch (NumberFormatException nfe) {
            messageT.setText("Please enter a valid number for marks and credits");
        }

    }

    private String calculateGrade(int mark) {
        if (mark >= 95 && mark <= 100) {
            return "A*";
        } else if (mark >= 90 && mark < 95) {
            return "A";
        } else if (mark >= 85 && mark < 90) {
            return "A-";
        } else if (mark >= 80 && mark < 85) {
            return "B+";
        } else if (mark >= 75 && mark < 80) {
            return "B";
        } else if (mark >= 70 && mark < 75) {
            return "B-";
        } else if (mark >= 65 && mark < 70) {
            return "C+";
        } else if (mark >= 60 && mark < 65) {
            return "C";
        } else if (mark >= 55 && mark < 60) {
            return "C-";
        } else if (mark >= 50 && mark < 55) {
            return "D+";
        } else if (mark >= 45 && mark < 50) {
            return "D";
        } else {
            return "F";
        }
    }

    private double gradeToPoint(String grade) {
        switch (grade) {
            case "A*":
                return 4.0;
            case "A":
                return 4.0;
            case "A-":
                return 3.7;
            case "B+":
                return 3.3;
            case "B":
                return 3.0;
            case "B-":
                return 2.7;
            case "C+":
                return 2.3;
            case "C":
                return 2.0;
            case "C-":
                return 1.7;
            case "D+":
                return 1.3;
            case "D":
                return 1.0;
            default:
                return 0.0;
        }
    }

    private double calculateGPA(Integer mark1, Integer mark2, Integer mark3, Integer mark4, Integer credits1,
            Integer credits2,
            Integer credits3, Integer credits4) {
        if (credits1 == null && credits2 == null && credits3 == null && credits4 == null && mark1 == null
                && mark2 == null && mark3 == null && mark4 == null) {
            messageT.setText("Please enter a valid credit hour");
        }
        double[] gradePoints = {
                gradeToPoint(calculateGrade(mark1)),
                gradeToPoint(calculateGrade(mark2)),
                gradeToPoint(calculateGrade(mark3)),
                gradeToPoint(calculateGrade(mark4))
        };

        double totalGradePoints = 0.0;
        double totalCredits = credits1 + credits2 + credits3 + credits4;
        double[] credits = { credits1, credits2, credits3, credits4 };

        for (int i = 0; i < 4; i++) {
            totalGradePoints += gradePoints[i] * credits[i];
        }

        double gpa = totalGradePoints / totalCredits;
        return Math.round(gpa * 10.0) / 10.0;
    }

    @FXML
    public void markSpinner() {

        mark1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        mark2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        mark3.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        mark4.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        mark1.setEditable(true);
        mark2.setEditable(true);
        mark3.setEditable(true);
        mark4.setEditable(true);
        SpinnerListener(mark1);
        SpinnerListener(mark2);
        SpinnerListener(mark3);
        SpinnerListener(mark4);
    }

    @FXML
    public void initialize() {
        markSpinner();
        gpaProgressBar.setProgress(0); 
        
    }

    private void SpinnerListener(Spinner<Integer> spinner) throws NullPointerException {
        spinner.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue == null) {
                messageT.setText("Please enter your mark");
            }
        });
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {
        SceneSwitcher signUpSwitcher = new SceneSwitcher();
        signUpSwitcher.switchScene("StudentHomeScene.fxml", event, "Student Home Page");
    }

}
