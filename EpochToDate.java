import java.text.ParseException;
import java.util.Calendar;
import java.util.TimeZone;



/**
 *
 */

/**
 * @author egupgha
 *
 */
public class EpochToDate {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long epoch=1138713650;
		int numberOfDays=0;
		try {

			Calendar cal  = Calendar.getInstance();

			cal.set(Calendar.HOUR_OF_DAY,
					Integer.parseInt(new java.text.SimpleDateFormat("HH").format(new java.util.Date (epoch*1000))));
			cal.set(Calendar.MINUTE,
					Integer.parseInt(new java.text.SimpleDateFormat("mm").format(new java.util.Date (epoch*1000))));
			cal.set(Calendar.SECOND,
					Integer.parseInt(new java.text.SimpleDateFormat("ss").format(new java.util.Date (epoch*1000))));




			String createDayDate = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").
					format(new java.util.Date (epoch*1000));
			System.out.println("Create Date:"+createDayDate);

			String createDay = new java.text.SimpleDateFormat("dd").
					format(new java.util.Date (epoch*1000));

			int migDay=cal.get(Calendar.DAY_OF_MONTH);
			cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(createDay));

			if (migDay<Integer.parseInt(createDay))
				cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1);

			cal.add(Calendar.DAY_OF_MONTH, numberOfDays);

			System.out.println("Cal:"+cal);
			System.out.println("Date:"+cal.get(Calendar.DAY_OF_MONTH)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.YEAR));

			java.util.Date date1 = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/01/1970 01:00:00");
			java.util.Date date2 = new java.util.Date(cal.getTimeInMillis());
			System.out.println((date2.getTime() - date1.getTime())/(24 * 60 * 60 * 1000));


} catch (NumberFormatException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


	}

}
