    // import java.io.FileNotFoundException;
    // import java.io.FileWriter;
    import java.io.IOException;

    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    // import javafx.fxml.FXMLLoader;
    // import javafx.scene.*;
    import javafx.scene.control.Button;
    import javafx.scene.control.PasswordField;
    import javafx.scene.control.RadioButton;
    import javafx.scene.control.TextField;
    // import javafx.stage.Stage;
    import javafx.scene.text.Text;
    import javafx.stage.Stage;
    
    public class SignUpSceneController 
    {
        
        
        @FXML
        private Stage SignUpWindow;
        @FXML
        private TextField nameTF;
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
        @FXML
        private Button gotoLoginBtn;
        
        public void setSignUpWindow(Stage SignUpWindow) 
        {
            this.SignUpWindow = SignUpWindow;
        }
    
        public void switchToLoginScene(ActionEvent event)throws IOException
        {
            SceneSwitcher signUpSwitcher = new SceneSwitcher();
            signUpSwitcher.switchScene("LoginScene.fxml", event, "Login");
        }
    
        @FXML
        private Button signUpBtn;
    
        public void gotoHome(ActionEvent event)throws IOException
        {
            String nameText = nameTF.getText();
            String regText = regTF.getText();
            String pinText = pinTF.getText();
    
            if (regText.isEmpty() || pinText.isEmpty() || nameText.isEmpty()) 
            {
                messageT.setText("Name, Registration number and Pin Code are required");
                return;
            }
    
            if(!studentRB.isSelected() && !professorRB.isSelected())
            {
                messageT.setText("Selecting your academic is required");
                return;
            }
    
            else
            {
                if(studentRB.isSelected())
                {
                    if(FileCheck.found("students",Integer.parseInt(regText)))
                    {
                        messageT.setText("This registration number is already taken");
                    }
                    else
                    {
                        JDBC.connectAndInsert("students",nameText,Integer.parseInt(regText),Integer.parseInt(pinText)); 
                        SceneSwitcher sceneSwitcher = new SceneSwitcher();
                        sceneSwitcher.switchScene("StudentHomeScene.fxml", event, "Student Home Page");
                    }
                }
    
                else if(professorRB.isSelected())
                {
                    if(FileCheck.found("professor",Integer.parseInt(regText)))
                    {
                        messageT.setText("This registration number is already taken");
                    }
                    else
                    {
                        JDBC.connectAndInsert("professor",nameText,Integer.parseInt(regText),Integer.parseInt(pinText)); 
                        SceneSwitcher sceneSwitcher = new SceneSwitcher();
                        sceneSwitcher.switchScene("ProfHomeScene.fxml", event, "Professor Home Page");    
                    }
                }
                
            }
        }    
    }
