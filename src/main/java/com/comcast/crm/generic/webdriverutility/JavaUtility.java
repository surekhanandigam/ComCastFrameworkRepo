package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber()
	{
		Random r=new Random();
		int random=r.nextInt(5000);
		return random;
	}
	
	public String getSystemDateYYYYMMDD()
	{
		Date dateObj=new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(dateObj);
		return date;
	}
	
	public String getRequiredDateYYYYMMDD(int days)
	{
		Date date = new Date();
	    SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	    sim.format(date);
	    Calendar cal=sim.getCalendar();
	    cal.add(Calendar.DAY_OF_MONTH,days);
	    String reqDate=sim.format(cal.getTime());
	    return reqDate;
	}
}
