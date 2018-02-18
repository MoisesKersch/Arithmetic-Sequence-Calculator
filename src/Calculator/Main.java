package Calculator;
// by Moises Kerschner
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Main extends Application {

    private Parent root;
    private Parent dialogue;
    private Scene scene1;
    private Scene scene2;


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        root = FXMLLoader.load(getClass().getResource("MainFrame.fxml"));
        scene1 = new Scene(root);
        primaryStage.setTitle("Calculator");
        Image image = new Image("/Calculator/paicon.png");
        primaryStage.getIcons().add(image);
        primaryStage.setScene(scene1);
        primaryStage.setResizable(false);
        primaryStage.show();
        System.out.println("from main "+ primaryStage);

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
