import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.applet.Applet;
import java.awt.Label;
import java.awt.TextField;
import java.io.File;

import javafx.scene.text.*;
 
public class GameCode extends Application {
   
	private static int width = 200;
	private static int length = 200;

	static BackEnd newData = new BackEnd();
	static File file = new File("a.csv");
	
	public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	primaryStage.setTitle("Chase the Button!");
    	newData.CSVUtilities(file);
    	
    	newData.printData();
    	
        
        Text t = new Text();
        t.setFont(new Font(15));
        t.setText("Score:" + newData.score);
        t.setX(width-width*0.4);
        t.setY(length-length*0.9);
        
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("");
        dialog.setHeaderText("Welcome to Chase the Button! After entering your name the game will begin.");
        dialog.setContentText("Please enter your name:");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent())
        {
            newData.name = result.get();
        }

        
        Button btn = new Button();
        btn.setText("Click me!");
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	
 
            @Override
            public void handle(ActionEvent event) {
            	
            	movePosition(btn);
            	newData.score++;
            	t.setText("Score: " + newData.score);
            }
        });
        
        Pane root = new Pane();
        root.getChildren().add(btn);
        root.getChildren().add(t);
        //root.getChildren().add(dialog);
        primaryStage.setScene(new Scene(root, width, length));
        primaryStage.show();
 
        
        initializeTimer(btn);
        //newData.printData();
        //writeCSV(file);
        //System.out.println(num);
    }
    
	public static void initializeTimer(Button btn)
	{
		Timer x = new Timer();
		
		x.schedule(new TimerTask() {
			  @Override
			  public void run() {
				 btn.setVisible(false);
				 newData.writeCSV(file);
				 newData.printData();
			  }
			}, 10*1000);
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