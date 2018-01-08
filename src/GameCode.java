import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Timer;
 
public class GameCode extends Application {
   
	private static int width = 50;
	private static int length = 50;
	
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
            	movePosition(btn);
            }
        });
        
        Pane root = new Pane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, width, length));
        primaryStage.show();
        //System.out.println(num);
    }
    
    public static void movePosition(Button btn)
	{
    	int a = (int) (width - width*0.2);
    	int b = (int) (length - length*0.3);
    	
		btn.setLayoutX(randomNum(0,a));
		btn.setLayoutY(randomNum(0,b));
	}
    
    public static int randomNum (int min, int max)
    {
       int range = (max - min) + 1;     
       return (int)(Math.random() * range) + min;
    }
}