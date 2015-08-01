package net.trustie.test.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.selector.Html;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yiang on 2015/3/19.
 */
public class GdgsJyycList implements AfterExtractor {

    // store the list of extract
    List<JyycList> gdgsJyycLists;

    @Override
    public void afterProcess(Page page) {
        // 解码源页面
        String rawText=decodeUnicode(page.getRawText());

        // 解析数据  使用Fastjson@alibaba
        JSONObject jsonObj = JSON.parseObject(rawText);
        JSONArray result = jsonObj.getJSONArray("selList");
        gdgsJyycLists= JSON.parseArray(result.toJSONString(),JyycList.class);
    }

    public List<JyycList> getGdgsJyycLists() {
        return gdgsJyycLists;
    }

    public void setGdgsJyycLists(List<JyycList> gdgsJyycLists) {
        this.gdgsJyycLists = gdgsJyycLists;
    }

    // 解码 Unicode \\uXXXX
    public static String decodeUnicode(String str) {
        Charset set = Charset.forName("UTF-16");
        Pattern p = Pattern.compile("\\\\u([0-9a-fA-F]{4})");
        Matcher m = p.matcher( str );
        int start = 0 ;
        int start2 = 0 ;
        StringBuffer sb = new StringBuffer();
        while( m.find( start ) ) {
            start2 = m.start() ;
            if( start2 > start ){
                String seg = str.substring(start, start2) ;
                sb.append( seg );
            }
            String code = m.group( 1 );
            int i = Integer.valueOf( code , 16 );
            byte[] bb = new byte[ 4 ] ;
            bb[ 0 ] = (byte) ((i >> 8) & 0xFF );
            bb[ 1 ] = (byte) ( i & 0xFF ) ;
            ByteBuffer b = ByteBuffer.wrap(bb);
            sb.append( String.valueOf( set.decode(b) ).trim() );
            start = m.end() ;
        }
        start2 = str.length() ;
        if( start2 > start ){
            String seg = str.substring(start, start2) ;
            sb.append( seg );
        }
        return sb.toString() ;
    }
}
