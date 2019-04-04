package pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Calender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("mm/d/yyyy");
		
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		

	}

}
