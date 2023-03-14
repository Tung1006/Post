package com.cms.test;


import oracle.sql.DATE;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateTime {
    public static void main(String[] args) {
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = localDateFormat.format(System.currentTimeMillis());

        System.out.println(" time" + time);
        Date date = new Date();

        String time1 = localDateFormat.format(date);
        System.out.println(" time" + time1);





    }
}
