package com.pinnoocle.fruitindustryoptimization.bean;

import java.util.List;

public class GroupWorkModel {
    /**
     * code : 1
     * msg : success
     * data : {"categoryList":[{"category_id":10030,"name":"干果","parent_id":0,"image_id":0,"sort":100,"wxapp_id":10001,"create_time":"2020-09-09 18:42:13","update_time":"2020-09-09 18:42:13"}]}
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
        private List<CategoryListBean> categoryList;

        public List<CategoryListBean> getCategoryList() {
            return categoryList;
        }

        public void setCategoryList(List<CategoryListBean> categoryList) {
            this.categoryList = categoryList;
        }

        public static class CategoryListBean {
            /**
             * category_id : 10030
             * name : 干果
             * parent_id : 0
             * image_id : 0
             * sort : 100
             * wxapp_id : 10001
             * create_time : 2020-09-09 18:42:13
             * update_time : 2020-09-09 18:42:13
             */

            private int category_id;
            private String name;
            private int parent_id;
            private int image_id;
            private int sort;
            private int wxapp_id;
            private String create_time;
            private String update_time;

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
        }
    }
}
