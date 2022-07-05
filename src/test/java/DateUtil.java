import com.hfcsbc.utils.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Liu Chong
 * @DateTime 2022/7/4
 * @Description xxx
 */
public class DateUtil {



    /**
     * string类型转date类型
     */
    public static Date strToDate(String string, String format) {
        if (StringUtil.isEmpty(string)) {
            return null;
        }
        SimpleDateFormat sd = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sd.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
