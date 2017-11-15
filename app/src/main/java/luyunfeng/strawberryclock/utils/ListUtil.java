package luyunfeng.strawberryclock.utils;

import com.wannar.base_library.text.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by luyunfeng on 16/7/28.
 */
public class ListUtil {

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    public static ArrayList<Integer> copy0(List<Integer> source) {
        ArrayList<Integer> tempList = new ArrayList<>(Arrays.asList(new Integer[source.size()]));
        Collections.copy(tempList, source);
        return tempList;
    }

    public static ArrayList<String> copy1(List<String> source) {
        if (source == null){
            return null;
        }
        ArrayList<String> tempList = new ArrayList<>(Arrays.asList(new String[source.size()]));
        Collections.copy(tempList, source);
        return tempList;
    }

    public static <T> ArrayList<T> copy(List<T> source, T[] array) {
        ArrayList<T> tempList = new ArrayList<>(Arrays.asList(array));
        Collections.copy(tempList, source);
        return tempList;
    }

    public static List<String> split(String regularExpression, String str) {
        List<String> list = null;
        if (!StringUtils.isEmpty(str)) {
            String[] array= str.split(regularExpression, -1);
            if (array.length != 0){
                list = new ArrayList<>(array.length);
                Collections.addAll(list, array);
            }
        }
        if (list == null) {
            return Collections.emptyList();
        } else {
            return list;
        }
    }

    public static String join(String delimiter, String... strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean firstTime = true;
        for (String s : strings) {
            if (firstTime) {
                firstTime = false;
            } else {
                sb.append(delimiter);
            }
            if (StringUtils.isEmpty(s)) {
                sb.append("");
            } else {
                sb.append(s);
            }
        }
        return sb.toString();
    }

    public static String join(String delimiter, List<String> strings) {
        if (ListUtil.isEmpty(strings)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean firstTime = true;
        for (String s : strings) {
            if (firstTime) {
                firstTime = false;
            } else {
                sb.append(delimiter);
            }
            if (StringUtils.isEmpty(s)) {
                sb.append("");
            } else {
                sb.append(s);
            }
        }
        return sb.toString();
    }


    public static void join(StringBuilder sb, String delimiter, String... strings) {

        boolean firstTime = true;
        for (String str : strings) {
            if (firstTime) {
                firstTime = false;
            } else {
                sb.append(delimiter);
            }

            if (StringUtils.isEmpty(str)) {
                sb.append("");
            } else {
                sb.append(str);
            }
        }
    }

    public static <T> List<T> clear(List<T> list) {
        if (list == null) return new ArrayList<>();
        list.clear();
        return list;
    }

    public static boolean contains(List list, Object object) {
        return list != null && list.contains(object);
    }

}
