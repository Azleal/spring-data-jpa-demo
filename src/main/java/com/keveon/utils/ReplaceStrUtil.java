package com.keveon.utils;

import lombok.experimental.UtilityClass;

/**
 * Created by Keveon on 2017/2/18.
 * 身份证替换指定位置字符串
 */
@UtilityClass
public class ReplaceStrUtil {
    public static String replace(String StrPara) throws Exception {
        StringBuilder stringBuffer = new StringBuilder(StrPara);
        stringBuffer.replace(10, 14, "****");
        return stringBuffer.toString();
    }
}
