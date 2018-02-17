package Calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DialogueBoxController implements EventHandler<ActionEvent>
{

    @FXML private Pane alertbox;
    @FXML private Button back;
    ActionEvent event;

    @Override
    public void handle(ActionEvent event)
    {
        Parent screen;
        Stage stage;
        if (event.getSource() == back)
        {
            stage = new Stage();
            stage = (Stage)back.getScene().getWindow();
            stage.close();
        }

    }


}
