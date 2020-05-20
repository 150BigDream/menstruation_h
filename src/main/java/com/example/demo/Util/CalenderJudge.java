package com.example.demo.Util;

import java.util.Calendar;
import java.util.Date;

public   class CalenderJudge {
    public int judegeDay(Date date){
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH)+1;
    switch (month) {
        case 1: case 3: case 5:case 7:  case 8:  case 10:  case 12:
            return 31;	        case 4:  case 6: case 9:  case 11:
                return 30; 	        //对于2月份需要判断是否为闰年
     case 2:
         if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
         {
         return 29;
         }
         else
             {
                 return 28;
             }
         default:
             return 0;
    }
    }

}
