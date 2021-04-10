package com.pinnoocle.fruitindustryoptimization.bean;

import java.util.List;

public class CommentBean {

    /**
     * goods_id : 12478
     * order_goods_id : 23304
     * score : 10
     * content : 11
     * image_list : ["http://tmp/fK9p4hxA7Rfc3be9ce1cd2cde8453df66cb49277bddf.gif"]
     * uploaded : ["25212"]
     */

    private int goods_id;
    private int order_goods_id;
    private String score;
    private String content;
    private List<String> image_list;
    private List<String> uploaded;

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getOrder_goods_id() {
        return order_goods_id;
    }

    public void setOrder_goods_id(int order_goods_id) {
        this.order_goods_id = order_goods_id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getImage_list() {
        return image_list;
    }

    public void setImage_list(List<String> image_list) {
        this.image_list = image_list;
    }

    public List<String> getUploaded() {
        return uploaded;
    }

    public void setUploaded(List<String> uploaded) {
        this.uploaded = uploaded;
    }
}
