package com.pinnoocle.fruitindustryoptimization.bean;

import com.google.gson.annotations.SerializedName;

public class GeneTreeOrderModel {
    /**
     * code : 1
     * msg : 获取支付参数
     * data : {"payment":{"prepay_id":"wx10175549663169f0927f9f8a97945b0000","nonceStr":"0511816685eee7409d99c1a3c66fb573","timeStamp":"1615370146","paySign":"157CFF386FE99DD79B3BB5DDC8EF0CAB","package":"prepay_id=wx10175549663169f0927f9f8a97945b0000"},"order_no":"TR2021031017554617139"}
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
         * payment : {"prepay_id":"wx10175549663169f0927f9f8a97945b0000","nonceStr":"0511816685eee7409d99c1a3c66fb573","timeStamp":"1615370146","paySign":"157CFF386FE99DD79B3BB5DDC8EF0CAB","package":"prepay_id=wx10175549663169f0927f9f8a97945b0000"}
         * order_no : TR2021031017554617139
         */

        private PaymentBean payment;
        private String order_no;

        public PaymentBean getPayment() {
            return payment;
        }

        public void setPayment(PaymentBean payment) {
            this.payment = payment;
        }

        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }

        public static class PaymentBean {
            /**
             * prepay_id : wx10175549663169f0927f9f8a97945b0000
             * nonceStr : 0511816685eee7409d99c1a3c66fb573
             * timeStamp : 1615370146
             * paySign : 157CFF386FE99DD79B3BB5DDC8EF0CAB
             * package : prepay_id=wx10175549663169f0927f9f8a97945b0000
             */

            private String prepay_id;
            private String nonceStr;
            private String timeStamp;
            private String paySign;
            @SerializedName("package")
            private String packageX;

            public String getPrepay_id() {
                return prepay_id;
            }

            public void setPrepay_id(String prepay_id) {
                this.prepay_id = prepay_id;
            }

            public String getNonceStr() {
                return nonceStr;
            }

            public void setNonceStr(String nonceStr) {
                this.nonceStr = nonceStr;
            }

            public String getTimeStamp() {
                return timeStamp;
            }

            public void setTimeStamp(String timeStamp) {
                this.timeStamp = timeStamp;
            }

            public String getPaySign() {
                return paySign;
            }

            public void setPaySign(String paySign) {
                this.paySign = paySign;
            }

            public String getPackageX() {
                return packageX;
            }

            public void setPackageX(String packageX) {
                this.packageX = packageX;
            }
        }
    }
}
