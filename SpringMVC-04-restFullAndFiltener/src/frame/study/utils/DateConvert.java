package frame.study.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by canglang on 2017/5/29.
 * 自定义时间类型转换
 */
public class DateConvert implements Converter<String, Date>{
    @Override
    public Date convert(String source) {

        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return sm.parse(source);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
