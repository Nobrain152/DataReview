package util;

import java.util.Calendar;

/**
 * 获取当前日期
 * @author txin15
 *
 */
public class Today {
	
	String today;
	
	public String getToday() {
		
		Calendar calendar = Calendar.getInstance();
		today = calendar.getTime().toString();
		
		String year = today.substring(24);
		String month = today.substring(4,7);
		if(month.equals("Jan")) {
			month = "01";
		} else if(month.equals("Feb")) {
			month = "02";
		} else if(month.equals("Mar")) {
			month = "03";
		} else if(month.equals("Apr")) {
			month = "04";
		} else if(month.equals("May")) {
			month = "05";
		} else if(month.equals("Jun")) {
			month = "06";
		} else if(month.equals("Jul")) {
			month = "07";
		} else if(month.equals("Aug")) {
			month = "08";
		} else if(month.equals("Sep")) {
			month = "09";
		} else if(month.equals("Oct")) {
			month = "10";
		} else if(month.equals("Nov")) {
			month = "11";
		} else if(month.equals("Dec")) {
			month = "12";
		}
		String day = today.substring(8, 10);
		String time = today.substring(11, 16);
		today = year + "-" + month + "-" + day + " " + time;
		
		return today;
	}

}
