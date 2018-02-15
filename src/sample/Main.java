package sample;
// by Moises Kerschner
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    private Parent root;
    private Parent dialogue;
    private Scene scene1;
    private Scene scene2;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        root = FXMLLoader.load(getClass().getResource("first.fxml"));
        scene1 = new Scene(root);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene1);
        primaryStage.setResizable(false);
        primaryStage.show();
        System.out.println("from main "+ primaryStage);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
//    public void displayDialogueBox() throws Exception
//    {
//        dialogue = FXMLLoader.load(Main.class.getResource("dialoguebox.fxml"));
//        primaryStage.setScene(new Scene(dialogue));
//        primaryStage.setScene(new Scene(root));
//    }
}
