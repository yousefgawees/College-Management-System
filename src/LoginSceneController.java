import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginSceneController
{
    @FXML
    private Stage loginWindow;
    @FXML
    private Stage loginStage;
    @FXML 
    private Button loginBtn;
    @FXML
    private Button registerBtn;
    @FXML 
    private TextField regTF;
    @FXML 
    private PasswordField pinTF;
    @FXML
    private Text messageT;
    @FXML
    private RadioButton studentRB;
    @FXML
    private RadioButton professorRB;
    public void setloginWindow(Stage loginWindow) 
    {
        this.loginWindow = loginWindow;
    }

    String userName;

    public void checkInput(ActionEvent event) 
    {
        String regText = regTF.getText();
        String pinText = pinTF.getText();

        if (regText.isEmpty() || pinText.isEmpty()) 
        {
            messageT.setText("Registration number and Pin Code are required");
        }

        if(!studentRB.isSelected() && !professorRB.isSelected())
        {
            messageT.setText("Selecting your academic is required");
        }

        try
        {
            int registerNumber = Integer.parseInt(regTF.getText());
            int pinCode = Integer.parseInt(pinTF.getText());

            boolean verify;
            if(studentRB.isSelected())
            {
                verify = FileCheck.checkLogin("students",registerNumber, pinCode);
            }

            else
            {

                verify = FileCheck.checkLogin("professor",registerNumber, pinCode);
            }

            if (verify) 
            {
                if(studentRB.isSelected())
                {
                    SceneSwitcher sceneSwitcher = new SceneSwitcher();
                    sceneSwitcher.switchScene("StudentHomeScene.fxml", event, "Student Home Page");
                }
                else if(professorRB.isSelected())
                {
                    SceneSwitcher sceneSwitcher = new SceneSwitcher();
                    sceneSwitcher.switchScene("ProfHomeScene.fxml", event, "Professor Home Page");
                }
            }

            else
            {
                messageT.setText("Registration Number and Pin Code do not match.\nPlease type them correctly");
                // return 0;
            }
        }
        finally
        {

        }
    }
    
    @FXML
    public void switchToSignUpScene(ActionEvent event)
    {
        SceneSwitcher signUpSwitcher = new SceneSwitcher();
        signUpSwitcher.switchScene("SignUpScene.fxml", event, "Sign up");
    }
}
