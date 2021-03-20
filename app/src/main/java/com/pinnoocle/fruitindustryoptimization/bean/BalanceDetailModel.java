package com.pinnoocle.fruitindustryoptimization.bean;

import java.util.List;

public class BalanceDetailModel {
    /**
     * code : 1
     * msg : success
     * data : {"list":{"total":2,"per_page":15,"current_page":1,"last_page":1,"data":[{"log_id":12247,"user_id":17139,"scene":{"text":"订单退款","value":40},"money":"22.00","describe":"订单退款：2020122517214456564953","remark":"","create_time":"2020-12-25 17:26:16"},{"log_id":12248,"user_id":17139,"scene":{"text":"用户消费","value":20},"money":"11.00","describe":"用户消费：2020122517214456564953","remark":"","create_time":"2020-12-25 17:22:14"}]}}
     */

    private int code;
    private String msg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * list : {"total":2,"per_page":15,"current_page":1,"last_page":1,"data":[{"log_id":12247,"user_id":17139,"scene":{"text":"订单退款","value":40},"money":"22.00","describe":"订单退款：2020122517214456564953","remark":"","create_time":"2020-12-25 17:26:16"},{"log_id":12248,"user_id":17139,"scene":{"text":"用户消费","value":20},"money":"11.00","describe":"用户消费：2020122517214456564953","remark":"","create_time":"2020-12-25 17:22:14"}]}
         */

        private ListBean list;

        public ListBean getList() {
            return list;
        }

        public void setList(ListBean list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * total : 2
             * per_page : 15
             * current_page : 1
             * last_page : 1
             * data : [{"log_id":12247,"user_id":17139,"scene":{"text":"订单退款","value":40},"money":"22.00","describe":"订单退款：2020122517214456564953","remark":"","create_time":"2020-12-25 17:26:16"},{"log_id":12248,"user_id":17139,"scene":{"text":"用户消费","value":20},"money":"11.00","describe":"用户消费：2020122517214456564953","remark":"","create_time":"2020-12-25 17:22:14"}]
             */

            private int total;
            private int per_page;
            private int current_page;
            private int last_page;
            private List<DataBean> data;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPer_page() {
                return per_page;
            }

            public void setPer_page(int per_page) {
                this.per_page = per_page;
            }

            public int getCurrent_page() {
                return current_page;
            }

            public void setCurrent_page(int current_page) {
                this.current_page = current_page;
            }

            public int getLast_page() {
                return last_page;
            }

            public void setLast_page(int last_page) {
                this.last_page = last_page;
            }

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class DataBean {
                /**
                 * log_id : 12247
                 * user_id : 17139
                 * scene : {"text":"订单退款","value":40}
                 * money : 22.00
                 * describe : 订单退款：2020122517214456564953
                 * remark :
                 * create_time : 2020-12-25 17:26:16
                 */

                private int log_id;
                private int user_id;
                private SceneBean scene;
                private String money;
                private String describe;
                private String remark;
                private String create_time;

                public int getLog_id() {
                    return log_id;
                }

                public void setLog_id(int log_id) {
                    this.log_id = log_id;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public SceneBean getScene() {
                    return scene;
                }

                public void setScene(SceneBean scene) {
                    this.scene = scene;
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

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }

                public static class SceneBean {
                    /**
                     * text : 订单退款
                     * value : 40
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
}
