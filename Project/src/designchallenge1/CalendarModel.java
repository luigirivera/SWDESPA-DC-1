package designchallenge1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class CalendarModel {
	private List<CalendarEvent> events;
	private List<CalendarObserver> observers;
	private CalendarProgram view;
	private Timer timer;
	
	public CalendarModel(CalendarProgram view) {
		events = new ArrayList<CalendarEvent>();
		observers = new ArrayList<CalendarObserver>();
		this.view = view;
		timer = new Timer();
	}
	
	public void initEvents() {
		EventReader er = new CSVEventReader("res/Philippine Holidays.csv");
		this.addEvents(er.readEvents());
		er = new PSVEventReader("res/DLSU Unicalendar.psv");
		this.addEvents(er.readEvents());
	}
	
	public void addEvent(CalendarEvent evt) {
		events.add(evt);
		scheduleEventNotification(evt);
		updateView();
	}
	
	public void addEvents(List<CalendarEvent> evts) {
		events.addAll(evts);
		for(CalendarEvent evt : evts) {
			scheduleEventNotification(evt);
		}
		updateView();
	}
	
	public void attach(CalendarObserver obs) {
		observers.add(obs);
	}
	
	public void updateView() {
		if (view!=null)
			view.refreshCurrentPage();
	}
	
	public void updateObservers(CalendarEvent evt) {
		for (CalendarObserver co : observers) {
			co.update(evt);
		}
	}
	
	public void scheduleEventNotification(CalendarEvent evt) {
		if (evt.getDate().after(Calendar.getInstance())) {
			if(evt.isRepeating()) {
				timer.scheduleAtFixedRate(new TimerTask() {
					public void run() {
						updateObservers(evt);
					}
				}, evt.getDate().getTime(), TimeUnit.DAYS.toMillis(365));
			}else {
				timer.schedule(new TimerTask() {
					public void run() {
						updateObservers(evt);
					}
				}, evt.getDate().getTime());
			}
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
