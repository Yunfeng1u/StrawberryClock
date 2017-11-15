package com.wannar.base_library.text;

import android.support.annotation.StringRes;
import android.text.TextUtils;

import com.wannar.base_library.log.Log;
import com.wannar.base_library.resource.ResourceHelper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import taobe.tec.jcc.JChineseConvertor;

/**
 * Created by luyunfeng on 17/8/21.
 * 基础实用类 - 处理文本相关操作
 */

public class StringUtils {

    /**
     * 判断是否字符串无效
     *
     * @param src
     * @return
     */
    public static boolean isEmpty(String src) {
        return TextUtils.isEmpty(src) || src.equalsIgnoreCase("null");
    }

    /**
     * 判断是否字符串有效
     *
     * @param src
     * @return
     */
    public static boolean isValid(String src) {
        return !isEmpty(src);
    }

    /**
     * 字符串escape操作
     *
     * @param src
     * @return
     */
    public static String escape(String src) {
        if (TextUtils.isEmpty(src)) {
            return "";
        }
        StringBuilder tmp = new StringBuilder(src.length() * 6);
        for (int i = 0; i < src.length(); i++) {
            char ch = src.charAt(i);
            if (Character.isDigit(ch)
                    || Character.isLowerCase(ch)
                    || Character.isUpperCase(ch)) {
                tmp.append(ch);
            } else if (ch < 256) {
                tmp.append('%');
                if (ch < 16)
                    tmp.append('0');
                tmp.append(Integer.toString(ch, 16));
            } else {
                tmp.append("%u");
                tmp.append(Integer.toString(ch, 16));
            }
        }
        return tmp.toString();
    }

    /**
     * 字符串unescape操作
     *
     * @param src
     * @return
     */
    public static String unescape(String src) {

        if (TextUtils.isEmpty(src)) {
            return "";
        }

        StringBuilder tmp = new StringBuilder(src.length());
        int lastPos = 0, pos;
        while (lastPos < src.length()) {
            pos = src.indexOf("%", lastPos);
            if (pos == lastPos) {
                if (src.charAt(pos + 1) == 'u') {
                    String value = src.substring(pos + 2, pos + 6);
                    char c = src.charAt(pos + 2);
                    // 汉字
                    if (isChinese(c)) {
                        tmp.append(value);
                    } else {
                        tmp.append((char) Integer.parseInt(value, 16));
                    }
                    lastPos = pos + 6;
                } else {
                    String value = src.substring(pos + 1, pos + 3);
                    try {
                        tmp.append((char) Integer.parseInt(value, 16));
                    } catch (Exception e) {
                        tmp.append('%').append(value);
                    }

                    lastPos = pos + 3;
                }
            } else {
                if (pos == -1) {
                    tmp.append(src.substring(lastPos));
                    lastPos = src.length();
                } else {
                    tmp.append(src.substring(lastPos, pos));
                    lastPos = pos;
                }
            }
        }
        return tmp.toString();
    }

    /**
     * 清除Html格式
     *
     * @param content
     * @return
     */
    public static String stripHtml(String content) {

        if (TextUtils.isEmpty(content)) {
            return "";
        }

        // <p>段落替换为换行
        content = content.replaceAll("<p .*?>", "\r\n");

        // <br><br/>替换为换行
        content = content.replaceAll("<br\\s*/?>", "\r\n");

        // 去掉其它的<>之间的东西
        content = content.replaceAll("<.*?>", "");

        content = content.replace("&amp;", "&");

        content = content.replace("&nbsp;", " ");

        return content;
    }

    /**
     * 解析Unicode编码格式
     *
     * @param source
     * @return
     */
    public static String parseUnicode(String source) {
        StringBuilder sb = new StringBuilder();
        int i;
        int pos = 0;

        while ((i = source.indexOf("\\u", pos)) != -1) {
            sb.append(source.substring(pos, i));
            if (i + 5 < source.length()) {
                pos = i + 6;
                sb.append((char) Integer.parseInt(source.substring(i + 2, i + 6), 16));
            }
        }
        return sb.toString();
    }

    /**
     * 检查邮箱格式
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        if (isEmpty(email)) return false;
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * 字符串模板
     *
     * @param stringId
     * @param count
     * @return
     */
    public static String messageFormat(@StringRes int stringId, int count) {
        String fmt = ResourceHelper.getString(stringId);
        return MessageFormat.format(fmt, count);
    }

    public static String format(@StringRes int stringId, Object... args) {
        if (args == null) {
            return "";
        }
        return format(ResourceHelper.getString(stringId), args);
    }

    public static String format(String holder, Object... args) {
        if (args == null) {
            return "";
        }
        return String.format(holder, args);
    }

    /**
     * 截取之间的字符串
     *
     * @param str
     * @param open
     * @param close
     * @return
     */
    public static String substringBetween(final String str, final String open, final String close) {
        if (str == null || open == null || close == null) {
            return null;
        }
        final int start = str.indexOf(open);
        if (start != -1) {
            final int end = str.indexOf(close, start + open.length());
            if (end != -1) {
                return str.substring(start + open.length(), end);
            }
        }
        return null;
    }

    /**
     * 简体中文转换成繁体中文
     *
     * @param changeString
     * @return
     */
    public static String toTraditional(String changeString) {
        try {
            changeString = JChineseConvertor.getInstance().s2t(changeString);
        } catch (IOException e) {
            Log.printStackTrace(e);
        }
        return changeString;
    }

    /**
     * 获取最优字符串
     *
     * @param priorityValue  首选值
     * @param alternateValue 备选值
     * @param defaultValue   补选值
     * @return
     */
    public static String getString(String priorityValue, String alternateValue, String defaultValue) {
        if (!TextUtils.isEmpty(priorityValue)) {
            return priorityValue;
        } else {
            if (!TextUtils.isEmpty(alternateValue)) {
                return alternateValue;
            } else {
                if (!TextUtils.isEmpty(defaultValue)) {
                    return defaultValue;
                }
            }
        }
        return "";
    }

    public static String getString(String value, String fallback) {
        return getString(value, fallback, fallback);
    }

    public static String getString(String value, @StringRes int fallbackRes) {
        if (isValid(value)) {
            return value;
        } else {
            return ResourceHelper.getString(fallbackRes);
        }
    }

    /**
     * 生成多个相同字符串
     *
     * @param str
     * @param count
     * @return
     */
    public static String repeat(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * 判断是否含有中文字符
     *
     * @param value
     * @return
     */
    public static boolean containsChinese(String value) {

        if (value == null) return false;

        for (int i = 0; i < value.length(); i++) {
            if (isChinese(value.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符是否在中文范围
     *
     * @param ch
     * @return
     */
    public static boolean isChinese(char ch) {
        return ch >= 0x4E00 && ch <= 0x9FA5;
    }

    /**
     * 获取UTF-8编码格式
     *
     * @return
     */
    public static Charset getUTF8Charset() {
        return Charset.forName("UTF-8");
    }

    public static byte[] toBytes(String str) {
        if (str == null) return null;
        return str.getBytes(getUTF8Charset());
    }

    public static String toString(byte[] bytes) {
        if (bytes == null) return null;
        return new String(bytes, getUTF8Charset());
    }

    public static void deleteLastChar(StringBuilder sb) {
        if (sb.length() > 1){
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
