package designchallenge1;

import java.util.List;

public abstract class EventWriter {
	protected List<CalendarEvent> calendarEvents;
	
	public void writeEvents(List<CalendarEvent> calendarEvents) {
		this.calendarEvents = calendarEvents;
		setOutput();
	}
	
	protected abstract void setOutput();
}
