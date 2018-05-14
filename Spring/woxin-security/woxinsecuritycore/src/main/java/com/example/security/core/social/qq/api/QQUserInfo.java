package com.example.security.core.social.qq.api;

<<<<<<< HEAD
=======
/**
 * @author: mengchen
 * Create by 18-4-12
 */
>>>>>>> d3084b8c8c024348b672e7b49795c5e5c8b08016
public class QQUserInfo {
    /**
     * 返回码
     */
    private String ret;
    /**
     * 如果ret<0，会有相应的错误信息提示，返回数据全部用UTF-8编码。
     */
    private String msg;
<<<<<<< HEAD

    private String openId;

    /**
     * ？？
     */
    private String is_lost;

    /**
     * 省（直辖市）
     */
    private String province;

    /**
     * 市（直辖市区）
     */
    private String city;

    /**
     * 出身年月
     */
    private String year;


=======
    /**
     *
     */
    private String openId;
    /**
     * 不知道什么东西，文档上没写，但是实际api返回里有。
     */
    private String is_lost;
    /**
     * 省(直辖市)
     */
    private String province;
    /**
     * 市(直辖市区)
     */
    private String city;
    /**
     * 出生年月
     */
    private String year;
>>>>>>> d3084b8c8c024348b672e7b49795c5e5c8b08016
    /**
     * 用户在QQ空间的昵称。
     */
    private String nickname;
    /**
<<<<<<< HEAD
     * 大小为30*30像素的QQ空间的URL
     */
    private String figureurl;

    /**
     * 大小为100×100像素的QQ空间头像URL
     */
    private String figureurl_2;

=======
     * 大小为30×30像素的QQ空间头像URL。
     */
    private String figureurl;
    /**
     * 大小为50×50像素的QQ空间头像URL。
     */
    private String figureurl_1;
    /**
     * 大小为100×100像素的QQ空间头像URL。
     */
    private String figureurl_2;
>>>>>>> d3084b8c8c024348b672e7b49795c5e5c8b08016
    /**
     * 大小为40×40像素的QQ头像URL。
     */
    private String figureurl_qq_1;
<<<<<<< HEAD

    /**
     * 大小为100×100像素的QQ头像URL。需要注意，不是所有的用户都拥有QQ的100x100的头像，但40x40像素则是一定会有。
     */
    private String figureurl_qq_2;

    /**
     * 性别。 如果获取不到则默认返回"男"
     */
    private String gender;

    /**
     * 标识用户是否为黄钻用户（0：不是；1：是）
     */
    private String is_yellow_vip;

=======
    /**
     * 大小为100×100像素的QQ头像URL。需要注意，不是所有的用户都拥有QQ的100×100的头像，但40×40像素则是一定会有。
     */
    private String figureurl_qq_2;
    /**
     * 性别。 如果获取不到则默认返回”男”
     */
    private String gender;
    /**
     * 标识用户是否为黄钻用户（0：不是；1：是）。
     */
    private String is_yellow_vip;
>>>>>>> d3084b8c8c024348b672e7b49795c5e5c8b08016
    /**
     * 标识用户是否为黄钻用户（0：不是；1：是）
     */
    private String vip;
<<<<<<< HEAD

=======
>>>>>>> d3084b8c8c024348b672e7b49795c5e5c8b08016
    /**
     * 黄钻等级
     */
    private String yellow_vip_level;
<<<<<<< HEAD

=======
>>>>>>> d3084b8c8c024348b672e7b49795c5e5c8b08016
    /**
     * 黄钻等级
     */
    private String level;
<<<<<<< HEAD

=======
>>>>>>> d3084b8c8c024348b672e7b49795c5e5c8b08016
    /**
     * 标识是否为年费黄钻用户（0：不是； 1：是）
     */
    private String is_yellow_year_vip;

<<<<<<< HEAD

=======
>>>>>>> d3084b8c8c024348b672e7b49795c5e5c8b08016
    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getIs_lost() {
        return is_lost;
    }

    public void setIs_lost(String is_lost) {
        this.is_lost = is_lost;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFigureurl() {
        return figureurl;
    }

    public void setFigureurl(String figureurl) {
        this.figureurl = figureurl;
    }

<<<<<<< HEAD
=======
    public String getFigureurl_1() {
        return figureurl_1;
    }

    public void setFigureurl_1(String figureurl_1) {
        this.figureurl_1 = figureurl_1;
    }

>>>>>>> d3084b8c8c024348b672e7b49795c5e5c8b08016
    public String getFigureurl_2() {
        return figureurl_2;
    }

    public void setFigureurl_2(String figureurl_2) {
        this.figureurl_2 = figureurl_2;
    }

    public String getFigureurl_qq_1() {
        return figureurl_qq_1;
    }

    public void setFigureurl_qq_1(String figureurl_qq_1) {
        this.figureurl_qq_1 = figureurl_qq_1;
    }

    public String getFigureurl_qq_2() {
        return figureurl_qq_2;
    }

    public void setFigureurl_qq_2(String figureurl_qq_2) {
        this.figureurl_qq_2 = figureurl_qq_2;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIs_yellow_vip() {
        return is_yellow_vip;
    }

    public void setIs_yellow_vip(String is_yellow_vip) {
        this.is_yellow_vip = is_yellow_vip;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getYellow_vip_level() {
        return yellow_vip_level;
    }

    public void setYellow_vip_level(String yellow_vip_level) {
        this.yellow_vip_level = yellow_vip_level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getIs_yellow_year_vip() {
        return is_yellow_year_vip;
    }

    public void setIs_yellow_year_vip(String is_yellow_year_vip) {
        this.is_yellow_year_vip = is_yellow_year_vip;
    }
}
