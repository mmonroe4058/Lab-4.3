import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Timer;
import java.util.TimerTask;

public class BackEnd
{
	private final int seconds = 10;
	
	public static void initializeGame()
	{
		Timer x = new Timer();
		
	}
	
	public static void movePosition(Button btn)
	{
		btn.setTranslateX((int)Math.random()*200);
		btn.setTranslateY((int)Math.random()*200);
	}
	
	public static void timer()
	{
		TimerTask task = new TimerTask();
		
		 @Override
	        public void run() { 
	            if (seconds < MAX_SECONDS) {
	                System.out.println("Seconds = " + seconds);
	                seconds++;
	            } else {
	                // stop the timer
	                cancel();
	            }
	        }
	}

}
