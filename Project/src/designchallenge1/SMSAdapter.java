package designchallenge1;

import java.util.Calendar;
import java.util.GregorianCalendar;

import sms.SMS;
import sms.SMSView;

public class SMSAdapter implements CalendarObserver {
	private SMSView view;
	
	public SMSAdapter(SMSView view) {
		this.view = view;
	}
	
	@Override
	public void update(CalendarModel model) {
		Calendar today = GregorianCalendar.getInstance();
		for (CalendarEvent evt : model.getEventsAt(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
				today.get(Calendar.DAY_OF_MONTH))) {
			SMS sms = new SMS(evt.getName(), evt.getDate(), evt.getColor().toColor());
			view.sendSMS(sms);
		}
	}
}
