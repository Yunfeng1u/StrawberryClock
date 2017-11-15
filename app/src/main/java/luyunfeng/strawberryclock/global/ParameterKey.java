package luyunfeng.strawberryclock.global;

/**
 * 参数key配置项（谨慎修改）
 *
 * @author luyunfeng
 * @date 16/6/28
 */
public interface ParameterKey {

    String IS_TEST = "isTest";

    String SIGN = "sign";

    String RESPONSE_ERROR_CODE = "RESPONSE_ERROR_CODE";
    String RESPONSE_ERROR_MSG = "RESPONSE_ERROR_MSG";

    //时间
    String CURRENT_TIME = "time";
    String SHARE_COUNT = "share_count";

    // 用户
    String USER_NAME = "user_name";
    String USER_ID = "user_id";
    String USER_EMAIL = "uemail";
    String USER_PASSWORD = "upassword";
    String WEIBO_CONNECTED = "weibo_connected";
    String WECHAT_CONNECTED = "wechat_connected";
    String QQ_CONNECTED = "qq_connected";
    String RECENT_SOCIAL = "recent_social";
    String CITY_ID = "city_id";
    String CURRENT_CITY_CN = "current_city";
    String CURRENT_CURRENCY = "CURRENT_CURRENCY";
    String LANG = "LANG";
    String IS_C = "is_c";
    String IS_KM = "is_km";
    String DEFAULT_EMAIL_KEY = "DEFAULT_EMAIL_KEY";
    String DEFAULT_PHONE_NUMBER = "DEFAULT_PHONE_NUMBER";
    String DEFAULT_PHONE_AREA = "DEFAULT_PHONE_AREA";
    String HOTEL_STAY_TIME = "HOTEL_STAY_TIME";

    // 行程规划
    String SHOP_CART_ID = "SHOP_CART_ID";
    String SHOP_CART_PLAN_ID = "SHOP_CART_PLAN_ID";
    String SHOP_CART_PLAN_DETAIL_ID = "SHOP_CART_PLAN_DETAIL_ID";
    String WATCHING_PLAN = "watching_plan";
    String CURRENT_DAY = "current_day";
    String DELETE_DAY_ALERT = "delete_day_alert";
    String PLAN_ID = "plan_id";
    String PLAN_UUID = "uuid";
    String PLAN_ID_ON_LINE = "plan_id_on_line";
    String ORDER_ID = "order_id";
    String IS_NEW_ORDER = "IS_NEW_ORDER";
    String SHOPCART_ID = "shopcart_id";
    String TOTAL_PERSON_NUM = "total_person_num";
    String PERSONAL_INFO = "personal_info";
    String PICKUP_LOCATIONS = "pickupLocations";
    String FLIGHT_INFO = "flight_info";
    String IS_DATA_LEGAL = "is_data_legal";
    String CREDIT_CARD = "CREIDT_CARD";


    // 基础项目
    String SCENIC_ID = "scenic_id";
    String YELP_ID = "yelp_id";
    String TOUR_ID = "tour_id";
    String NOTE_ID = "noteId";


    // 租车
    String CAR_HELPER = "CAR_HELPER";
    String IS_DESTINATION = "is_destination";
    String AIRPORT_DESTINATION_NAME = "airport_destination_name";
    String AIRPORT_DESTINATION_CODE = "airport_destination_code";
    String CAR_PRODUCT_ID = "car_product_ID";
    String PICK_UP_STATION_ID = "PICK_UP_STATION_ID";
    String DROP_OFF_STATION_ID = "DROP_OFF_STATION_ID";

    String SCENIC_SEARCH_HISTORY = "SCENIC_SEARCH_HISTORY";
    String TOUR_SEARCH_HISTORY = "TOUR_SEARCH_HISTORY";
    String HOTEL_SEARCH_HISTORY = "HOTEL_SEARCH_HISTORY";

    // hotelbeds
    String HOTEL_CODE = "ids";
    String HOLDER = "holder";
    String PAXES = "paxes";


    String HB_HELPER = "HB_HELPER";

    String CHECK_IN = "checkIn";
    String CHECK_OUT = "checkOut";
    String OCCUPANCY = "occupancy";


    String SELECTED_DEPARTURE_KEY = "SELECTED_DEPARTURE_KEY";

    //更新
    String IGNORE_VERSION = "ignore_version";
    String DOWNLOAD_APK_NAME = "DOWNLOAD_APK_NAME";

    // 列表参数
    String FACETS = "facets";
    String QUERY = "query";
    String SORT = "sort";
    String OFFSET = "offset";
    String LIMIT = "limit";
    String FIELDS = "fields";

}
