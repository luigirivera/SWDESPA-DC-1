package designchallenge1;

import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;

import facebook.FBView;

public class FBAdapter implements CalendarObserver {
	private FBView view;

	public FBAdapter(FBView view) {
		this.view = view;
	}

	@Override
	public void update(CalendarModel model) {
		Calendar today = GregorianCalendar.getInstance();
		for (CalendarEvent evt : model.getEventsAt(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
				today.get(Calendar.DAY_OF_MONTH))) {
			view.showNewEvent(evt.getName(), evt.getDate().get(Calendar.MONTH)+1,
					evt.getDate().get(Calendar.DAY_OF_MONTH), evt.getDate().get(Calendar.YEAR),
					evt.getColor().toColor());
		}
	}

}
