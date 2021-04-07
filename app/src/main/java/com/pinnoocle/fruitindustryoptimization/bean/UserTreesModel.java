package com.pinnoocle.fruitindustryoptimization.bean;

import java.util.List;

public class UserTreesModel {
    /**
     * code : 1
     * msg : 获取成功
     * data : {"trees":[{"user_tree_id":416,"land_id":5,"user_id":17148,"tree_id":2,"growth":0,"tree_status":1,"end_time":"2022-04-01","get_packet":0,"get_goods":0,"number":1,"status":1,"name":"具体","type":1,"team":0,"live":null,"certification_code":"BTREE171482021AprTue1739270","create_time":"2021-04-06 17:39:27","wxapp_id":10001,"update_time":"2021-04-06 17:39:27","create_order_no":null,"transaction_id":"","wish":"","start_time":"2021-04-06","typename":"核桃树","tree":{"tree_id":2,"name":"核桃树","pic":"25131","child_pic":"24490","youth":100,"youth_pic":"24491","flower":100,"flower_pic":"25198","adult":300,"adult_pic":"24492","option":1,"number":3,"price":"11.50","multi_price":"0.10","bg":"24493","multi_bg":"24493","wxapp_id":10001,"land_id":5,"count_down":300,"pics":"25060,25062,25061,25097,25185","tree_title":"核桃树（认养一棵核桃树可收获5斤核桃）","sub_title":"新疆阿克苏三团种植基地","detail1":"&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201028102555313733514.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010291658053ad082692.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","detail2":"&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201021180047f57b08067.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","detail3":"","type":1,"has_more":1,"goods_id":12481,"goods_days":"每年的12月份"}},{"user_tree_id":417,"land_id":5,"user_id":17148,"tree_id":2,"growth":0,"tree_status":1,"end_time":"2022-04-01","get_packet":0,"get_goods":0,"number":1,"status":1,"name":"具体","type":1,"team":0,"live":null,"certification_code":"BTREE171482021AprTue1740130","create_time":"2021-04-06 17:40:13","wxapp_id":10001,"update_time":"2021-04-06 17:40:13","create_order_no":null,"transaction_id":"","wish":"","start_time":"2021-04-06","typename":"核桃树","tree":{"tree_id":2,"name":"核桃树","pic":"25131","child_pic":"24490","youth":100,"youth_pic":"24491","flower":100,"flower_pic":"25198","adult":300,"adult_pic":"24492","option":1,"number":3,"price":"11.50","multi_price":"0.10","bg":"24493","multi_bg":"24493","wxapp_id":10001,"land_id":5,"count_down":300,"pics":"25060,25062,25061,25097,25185","tree_title":"核桃树（认养一棵核桃树可收获5斤核桃）","sub_title":"新疆阿克苏三团种植基地","detail1":"&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201028102555313733514.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010291658053ad082692.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","detail2":"&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201021180047f57b08067.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","detail3":"","type":1,"has_more":1,"goods_id":12481,"goods_days":"每年的12月份"}},{"user_tree_id":418,"land_id":5,"user_id":17148,"tree_id":2,"growth":0,"tree_status":1,"end_time":"2022-04-01","get_packet":0,"get_goods":0,"number":1,"status":1,"name":"具体","type":1,"team":0,"live":null,"certification_code":"BTREE171482021AprTue1740170","create_time":"2021-04-06 17:40:17","wxapp_id":10001,"update_time":"2021-04-06 17:40:17","create_order_no":null,"transaction_id":"","wish":"","start_time":"2021-04-06","typename":"核桃树","tree":{"tree_id":2,"name":"核桃树","pic":"25131","child_pic":"24490","youth":100,"youth_pic":"24491","flower":100,"flower_pic":"25198","adult":300,"adult_pic":"24492","option":1,"number":3,"price":"11.50","multi_price":"0.10","bg":"24493","multi_bg":"24493","wxapp_id":10001,"land_id":5,"count_down":300,"pics":"25060,25062,25061,25097,25185","tree_title":"核桃树（认养一棵核桃树可收获5斤核桃）","sub_title":"新疆阿克苏三团种植基地","detail1":"&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201028102555313733514.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010291658053ad082692.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","detail2":"&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201021180047f57b08067.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","detail3":"","type":1,"has_more":1,"goods_id":12481,"goods_days":"每年的12月份"}}]}
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
        private List<TreesBean> trees;

        public List<TreesBean> getTrees() {
            return trees;
        }

        public void setTrees(List<TreesBean> trees) {
            this.trees = trees;
        }

        public static class TreesBean {
            /**
             * user_tree_id : 416
             * land_id : 5
             * user_id : 17148
             * tree_id : 2
             * growth : 0
             * tree_status : 1
             * end_time : 2022-04-01
             * get_packet : 0
             * get_goods : 0
             * number : 1
             * status : 1
             * name : 具体
             * type : 1
             * team : 0
             * live : null
             * certification_code : BTREE171482021AprTue1739270
             * create_time : 2021-04-06 17:39:27
             * wxapp_id : 10001
             * update_time : 2021-04-06 17:39:27
             * create_order_no : null
             * transaction_id :
             * wish :
             * start_time : 2021-04-06
             * typename : 核桃树
             * tree : {"tree_id":2,"name":"核桃树","pic":"25131","child_pic":"24490","youth":100,"youth_pic":"24491","flower":100,"flower_pic":"25198","adult":300,"adult_pic":"24492","option":1,"number":3,"price":"11.50","multi_price":"0.10","bg":"24493","multi_bg":"24493","wxapp_id":10001,"land_id":5,"count_down":300,"pics":"25060,25062,25061,25097,25185","tree_title":"核桃树（认养一棵核桃树可收获5斤核桃）","sub_title":"新疆阿克苏三团种植基地","detail1":"&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201028102555313733514.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010291658053ad082692.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","detail2":"&lt;p&gt;&lt;br/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201021180047f57b08067.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","detail3":"","type":1,"has_more":1,"goods_id":12481,"goods_days":"每年的12月份"}
             */

            private int user_tree_id;
            private int land_id;
            private int user_id;
            private int tree_id;
            private int growth;
            private int tree_status;
            private String end_time;
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
            private String start_time;
            private String typename;
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

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
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

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getTypename() {
                return typename;
            }

            public void setTypename(String typename) {
                this.typename = typename;
            }

            public TreeBean getTree() {
                return tree;
            }

            public void setTree(TreeBean tree) {
                this.tree = tree;
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
    }
}
