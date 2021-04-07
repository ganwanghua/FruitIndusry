package com.pinnoocle.fruitindustryoptimization.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TreePacketModel {
    /**
     * code : 1
     * msg :
     * data : {"sku":"0","user_tree":{"user_tree_id":416,"land_id":5,"user_id":17148,"tree_id":2,"growth":10,"tree_status":1,"end_time":1648805967,"get_packet":1,"get_goods":1,"number":1,"status":1,"name":"具体","type":1,"team":0,"live":null,"certification_code":"BTREE171482021AprTue1739270","create_time":"2021-04-06 17:39:27","wxapp_id":10001,"update_time":"2021-04-06 18:18:29","create_order_no":null,"transaction_id":"","wish":"","user":{"user_id":17148,"union_id":"","open_id":"","app_openid":"","pid":null,"nickName":"技术测试","avatarUrl":"http://btys.vshop365.cn/uploads/2021032909384785f201603.jpeg","gender":"未知","country":"","province":"","city":"","address_id":13419,"balance":"0.00","points":0,"pay_money":"0.00","expend_money":"0.00","grade_id":1,"is_new_user":1,"is_delete":0,"wxapp_id":10001,"create_time":"2021-03-20 15:21:20","update_time":"2021-04-06 17:39:27","phone":"13013109290","fid":0,"mid":1,"role":null,"smile":0,"weixin":null,"job":null,"source_name":null,"source_text":null,"source_cardid":null,"lasttime":null,"group_tags":null,"company":null,"position":null,"source_type":1,"scene":null,"source_id":null,"phonemodel":null,"address":null,"username":null,"password":"","tree_prize":"0.00","register_prize":"0.00"},"tree":{"tree_id":2,"name":"核桃树","pic":"25131","child_pic":"24490","youth":100,"youth_pic":"24491","flower":100,"flower_pic":"25198","adult":300,"adult_pic":"24492","option":1,"number":3,"price":"11.50","multi_price":"0.10","bg":"24493","multi_bg":"24493","wxapp_id":10001,"land_id":5,"count_down":300,"pics":"25060,25062,25061,25097,25185","tree_title":"核桃树（认养一棵核桃树可收获5斤核桃）","sub_title":"新疆阿克苏三团种植基地","detail1":"&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201028102555313733514.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010291658053ad082692.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","detail2":"&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201021180047f57b08067.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","detail3":"","type":1,"has_more":1,"goods_id":12481,"goods_days":"每年的12月份"}},"goods_ids":"12478","goods":[{"goods_id":12478,"goods_name":"兵团大地干果礼盒2.1kg","selling_point":"","category_id":10515,"spec_type":10,"deduct_stock_type":10,"goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":10001,"is_new_user_enjoy":0,"is_points_gift":0,"is_points_discount":0,"is_enable_balance_price":0,"is_enable_grade":0,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":""},"is_ind_dealer":1,"dealer_money_type":1,"first_money":0,"second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","goods_status":{"text":"上架","value":10},"is_packet":1,"is_checked":1,"video":"","goods_stock":1976,"goods_image":"http://btys.vshop365.cn/uploads/202010291636137eec53445.jpg","goods_sku":{"goods_sku_id":33782,"goods_id":12478,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"0.00","line_price":"0.00","stock_num":1976,"goods_sales":0,"goods_weight":2.1,"goods_old_price":"0.00","image":null},"goods_multi_spec":null,"is_user_grade":false,"category":{"category_id":10515,"name":"礼盒","parent_id":0,"image_id":0,"sort":100,"create_time":"2020-09-14 19:21:10"},"image":[{"id":30637,"goods_id":12478,"image_id":25187,"file_path":"http://btys.vshop365.cn/uploads/202010291636137eec53445.jpg","file_name":"202010291636137eec53445.jpg","file_url":""}],"sku":[{"goods_sku_id":33782,"goods_id":12478,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"0.00","line_price":"0.00","stock_num":1976,"goods_sales":0,"goods_weight":2.1,"goods_old_price":"0.00","image":null}],"goods_sales":1}]}
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
        /**
         * sku : 0
         * user_tree : {"user_tree_id":416,"land_id":5,"user_id":17148,"tree_id":2,"growth":10,"tree_status":1,"end_time":1648805967,"get_packet":1,"get_goods":1,"number":1,"status":1,"name":"具体","type":1,"team":0,"live":null,"certification_code":"BTREE171482021AprTue1739270","create_time":"2021-04-06 17:39:27","wxapp_id":10001,"update_time":"2021-04-06 18:18:29","create_order_no":null,"transaction_id":"","wish":"","user":{"user_id":17148,"union_id":"","open_id":"","app_openid":"","pid":null,"nickName":"技术测试","avatarUrl":"http://btys.vshop365.cn/uploads/2021032909384785f201603.jpeg","gender":"未知","country":"","province":"","city":"","address_id":13419,"balance":"0.00","points":0,"pay_money":"0.00","expend_money":"0.00","grade_id":1,"is_new_user":1,"is_delete":0,"wxapp_id":10001,"create_time":"2021-03-20 15:21:20","update_time":"2021-04-06 17:39:27","phone":"13013109290","fid":0,"mid":1,"role":null,"smile":0,"weixin":null,"job":null,"source_name":null,"source_text":null,"source_cardid":null,"lasttime":null,"group_tags":null,"company":null,"position":null,"source_type":1,"scene":null,"source_id":null,"phonemodel":null,"address":null,"username":null,"password":"","tree_prize":"0.00","register_prize":"0.00"},"tree":{"tree_id":2,"name":"核桃树","pic":"25131","child_pic":"24490","youth":100,"youth_pic":"24491","flower":100,"flower_pic":"25198","adult":300,"adult_pic":"24492","option":1,"number":3,"price":"11.50","multi_price":"0.10","bg":"24493","multi_bg":"24493","wxapp_id":10001,"land_id":5,"count_down":300,"pics":"25060,25062,25061,25097,25185","tree_title":"核桃树（认养一棵核桃树可收获5斤核桃）","sub_title":"新疆阿克苏三团种植基地","detail1":"&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201028102555313733514.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010291658053ad082692.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","detail2":"&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201021180047f57b08067.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","detail3":"","type":1,"has_more":1,"goods_id":12481,"goods_days":"每年的12月份"}}
         * goods_ids : 12478
         * goods : [{"goods_id":12478,"goods_name":"兵团大地干果礼盒2.1kg","selling_point":"","category_id":10515,"spec_type":10,"deduct_stock_type":10,"goods_sort":100,"buy_limit":0,"least_expend_money":"0.00","delivery_id":10001,"is_new_user_enjoy":0,"is_points_gift":0,"is_points_discount":0,"is_enable_balance_price":0,"is_enable_grade":0,"is_alone_grade":0,"alone_grade_equity":{"1":"","2":""},"is_ind_dealer":1,"dealer_money_type":1,"first_money":0,"second_money":"0.00","third_money":"0.00","is_rush":0,"is_points_exchange":0,"need_points_num":0,"need_points_money":"0.00","goods_status":{"text":"上架","value":10},"is_packet":1,"is_checked":1,"video":"","goods_stock":1976,"goods_image":"http://btys.vshop365.cn/uploads/202010291636137eec53445.jpg","goods_sku":{"goods_sku_id":33782,"goods_id":12478,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"0.00","line_price":"0.00","stock_num":1976,"goods_sales":0,"goods_weight":2.1,"goods_old_price":"0.00","image":null},"goods_multi_spec":null,"is_user_grade":false,"category":{"category_id":10515,"name":"礼盒","parent_id":0,"image_id":0,"sort":100,"create_time":"2020-09-14 19:21:10"},"image":[{"id":30637,"goods_id":12478,"image_id":25187,"file_path":"http://btys.vshop365.cn/uploads/202010291636137eec53445.jpg","file_name":"202010291636137eec53445.jpg","file_url":""}],"sku":[{"goods_sku_id":33782,"goods_id":12478,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"0.00","line_price":"0.00","stock_num":1976,"goods_sales":0,"goods_weight":2.1,"goods_old_price":"0.00","image":null}],"goods_sales":1}]
         */

        private String sku;
        private UserTreeBean user_tree;
        private String goods_ids;
        private List<GoodsBean> goods;

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public UserTreeBean getUser_tree() {
            return user_tree;
        }

        public void setUser_tree(UserTreeBean user_tree) {
            this.user_tree = user_tree;
        }

        public String getGoods_ids() {
            return goods_ids;
        }

        public void setGoods_ids(String goods_ids) {
            this.goods_ids = goods_ids;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public static class UserTreeBean {
            /**
             * user_tree_id : 416
             * land_id : 5
             * user_id : 17148
             * tree_id : 2
             * growth : 10
             * tree_status : 1
             * end_time : 1648805967
             * get_packet : 1
             * get_goods : 1
             * number : 1
             * status : 1
             * name : 具体
             * type : 1
             * team : 0
             * live : null
             * certification_code : BTREE171482021AprTue1739270
             * create_time : 2021-04-06 17:39:27
             * wxapp_id : 10001
             * update_time : 2021-04-06 18:18:29
             * create_order_no : null
             * transaction_id :
             * wish :
             * user : {"user_id":17148,"union_id":"","open_id":"","app_openid":"","pid":null,"nickName":"技术测试","avatarUrl":"http://btys.vshop365.cn/uploads/2021032909384785f201603.jpeg","gender":"未知","country":"","province":"","city":"","address_id":13419,"balance":"0.00","points":0,"pay_money":"0.00","expend_money":"0.00","grade_id":1,"is_new_user":1,"is_delete":0,"wxapp_id":10001,"create_time":"2021-03-20 15:21:20","update_time":"2021-04-06 17:39:27","phone":"13013109290","fid":0,"mid":1,"role":null,"smile":0,"weixin":null,"job":null,"source_name":null,"source_text":null,"source_cardid":null,"lasttime":null,"group_tags":null,"company":null,"position":null,"source_type":1,"scene":null,"source_id":null,"phonemodel":null,"address":null,"username":null,"password":"","tree_prize":"0.00","register_prize":"0.00"}
             * tree : {"tree_id":2,"name":"核桃树","pic":"25131","child_pic":"24490","youth":100,"youth_pic":"24491","flower":100,"flower_pic":"25198","adult":300,"adult_pic":"24492","option":1,"number":3,"price":"11.50","multi_price":"0.10","bg":"24493","multi_bg":"24493","wxapp_id":10001,"land_id":5,"count_down":300,"pics":"25060,25062,25061,25097,25185","tree_title":"核桃树（认养一棵核桃树可收获5斤核桃）","sub_title":"新疆阿克苏三团种植基地","detail1":"&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201028102555313733514.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010291658053ad082692.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","detail2":"&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201021180047f57b08067.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","detail3":"","type":1,"has_more":1,"goods_id":12481,"goods_days":"每年的12月份"}
             */

            private int user_tree_id;
            private int land_id;
            private int user_id;
            private int tree_id;
            private int growth;
            private int tree_status;
            private int end_time;
            private int get_packet;
            private int get_goods;
            private int number;
            private int status;
            private String name;
            private int type;
            private int team;
            private Object live;
            private String certification_code;
            private String create_time;
            private int wxapp_id;
            private String update_time;
            private Object create_order_no;
            private String transaction_id;
            private String wish;
            private UserBean user;
            private TreeBean tree;

            public int getUser_tree_id() {
                return user_tree_id;
            }

            public void setUser_tree_id(int user_tree_id) {
                this.user_tree_id = user_tree_id;
            }

            public int getLand_id() {
                return land_id;
            }

            public void setLand_id(int land_id) {
                this.land_id = land_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getTree_id() {
                return tree_id;
            }

            public void setTree_id(int tree_id) {
                this.tree_id = tree_id;
            }

            public int getGrowth() {
                return growth;
            }

            public void setGrowth(int growth) {
                this.growth = growth;
            }

            public int getTree_status() {
                return tree_status;
            }

            public void setTree_status(int tree_status) {
                this.tree_status = tree_status;
            }

            public int getEnd_time() {
                return end_time;
            }

            public void setEnd_time(int end_time) {
                this.end_time = end_time;
            }

            public int getGet_packet() {
                return get_packet;
            }

            public void setGet_packet(int get_packet) {
                this.get_packet = get_packet;
            }

            public int getGet_goods() {
                return get_goods;
            }

            public void setGet_goods(int get_goods) {
                this.get_goods = get_goods;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getTeam() {
                return team;
            }

            public void setTeam(int team) {
                this.team = team;
            }

            public Object getLive() {
                return live;
            }

            public void setLive(Object live) {
                this.live = live;
            }

            public String getCertification_code() {
                return certification_code;
            }

            public void setCertification_code(String certification_code) {
                this.certification_code = certification_code;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public int getWxapp_id() {
                return wxapp_id;
            }

            public void setWxapp_id(int wxapp_id) {
                this.wxapp_id = wxapp_id;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public Object getCreate_order_no() {
                return create_order_no;
            }

            public void setCreate_order_no(Object create_order_no) {
                this.create_order_no = create_order_no;
            }

            public String getTransaction_id() {
                return transaction_id;
            }

            public void setTransaction_id(String transaction_id) {
                this.transaction_id = transaction_id;
            }

            public String getWish() {
                return wish;
            }

            public void setWish(String wish) {
                this.wish = wish;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public TreeBean getTree() {
                return tree;
            }

            public void setTree(TreeBean tree) {
                this.tree = tree;
            }

            public static class UserBean {
                /**
                 * user_id : 17148
                 * union_id :
                 * open_id :
                 * app_openid :
                 * pid : null
                 * nickName : 技术测试
                 * avatarUrl : http://btys.vshop365.cn/uploads/2021032909384785f201603.jpeg
                 * gender : 未知
                 * country :
                 * province :
                 * city :
                 * address_id : 13419
                 * balance : 0.00
                 * points : 0
                 * pay_money : 0.00
                 * expend_money : 0.00
                 * grade_id : 1
                 * is_new_user : 1
                 * is_delete : 0
                 * wxapp_id : 10001
                 * create_time : 2021-03-20 15:21:20
                 * update_time : 2021-04-06 17:39:27
                 * phone : 13013109290
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
                private String open_id;
                private String app_openid;
                private Object pid;
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
                private int is_delete;
                private int wxapp_id;
                private String create_time;
                private String update_time;
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

                public String getOpen_id() {
                    return open_id;
                }

                public void setOpen_id(String open_id) {
                    this.open_id = open_id;
                }

                public String getApp_openid() {
                    return app_openid;
                }

                public void setApp_openid(String app_openid) {
                    this.app_openid = app_openid;
                }

                public Object getPid() {
                    return pid;
                }

                public void setPid(Object pid) {
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

                public int getIs_delete() {
                    return is_delete;
                }

                public void setIs_delete(int is_delete) {
                    this.is_delete = is_delete;
                }

                public int getWxapp_id() {
                    return wxapp_id;
                }

                public void setWxapp_id(int wxapp_id) {
                    this.wxapp_id = wxapp_id;
                }

                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }

                public String getUpdate_time() {
                    return update_time;
                }

                public void setUpdate_time(String update_time) {
                    this.update_time = update_time;
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

            public static class TreeBean {
                /**
                 * tree_id : 2
                 * name : 核桃树
                 * pic : 25131
                 * child_pic : 24490
                 * youth : 100
                 * youth_pic : 24491
                 * flower : 100
                 * flower_pic : 25198
                 * adult : 300
                 * adult_pic : 24492
                 * option : 1
                 * number : 3
                 * price : 11.50
                 * multi_price : 0.10
                 * bg : 24493
                 * multi_bg : 24493
                 * wxapp_id : 10001
                 * land_id : 5
                 * count_down : 300
                 * pics : 25060,25062,25061,25097,25185
                 * tree_title : 核桃树（认养一棵核桃树可收获5斤核桃）
                 * sub_title : 新疆阿克苏三团种植基地
                 * detail1 : &lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201028102555313733514.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010291658053ad082692.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;
                 * detail2 : &lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201021180047f57b08067.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;
                 * detail3 :
                 * type : 1
                 * has_more : 1
                 * goods_id : 12481
                 * goods_days : 每年的12月份
                 */

                private int tree_id;
                private String name;
                private String pic;
                private String child_pic;
                private int youth;
                private String youth_pic;
                private int flower;
                private String flower_pic;
                private int adult;
                private String adult_pic;
                private int option;
                private int number;
                private String price;
                private String multi_price;
                private String bg;
                private String multi_bg;
                private int wxapp_id;
                private int land_id;
                private int count_down;
                private String pics;
                private String tree_title;
                private String sub_title;
                private String detail1;
                private String detail2;
                private String detail3;
                private int type;
                private int has_more;
                private int goods_id;
                private String goods_days;

                public int getTree_id() {
                    return tree_id;
                }

                public void setTree_id(int tree_id) {
                    this.tree_id = tree_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getChild_pic() {
                    return child_pic;
                }

                public void setChild_pic(String child_pic) {
                    this.child_pic = child_pic;
                }

                public int getYouth() {
                    return youth;
                }

                public void setYouth(int youth) {
                    this.youth = youth;
                }

                public String getYouth_pic() {
                    return youth_pic;
                }

                public void setYouth_pic(String youth_pic) {
                    this.youth_pic = youth_pic;
                }

                public int getFlower() {
                    return flower;
                }

                public void setFlower(int flower) {
                    this.flower = flower;
                }

                public String getFlower_pic() {
                    return flower_pic;
                }

                public void setFlower_pic(String flower_pic) {
                    this.flower_pic = flower_pic;
                }

                public int getAdult() {
                    return adult;
                }

                public void setAdult(int adult) {
                    this.adult = adult;
                }

                public String getAdult_pic() {
                    return adult_pic;
                }

                public void setAdult_pic(String adult_pic) {
                    this.adult_pic = adult_pic;
                }

                public int getOption() {
                    return option;
                }

                public void setOption(int option) {
                    this.option = option;
                }

                public int getNumber() {
                    return number;
                }

                public void setNumber(int number) {
                    this.number = number;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getMulti_price() {
                    return multi_price;
                }

                public void setMulti_price(String multi_price) {
                    this.multi_price = multi_price;
                }

                public String getBg() {
                    return bg;
                }

                public void setBg(String bg) {
                    this.bg = bg;
                }

                public String getMulti_bg() {
                    return multi_bg;
                }

                public void setMulti_bg(String multi_bg) {
                    this.multi_bg = multi_bg;
                }

                public int getWxapp_id() {
                    return wxapp_id;
                }

                public void setWxapp_id(int wxapp_id) {
                    this.wxapp_id = wxapp_id;
                }

                public int getLand_id() {
                    return land_id;
                }

                public void setLand_id(int land_id) {
                    this.land_id = land_id;
                }

                public int getCount_down() {
                    return count_down;
                }

                public void setCount_down(int count_down) {
                    this.count_down = count_down;
                }

                public String getPics() {
                    return pics;
                }

                public void setPics(String pics) {
                    this.pics = pics;
                }

                public String getTree_title() {
                    return tree_title;
                }

                public void setTree_title(String tree_title) {
                    this.tree_title = tree_title;
                }

                public String getSub_title() {
                    return sub_title;
                }

                public void setSub_title(String sub_title) {
                    this.sub_title = sub_title;
                }

                public String getDetail1() {
                    return detail1;
                }

                public void setDetail1(String detail1) {
                    this.detail1 = detail1;
                }

                public String getDetail2() {
                    return detail2;
                }

                public void setDetail2(String detail2) {
                    this.detail2 = detail2;
                }

                public String getDetail3() {
                    return detail3;
                }

                public void setDetail3(String detail3) {
                    this.detail3 = detail3;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public int getHas_more() {
                    return has_more;
                }

                public void setHas_more(int has_more) {
                    this.has_more = has_more;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public String getGoods_days() {
                    return goods_days;
                }

                public void setGoods_days(String goods_days) {
                    this.goods_days = goods_days;
                }
            }
        }

        public static class GoodsBean {
            /**
             * goods_id : 12478
             * goods_name : 兵团大地干果礼盒2.1kg
             * selling_point :
             * category_id : 10515
             * spec_type : 10
             * deduct_stock_type : 10
             * goods_sort : 100
             * buy_limit : 0
             * least_expend_money : 0.00
             * delivery_id : 10001
             * is_new_user_enjoy : 0
             * is_points_gift : 0
             * is_points_discount : 0
             * is_enable_balance_price : 0
             * is_enable_grade : 0
             * is_alone_grade : 0
             * alone_grade_equity : {"1":"","2":""}
             * is_ind_dealer : 1
             * dealer_money_type : 1
             * first_money : 0
             * second_money : 0.00
             * third_money : 0.00
             * is_rush : 0
             * is_points_exchange : 0
             * need_points_num : 0
             * need_points_money : 0.00
             * goods_status : {"text":"上架","value":10}
             * is_packet : 1
             * is_checked : 1
             * video :
             * goods_stock : 1976
             * goods_image : http://btys.vshop365.cn/uploads/202010291636137eec53445.jpg
             * goods_sku : {"goods_sku_id":33782,"goods_id":12478,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"0.00","line_price":"0.00","stock_num":1976,"goods_sales":0,"goods_weight":2.1,"goods_old_price":"0.00","image":null}
             * goods_multi_spec : null
             * is_user_grade : false
             * category : {"category_id":10515,"name":"礼盒","parent_id":0,"image_id":0,"sort":100,"create_time":"2020-09-14 19:21:10"}
             * image : [{"id":30637,"goods_id":12478,"image_id":25187,"file_path":"http://btys.vshop365.cn/uploads/202010291636137eec53445.jpg","file_name":"202010291636137eec53445.jpg","file_url":""}]
             * sku : [{"goods_sku_id":33782,"goods_id":12478,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"0.00","line_price":"0.00","stock_num":1976,"goods_sales":0,"goods_weight":2.1,"goods_old_price":"0.00","image":null}]
             * goods_sales : 1
             */

            private int goods_id;
            private String goods_name;
            private String selling_point;
            private int category_id;
            private int spec_type;
            private int deduct_stock_type;
            private int goods_sort;
            private int buy_limit;
            private String least_expend_money;
            private int delivery_id;
            private int is_new_user_enjoy;
            private int is_points_gift;
            private int is_points_discount;
            private int is_enable_balance_price;
            private int is_enable_grade;
            private int is_alone_grade;
            private AloneGradeEquityBean alone_grade_equity;
            private int is_ind_dealer;
            private int dealer_money_type;
            private int first_money;
            private String second_money;
            private String third_money;
            private int is_rush;
            private int is_points_exchange;
            private int need_points_num;
            private String need_points_money;
            private GoodsStatusBean goods_status;
            private int is_packet;
            private int is_checked;
            private String video;
            private int goods_stock;
            private String goods_image;
            private GoodsSkuBean goods_sku;
            private Object goods_multi_spec;
            private boolean is_user_grade;
            private CategoryBean category;
            private int goods_sales;
            private List<ImageBean> image;
            private List<SkuBean> sku;

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getSelling_point() {
                return selling_point;
            }

            public void setSelling_point(String selling_point) {
                this.selling_point = selling_point;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public int getSpec_type() {
                return spec_type;
            }

            public void setSpec_type(int spec_type) {
                this.spec_type = spec_type;
            }

            public int getDeduct_stock_type() {
                return deduct_stock_type;
            }

            public void setDeduct_stock_type(int deduct_stock_type) {
                this.deduct_stock_type = deduct_stock_type;
            }

            public int getGoods_sort() {
                return goods_sort;
            }

            public void setGoods_sort(int goods_sort) {
                this.goods_sort = goods_sort;
            }

            public int getBuy_limit() {
                return buy_limit;
            }

            public void setBuy_limit(int buy_limit) {
                this.buy_limit = buy_limit;
            }

            public String getLeast_expend_money() {
                return least_expend_money;
            }

            public void setLeast_expend_money(String least_expend_money) {
                this.least_expend_money = least_expend_money;
            }

            public int getDelivery_id() {
                return delivery_id;
            }

            public void setDelivery_id(int delivery_id) {
                this.delivery_id = delivery_id;
            }

            public int getIs_new_user_enjoy() {
                return is_new_user_enjoy;
            }

            public void setIs_new_user_enjoy(int is_new_user_enjoy) {
                this.is_new_user_enjoy = is_new_user_enjoy;
            }

            public int getIs_points_gift() {
                return is_points_gift;
            }

            public void setIs_points_gift(int is_points_gift) {
                this.is_points_gift = is_points_gift;
            }

            public int getIs_points_discount() {
                return is_points_discount;
            }

            public void setIs_points_discount(int is_points_discount) {
                this.is_points_discount = is_points_discount;
            }

            public int getIs_enable_balance_price() {
                return is_enable_balance_price;
            }

            public void setIs_enable_balance_price(int is_enable_balance_price) {
                this.is_enable_balance_price = is_enable_balance_price;
            }

            public int getIs_enable_grade() {
                return is_enable_grade;
            }

            public void setIs_enable_grade(int is_enable_grade) {
                this.is_enable_grade = is_enable_grade;
            }

            public int getIs_alone_grade() {
                return is_alone_grade;
            }

            public void setIs_alone_grade(int is_alone_grade) {
                this.is_alone_grade = is_alone_grade;
            }

            public AloneGradeEquityBean getAlone_grade_equity() {
                return alone_grade_equity;
            }

            public void setAlone_grade_equity(AloneGradeEquityBean alone_grade_equity) {
                this.alone_grade_equity = alone_grade_equity;
            }

            public int getIs_ind_dealer() {
                return is_ind_dealer;
            }

            public void setIs_ind_dealer(int is_ind_dealer) {
                this.is_ind_dealer = is_ind_dealer;
            }

            public int getDealer_money_type() {
                return dealer_money_type;
            }

            public void setDealer_money_type(int dealer_money_type) {
                this.dealer_money_type = dealer_money_type;
            }

            public int getFirst_money() {
                return first_money;
            }

            public void setFirst_money(int first_money) {
                this.first_money = first_money;
            }

            public String getSecond_money() {
                return second_money;
            }

            public void setSecond_money(String second_money) {
                this.second_money = second_money;
            }

            public String getThird_money() {
                return third_money;
            }

            public void setThird_money(String third_money) {
                this.third_money = third_money;
            }

            public int getIs_rush() {
                return is_rush;
            }

            public void setIs_rush(int is_rush) {
                this.is_rush = is_rush;
            }

            public int getIs_points_exchange() {
                return is_points_exchange;
            }

            public void setIs_points_exchange(int is_points_exchange) {
                this.is_points_exchange = is_points_exchange;
            }

            public int getNeed_points_num() {
                return need_points_num;
            }

            public void setNeed_points_num(int need_points_num) {
                this.need_points_num = need_points_num;
            }

            public String getNeed_points_money() {
                return need_points_money;
            }

            public void setNeed_points_money(String need_points_money) {
                this.need_points_money = need_points_money;
            }

            public GoodsStatusBean getGoods_status() {
                return goods_status;
            }

            public void setGoods_status(GoodsStatusBean goods_status) {
                this.goods_status = goods_status;
            }

            public int getIs_packet() {
                return is_packet;
            }

            public void setIs_packet(int is_packet) {
                this.is_packet = is_packet;
            }

            public int getIs_checked() {
                return is_checked;
            }

            public void setIs_checked(int is_checked) {
                this.is_checked = is_checked;
            }

            public String getVideo() {
                return video;
            }

            public void setVideo(String video) {
                this.video = video;
            }

            public int getGoods_stock() {
                return goods_stock;
            }

            public void setGoods_stock(int goods_stock) {
                this.goods_stock = goods_stock;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public GoodsSkuBean getGoods_sku() {
                return goods_sku;
            }

            public void setGoods_sku(GoodsSkuBean goods_sku) {
                this.goods_sku = goods_sku;
            }

            public Object getGoods_multi_spec() {
                return goods_multi_spec;
            }

            public void setGoods_multi_spec(Object goods_multi_spec) {
                this.goods_multi_spec = goods_multi_spec;
            }

            public boolean isIs_user_grade() {
                return is_user_grade;
            }

            public void setIs_user_grade(boolean is_user_grade) {
                this.is_user_grade = is_user_grade;
            }

            public CategoryBean getCategory() {
                return category;
            }

            public void setCategory(CategoryBean category) {
                this.category = category;
            }

            public int getGoods_sales() {
                return goods_sales;
            }

            public void setGoods_sales(int goods_sales) {
                this.goods_sales = goods_sales;
            }

            public List<ImageBean> getImage() {
                return image;
            }

            public void setImage(List<ImageBean> image) {
                this.image = image;
            }

            public List<SkuBean> getSku() {
                return sku;
            }

            public void setSku(List<SkuBean> sku) {
                this.sku = sku;
            }

            public static class AloneGradeEquityBean {
                /**
                 * 1 :
                 * 2 :
                 */

                @SerializedName("1")
                private String _$1;
                @SerializedName("2")
                private String _$2;

                public String get_$1() {
                    return _$1;
                }

                public void set_$1(String _$1) {
                    this._$1 = _$1;
                }

                public String get_$2() {
                    return _$2;
                }

                public void set_$2(String _$2) {
                    this._$2 = _$2;
                }
            }

            public static class GoodsStatusBean {
                /**
                 * text : 上架
                 * value : 10
                 */

                private String text;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class GoodsSkuBean {
                /**
                 * goods_sku_id : 33782
                 * goods_id : 12478
                 * spec_sku_id : 0
                 * image_id : 0
                 * goods_no :
                 * balance_price : 0.00
                 * goods_price : 0.00
                 * line_price : 0.00
                 * stock_num : 1976
                 * goods_sales : 0
                 * goods_weight : 2.1
                 * goods_old_price : 0.00
                 * image : null
                 */

                private int goods_sku_id;
                private int goods_id;
                private String spec_sku_id;
                private int image_id;
                private String goods_no;
                private String balance_price;
                private String goods_price;
                private String line_price;
                private int stock_num;
                private int goods_sales;
                private double goods_weight;
                private String goods_old_price;
                private Object image;

                public int getGoods_sku_id() {
                    return goods_sku_id;
                }

                public void setGoods_sku_id(int goods_sku_id) {
                    this.goods_sku_id = goods_sku_id;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public String getSpec_sku_id() {
                    return spec_sku_id;
                }

                public void setSpec_sku_id(String spec_sku_id) {
                    this.spec_sku_id = spec_sku_id;
                }

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
                }

                public String getGoods_no() {
                    return goods_no;
                }

                public void setGoods_no(String goods_no) {
                    this.goods_no = goods_no;
                }

                public String getBalance_price() {
                    return balance_price;
                }

                public void setBalance_price(String balance_price) {
                    this.balance_price = balance_price;
                }

                public String getGoods_price() {
                    return goods_price;
                }

                public void setGoods_price(String goods_price) {
                    this.goods_price = goods_price;
                }

                public String getLine_price() {
                    return line_price;
                }

                public void setLine_price(String line_price) {
                    this.line_price = line_price;
                }

                public int getStock_num() {
                    return stock_num;
                }

                public void setStock_num(int stock_num) {
                    this.stock_num = stock_num;
                }

                public int getGoods_sales() {
                    return goods_sales;
                }

                public void setGoods_sales(int goods_sales) {
                    this.goods_sales = goods_sales;
                }

                public double getGoods_weight() {
                    return goods_weight;
                }

                public void setGoods_weight(double goods_weight) {
                    this.goods_weight = goods_weight;
                }

                public String getGoods_old_price() {
                    return goods_old_price;
                }

                public void setGoods_old_price(String goods_old_price) {
                    this.goods_old_price = goods_old_price;
                }

                public Object getImage() {
                    return image;
                }

                public void setImage(Object image) {
                    this.image = image;
                }
            }

            public static class CategoryBean {
                /**
                 * category_id : 10515
                 * name : 礼盒
                 * parent_id : 0
                 * image_id : 0
                 * sort : 100
                 * create_time : 2020-09-14 19:21:10
                 */

                private int category_id;
                private String name;
                private int parent_id;
                private int image_id;
                private int sort;
                private String create_time;

                public int getCategory_id() {
                    return category_id;
                }

                public void setCategory_id(int category_id) {
                    this.category_id = category_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getParent_id() {
                    return parent_id;
                }

                public void setParent_id(int parent_id) {
                    this.parent_id = parent_id;
                }

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }
            }

            public static class ImageBean {
                /**
                 * id : 30637
                 * goods_id : 12478
                 * image_id : 25187
                 * file_path : http://btys.vshop365.cn/uploads/202010291636137eec53445.jpg
                 * file_name : 202010291636137eec53445.jpg
                 * file_url :
                 */

                private int id;
                private int goods_id;
                private int image_id;
                private String file_path;
                private String file_name;
                private String file_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
                }

                public String getFile_path() {
                    return file_path;
                }

                public void setFile_path(String file_path) {
                    this.file_path = file_path;
                }

                public String getFile_name() {
                    return file_name;
                }

                public void setFile_name(String file_name) {
                    this.file_name = file_name;
                }

                public String getFile_url() {
                    return file_url;
                }

                public void setFile_url(String file_url) {
                    this.file_url = file_url;
                }
            }

            public static class SkuBean {
                /**
                 * goods_sku_id : 33782
                 * goods_id : 12478
                 * spec_sku_id : 0
                 * image_id : 0
                 * goods_no :
                 * balance_price : 0.00
                 * goods_price : 0.00
                 * line_price : 0.00
                 * stock_num : 1976
                 * goods_sales : 0
                 * goods_weight : 2.1
                 * goods_old_price : 0.00
                 * image : null
                 */

                private int goods_sku_id;
                private int goods_id;
                private String spec_sku_id;
                private int image_id;
                private String goods_no;
                private String balance_price;
                private String goods_price;
                private String line_price;
                private int stock_num;
                private int goods_sales;
                private double goods_weight;
                private String goods_old_price;
                private Object image;

                public int getGoods_sku_id() {
                    return goods_sku_id;
                }

                public void setGoods_sku_id(int goods_sku_id) {
                    this.goods_sku_id = goods_sku_id;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public String getSpec_sku_id() {
                    return spec_sku_id;
                }

                public void setSpec_sku_id(String spec_sku_id) {
                    this.spec_sku_id = spec_sku_id;
                }

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
                }

                public String getGoods_no() {
                    return goods_no;
                }

                public void setGoods_no(String goods_no) {
                    this.goods_no = goods_no;
                }

                public String getBalance_price() {
                    return balance_price;
                }

                public void setBalance_price(String balance_price) {
                    this.balance_price = balance_price;
                }

                public String getGoods_price() {
                    return goods_price;
                }

                public void setGoods_price(String goods_price) {
                    this.goods_price = goods_price;
                }

                public String getLine_price() {
                    return line_price;
                }

                public void setLine_price(String line_price) {
                    this.line_price = line_price;
                }

                public int getStock_num() {
                    return stock_num;
                }

                public void setStock_num(int stock_num) {
                    this.stock_num = stock_num;
                }

                public int getGoods_sales() {
                    return goods_sales;
                }

                public void setGoods_sales(int goods_sales) {
                    this.goods_sales = goods_sales;
                }

                public double getGoods_weight() {
                    return goods_weight;
                }

                public void setGoods_weight(double goods_weight) {
                    this.goods_weight = goods_weight;
                }

                public String getGoods_old_price() {
                    return goods_old_price;
                }

                public void setGoods_old_price(String goods_old_price) {
                    this.goods_old_price = goods_old_price;
                }

                public Object getImage() {
                    return image;
                }

                public void setImage(Object image) {
                    this.image = image;
                }
            }
        }
    }
}
