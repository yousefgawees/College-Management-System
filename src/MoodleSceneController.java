import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.awt.Desktop;
import java.net.URI;

public class MoodleSceneController 
{
    @FXML
    private Button goBack;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;


    public void goBack(ActionEvent event)
    {
        SceneSwitcher signUpSwitcher = new SceneSwitcher();
        signUpSwitcher.switchScene("StudentHomeScene.fxml", event, "Student Home Page");
    }

    public void gotoAdvanced()
    {
        try 
        {
            Desktop.getDesktop().browse(new URI("https://docs.oracle.com/cd/E40229_01/technical/a81_apca.pdf"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    public void gotoCyber()
    {
        try 
        {
            Desktop.getDesktop().browse(new URI("https://www.uou.ac.in/sites/default/files/slm/Introduction-cyber-security.pdf"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    public void gotoArch()
    {
        try 
        {
            Desktop.getDesktop().browse(new URI("https://nou.edu.ng/coursewarecontent/CIT309%20Computer%20Architecture.pdf"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    public void gotoData()
    {
        try 
        {
            Desktop.getDesktop().browse(new URI("https://www.mta.ca/~rrosebru/oldcourse/263114/Dsa.pdf"));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

}
