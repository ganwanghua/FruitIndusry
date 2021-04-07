package com.pinnoocle.fruitindustryoptimization.bean;

public class CertificateDetailModel {
    /**
     * code : 1
     * msg : success
     * data : {"user_tree_id":411,"name":"11","content":"您于2021年03月10号在新疆生产建设兵团第1师3团已成功认养1棵测试果树，感谢您为兵团消费扶贫增添一份力量！","treeNum":"BTREE171392021MarW","treeComp":"新疆生产建设兵团果业有限公司","treeDate":"2022/03/05到期"}
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
         * user_tree_id : 411
         * name : 11
         * content : 您于2021年03月10号在新疆生产建设兵团第1师3团已成功认养1棵测试果树，感谢您为兵团消费扶贫增添一份力量！
         * treeNum : BTREE171392021MarW
         * treeComp : 新疆生产建设兵团果业有限公司
         * treeDate : 2022/03/05到期
         */

        private int user_tree_id;
        private String name;
        private String content;
        private String treeNum;
        private String treeComp;
        private String treeDate;

        public int getUser_tree_id() {
            return user_tree_id;
        }

        public void setUser_tree_id(int user_tree_id) {
            this.user_tree_id = user_tree_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTreeNum() {
            return treeNum;
        }

        public void setTreeNum(String treeNum) {
            this.treeNum = treeNum;
        }

        public String getTreeComp() {
            return treeComp;
        }

        public void setTreeComp(String treeComp) {
            this.treeComp = treeComp;
        }

        public String getTreeDate() {
            return treeDate;
        }

        public void setTreeDate(String treeDate) {
            this.treeDate = treeDate;
        }
    }
}
