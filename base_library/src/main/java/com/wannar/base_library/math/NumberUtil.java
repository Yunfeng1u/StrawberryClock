package com.wannar.base_library.math;

import com.wannar.base_library.text.StringUtils;

/**
 * Created by luyunfeng on 16/11/9.
 * 基础实用类 - 处理数字相关操作
 */
public class NumberUtil {

    public static int parseInt(Object str) {
        return parseInt(str, 0);
    }

    public static int parseInt(Object str, int fallback) {
        if (str == null) {
            return fallback;
        }
        try {
            return Integer.parseInt(str.toString());
        } catch (Exception e) {
            return fallback;
        }
    }

    public static float parseFloat(Object str) {
        return parseFloat(str, 0);
    }

    public static float parseFloat(Object str, float fallback) {
        if (str == null) {
            return fallback;
        }
        try {
            return Float.parseFloat(str.toString());
        } catch (Exception e) {
            return fallback;
        }
    }

    public static double parseDouble(Object str) {
        return parseDouble(str, 0);
    }

    public static double parseDouble(Object str, double fallback) {
        if (str == null) {
            return fallback;
        }
        try {
            return Double.parseDouble(str.toString());
        } catch (Exception e) {
            return fallback;
        }
    }

    public static long parseLong(Object str) {
        return parseLong(str, 0);
    }

    public static long parseLong(Object str, long fallback) {
        if (str == null) {
            return fallback;
        }
        try {
            return Long.parseLong(str.toString());
        } catch (Exception e) {
            return fallback;
        }
    }

    /**
     * 版本比较
     *
     * @param version1 1.2.6
     * @param version2 2.1.3
     * @return
     */
    public static int versionCompare(String version1, String version2) {
        try {

            String[] v1s = version1.split("\\.");
            String[] v2s = version2.split("\\.");

            int length = Math.min(v1s.length, v2s.length);

            for (int i = 0; i < length; i++) {
                int result = v1s[i].compareToIgnoreCase(v2s[i]);
                if (result != 0) return result;
            }

            return v1s.length - v2s.length;

        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 将数字转换成中文表达
     *
     * @param num
     * @return
     */
    public static String number2Chinese(int num) {

        // 单位数组
        String[] units = new String[]{"十", "百", "千", "万", "十", "百", "千", "亿"};

        // 中文大写数字数组
        String[] numeric = new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

        String number = String.valueOf(num);
        String res = "";

        // 遍历一行中所有数字
        for (int k = -1; number.length() > 0; k++) {
            // 解析最后一位
            int j = parseInt(number.substring(number.length() - 1, number.length()));
            String rtemp = numeric[j];

            // 数值不是0且不是个位 或者是万位或者是亿位 则去取单位
            if (j != 0 && k != -1 || k % 8 == 3 || k % 8 == 7) {
                rtemp += units[k % 8];
            }

            // 拼在之前的前面
            res = rtemp + res;

            // 去除最后一位
            number = number.substring(0, number.length() - 1);
        }

        // 去除后面连续的零零..
        while (res.endsWith(numeric[0])) {
            res = res.substring(0, res.lastIndexOf(numeric[0]));
        }

        // 将零零替换成零
        while (res.contains(numeric[0] + numeric[0])) {
            res = res.replaceAll(numeric[0] + numeric[0], numeric[0]);
        }

        // 将 零+某个单位 这样的窜替换成 该单位 去掉单位前面的零
        for (int m = 1; m < units.length; m++) {
            res = res.replaceAll(numeric[0] + units[m], units[m]);
        }

        if (num >= 10 && num <= 19) {
            res = res.substring(1);
        }
        return res;

    }

    /**
     * 判断是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        return !StringUtils.isEmpty(str) && str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
    }
}
