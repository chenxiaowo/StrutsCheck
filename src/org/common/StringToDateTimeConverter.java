package org.common;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.struts2.util.StrutsTypeConverter;



import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

    public class StringToDateTimeConverter extends StrutsTypeConverter{

        public Object convertFromString(Map context, String[] strings, Class toClass) {     

    		Date date = null;
    		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
    		try {
				date = df2.parse(strings[0]);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sdate = new java.sql.Date(date.getTime());
			return sdate;
        }

        public String convertToString(Map context, Object date) {
            DateFormat DATETIME_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
            if (date != null && date instanceof Date) {
                return DATETIME_FORMAT.format(date);
            } else {
                return null;
            }
        }
    }