package designchallenge1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarModel {
	private List<CalendarEvent> events;
	private List<CalendarObserver> observers;
	private CalendarProgram view;
	
	public CalendarModel(CalendarProgram view) {
		events = new ArrayList<CalendarEvent>();
		observers = new ArrayList<CalendarObserver>();
		this.view = view;
	}
	
	public void initEvents() {
		EventReader er = new CSVEventReader("res/Philippine Holidays.csv");
		this.addEvents(er.readEvents());
		er = new PSVEventReader("res/DLSU Unicalendar.psv");
		this.addEvents(er.readEvents());
	}
	
	public void addEvent(CalendarEvent evt) {
		events.add(evt);
		updateAll();
	}
	
	public void addEvents(List<CalendarEvent> evts) {
		events.addAll(evts);
		updateAll();
	}
	
	public void attach(CalendarObserver obs) {
		observers.add(obs);
		obs.update();
	}
	
	public void updateAll() {
		if (view!=null)
			view.refreshCurrentPage();
		for (CalendarObserver co : observers) {
			co.update();
		}
	}
	
	public List<CalendarEvent> getEventsAt(int year, int month, int dayOfMonth){
		Calendar cal = new Calendar.Builder().setDate(year, month, dayOfMonth).build();
		List<CalendarEvent> evts = new ArrayList<CalendarEvent>();
		for (CalendarEvent ce : events) {
			if (year>=ce.getDate().get(Calendar.YEAR) &&
				(ce.getDate().get(Calendar.YEAR)==year ||
				ce.isRepeating()) &&
				ce.getDate().get(Calendar.MONTH)==month &&
				ce.getDate().get(Calendar.DAY_OF_MONTH)==dayOfMonth)
				evts.add(ce);
		}
		return evts;
	}
	
	//debug method
	public void printEvents() {
		for (CalendarEvent ce : events) {
			System.out.println(ce);
		}
	}
	
	//debug method
	public void outputEvents() {
		EventWriter ew = new CSVEventWriter("res/Philippine Holidays2.csv");
		ew.writeEvents(events);
		ew = new PSVEventWriter("res/DLSU Unicalendar2.psv");
		ew.writeEvents(events);
	}
}
