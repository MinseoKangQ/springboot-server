package com.server.sumnote.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChangeDateFormat {

    public static String doChange(String s) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy.M.d a hh:mm");
        String result =  LocalDateTime.parse(s, inputFormatter).format(outputFormatter);
        return result.replace("오후", "pm").replace("오전", "am");
    }
}
