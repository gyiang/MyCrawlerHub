package net.trustie.task.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yiang on 2014/7/22.
 */
public class StringUtils {

    public static List<Long> getDigit(String text) {
        List<Long> digitList = new ArrayList<Long>();
        Pattern p = Pattern.compile("(\\d+)");
        Matcher m = p.matcher(text);
        while (m.find()) {
            String find = m.group(1).toString();
            digitList.add(Long.valueOf(find));
        }
        return digitList;
    }


    public static String getNumber(String text) {
        Pattern p = Pattern.compile("(\\d+)");
        Matcher m = p.matcher(text);
        if (m.find())
            return m.group(1).toString();
        else
            return "0";
    }



}
