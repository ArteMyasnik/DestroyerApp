package learn.destroyer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Set the width size: ");
//        double sizeWidth = scanner.nextDouble();
//        System.out.print("Set the height size: ");
//        double sizeHeight = scanner.nextDouble();

        double sizeWidth = 480;
        double sizeHeight = 360;

        System.out.println("App was opened");
//        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        AnchorPane anchorPane = new AnchorPane();
        Button button = new Button("Destroying the peace");

        TextField textField = new TextField();
        anchorPane.getChildren().addAll(textField, button);

        AnchorPane.setLeftAnchor(button, sizeWidth / 10 * 1);
        AnchorPane.setTopAnchor(button, sizeHeight / 10 * 1);

        AnchorPane.setLeftAnchor(textField, sizeWidth / 10 * 1);
        AnchorPane.setTopAnchor(textField, sizeHeight / 10 * 2);

        Scene scene = new Scene(anchorPane, sizeWidth, sizeHeight);

//        button
        button.setOnAction(actionEvent -> System.out.println("destroyed"));
//        Ctrl+N or Ctrl+Shift+N on Scene
        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.N && keyEvent.isControlDown()) {
                if (keyEvent.isShiftDown()) {
                    System.out.println("Ctrl+Shift+N");
                } else {
                    System.out.println("Ctrl+N");
                }
            }
        });


//        Scene scene = new Scene(fxmlLoader.load(), 480, 400);
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/learn/destroyer/iconExample16x16.png"))));
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/learn/destroyer/iconExample32x32.png"))));
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/learn/destroyer/iconExample64x64.png"))));
        stage.setTitle("Destroyer App");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("App was closed");
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}