package com.tazine.base.enumerate;

/**
 * 星期枚举
 *
 * @author 李扬
 * @since 1.0.0
 */
public enum DaysEnum {

    MONDAY(1, "星期一", "mon"),
    TUESDAY(2, "星期二", "tue"),
    WEDNESDAY(3, "星期三", "wed"),
    THURSDAY(4, "星期四", "thu"),
    FRIDAY(5, "星期五", "fri"),
    SATURDAY(6, "星期六", "sat"),
    SUNDAY(7, "星期日", "sun");

    private int id;
    private String desc;
    private String matchKey;

    /**
     * 枚举常量在创建时，会自动调用构造方法
     * @param id
     * @param desc
     * @param matchKey
     */
    DaysEnum(int id, String desc, String matchKey) {
        this.id = id;
        this.desc = desc;
        this.matchKey = matchKey;
    }

    public int getId() {
        return this.id;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getMatchKey() {
        return this.matchKey;
    }

    public static int[] getAllIds() {
        DaysEnum[] optionArr = DaysEnum.values();
        int[] ids = new int[optionArr.length];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = optionArr[i].getId();
        }
        return ids;
    }

    public static DaysEnum getOptionByKey(String key) {
        DaysEnum[] optionArr = DaysEnum.values();
        for (DaysEnum i : optionArr) {
            if (i.getMatchKey().equals(key)) {
                return i;
            }
        }
        return null;
    }

    public static DaysEnum getOptionById(int id) {
        DaysEnum[] optionArr = DaysEnum.values();
        for (DaysEnum i : optionArr) {
            if (i.getId() == id) {
                System.out.println(i.getId() + " " + i.getDesc() + " " + i.getMatchKey());
                return i;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        getOptionById(2);
    }
}