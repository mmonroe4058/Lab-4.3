import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Timer;
 
public class GameCode extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chase the Button!");
        Button btn = new Button();
        btn.setText("Start");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	
            	btn.setText("Click me!");
            	
            }
        });
        
        StackPane root = new StackPane();
        btn.setLayoutX(150);
        btn.setLayoutY(120);
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 800, 250));
        primaryStage.show();
    }
}