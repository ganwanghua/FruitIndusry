package com.pinnoocle.fruitindustryoptimization.bean;

public class VipIntroModel {
    /**
     * code : 1
     * msg : success
     * data : {"vip_intro":"<p><img src=\"http://btys.vshop365.cn/uploads/2020102011551893f6c3387.png\"/><\/p><p><br/><\/p>"}
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
         * vip_intro : <p><img src="http://btys.vshop365.cn/uploads/2020102011551893f6c3387.png"/></p><p><br/></p>
         */

        private String vip_intro;

        public String getVip_intro() {
            return vip_intro;
        }

        public void setVip_intro(String vip_intro) {
            this.vip_intro = vip_intro;
        }
    }
}
