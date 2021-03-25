package com.pinnoocle.fruitindustryoptimization.bean;

import java.util.List;

public class MyBalanceModel {
    /**
     * code : 1
     * msg : success
     * data : {"list":[{"id":252,"user_id":17139,"flow_type":{"text":"佣金收入","value":10},"money":"13.80","describe":"邀请个人种树奖励沙棘","wxapp_id":10001,"type":2,"fname":"沙棘","fuid":16843,"capital_status":10,"order_id":0,"status_txt":""}]}
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 252
             * user_id : 17139
             * flow_type : {"text":"佣金收入","value":10}
             * money : 13.80
             * describe : 邀请个人种树奖励沙棘
             * wxapp_id : 10001
             * type : 2
             * fname : 沙棘
             * fuid : 16843
             * capital_status : 10
             * order_id : 0
             * status_txt :
             */

            private int id;
            private int user_id;
            private FlowTypeBean flow_type;
            private String money;
            private String describe;
            private int wxapp_id;
            private int type;
            private String fname;
            private int fuid;
            private int capital_status;
            private int order_id;
            private String status_txt;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public FlowTypeBean getFlow_type() {
                return flow_type;
            }

            public void setFlow_type(FlowTypeBean flow_type) {
                this.flow_type = flow_type;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public int getWxapp_id() {
                return wxapp_id;
            }

            public void setWxapp_id(int wxapp_id) {
                this.wxapp_id = wxapp_id;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getFname() {
                return fname;
            }

            public void setFname(String fname) {
                this.fname = fname;
            }

            public int getFuid() {
                return fuid;
            }

            public void setFuid(int fuid) {
                this.fuid = fuid;
            }

            public int getCapital_status() {
                return capital_status;
            }

            public void setCapital_status(int capital_status) {
                this.capital_status = capital_status;
            }

            public int getOrder_id() {
                return order_id;
            }

            public void setOrder_id(int order_id) {
                this.order_id = order_id;
            }

            public String getStatus_txt() {
                return status_txt;
            }

            public void setStatus_txt(String status_txt) {
                this.status_txt = status_txt;
            }

            public static class FlowTypeBean {
                /**
                 * text : 佣金收入
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
        }
    }
}
