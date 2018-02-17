package designchallenge1;

import java.util.ArrayList;
import java.util.List;

public class CalendarModel {
	private List<CalendarEvent> events;
	private List<CalendarObserver> views;
	
	public CalendarModel() {
		events = new ArrayList<CalendarEvent>();
		views = new ArrayList<CalendarObserver>();
	}
	
	public void addEvent(CalendarEvent evt) {
		events.add(evt);
	}
	
	public void addEvents(List<CalendarEvent> evts) {
		events.addAll(evts);
	}
	
	public void attach(CalendarObserver n) {
		views.add(n);
	}
	
	//debug method
	public void printEvents() {
		for (CalendarEvent ce : events) {
			System.out.println(ce);
		}
	}
}
