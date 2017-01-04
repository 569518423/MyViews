package com.jiawei.ibm.myviews;

/**
 * Created by ibm on 2016/12/23.
 */


public class Response {

    /**
     * requestType : 1
     * code : 0
     * msg :
     * user : {"id":14,"birthday":"2015-04-15","companyid":"a0118b40-8004-47c8-856f-aa1a0923be81","phone":"15710080577","sex":"1","shopid":"14","truename":"搞得之","nickname":"哈哈","status":"n","pic":"http:__bmn.oss-cn-beijing.aliyuncs.com_images_productImages_14_14_201507_b72ac0ca-1d69-4e50-9120-d96acff2c4c1.jpg"}
     */

    private String requestType;
    private String code;
    private String msg;
    private UserBean user;

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * id : 14
         * birthday : 2015-04-15
         * companyid : a0118b40-8004-47c8-856f-aa1a0923be81
         * phone : 15710080577
         * sex : 1
         * shopid : 14
         * truename : 搞得之
         * nickname : 哈哈
         * status : n
         * pic : http:__bmn.oss-cn-beijing.aliyuncs.com_images_productImages_14_14_201507_b72ac0ca-1d69-4e50-9120-d96acff2c4c1.jpg
         */

        private int id;
        private String birthday;
        private String companyid;
        private String phone;
        private String sex;
        private String shopid;
        private String truename;
        private String nickname;
        private String status;
        private String pic;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getCompanyid() {
            return companyid;
        }

        public void setCompanyid(String companyid) {
            this.companyid = companyid;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getShopid() {
            return shopid;
        }

        public void setShopid(String shopid) {
            this.shopid = shopid;
        }

        public String getTruename() {
            return truename;
        }

        public void setTruename(String truename) {
            this.truename = truename;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }
}
