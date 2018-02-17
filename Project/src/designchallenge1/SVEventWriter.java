package designchallenge1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public abstract class SVEventWriter extends EventWriter{
	protected String filename;
	protected String separator;
	protected String data;
	protected int dateIndex;
	protected int nameIndex;
	protected int colorIndex;
	protected boolean repeating;
	
	public SVEventWriter(String filename) {
		this.filename = filename;
	}
	
	@Override
	protected void setOutput() {
		FileReader fr;
		BufferedReader br;
		
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			
			for(CalendarEvent event : calendarEvents) {
				data = data + event.getName();
				data = data + event.getColor();
				data = data + event.getDate();
				data = data + String.valueOf(event.isRepeating());
			}
				
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
