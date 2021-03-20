package com.pinnoocle.fruitindustryoptimization.bean;

public class ArticleModel {
    /**
     * code : 1
     * msg : success
     * data : {"detail":{"article_id":8,"article_title":"团团兵果树认养项目介绍","show_type":20,"category_id":1,"image_id":25096,"article_content":"&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010212152335686b6946.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201021215234efd9d4833.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","article_sort":100,"article_status":1,"virtual_views":3553,"actual_views":189,"image":{"file_id":25096,"storage":"local","group_id":0,"file_url":"","file_name":"20200930181958023e25405.jpg","file_size":206506,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://btys.vshop365.cn/uploads/20200930181958023e25405.jpg"},"category":{"category_id":1,"name":"果树项目","sort":100,"wxapp_id":10001,"create_time":"2020-09-09 18:17:37","update_time":"2020-10-12 10:19:29"},"show_views":3742,"view_time":"2020-10-14"}}
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
         * detail : {"article_id":8,"article_title":"团团兵果树认养项目介绍","show_type":20,"category_id":1,"image_id":25096,"article_content":"&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010212152335686b6946.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201021215234efd9d4833.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;","article_sort":100,"article_status":1,"virtual_views":3553,"actual_views":189,"image":{"file_id":25096,"storage":"local","group_id":0,"file_url":"","file_name":"20200930181958023e25405.jpg","file_size":206506,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://btys.vshop365.cn/uploads/20200930181958023e25405.jpg"},"category":{"category_id":1,"name":"果树项目","sort":100,"wxapp_id":10001,"create_time":"2020-09-09 18:17:37","update_time":"2020-10-12 10:19:29"},"show_views":3742,"view_time":"2020-10-14"}
         */

        private DetailBean detail;

        public DetailBean getDetail() {
            return detail;
        }

        public void setDetail(DetailBean detail) {
            this.detail = detail;
        }

        public static class DetailBean {
            /**
             * article_id : 8
             * article_title : 团团兵果树认养项目介绍
             * show_type : 20
             * category_id : 1
             * image_id : 25096
             * article_content : &lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/202010212152335686b6946.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;img src=&quot;http://btys.vshop365.cn/uploads/20201021215234efd9d4833.jpg&quot;/&gt;&lt;/p&gt;&lt;p&gt;&lt;br/&gt;&lt;/p&gt;
             * article_sort : 100
             * article_status : 1
             * virtual_views : 3553
             * actual_views : 189
             * image : {"file_id":25096,"storage":"local","group_id":0,"file_url":"","file_name":"20200930181958023e25405.jpg","file_size":206506,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://btys.vshop365.cn/uploads/20200930181958023e25405.jpg"}
             * category : {"category_id":1,"name":"果树项目","sort":100,"wxapp_id":10001,"create_time":"2020-09-09 18:17:37","update_time":"2020-10-12 10:19:29"}
             * show_views : 3742
             * view_time : 2020-10-14
             */

            private int article_id;
            private String article_title;
            private int show_type;
            private int category_id;
            private int image_id;
            private String article_content;
            private int article_sort;
            private int article_status;
            private int virtual_views;
            private int actual_views;
            private ImageBean image;
            private CategoryBean category;
            private int show_views;
            private String view_time;

            public int getArticle_id() {
                return article_id;
            }

            public void setArticle_id(int article_id) {
                this.article_id = article_id;
            }

            public String getArticle_title() {
                return article_title;
            }

            public void setArticle_title(String article_title) {
                this.article_title = article_title;
            }

            public int getShow_type() {
                return show_type;
            }

            public void setShow_type(int show_type) {
                this.show_type = show_type;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public int getImage_id() {
                return image_id;
            }

            public void setImage_id(int image_id) {
                this.image_id = image_id;
            }

            public String getArticle_content() {
                return article_content;
            }

            public void setArticle_content(String article_content) {
                this.article_content = article_content;
            }

            public int getArticle_sort() {
                return article_sort;
            }

            public void setArticle_sort(int article_sort) {
                this.article_sort = article_sort;
            }

            public int getArticle_status() {
                return article_status;
            }

            public void setArticle_status(int article_status) {
                this.article_status = article_status;
            }

            public int getVirtual_views() {
                return virtual_views;
            }

            public void setVirtual_views(int virtual_views) {
                this.virtual_views = virtual_views;
            }

            public int getActual_views() {
                return actual_views;
            }

            public void setActual_views(int actual_views) {
                this.actual_views = actual_views;
            }

            public ImageBean getImage() {
                return image;
            }

            public void setImage(ImageBean image) {
                this.image = image;
            }

            public CategoryBean getCategory() {
                return category;
            }

            public void setCategory(CategoryBean category) {
                this.category = category;
            }

            public int getShow_views() {
                return show_views;
            }

            public void setShow_views(int show_views) {
                this.show_views = show_views;
            }

            public String getView_time() {
                return view_time;
            }

            public void setView_time(String view_time) {
                this.view_time = view_time;
            }

            public static class ImageBean {
                /**
                 * file_id : 25096
                 * storage : local
                 * group_id : 0
                 * file_url :
                 * file_name : 20200930181958023e25405.jpg
                 * file_size : 206506
                 * file_type : image
                 * extension : jpg
                 * is_user : 0
                 * is_recycle : 0
                 * is_delete : 0
                 * file_path : http://btys.vshop365.cn/uploads/20200930181958023e25405.jpg
                 */

                private int file_id;
                private String storage;
                private int group_id;
                private String file_url;
                private String file_name;
                private int file_size;
                private String file_type;
                private String extension;
                private int is_user;
                private int is_recycle;
                private int is_delete;
                private String file_path;

                public int getFile_id() {
                    return file_id;
                }

                public void setFile_id(int file_id) {
                    this.file_id = file_id;
                }

                public String getStorage() {
                    return storage;
                }

                public void setStorage(String storage) {
                    this.storage = storage;
                }

                public int getGroup_id() {
                    return group_id;
                }

                public void setGroup_id(int group_id) {
                    this.group_id = group_id;
                }

                public String getFile_url() {
                    return file_url;
                }

                public void setFile_url(String file_url) {
                    this.file_url = file_url;
                }

                public String getFile_name() {
                    return file_name;
                }

                public void setFile_name(String file_name) {
                    this.file_name = file_name;
                }

                public int getFile_size() {
                    return file_size;
                }

                public void setFile_size(int file_size) {
                    this.file_size = file_size;
                }

                public String getFile_type() {
                    return file_type;
                }

                public void setFile_type(String file_type) {
                    this.file_type = file_type;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public int getIs_user() {
                    return is_user;
                }

                public void setIs_user(int is_user) {
                    this.is_user = is_user;
                }

                public int getIs_recycle() {
                    return is_recycle;
                }

                public void setIs_recycle(int is_recycle) {
                    this.is_recycle = is_recycle;
                }

                public int getIs_delete() {
                    return is_delete;
                }

                public void setIs_delete(int is_delete) {
                    this.is_delete = is_delete;
                }

                public String getFile_path() {
                    return file_path;
                }

                public void setFile_path(String file_path) {
                    this.file_path = file_path;
                }
            }

            public static class CategoryBean {
                /**
                 * category_id : 1
                 * name : 果树项目
                 * sort : 100
                 * wxapp_id : 10001
                 * create_time : 2020-09-09 18:17:37
                 * update_time : 2020-10-12 10:19:29
                 */

                private int category_id;
                private String name;
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
}
