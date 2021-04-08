package com.pinnoocle.fruitindustryoptimization.bean;

import java.util.List;

public class FileInfoModel {
    /**
     * code : 1
     * msg :
     * data : {"images":["http://btys.cc/uploads/20210312165816a23500771.png"],"videos":["http://btys.cc/uploads/20210312174027c562f7966.mp4"]}
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
        private List<String> images;
        private List<String> videos;

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public List<String> getVideos() {
            return videos;
        }

        public void setVideos(List<String> videos) {
            this.videos = videos;
        }
    }
}
