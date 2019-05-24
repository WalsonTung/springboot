package com.zhengzhaoxi.webdemo.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public final class DateUtils {
    
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_STAMP_FORMAT = "yyyyMMddHHmmss";
    
    public static Date now(){
        return new Date();
    }
    
    
    public static int getIntervalDays(Date date1,Date date2){
    	if (null == date1 || null == date2) {
            return -1;
        }

        long intervalMilli = date1.getTime() - date2.getTime();

        return (int) (intervalMilli / (24 * 60 * 60 * 1000));
    }
    
    public static int getIntervalSecond(Date date1,Date date2){
    	if (null == date1 || null == date2) {
            return -1;
        }

        long intervalMilli = date1.getTime() - date2.getTime();
        return (int)intervalMilli/1000;
    }
    
    public static Date getMinDate(){
        Calendar calendar = Calendar.getInstance();  
        calendar.set(1900,0,1);
       return calendar.getTime();
    }
    
    public static Date parse(String date){
    	
    	return parse(date,DATETIME_FORMAT);
    }
    
    public static Date parseDate(String date){
    	return parse(date,DATE_FORMAT);
    }
    
    public static Date parse(String date,String pattern) {
    	if(StringUtils.isNullOrEmpty(date)){
    		return null;
    	}
    	
    	SimpleDateFormat dFormat = new SimpleDateFormat(pattern);
    	try{
    		return dFormat.parse(date);
    	}catch(Exception ex){
    		ex.printStackTrace();
    		return null;
    	}
    }
    
    public static String toString(Date date, String pattern){
    	SimpleDateFormat dFormat = new SimpleDateFormat(pattern);
    	return dFormat.format(date);
    }
    
    public static String toDateString(Date date){
    	return toString(date,DATE_FORMAT);
    }
    
    public static String toDateTimeString(Date date){
    	return toString(date, DATETIME_FORMAT);
    }
    
    public static String toTimeStampString(Date date){
        return toString(date, TIME_STAMP_FORMAT);
    }
    
	public static boolean isWithinWeek(Date addtime){
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(now());
		calendar.add(Calendar.DAY_OF_MONTH, -7);  
		Date before7days = calendar.getTime();   
		if(before7days.getTime() < addtime.getTime()){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isWithinDay(Date addtime){
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(now());
		calendar.add(Calendar.DAY_OF_MONTH, -1);  
		Date before1days = calendar.getTime();   
		if(before1days.getTime() < addtime.getTime()){
			return true;
		}else{
			return false;
		}
	}

}
