package Calculator;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import java.io.IOException;

public class FirstController implements EventHandler<Event>
{
    // labels in the title screen
    @FXML private Label labelcommondif;
    @FXML private Label gettermvalue;
    @FXML private Label getsum;
    @FXML private Label getnthterm;
    @FXML private Label about;

    // input
    @FXML private TextField number1;
    @FXML private TextField number2;
    @FXML private TextField term;
    @FXML private TextField setSequence;

    // output
    @FXML private Button calculate;
    @FXML private Label printoption;
    @FXML private Text entertermmessage;
    @FXML private Text result;
    @FXML private Text resultMessage;
    @FXML private Label footer;

    // events
    Event event;
    Event mouseevent;

    // model class
    Logic logic = new Logic();

    public void mouseEvenHandler()
    {
        mouseevent = event;
        term.setText("");
        if (event.getSource() == labelcommondif)
        {
            printoption.setText("Common Difference");
            entertermmessage.setVisible(false);
            term.setVisible(false);
            resultMessage.setText("Result:");
            footer.setText("Get a the common difference of a P.A");
        }

        if (event.getSource() == gettermvalue)
        {
            printoption.setText("Get certain term Value");
            entertermmessage.setVisible(true);
            term.setVisible(true);
            resultMessage.setText("Result:");
            footer.setText("Get a the term value of a P.A ex: 6, 10, 14, the 2th term value is 10");
        }

        if (event.getSource() == getsum)
        {
            printoption.setText("Get Sum");
            entertermmessage.setVisible(true);
            term.setVisible(true);
            footer.setText("Get a the sum value of a P.A ex: 6, 10, 14, the sum would be (6+10+14)");
        }

        if (event.getSource() == getnthterm)
        {
            printoption.setText("Get Index Value");
            resultMessage.setText("Result:");
        }

        if (mouseevent.getSource() == about)
        {
            try
            {
                footer.setText("Moises Kerschner 2018");
            }catch (NumberFormatException e){
                System.out.println("error message");
            }
        }
    }

    public void actionEvent()
    {
        if (event.getSource() == calculate && mouseevent.getSource() == labelcommondif)
        {
            if (logic.setSequence(setSequence.getText()))
            {
                if (logic.hasCommonDifference())
                {
                    result.setText(Float.toString(logic.getCommonDiference()));
                }
                else
                {
                    result.setText("Invalid Common Difference!");
                }
            }
            else
            {
                result.setText("Invalid input!");
            }
            logic.cleaner();
        }

        if (event.getSource() == calculate && mouseevent.getSource() == gettermvalue || (event.getSource() == setSequence && mouseevent.getSource() == gettermvalue))
        {
            if (logic.setSequence(setSequence.getText()))
            {
                if (logic.hasCommonDifference())
                {
                    try
                    {
                        logic.setTerm(Integer.parseInt(term.getText()));
                        result.setText(Float.toString(logic.getCertainTermValue()));
                    }catch (NumberFormatException e){ result.setText("Invalid input!");}
                }
                else
                {
                    result.setText("Invalid Common Difference!");
                }
            }
            else
            {
                result.setText("Invalid input!");
            }
            logic.cleaner();
        }

        if (event.getSource() == calculate && mouseevent.getSource() == getsum || (event.getSource() == setSequence && mouseevent.getSource() == getsum))
        {
            if (logic.setSequence(setSequence.getText()))
            {
                if (logic.hasCommonDifference())
                {
                    try
                    {
                        logic.setTerm(Integer.parseInt(term.getText()));
                        result.setText(Long.toString(logic.getSum()));
                    }catch (NumberFormatException e){ result.setText("Invalid input!");}
                }
                else
                {
                    result.setText("Invalid Common Difference!");
                }
            }
            else
            {
                result.setText("Invalid input!");
            }
            logic.getSequence();
            logic.cleaner();
        }
    }

    @Override
    public void handle(Event event)
    {
        this.event = event;
        if(event.getEventType() == (MouseEvent.MOUSE_CLICKED))
        {
            mouseEvenHandler();
        }

        if(event.getEventType() == (ActionEvent.ACTION))
        {
            try
            {
                actionEvent();
            }catch (Exception e){}
        }
    }
}
