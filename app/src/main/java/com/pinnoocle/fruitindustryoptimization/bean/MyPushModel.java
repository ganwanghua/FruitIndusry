package com.pinnoocle.fruitindustryoptimization.bean;

import java.util.List;

public class MyPushModel {
    /**
     * code : 1
     * msg : success
     * data : {"arr":[{"order_no":"2020102314515910210048","create_time":"2020-10-23 14:51:59","money":"5.16","user":{"user_id":16958,"union_id":"","app_openid":"","pid":16792,"nickName":"春华秋实","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ9QuWL96q8T8w05CGrMdiaHzcefmWdh8xE9pyrXd4w8q1mZHDxz55RaV4a5yrfVPibEicyGucGAaBHA/132","gender":"女","country":"中国","province":"新疆","city":"克拉玛依","address_id":13319,"balance":"0.00","points":0,"pay_money":"51.60","expend_money":"51.60","grade_id":0,"is_new_user":1,"phone":"","fid":0,"mid":1,"role":null,"smile":0,"weixin":null,"job":null,"source_name":null,"source_text":null,"source_cardid":null,"lasttime":null,"group_tags":null,"company":null,"position":null,"source_type":1,"scene":null,"source_id":null,"phonemodel":null,"address":null,"username":null,"password":"","tree_prize":"0.00","register_prize":"0.00"}}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<ArrBean> arr;

        public List<ArrBean> getArr() {
            return arr;
        }

        public void setArr(List<ArrBean> arr) {
            this.arr = arr;
        }

        public static class ArrBean {
            /**
             * order_no : 2020102314515910210048
             * create_time : 2020-10-23 14:51:59
             * money : 5.16
             * user : {"user_id":16958,"union_id":"","app_openid":"","pid":16792,"nickName":"春华秋实","avatarUrl":"https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ9QuWL96q8T8w05CGrMdiaHzcefmWdh8xE9pyrXd4w8q1mZHDxz55RaV4a5yrfVPibEicyGucGAaBHA/132","gender":"女","country":"中国","province":"新疆","city":"克拉玛依","address_id":13319,"balance":"0.00","points":0,"pay_money":"51.60","expend_money":"51.60","grade_id":0,"is_new_user":1,"phone":"","fid":0,"mid":1,"role":null,"smile":0,"weixin":null,"job":null,"source_name":null,"source_text":null,"source_cardid":null,"lasttime":null,"group_tags":null,"company":null,"position":null,"source_type":1,"scene":null,"source_id":null,"phonemodel":null,"address":null,"username":null,"password":"","tree_prize":"0.00","register_prize":"0.00"}
             */

            private String order_no;
            private String create_time;
            private String money;
            private UserBean user;

            public String getOrder_no() {
                return order_no;
            }

