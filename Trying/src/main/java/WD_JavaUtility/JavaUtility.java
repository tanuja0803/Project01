package WD_JavaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int generateRandomNumber() {
		Random ran=new Random();
		int limit=ran.nextInt(1000);
		
		return limit;
	}
	public String getSystemDate() {
		//Date date=new Date();
		Date date=new Date();
		System.out.println(date);
		String todaysDate=String.valueOf(date);
		todaysDate=todaysDate.replace(' ', '_').replace(':', '_');
		return todaysDate;
	}
	
	public String getSystemDateInFormat() {
		Date date=new Date();
		SimpleDateFormat sDate=new SimpleDateFormat("yyyy-mm-dd");
		String newDate=sDate.format(date);
		
		return newDate;
	}
	
	public String generateDateBasedOnSpecification(int diff,String basedOn) {
		Date d=new Date();
		SimpleDateFormat sDate=new SimpleDateFormat("dd-MM-yyyy");
		String date=sDate.format(d);
		System.out.println("Simple Date Format:"+date);
		Calendar cal=sDate.getCalendar();
		
		if(basedOn.equalsIgnoreCase("month"))
			cal.add(Calendar.DAY_OF_MONTH, diff);
		else if(basedOn.equalsIgnoreCase("days"))
			cal.add(cal.DAY_OF_WEEK, diff);
		else if(basedOn.equalsIgnoreCase("Year"))
			cal.add(cal.DAY_OF_YEAR, diff);
		
		String dateReq=sDate.format(cal.getTime());
		
		return dateReq;
	}
}
