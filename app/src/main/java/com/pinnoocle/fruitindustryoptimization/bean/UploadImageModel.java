package com.pinnoocle.fruitindustryoptimization.bean;

public class UploadImageModel {

    /**
     * code : 1
     * msg : 图片上传成功
     * data : {"file_id":"25212","file_path":"http://btys.cc/uploads/202103111358579c5680427.gif"}
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
         * file_id : 25212
         * file_path : http://btys.cc/uploads/202103111358579c5680427.gif
         */

        private String file_id;
        private String file_path;

        public String getFile_id() {
            return file_id;
        }

        public void setFile_id(String file_id) {
            this.file_id = file_id;
        }

        public String getFile_path() {
            return file_path;
        }

        public void setFile_path(String file_path) {
            this.file_path = file_path;
        }
    }
}
