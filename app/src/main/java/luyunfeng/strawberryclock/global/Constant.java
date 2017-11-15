package luyunfeng.strawberryclock.global;


/**
 * 全局常量存放类
 */
public class Constant {

    // 【切记发版前都设false】
    private static boolean isTestMode = false;              // 是否测试模式
    final public static boolean isLocalDebug = false;       // 本地调试
    public static boolean isLogResponse = false;
    public static boolean isLogRequest = false;

    //分享积分次数
    final public static int CREDIT_COUNT = 10;

    // 默认数据配置项
    final public static int DEFAULT_CITY_ID = 46;
    final public static String DEFAULT_CITY_CN = "纽约";
    final public static int DEFAULT_FACET_LIMIT = 2000;
    final public static int DEFAULT_DATA_LIMIT = 50;
    final public static String DEFAULT_CURRENCY = "USD";

    public static final int NULL_VALUE = -10086;

    final public static String BLANK4 = "    ";
    final public static String PLACE_HOLDER = "%s";
    final public static String PLACE_HOLDER_I = "%1$d";
    final public static String PLACE_HOLDER_S = "%1$s";

}
