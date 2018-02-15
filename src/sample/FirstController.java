package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstController implements EventHandler<ActionEvent>
{
    @FXML
    private TextField result;
    @FXML
    private TextField number1;
    @FXML
    private Button calculate;
    @FXML
    private TextField number2;
    @FXML
    private TextField commondiference;
    @FXML
    private TextField sum;
    @FXML
    private TextField term;
    @FXML
    private TextField termvalue;
    @FXML
    private Button back;
    ActionEvent event;
    Logic logic = new Logic();


    @Override
    public void handle(ActionEvent event)
    {
        Parent screen;
        Stage stage;

        if (event.getSource() == calculate)
        {
            stage = new Stage();
            try
            {
                logic.add(Float.parseFloat(number1.getText()), Float.parseFloat(number2.getText()));
                commondiference.setText(Float.toString(logic.getCommonDiference()));
                logic.setTerm(Integer.parseInt(term.getText()));
                termvalue.setText(Float.toString(logic.getCertainTermValue()));
                sum.setText(Float.toString(logic.getSum()));
            } catch (NumberFormatException e)
            {
                try
                {
                    screen = FXMLLoader.load(getClass().getResource("dialoguebox.fxml"));
                    stage.setScene(new Scene(screen));
                } catch (IOException e1)
                {
                    e1.printStackTrace();
                }
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initOwner(calculate.getScene().getWindow());
                stage.showAndWait();
            }
        }
    }

}
