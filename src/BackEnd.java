import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.text.*;

public class BackEnd
{
	private final int seconds = 10;
	ArrayList<String> CSVData = new ArrayList<String>();
	int numColumns = 0;
	int numRows = 0;
	int score = 0;
	String name = "";
	
	
	public void CSVUtilities(File csv)
	{
			FileReader reader = null;
			BufferedReader filein = null;
			try
			{
				reader = new FileReader(csv);
				filein = new BufferedReader(reader);
				try
				{
					String line = filein.readLine();
					
						while (line != null)
						{ 						
							String[] attributes = line.split(",");
							numColumns = attributes.length;
							for(int x = 0; x < numColumns; x++ )
							{
								CSVData.add(attributes[x]);
							}
							numRows++;
							line = filein.readLine(); 
						}
				}
				
				catch (IOException ioe)
				{
		            ioe.printStackTrace();
		        }	
			}

		catch (FileNotFoundException fnfe)
		{
			System.out.println("ERROR: File not found!");
		}

	}
	
	public void writeCSV(File file)
	{
		PrintWriter pw = null;
		try
		{
			pw = new PrintWriter(file);
		}
		catch(FileNotFoundException e)
		{
			System.err.println(e);
		}
		StringBuilder sb = new StringBuilder();
		
		/*
		sb.append("Name");
        sb.append(',');
        sb.append("High Score");
        sb.append('\n');
        */
        
        
        sb.append(name);
        sb.append(',');
        sb.append(score);
        sb.append('\n');
        
        pw.write(sb.toString());
        pw.close();
        //System.out.println("done!");
	}
	
	public void printData()
	{
		int y = this.numColumns;
		int z = this.numRows;
		int a = 0;
		int b = y * z;
		while(a < b)
		{
			for(int i = 0; i < y; i++)
			{	
				System.out.print(this.CSVData.get(a) + "  ");
				a++;
			}
			System.out.println();
			
		}
	}
}