            public void setOrder_no(String order_no) {
                this.order_no = order_no;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public static class UserBean {
                /**
                 * user_id : 16958
                 * union_id :
                 * app_openid :
                 * pid : 16792
                 * nickName : 春华秋实
                 * avatarUrl : https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ9QuWL96q8T8w05CGrMdiaHzcefmWdh8xE9pyrXd4w8q1mZHDxz55RaV4a5yrfVPibEicyGucGAaBHA/132
                 * gender : 女
                 * country : 中国
                 * province : 新疆
                 * city : 克拉玛依
                 * address_id : 13319
                 * balance : 0.00
                 * points : 0
                 * pay_money : 51.60
                 * expend_money : 51.60
                 * grade_id : 0
                 * is_new_user : 1
                 * phone :
                 * fid : 0
                 * mid : 1
                 * role : null
                 * smile : 0
                 * weixin : null
                 * job : null
                 * source_name : null
                 * source_text : null
                 * source_cardid : null
                 * lasttime : null
                 * group_tags : null
                 * company : null
                 * position : null
                 * source_type : 1
                 * scene : null
                 * source_id : null
                 * phonemodel : null
                 * address : null
                 * username : null
                 * password :
                 * tree_prize : 0.00
                 * register_prize : 0.00
                 */

                private int user_id;
                private String union_id;
                private String app_openid;
                private int pid;
                private String nickName;
                private String avatarUrl;
                private String gender;
                private String country;
                private String province;
                private String city;
                private int address_id;
                private String balance;
                private int points;
                private String pay_money;
                private String expend_money;
                private int grade_id;
                private int is_new_user;
                private String phone;
                private int fid;
                private int mid;
                private Object role;
                private int smile;
                private Object weixin;
                private Object job;
                private Object source_name;
                private Object source_text;
                private Object source_cardid;
                private Object lasttime;
                private Object group_tags;
                private Object company;
                private Object position;
                private int source_type;
                private Object scene;
                private Object source_id;
                private Object phonemodel;
                private Object address;
                private Object username;
                private String password;
                private String tree_prize;
                private String register_prize;

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public String getUnion_id() {
                    return union_id;
                }

                public void setUnion_id(String union_id) {
                    this.union_id = union_id;
                }

                public String getApp_openid() {
                    return app_openid;
                }

                public void setApp_openid(String app_openid) {
                    this.app_openid = app_openid;
                }

                public int getPid() {
                    return pid;
                }

                public void setPid(int pid) {
                    this.pid = pid;
                }

                public String getNickName() {
                    return nickName;
                }

                public void setNickName(String nickName) {
                    this.nickName = nickName;
                }

                public String getAvatarUrl() {
                    return avatarUrl;
                }

                public void setAvatarUrl(String avatarUrl) {
                    this.avatarUrl = avatarUrl;
                }

                public String getGender() {
                    return gender;
                }

                public void setGender(String gender) {
                    this.gender = gender;
                }

                public String getCountry() {
                    return country;
                }

                public void setCountry(String country) {
                    this.country = country;
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

                public int getAddress_id() {
                    return address_id;
                }

                public void setAddress_id(int address_id) {
                    this.address_id = address_id;
                }

                public String getBalance() {
                    return balance;
                }

                public void setBalance(String balance) {
                    this.balance = balance;
                }

                public int getPoints() {
                    return points;
                }

                public void setPoints(int points) {
                    this.points = points;
                }

                public String getPay_money() {
                    return pay_money;
                }

                public void setPay_money(String pay_money) {
                    this.pay_money = pay_money;
                }

                public String getExpend_money() {
                    return expend_money;
                }

                public void setExpend_money(String expend_money) {
                    this.expend_money = expend_money;
                }

                public int getGrade_id() {
                    return grade_id;
                }

                public void setGrade_id(int grade_id) {
                    this.grade_id = grade_id;
                }

                public int getIs_new_user() {
                    return is_new_user;
                }

                public void setIs_new_user(int is_new_user) {
                    this.is_new_user = is_new_user;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public int getFid() {
                    return fid;
                }

                public void setFid(int fid) {
                    this.fid = fid;
                }

                public int getMid() {
                    return mid;
                }

                public void setMid(int mid) {
                    this.mid = mid;
                }

                public Object getRole() {
                    return role;
                }

                public void setRole(Object role) {
                    this.role = role;
                }

                public int getSmile() {
                    return smile;
                }

                public void setSmile(int smile) {
                    this.smile = smile;
                }

                public Object getWeixin() {
                    return weixin;
                }

                public void setWeixin(Object weixin) {
                    this.weixin = weixin;
                }

                public Object getJob() {
                    return job;
                }

                public void setJob(Object job) {
                    this.job = job;
                }

                public Object getSource_name() {
                    return source_name;
                }

                public void setSource_name(Object source_name) {
                    this.source_name = source_name;
                }

                public Object getSource_text() {
                    return source_text;
                }

                public void setSource_text(Object source_text) {
                    this.source_text = source_text;
                }

                public Object getSource_cardid() {
                    return source_cardid;
                }

                public void setSource_cardid(Object source_cardid) {
                    this.source_cardid = source_cardid;
                }

                public Object getLasttime() {
                    return lasttime;
                }

                public void setLasttime(Object lasttime) {
                    this.lasttime = lasttime;
                }

                public Object getGroup_tags() {
                    return group_tags;
                }

                public void setGroup_tags(Object group_tags) {
                    this.group_tags = group_tags;
                }

                public Object getCompany() {
                    return company;
                }

                public void setCompany(Object company) {
                    this.company = company;
                }

                public Object getPosition() {
                    return position;
                }

                public void setPosition(Object position) {
                    this.position = position;
                }

                public int getSource_type() {
                    return source_type;
                }

                public void setSource_type(int source_type) {
                    this.source_type = source_type;
                }

                public Object getScene() {
                    return scene;
                }

                public void setScene(Object scene) {
                    this.scene = scene;
                }

                public Object getSource_id() {
                    return source_id;
                }

                public void setSource_id(Object source_id) {
                    this.source_id = source_id;
                }

                public Object getPhonemodel() {
                    return phonemodel;
                }

                public void setPhonemodel(Object phonemodel) {
                    this.phonemodel = phonemodel;
                }

                public Object getAddress() {
                    return address;
                }

                public void setAddress(Object address) {
                    this.address = address;
                }

                public Object getUsername() {
                    return username;
                }

                public void setUsername(Object username) {
                    this.username = username;
                }

                public String getPassword() {
                    return password;
                }

                public void setPassword(String password) {
                    this.password = password;
                }

                public String getTree_prize() {
                    return tree_prize;
                }

                public void setTree_prize(String tree_prize) {
                    this.tree_prize = tree_prize;
                }

                public String getRegister_prize() {
                    return register_prize;
                }

                public void setRegister_prize(String register_prize) {
                    this.register_prize = register_prize;
                }
            }
        }
    }
}
