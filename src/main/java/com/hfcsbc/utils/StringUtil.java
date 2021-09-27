package com.hfcsbc.utils;

import java.util.Random;

/**
 * @Author 刘翀
 * @DateTime 2021/9/17
 * @Description 字符串工具类
 */
public class StringUtil {

    public static final String STRING_EMPTY = "";

    /**
     * 判断是否为空
     */
    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static String getStringSafely(String string) {
        return isEmpty(string) ? STRING_EMPTY : string;
    }

    public static boolean isEmpty(String... stringArr) {
        return stringArr == null || stringArr.length == 0;
    }

    public static String randomStringOnlyNumber(int length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

    public static String findFirstNotEmptyString(String... stringArr) {
        if (isEmpty(stringArr)) {
            return null;
        }
        for (String string : stringArr) {
            if (!isEmpty(string)) {
                return string;
            }
        }
        return null;
    }
}
