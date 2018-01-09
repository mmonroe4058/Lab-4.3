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
	
	public static void initializeTimer(Button btn)
	{
		Timer x = new Timer();
		
		x.schedule(new TimerTask() {
			  @Override
			  public void run() {
				 btn.setVisible(false);
			  }
			}, 10*1000);
	}
	
	
	public static void timer()
	{
		
		
	}

}
