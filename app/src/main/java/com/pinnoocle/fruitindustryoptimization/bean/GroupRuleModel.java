package com.pinnoocle.fruitindustryoptimization.bean;

public class GroupRuleModel {

    /**
     * code : 1
     * msg : success
     * data : {"setting":{"basic":{"auto_refund":"1","is_coupon":"0","is_dealer":"0","rule_brief":"好友拼单 · 人满发货 · 人不满退款","rule_detail":"开团：选择商品，点击\u201c发起拼单\u201d按钮，付款完成后即开团成功，就可以邀请小伙伴一起拼团啦;\n\n参团：进入朋友分享的页面，点击\u201c立即参团\u201d按钮，付款完成后参团成功，在有效时间内凑齐人数即成团，就可以等待收货喽;\n\n成团：在开团或参团成功后，点击\u201c立即分享\u201d将页面分享给好友，在有效时间内凑齐人数即成团，成团后商家开始发货;\n\n组团失败：在有效时间内未凑齐人数，即组团失败，组团失败后订单所付款将原路退回到支付账户。","is_enable":"1","tpl_msg_id":"","template_params":"","color":"#ff495e"}}}
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
         * setting : {"basic":{"auto_refund":"1","is_coupon":"0","is_dealer":"0","rule_brief":"好友拼单 · 人满发货 · 人不满退款","rule_detail":"开团：选择商品，点击\u201c发起拼单\u201d按钮，付款完成后即开团成功，就可以邀请小伙伴一起拼团啦;\n\n参团：进入朋友分享的页面，点击\u201c立即参团\u201d按钮，付款完成后参团成功，在有效时间内凑齐人数即成团，就可以等待收货喽;\n\n成团：在开团或参团成功后，点击\u201c立即分享\u201d将页面分享给好友，在有效时间内凑齐人数即成团，成团后商家开始发货;\n\n组团失败：在有效时间内未凑齐人数，即组团失败，组团失败后订单所付款将原路退回到支付账户。","is_enable":"1","tpl_msg_id":"","template_params":"","color":"#ff495e"}}
         */

        private SettingBean setting;

        public SettingBean getSetting() {
            return setting;
        }

        public void setSetting(SettingBean setting) {
            this.setting = setting;
        }

        public static class SettingBean {
            /**
             * basic : {"auto_refund":"1","is_coupon":"0","is_dealer":"0","rule_brief":"好友拼单 · 人满发货 · 人不满退款","rule_detail":"开团：选择商品，点击\u201c发起拼单\u201d按钮，付款完成后即开团成功，就可以邀请小伙伴一起拼团啦;\n\n参团：进入朋友分享的页面，点击\u201c立即参团\u201d按钮，付款完成后参团成功，在有效时间内凑齐人数即成团，就可以等待收货喽;\n\n成团：在开团或参团成功后，点击\u201c立即分享\u201d将页面分享给好友，在有效时间内凑齐人数即成团，成团后商家开始发货;\n\n组团失败：在有效时间内未凑齐人数，即组团失败，组团失败后订单所付款将原路退回到支付账户。","is_enable":"1","tpl_msg_id":"","template_params":"","color":"#ff495e"}
             */

            private BasicBean basic;

            public BasicBean getBasic() {
                return basic;
            }

            public void setBasic(BasicBean basic) {
                this.basic = basic;
            }

            public static class BasicBean {
                /**
                 * auto_refund : 1
                 * is_coupon : 0
                 * is_dealer : 0
                 * rule_brief : 好友拼单 · 人满发货 · 人不满退款
                 * rule_detail : 开团：选择商品，点击“发起拼单”按钮，付款完成后即开团成功，就可以邀请小伙伴一起拼团啦;

                 参团：进入朋友分享的页面，点击“立即参团”按钮，付款完成后参团成功，在有效时间内凑齐人数即成团，就可以等待收货喽;

                 成团：在开团或参团成功后，点击“立即分享”将页面分享给好友，在有效时间内凑齐人数即成团，成团后商家开始发货;

                 组团失败：在有效时间内未凑齐人数，即组团失败，组团失败后订单所付款将原路退回到支付账户。
                 * is_enable : 1
                 * tpl_msg_id :
                 * template_params :
                 * color : #ff495e
                 */

                private String auto_refund;
                private String is_coupon;
                private String is_dealer;
                private String rule_brief;
                private String rule_detail;
                private String is_enable;
                private String tpl_msg_id;
                private String template_params;
                private String color;

                public String getAuto_refund() {
                    return auto_refund;
                }

                public void setAuto_refund(String auto_refund) {
                    this.auto_refund = auto_refund;
                }

                public String getIs_coupon() {
                    return is_coupon;
                }

                public void setIs_coupon(String is_coupon) {
                    this.is_coupon = is_coupon;
                }

                public String getIs_dealer() {
                    return is_dealer;
                }

                public void setIs_dealer(String is_dealer) {
                    this.is_dealer = is_dealer;
                }

                public String getRule_brief() {
                    return rule_brief;
                }

                public void setRule_brief(String rule_brief) {
                    this.rule_brief = rule_brief;
                }

                public String getRule_detail() {
                    return rule_detail;
                }

                public void setRule_detail(String rule_detail) {
                    this.rule_detail = rule_detail;
                }

                public String getIs_enable() {
                    return is_enable;
                }

                public void setIs_enable(String is_enable) {
                    this.is_enable = is_enable;
                }

                public String getTpl_msg_id() {
                    return tpl_msg_id;
                }

                public void setTpl_msg_id(String tpl_msg_id) {
                    this.tpl_msg_id = tpl_msg_id;
                }

                public String getTemplate_params() {
                    return template_params;
                }

                public void setTemplate_params(String template_params) {
                    this.template_params = template_params;
                }

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }
            }
        }
    }
}
