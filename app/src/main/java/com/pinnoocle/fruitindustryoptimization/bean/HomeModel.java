package com.pinnoocle.fruitindustryoptimization.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.pinnoocle.fruitindustryoptimization.adapter.RawStringJsonAdapter;

import java.util.List;

public class HomeModel {

    /**
     * code : 1
     * msg : success
     * data : {"page":{"type":"page","name":"页面设置","params":{"name":"兵团优选","title":"兵团优选","share_title":"兵团优选"},"style":{"titleTextColor":"white","titleBackgroundColor":"#d20000"}},"items":[{"name":"辅助线","type":"guide","style":{"background":"#ffffff","lineStyle":"solid","lineHeight":"1","lineColor":"#000000","paddingTop":"0"}},{"name":"搜索框","type":"search","params":{"placeholder":"搜索","address":"西湖国际广场A座1608"},"style":{"textAlign":"center","searchStyle":"round","address":true,"avatar":true,"bgColor":"#f65353"}},{"name":"图片轮播","type":"banner","style":{"btnColor":"#ffffff","btnShape":"round","borderRadius":"0"},"params":{"interval":"5000"},"data":[{"imgUrl":"http://btys.vshop365.cn/uploads/20200924115726f1e1a7005.jpg","linkUrl":"pages/tree/indexup/indexup"},{"imgUrl":"http://btys.vshop365.cn/uploads/202009241257367f26b4302.jpg","linkUrl":"pages/category/list"},{"imgUrl":"http://btys.vshop365.cn/uploads/20201015181701f4bea2457.jpg","linkUrl":"pages/article/detail/index?article_id=8"},{"imgUrl":"http://btys.vshop365.cn/uploads/2020093018124213ea24876.jpg","linkUrl":"pages/tree/indexup/indexup"}]},{"name":"导航组","type":"navBar","style":{"background":"#ffffff","rowsNum":"4","showPic":"1"},"data":[{"imgUrl":"http://btys.vshop365.cn/uploads/20200922162853e4f022192.png","imgName":"icon-1.png","linkUrl":"pages/tree/indexup/indexup","text":"果树认养","color":"#666666"},{"imgUrl":"http://btys.vshop365.cn/uploads/2020092216290344c3d7822.png","imgName":"icon-2.jpg","linkUrl":"pages/bargain/index/index","text":"秒杀助力","color":"#666666"},{"imgUrl":"http://btys.vshop365.cn/uploads/202009221629137acae2032.png","imgName":"icon-3.jpg","linkUrl":"pages/sharing/index/index","text":"团购好货","color":"#666666"},{"imgUrl":"http://btys.vshop365.cn/uploads/20200922162920433248070.png","imgName":"icon-4.jpg","linkUrl":"pages/discount/discount","text":"会员介绍","color":"#666666"}]},{"name":"头条快报","type":"special","params":{"source":"auto","auto":{"category":1,"showNum":6}},"style":{"display":"1","image":"http://btys.vshop365.cn/assets/store/img/diy/special.png"},"defaultData":[{"article_title":"张小龙4小时演讲：你和高手之间，隔着\u201c简单\u201d二字"},{"article_title":"张小龙4小时演讲：你和高手之间，隔着\u201c简单\u201d二字"}],"data":[{"article_id":8,"article_title":"团团兵果树认养项目介绍","show_type":20,"category_id":1,"image_id":25096,"article_sort":100,"article_status":1,"virtual_views":3553,"actual_views":185,"image":{"file_id":25096,"storage":"local","group_id":0,"file_url":"","file_name":"20200930181958023e25405.jpg","file_size":206506,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://btys.vshop365.cn/uploads/20200930181958023e25405.jpg"},"category":{"category_id":1,"name":"果树项目","sort":100,"wxapp_id":10001,"create_time":"2020-09-09 18:17:37","update_time":"2020-10-12 10:19:29"},"show_views":3738,"view_time":"2020-10-14"}]},{"name":"视频组","type":"video","params":{"videoUrl":"a3156b96p2k","poster":"http://btys.vshop365.cn/assets/store/img/diy/video_poster.png","autoplay":"1","vid":"a3156b96p2k"},"style":{"paddingTop":"0","height":"214"}},{"name":"单图组","type":"imageSingle","style":{"paddingTop":"0","paddingLeft":"17","borderRadius":"0","background":"#ffffff"},"data":[{"imgUrl":"http://btys.vshop365.cn/uploads/20200916172341af0329589.jpg","imgName":"image-1.jpg","linkUrl":"pages/category/list"}]},{"name":"秒杀商品组","type":"secKillGoods","params":{"source":"choice","auto":{"category":0,"goodsSort":"all","showNum":6}},"style":{"background":"#F6F6F6","show":{"secKillPrice":"1","goodsName":"1","linePrice":false}},"defaultData":[{"goods_image":"http://shop.liankebao.net/assets/store/img/diy/goods/01.png","goods_name":"此处是秒杀商品","sec_kill_price":"99.00","line_price":"139.00"},{"goods_image":"http://shop.liankebao.net/assets/store/img/diy/goods/01.png","goods_name":"此处是秒杀商品","goods_price":"99.00","line_price":"139.00"},{"goods_image":"http://shop.liankebao.net/assets/store/img/diy/goods/01.png","goods_name":"此处是秒杀商品","sec_kill_price":"99.00","line_price":"139.00"},{"goods_image":"http://shop.liankebao.net/assets/store/img/diy/goods/01.png","goods_name":"此处是秒杀商品","sec_kill_price":"99.00","line_price":"139.00"}],"data":[{"goods_image":"http://shop.liankebao.net/assets/store/img/diy/goods/01.png","goods_name":"此处是秒杀商品","sec_kill_price":"99.00","line_price":"139.00","is_default":true}]},{"name":"在线客服","type":"service","params":{"type":"chat","image":"http://btys.vshop365.cn/uploads/202009241603101a9589156.png","phone_num":""},"style":{"right":"0","bottom":"11","opacity":"100"}},{"name":"商品组","type":"goods","params":{"source":"auto","auto":{"category":10515,"goodsSort":"price","showNum":"100"}},"style":{"background":"#F6F6F6","price_color":"#F03C3C","cart_color":"#ff8040","selling_point_color":"#FF495E","display":"list","column":"2","show":{"goodsName":true,"goodsPrice":true,"linePrice":true,"sellingPoint":false,"goodsSales":false,"goodsStock":false,"shoppingCart":true}},"defaultData":[{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"6"},{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"66"},{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"666"},{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"999"}],"data":[{"goods_id":12439,"goods_name":"兵团大地果之粹红枣礼盒","selling_point":"物美价廉","image":"http://btys.vshop365.cn/uploads/202009081646084f1910130.jpg","goods_image":"http://btys.vshop365.cn/uploads/202009081646084f1910130.jpg","goods_price":"120.00","goods_old_price":"120.00","line_price":"0.00","goods_sales":1,"goods_stock":221,"spec_type":10,"goods_sku":{"goods_sku_id":33756,"goods_id":12439,"spec_sku_id":"0","image_id":0,"goods_no":"566464","balance_price":"0.00","goods_price":"120.00","line_price":"0.00","stock_num":221,"goods_sales":1,"goods_weight":1.5,"goods_old_price":"120.00","image":null},"goods_multi_spec":null},{"goods_id":12477,"goods_name":"兵团大地干果礼盒2.1kg","selling_point":"","image":"http://btys.vshop365.cn/uploads/202010291636137eec53445.jpg","goods_image":"http://btys.vshop365.cn/uploads/202010291636137eec53445.jpg","goods_price":"138.00","goods_old_price":"138.00","line_price":"0.00","goods_sales":0,"goods_stock":2000,"spec_type":10,"goods_sku":{"goods_sku_id":33783,"goods_id":12477,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"138.00","line_price":"0.00","stock_num":2000,"goods_sales":0,"goods_weight":2.1,"goods_old_price":"138.00","image":null},"goods_multi_spec":null},{"goods_id":12469,"goods_name":"兵团大地小兵坚果礼盒750g","selling_point":"营养丰富口感好","image":"http://btys.vshop365.cn/uploads/2020090816231978dc05966.png","goods_image":"http://btys.vshop365.cn/uploads/2020090816231978dc05966.png","goods_price":"148.00","goods_old_price":"148.00","line_price":"0.00","goods_sales":0,"goods_stock":789,"spec_type":10,"goods_sku":{"goods_sku_id":33728,"goods_id":12469,"spec_sku_id":"0","image_id":0,"goods_no":"131646","balance_price":"0.00","goods_price":"148.00","line_price":"0.00","stock_num":789,"goods_sales":0,"goods_weight":0.75,"goods_old_price":"148.00","image":null},"goods_multi_spec":null},{"goods_id":12457,"goods_name":"兵团大地新疆坚果大礼盒过节送礼首选礼包","selling_point":"","image":"http://btys.vshop365.cn/uploads/20200909104706bf6331925.jpg","goods_image":"http://btys.vshop365.cn/uploads/20200909104706bf6331925.jpg","goods_price":"158.00","goods_old_price":"158.00","line_price":"0.00","goods_sales":5,"goods_stock":994,"spec_type":10,"goods_sku":{"goods_sku_id":33733,"goods_id":12457,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"158.00","line_price":"0.00","stock_num":994,"goods_sales":5,"goods_weight":1.91,"goods_old_price":"158.00","image":null},"goods_multi_spec":null},{"goods_id":12476,"goods_name":"团团兵红花籽油2*500ml","selling_point":"","image":"http://btys.vshop365.cn/uploads/20201022130347d14211500.jpg","goods_image":"http://btys.vshop365.cn/uploads/20201022130347d14211500.jpg","goods_price":"198.00","goods_old_price":"198.00","line_price":"0.00","goods_sales":0,"goods_stock":2000,"spec_type":10,"goods_sku":{"goods_sku_id":33775,"goods_id":12476,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"198.00","line_price":"0.00","stock_num":2000,"goods_sales":0,"goods_weight":0.05,"goods_old_price":"198.00","image":null},"goods_multi_spec":null},{"goods_id":12438,"goods_name":"兵团大地果之粹坚果系列礼盒","selling_point":"物美价廉","image":"http://btys.vshop365.cn/uploads/202009081642503d0542293.jpg","goods_image":"http://btys.vshop365.cn/uploads/202009081642503d0542293.jpg","goods_price":"245.00","goods_old_price":"245.00","line_price":"0.00","goods_sales":0,"goods_stock":999,"spec_type":10,"goods_sku":{"goods_sku_id":33757,"goods_id":12438,"spec_sku_id":"0","image_id":0,"goods_no":"123456","balance_price":"0.00","goods_price":"245.00","line_price":"0.00","stock_num":999,"goods_sales":0,"goods_weight":1,"goods_old_price":"245.00","image":null},"goods_multi_spec":null},{"goods_id":12467,"goods_name":"兵团大地光辉岁月特产礼盒","selling_point":"","image":"http://btys.vshop365.cn/uploads/20200909113457adc023792.png","goods_image":"http://btys.vshop365.cn/uploads/20200909113457adc023792.png","goods_price":"298.00","goods_old_price":"298.00","line_price":"0.00","goods_sales":0,"goods_stock":3281,"spec_type":10,"goods_sku":{"goods_sku_id":33730,"goods_id":12467,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"298.00","line_price":"0.00","stock_num":3281,"goods_sales":0,"goods_weight":2.27,"goods_old_price":"298.00","image":null},"goods_multi_spec":null}]},{"name":"商品组","type":"goods","params":{"source":"auto","auto":{"category":10514,"goodsSort":"all","showNum":6}},"style":{"background":"#F6F6F6","price_color":"#F03C3C","cart_color":"#ff8000","selling_point_color":"#FF495E","display":"list","column":"2","show":{"goodsName":true,"goodsPrice":true,"linePrice":true,"sellingPoint":false,"goodsSales":false,"goodsStock":false,"shoppingCart":true}},"defaultData":[{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"6"},{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"66"},{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"666"},{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"999"}],"data":[{"goods_id":12461,"goods_name":"兵团大地罐装瓜子220g","selling_point":"新疆特产","image":"http://btys.vshop365.cn/uploads/20200909110858102577370.png","goods_image":"http://btys.vshop365.cn/uploads/20200909110858102577370.png","goods_price":"25.80","goods_old_price":"25.80","line_price":"0.00","goods_sales":0,"goods_stock":282,"spec_type":10,"goods_sku":{"goods_sku_id":33737,"goods_id":12461,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"25.80","line_price":"0.00","stock_num":282,"goods_sales":0,"goods_weight":0.22,"goods_old_price":"25.80","image":null},"goods_multi_spec":null},{"goods_id":12453,"goods_name":"兵团大地原味瓜子180g4袋","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009081902350a5184493.png","goods_image":"http://btys.vshop365.cn/uploads/202009081902350a5184493.png","goods_price":"38.00","goods_old_price":"38.00","line_price":"0.00","goods_sales":11,"goods_stock":984,"spec_type":10,"goods_sku":{"goods_sku_id":33744,"goods_id":12453,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"38.00","line_price":"0.00","stock_num":984,"goods_sales":11,"goods_weight":0.18,"goods_old_price":"38.00","image":null},"goods_multi_spec":null}]},{"name":"商品组","type":"goods","params":{"source":"auto","auto":{"category":10511,"goodsSort":"price","showNum":"50"}},"style":{"background":"#F6F6F6","price_color":"#F03C3C","cart_color":"#ff8000","selling_point_color":"#FF495E","display":"list","column":"2","show":{"goodsName":true,"goodsPrice":true,"linePrice":true,"sellingPoint":false,"goodsSales":false,"goodsStock":false,"shoppingCart":true}},"defaultData":[{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"6"},{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"66"},{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"666"},{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"999"}],"data":[{"goods_id":12446,"goods_name":"兵团大地男人香葡萄干120g","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009251612296e3d43587.jpg","goods_image":"http://btys.vshop365.cn/uploads/202009251612296e3d43587.jpg","goods_price":"9.90","goods_old_price":"9.90","line_price":"0.00","goods_sales":1,"goods_stock":3231,"spec_type":10,"goods_sku":{"goods_sku_id":33750,"goods_id":12446,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"9.90","line_price":"0.00","stock_num":3231,"goods_sales":1,"goods_weight":0.12,"goods_old_price":"9.90","image":null},"goods_multi_spec":null},{"goods_id":12447,"goods_name":"兵团大地女人香葡萄干120g","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009251611258424a3121.jpg","goods_image":"http://btys.vshop365.cn/uploads/202009251611258424a3121.jpg","goods_price":"9.90","goods_old_price":"9.90","line_price":"0.00","goods_sales":1,"goods_stock":2400,"spec_type":10,"goods_sku":{"goods_sku_id":33749,"goods_id":12447,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"9.90","line_price":"0.00","stock_num":2400,"goods_sales":1,"goods_weight":0.12,"goods_old_price":"9.90","image":null},"goods_multi_spec":null},{"goods_id":12448,"goods_name":"兵团大地黑加仑葡萄干120g","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009251610403d4df5802.jpg","goods_image":"http://btys.vshop365.cn/uploads/202009251610403d4df5802.jpg","goods_price":"9.90","goods_old_price":"9.90","line_price":"0.00","goods_sales":0,"goods_stock":2289,"spec_type":10,"goods_sku":{"goods_sku_id":33748,"goods_id":12448,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"9.90","line_price":"0.00","stock_num":2289,"goods_sales":0,"goods_weight":0.12,"goods_old_price":"9.90","image":null},"goods_multi_spec":null},{"goods_id":12449,"goods_name":"兵团大地香喀什葡萄干","selling_point":"","image":"http://btys.vshop365.cn/uploads/20200925160956486c40175.jpg","goods_image":"http://btys.vshop365.cn/uploads/20200925160956486c40175.jpg","goods_price":"9.90","goods_old_price":"9.90","line_price":"0.00","goods_sales":0,"goods_stock":3238,"spec_type":10,"goods_sku":{"goods_sku_id":33751,"goods_id":12449,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"9.90","line_price":"0.00","stock_num":3238,"goods_sales":0,"goods_weight":0.12,"goods_old_price":"9.90","image":null},"goods_multi_spec":null},{"goods_id":12451,"goods_name":"兵团大地红玛瑙葡萄干","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009251608206a8d93568.jpg","goods_image":"http://btys.vshop365.cn/uploads/202009251608206a8d93568.jpg","goods_price":"9.90","goods_old_price":"9.90","line_price":"0.00","goods_sales":0,"goods_stock":1549,"spec_type":10,"goods_sku":{"goods_sku_id":33746,"goods_id":12451,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"9.90","line_price":"0.00","stock_num":1549,"goods_sales":0,"goods_weight":0.12,"goods_old_price":"9.90","image":null},"goods_multi_spec":null},{"goods_id":12474,"goods_name":"兵团大地无核白葡萄干120g","selling_point":"货源火爆预定中！提早下单，优先备货！","image":"http://btys.vshop365.cn/uploads/20200925161332e88273839.jpg","goods_image":"http://btys.vshop365.cn/uploads/20200925161332e88273839.jpg","goods_price":"9.90","goods_old_price":"9.90","line_price":"0.00","goods_sales":4,"goods_stock":2297,"spec_type":10,"goods_sku":{"goods_sku_id":33762,"goods_id":12474,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"9.90","line_price":"0.00","stock_num":2297,"goods_sales":3,"goods_weight":0.12,"goods_old_price":"9.90","image":null},"goods_multi_spec":null},{"goods_id":12450,"goods_name":"兵团大地红香妃","selling_point":"","image":"http://btys.vshop365.cn/uploads/20200925160909b55140600.jpg","goods_image":"http://btys.vshop365.cn/uploads/20200925160909b55140600.jpg","goods_price":"12.80","goods_old_price":"12.80","line_price":"0.00","goods_sales":3,"goods_stock":2097,"spec_type":10,"goods_sku":{"goods_sku_id":33747,"goods_id":12450,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"12.80","line_price":"0.00","stock_num":2097,"goods_sales":3,"goods_weight":0.12,"goods_old_price":"12.80","image":null},"goods_multi_spec":null},{"goods_id":12452,"goods_name":"兵团大地绿香妃葡萄干","selling_point":"","image":"http://btys.vshop365.cn/uploads/20200925160411f9cc82992.jpg","goods_image":"http://btys.vshop365.cn/uploads/20200925160411f9cc82992.jpg","goods_price":"14.80","goods_old_price":"14.80","line_price":"0.00","goods_sales":5,"goods_stock":2487,"spec_type":10,"goods_sku":{"goods_sku_id":33745,"goods_id":12452,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"14.80","line_price":"0.00","stock_num":2487,"goods_sales":5,"goods_weight":0.12,"goods_old_price":"14.80","image":null},"goods_multi_spec":null},{"goods_id":12443,"goods_name":"兵团大地吊树干杏","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009081752020838d8523.png","goods_image":"http://btys.vshop365.cn/uploads/202009081752020838d8523.png","goods_price":"20.80","goods_old_price":"20.80","line_price":"0.00","goods_sales":3,"goods_stock":2280,"spec_type":10,"goods_sku":{"goods_sku_id":33754,"goods_id":12443,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"20.80","line_price":"0.00","stock_num":2280,"goods_sales":3,"goods_weight":0.24,"goods_old_price":"20.80","image":null},"goods_multi_spec":null},{"goods_id":12454,"goods_name":"兵团大地灰枣夹核桃仁260g","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009081914509db049832.png","goods_image":"http://btys.vshop365.cn/uploads/202009081914509db049832.png","goods_price":"25.80","goods_old_price":"25.80","line_price":"0.00","goods_sales":4,"goods_stock":11996,"spec_type":10,"goods_sku":{"goods_sku_id":33743,"goods_id":12454,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"25.80","line_price":"0.00","stock_num":11996,"goods_sales":4,"goods_weight":0.26,"goods_old_price":"25.80","image":null},"goods_multi_spec":null},{"goods_id":12464,"goods_name":"兵团大地光辉单品若羌灰枣350g","selling_point":"","image":"http://btys.vshop365.cn/uploads/2020090911241346d069876.jpg","goods_image":"http://btys.vshop365.cn/uploads/2020090911241346d069876.jpg","goods_price":"26.80","goods_old_price":"26.80","line_price":"0.00","goods_sales":0,"goods_stock":8450,"spec_type":10,"goods_sku":{"goods_sku_id":33740,"goods_id":12464,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"26.80","line_price":"0.00","stock_num":8450,"goods_sales":0,"goods_weight":0.35,"goods_old_price":"26.80","image":null},"goods_multi_spec":null},{"goods_id":12465,"goods_name":"兵团大地光辉单品薄皮核桃","selling_point":"","image":"http://btys.vshop365.cn/uploads/2020090911285533c235809.jpg","goods_image":"http://btys.vshop365.cn/uploads/2020090911285533c235809.jpg","goods_price":"29.80","goods_old_price":"29.80","line_price":"0.00","goods_sales":0,"goods_stock":3623,"spec_type":10,"goods_sku":{"goods_sku_id":33732,"goods_id":12465,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"29.80","line_price":"0.00","stock_num":3623,"goods_sales":0,"goods_weight":0.27,"goods_old_price":"29.80","image":null},"goods_multi_spec":null},{"goods_id":12466,"goods_name":"兵团大地光辉单品和田骏枣250g","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009091131563241b8882.jpg","goods_image":"http://btys.vshop365.cn/uploads/202009091131563241b8882.jpg","goods_price":"29.80","goods_old_price":"29.80","line_price":"0.00","goods_sales":0,"goods_stock":5261,"spec_type":10,"goods_sku":{"goods_sku_id":33731,"goods_id":12466,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"29.80","line_price":"0.00","stock_num":5261,"goods_sales":0,"goods_weight":0.25,"goods_old_price":"29.80","image":null},"goods_multi_spec":null},{"goods_id":12458,"goods_name":"兵团大地红枸杞","selling_point":"新疆特产","image":"http://btys.vshop365.cn/uploads/20200909105220df3ac9927.png","goods_image":"http://btys.vshop365.cn/uploads/20200909105220df3ac9927.png","goods_price":"32.00","goods_old_price":"32.00","line_price":"0.00","goods_sales":0,"goods_stock":4244,"spec_type":10,"goods_sku":{"goods_sku_id":33734,"goods_id":12458,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"32.00","line_price":"0.00","stock_num":4244,"goods_sales":0,"goods_weight":0.18,"goods_old_price":"32.00","image":null},"goods_multi_spec":null},{"goods_id":12445,"goods_name":"兵团大地无花果干","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009081825090f69f6912.jpg","goods_image":"http://btys.vshop365.cn/uploads/202009081825090f69f6912.jpg","goods_price":"32.80","goods_old_price":"32.80","line_price":"0.00","goods_sales":2,"goods_stock":2108,"spec_type":10,"goods_sku":{"goods_sku_id":33752,"goods_id":12445,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"32.80","line_price":"0.00","stock_num":2108,"goods_sales":2,"goods_weight":0.21,"goods_old_price":"32.80","image":null},"goods_multi_spec":null},{"goods_id":12444,"goods_name":"兵团大地原味巴旦木","selling_point":"","image":"http://btys.vshop365.cn/uploads/20200908182111f977b0473.png","goods_image":"http://btys.vshop365.cn/uploads/20200908182111f977b0473.png","goods_price":"35.60","goods_old_price":"35.60","line_price":"0.00","goods_sales":2,"goods_stock":2278,"spec_type":10,"goods_sku":{"goods_sku_id":33753,"goods_id":12444,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"35.60","line_price":"0.00","stock_num":2278,"goods_sales":2,"goods_weight":0.21,"goods_old_price":"35.60","image":null},"goods_multi_spec":null},{"goods_id":12442,"goods_name":"兵团大地薄皮核桃","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009081748259fa347422.jpg","goods_image":"http://btys.vshop365.cn/uploads/202009081748259fa347422.jpg","goods_price":"36.00","goods_old_price":"36.00","line_price":"0.00","goods_sales":0,"goods_stock":2281,"spec_type":10,"goods_sku":{"goods_sku_id":33755,"goods_id":12442,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"36.00","line_price":"0.00","stock_num":2281,"goods_sales":0,"goods_weight":0.21,"goods_old_price":"36.00","image":null},"goods_multi_spec":null},{"goods_id":12462,"goods_name":"兵团大地新疆特产光辉单品吊树干杏500g","selling_point":"新疆特产","image":"http://btys.vshop365.cn/uploads/20200909111731db80c3053.jpg","goods_image":"http://btys.vshop365.cn/uploads/20200909111731db80c3053.jpg","goods_price":"51.80","goods_old_price":"51.80","line_price":"0.00","goods_sales":0,"goods_stock":3216,"spec_type":10,"goods_sku":{"goods_sku_id":33738,"goods_id":12462,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"51.80","line_price":"0.00","stock_num":3216,"goods_sales":0,"goods_weight":0.5,"goods_old_price":"51.80","image":null},"goods_multi_spec":null},{"goods_id":12459,"goods_name":"兵团大地新疆特产黑枸杞","selling_point":"新疆特产","image":"http://btys.vshop365.cn/uploads/20200909105438ef8402176.png","goods_image":"http://btys.vshop365.cn/uploads/20200909105438ef8402176.png","goods_price":"59.00","goods_old_price":"59.00","line_price":"0.00","goods_sales":0,"goods_stock":3609,"spec_type":10,"goods_sku":{"goods_sku_id":33735,"goods_id":12459,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"59.00","line_price":"0.00","stock_num":3609,"goods_sales":0,"goods_weight":0.125,"goods_old_price":"59.00","image":null},"goods_multi_spec":null},{"goods_id":12468,"goods_name":"兵团大地高寒蜂蜜500g","selling_point":"","image":"http://btys.vshop365.cn/uploads/20200909114743309041451.png","goods_image":"http://btys.vshop365.cn/uploads/20200909114743309041451.png","goods_price":"65.00","goods_old_price":"65.00","line_price":"0.00","goods_sales":0,"goods_stock":3231,"spec_type":10,"goods_sku":{"goods_sku_id":33729,"goods_id":12468,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"65.00","line_price":"0.00","stock_num":3231,"goods_sales":0,"goods_weight":0.5,"goods_old_price":"65.00","image":null},"goods_multi_spec":null},{"goods_id":12463,"goods_name":"兵团大地光辉单品原味巴旦木400g","selling_point":"","image":"http://btys.vshop365.cn/uploads/20200909111934274721923.jpg","goods_image":"http://btys.vshop365.cn/uploads/20200909111934274721923.jpg","goods_price":"79.60","goods_old_price":"79.60","line_price":"0.00","goods_sales":0,"goods_stock":5264,"spec_type":10,"goods_sku":{"goods_sku_id":33739,"goods_id":12463,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"79.60","line_price":"0.00","stock_num":5264,"goods_sales":0,"goods_weight":0.4,"goods_old_price":"79.60","image":null},"goods_multi_spec":null},{"goods_id":12440,"goods_name":"兵团大地小兵坚果礼盒750g","selling_point":"营养丰富口感好","image":"http://btys.vshop365.cn/uploads/2020090816231978dc05966.png","goods_image":"http://btys.vshop365.cn/uploads/2020090816231978dc05966.png","goods_price":"148.00","goods_old_price":"148.00","line_price":"0.00","goods_sales":0,"goods_stock":789,"spec_type":10,"goods_sku":{"goods_sku_id":33662,"goods_id":12440,"spec_sku_id":"0","image_id":0,"goods_no":"131646","balance_price":"0.00","goods_price":"148.00","line_price":"0.00","stock_num":789,"goods_sales":0,"goods_weight":0.75,"goods_old_price":"148.00","image":null},"goods_multi_spec":null}]},{"name":"线下门店","type":"shop","params":{"source":"choice","auto":{"showNum":6}},"style":[],"defaultData":[{"shop_name":"此处显示门店名称","logo_image":"http://btys.vshop365.cn/assets/store/img/diy/circular.png","phone":"010-6666666","region":{"province":"xx省","city":"xx市","region":"xx区"},"address":"xx街道"},{"shop_name":"此处显示门店名称","logo_image":"http://btys.vshop365.cn/assets/store/img/diy/circular.png","phone":"010-6666666","region":{"province":"xx省","city":"xx市","region":"xx区"},"address":"xx街道"}],"data":[{"shop_id":10021,"shop_name":"兵团果业红山路店","logo_image":"http://btys.vshop365.cn/uploads/20201009162126c8e0c4730.jpg","phone":"0991-8862707","region":{"province":"新疆维吾尔自治区","city":"乌鲁木齐市","region":"天山区"},"address":"乌鲁木齐市天山区红山路120号"}]}]}
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
         * page : {"type":"page","name":"页面设置","params":{"name":"兵团优选","title":"兵团优选","share_title":"兵团优选"},"style":{"titleTextColor":"white","titleBackgroundColor":"#d20000"}}
         * items : [{"name":"辅助线","type":"guide","style":{"background":"#ffffff","lineStyle":"solid","lineHeight":"1","lineColor":"#000000","paddingTop":"0"}},{"name":"搜索框","type":"search","params":{"placeholder":"搜索","address":"西湖国际广场A座1608"},"style":{"textAlign":"center","searchStyle":"round","address":true,"avatar":true,"bgColor":"#f65353"}},{"name":"图片轮播","type":"banner","style":{"btnColor":"#ffffff","btnShape":"round","borderRadius":"0"},"params":{"interval":"5000"},"data":[{"imgUrl":"http://btys.vshop365.cn/uploads/20200924115726f1e1a7005.jpg","linkUrl":"pages/tree/indexup/indexup"},{"imgUrl":"http://btys.vshop365.cn/uploads/202009241257367f26b4302.jpg","linkUrl":"pages/category/list"},{"imgUrl":"http://btys.vshop365.cn/uploads/20201015181701f4bea2457.jpg","linkUrl":"pages/article/detail/index?article_id=8"},{"imgUrl":"http://btys.vshop365.cn/uploads/2020093018124213ea24876.jpg","linkUrl":"pages/tree/indexup/indexup"}]},{"name":"导航组","type":"navBar","style":{"background":"#ffffff","rowsNum":"4","showPic":"1"},"data":[{"imgUrl":"http://btys.vshop365.cn/uploads/20200922162853e4f022192.png","imgName":"icon-1.png","linkUrl":"pages/tree/indexup/indexup","text":"果树认养","color":"#666666"},{"imgUrl":"http://btys.vshop365.cn/uploads/2020092216290344c3d7822.png","imgName":"icon-2.jpg","linkUrl":"pages/bargain/index/index","text":"秒杀助力","color":"#666666"},{"imgUrl":"http://btys.vshop365.cn/uploads/202009221629137acae2032.png","imgName":"icon-3.jpg","linkUrl":"pages/sharing/index/index","text":"团购好货","color":"#666666"},{"imgUrl":"http://btys.vshop365.cn/uploads/20200922162920433248070.png","imgName":"icon-4.jpg","linkUrl":"pages/discount/discount","text":"会员介绍","color":"#666666"}]},{"name":"头条快报","type":"special","params":{"source":"auto","auto":{"category":1,"showNum":6}},"style":{"display":"1","image":"http://btys.vshop365.cn/assets/store/img/diy/special.png"},"defaultData":[{"article_title":"张小龙4小时演讲：你和高手之间，隔着\u201c简单\u201d二字"},{"article_title":"张小龙4小时演讲：你和高手之间，隔着\u201c简单\u201d二字"}],"data":[{"article_id":8,"article_title":"团团兵果树认养项目介绍","show_type":20,"category_id":1,"image_id":25096,"article_sort":100,"article_status":1,"virtual_views":3553,"actual_views":185,"image":{"file_id":25096,"storage":"local","group_id":0,"file_url":"","file_name":"20200930181958023e25405.jpg","file_size":206506,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://btys.vshop365.cn/uploads/20200930181958023e25405.jpg"},"category":{"category_id":1,"name":"果树项目","sort":100,"wxapp_id":10001,"create_time":"2020-09-09 18:17:37","update_time":"2020-10-12 10:19:29"},"show_views":3738,"view_time":"2020-10-14"}]},{"name":"视频组","type":"video","params":{"videoUrl":"a3156b96p2k","poster":"http://btys.vshop365.cn/assets/store/img/diy/video_poster.png","autoplay":"1","vid":"a3156b96p2k"},"style":{"paddingTop":"0","height":"214"}},{"name":"单图组","type":"imageSingle","style":{"paddingTop":"0","paddingLeft":"17","borderRadius":"0","background":"#ffffff"},"data":[{"imgUrl":"http://btys.vshop365.cn/uploads/20200916172341af0329589.jpg","imgName":"image-1.jpg","linkUrl":"pages/category/list"}]},{"name":"秒杀商品组","type":"secKillGoods","params":{"source":"choice","auto":{"category":0,"goodsSort":"all","showNum":6}},"style":{"background":"#F6F6F6","show":{"secKillPrice":"1","goodsName":"1","linePrice":false}},"defaultData":[{"goods_image":"http://shop.liankebao.net/assets/store/img/diy/goods/01.png","goods_name":"此处是秒杀商品","sec_kill_price":"99.00","line_price":"139.00"},{"goods_image":"http://shop.liankebao.net/assets/store/img/diy/goods/01.png","goods_name":"此处是秒杀商品","goods_price":"99.00","line_price":"139.00"},{"goods_image":"http://shop.liankebao.net/assets/store/img/diy/goods/01.png","goods_name":"此处是秒杀商品","sec_kill_price":"99.00","line_price":"139.00"},{"goods_image":"http://shop.liankebao.net/assets/store/img/diy/goods/01.png","goods_name":"此处是秒杀商品","sec_kill_price":"99.00","line_price":"139.00"}],"data":[{"goods_image":"http://shop.liankebao.net/assets/store/img/diy/goods/01.png","goods_name":"此处是秒杀商品","sec_kill_price":"99.00","line_price":"139.00","is_default":true}]},{"name":"在线客服","type":"service","params":{"type":"chat","image":"http://btys.vshop365.cn/uploads/202009241603101a9589156.png","phone_num":""},"style":{"right":"0","bottom":"11","opacity":"100"}},{"name":"商品组","type":"goods","params":{"source":"auto","auto":{"category":10515,"goodsSort":"price","showNum":"100"}},"style":{"background":"#F6F6F6","price_color":"#F03C3C","cart_color":"#ff8040","selling_point_color":"#FF495E","display":"list","column":"2","show":{"goodsName":true,"goodsPrice":true,"linePrice":true,"sellingPoint":false,"goodsSales":false,"goodsStock":false,"shoppingCart":true}},"defaultData":[{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"6"},{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"66"},{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"666"},{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"999"}],"data":[{"goods_id":12439,"goods_name":"兵团大地果之粹红枣礼盒","selling_point":"物美价廉","image":"http://btys.vshop365.cn/uploads/202009081646084f1910130.jpg","goods_image":"http://btys.vshop365.cn/uploads/202009081646084f1910130.jpg","goods_price":"120.00","goods_old_price":"120.00","line_price":"0.00","goods_sales":1,"goods_stock":221,"spec_type":10,"goods_sku":{"goods_sku_id":33756,"goods_id":12439,"spec_sku_id":"0","image_id":0,"goods_no":"566464","balance_price":"0.00","goods_price":"120.00","line_price":"0.00","stock_num":221,"goods_sales":1,"goods_weight":1.5,"goods_old_price":"120.00","image":null},"goods_multi_spec":null},{"goods_id":12477,"goods_name":"兵团大地干果礼盒2.1kg","selling_point":"","image":"http://btys.vshop365.cn/uploads/202010291636137eec53445.jpg","goods_image":"http://btys.vshop365.cn/uploads/202010291636137eec53445.jpg","goods_price":"138.00","goods_old_price":"138.00","line_price":"0.00","goods_sales":0,"goods_stock":2000,"spec_type":10,"goods_sku":{"goods_sku_id":33783,"goods_id":12477,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"138.00","line_price":"0.00","stock_num":2000,"goods_sales":0,"goods_weight":2.1,"goods_old_price":"138.00","image":null},"goods_multi_spec":null},{"goods_id":12469,"goods_name":"兵团大地小兵坚果礼盒750g","selling_point":"营养丰富口感好","image":"http://btys.vshop365.cn/uploads/2020090816231978dc05966.png","goods_image":"http://btys.vshop365.cn/uploads/2020090816231978dc05966.png","goods_price":"148.00","goods_old_price":"148.00","line_price":"0.00","goods_sales":0,"goods_stock":789,"spec_type":10,"goods_sku":{"goods_sku_id":33728,"goods_id":12469,"spec_sku_id":"0","image_id":0,"goods_no":"131646","balance_price":"0.00","goods_price":"148.00","line_price":"0.00","stock_num":789,"goods_sales":0,"goods_weight":0.75,"goods_old_price":"148.00","image":null},"goods_multi_spec":null},{"goods_id":12457,"goods_name":"兵团大地新疆坚果大礼盒过节送礼首选礼包","selling_point":"","image":"http://btys.vshop365.cn/uploads/20200909104706bf6331925.jpg","goods_image":"http://btys.vshop365.cn/uploads/20200909104706bf6331925.jpg","goods_price":"158.00","goods_old_price":"158.00","line_price":"0.00","goods_sales":5,"goods_stock":994,"spec_type":10,"goods_sku":{"goods_sku_id":33733,"goods_id":12457,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"158.00","line_price":"0.00","stock_num":994,"goods_sales":5,"goods_weight":1.91,"goods_old_price":"158.00","image":null},"goods_multi_spec":null},{"goods_id":12476,"goods_name":"团团兵红花籽油2*500ml","selling_point":"","image":"http://btys.vshop365.cn/uploads/20201022130347d14211500.jpg","goods_image":"http://btys.vshop365.cn/uploads/20201022130347d14211500.jpg","goods_price":"198.00","goods_old_price":"198.00","line_price":"0.00","goods_sales":0,"goods_stock":2000,"spec_type":10,"goods_sku":{"goods_sku_id":33775,"goods_id":12476,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"198.00","line_price":"0.00","stock_num":2000,"goods_sales":0,"goods_weight":0.05,"goods_old_price":"198.00","image":null},"goods_multi_spec":null},{"goods_id":12438,"goods_name":"兵团大地果之粹坚果系列礼盒","selling_point":"物美价廉","image":"http://btys.vshop365.cn/uploads/202009081642503d0542293.jpg","goods_image":"http://btys.vshop365.cn/uploads/202009081642503d0542293.jpg","goods_price":"245.00","goods_old_price":"245.00","line_price":"0.00","goods_sales":0,"goods_stock":999,"spec_type":10,"goods_sku":{"goods_sku_id":33757,"goods_id":12438,"spec_sku_id":"0","image_id":0,"goods_no":"123456","balance_price":"0.00","goods_price":"245.00","line_price":"0.00","stock_num":999,"goods_sales":0,"goods_weight":1,"goods_old_price":"245.00","image":null},"goods_multi_spec":null},{"goods_id":12467,"goods_name":"兵团大地光辉岁月特产礼盒","selling_point":"","image":"http://btys.vshop365.cn/uploads/20200909113457adc023792.png","goods_image":"http://btys.vshop365.cn/uploads/20200909113457adc023792.png","goods_price":"298.00","goods_old_price":"298.00","line_price":"0.00","goods_sales":0,"goods_stock":3281,"spec_type":10,"goods_sku":{"goods_sku_id":33730,"goods_id":12467,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"298.00","line_price":"0.00","stock_num":3281,"goods_sales":0,"goods_weight":2.27,"goods_old_price":"298.00","image":null},"goods_multi_spec":null}]},{"name":"商品组","type":"goods","params":{"source":"auto","auto":{"category":10514,"goodsSort":"all","showNum":6}},"style":{"background":"#F6F6F6","price_color":"#F03C3C","cart_color":"#ff8000","selling_point_color":"#FF495E","display":"list","column":"2","show":{"goodsName":true,"goodsPrice":true,"linePrice":true,"sellingPoint":false,"goodsSales":false,"goodsStock":false,"shoppingCart":true}},"defaultData":[{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"6"},{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"66"},{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"666"},{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"999"}],"data":[{"goods_id":12461,"goods_name":"兵团大地罐装瓜子220g","selling_point":"新疆特产","image":"http://btys.vshop365.cn/uploads/20200909110858102577370.png","goods_image":"http://btys.vshop365.cn/uploads/20200909110858102577370.png","goods_price":"25.80","goods_old_price":"25.80","line_price":"0.00","goods_sales":0,"goods_stock":282,"spec_type":10,"goods_sku":{"goods_sku_id":33737,"goods_id":12461,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"25.80","line_price":"0.00","stock_num":282,"goods_sales":0,"goods_weight":0.22,"goods_old_price":"25.80","image":null},"goods_multi_spec":null},{"goods_id":12453,"goods_name":"兵团大地原味瓜子180g4袋","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009081902350a5184493.png","goods_image":"http://btys.vshop365.cn/uploads/202009081902350a5184493.png","goods_price":"38.00","goods_old_price":"38.00","line_price":"0.00","goods_sales":11,"goods_stock":984,"spec_type":10,"goods_sku":{"goods_sku_id":33744,"goods_id":12453,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"38.00","line_price":"0.00","stock_num":984,"goods_sales":11,"goods_weight":0.18,"goods_old_price":"38.00","image":null},"goods_multi_spec":null}]},{"name":"商品组","type":"goods","params":{"source":"auto","auto":{"category":10511,"goodsSort":"price","showNum":"50"}},"style":{"background":"#F6F6F6","price_color":"#F03C3C","cart_color":"#ff8000","selling_point_color":"#FF495E","display":"list","column":"2","show":{"goodsName":true,"goodsPrice":true,"linePrice":true,"sellingPoint":false,"goodsSales":false,"goodsStock":false,"shoppingCart":true}},"defaultData":[{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"6"},{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"66"},{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"666"},{"goods_name":"此处显示商品名称","image":"http://btys.vshop365.cn/assets/store/img/diy/goods/01.png","goods_price":"99.00","line_price":"139.00","selling_point":"此款商品美观大方 不容错过","goods_sales":"100","goods_stock":"999"}],"data":[{"goods_id":12446,"goods_name":"兵团大地男人香葡萄干120g","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009251612296e3d43587.jpg","goods_image":"http://btys.vshop365.cn/uploads/202009251612296e3d43587.jpg","goods_price":"9.90","goods_old_price":"9.90","line_price":"0.00","goods_sales":1,"goods_stock":3231,"spec_type":10,"goods_sku":{"goods_sku_id":33750,"goods_id":12446,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"9.90","line_price":"0.00","stock_num":3231,"goods_sales":1,"goods_weight":0.12,"goods_old_price":"9.90","image":null},"goods_multi_spec":null},{"goods_id":12447,"goods_name":"兵团大地女人香葡萄干120g","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009251611258424a3121.jpg","goods_image":"http://btys.vshop365.cn/uploads/202009251611258424a3121.jpg","goods_price":"9.90","goods_old_price":"9.90","line_price":"0.00","goods_sales":1,"goods_stock":2400,"spec_type":10,"goods_sku":{"goods_sku_id":33749,"goods_id":12447,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"9.90","line_price":"0.00","stock_num":2400,"goods_sales":1,"goods_weight":0.12,"goods_old_price":"9.90","image":null},"goods_multi_spec":null},{"goods_id":12448,"goods_name":"兵团大地黑加仑葡萄干120g","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009251610403d4df5802.jpg","goods_image":"http://btys.vshop365.cn/uploads/202009251610403d4df5802.jpg","goods_price":"9.90","goods_old_price":"9.90","line_price":"0.00","goods_sales":0,"goods_stock":2289,"spec_type":10,"goods_sku":{"goods_sku_id":33748,"goods_id":12448,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"9.90","line_price":"0.00","stock_num":2289,"goods_sales":0,"goods_weight":0.12,"goods_old_price":"9.90","image":null},"goods_multi_spec":null},{"goods_id":12449,"goods_name":"兵团大地香喀什葡萄干","selling_point":"","image":"http://btys.vshop365.cn/uploads/20200925160956486c40175.jpg","goods_image":"http://btys.vshop365.cn/uploads/20200925160956486c40175.jpg","goods_price":"9.90","goods_old_price":"9.90","line_price":"0.00","goods_sales":0,"goods_stock":3238,"spec_type":10,"goods_sku":{"goods_sku_id":33751,"goods_id":12449,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"9.90","line_price":"0.00","stock_num":3238,"goods_sales":0,"goods_weight":0.12,"goods_old_price":"9.90","image":null},"goods_multi_spec":null},{"goods_id":12451,"goods_name":"兵团大地红玛瑙葡萄干","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009251608206a8d93568.jpg","goods_image":"http://btys.vshop365.cn/uploads/202009251608206a8d93568.jpg","goods_price":"9.90","goods_old_price":"9.90","line_price":"0.00","goods_sales":0,"goods_stock":1549,"spec_type":10,"goods_sku":{"goods_sku_id":33746,"goods_id":12451,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"9.90","line_price":"0.00","stock_num":1549,"goods_sales":0,"goods_weight":0.12,"goods_old_price":"9.90","image":null},"goods_multi_spec":null},{"goods_id":12474,"goods_name":"兵团大地无核白葡萄干120g","selling_point":"货源火爆预定中！提早下单，优先备货！","image":"http://btys.vshop365.cn/uploads/20200925161332e88273839.jpg","goods_image":"http://btys.vshop365.cn/uploads/20200925161332e88273839.jpg","goods_price":"9.90","goods_old_price":"9.90","line_price":"0.00","goods_sales":4,"goods_stock":2297,"spec_type":10,"goods_sku":{"goods_sku_id":33762,"goods_id":12474,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"9.90","line_price":"0.00","stock_num":2297,"goods_sales":3,"goods_weight":0.12,"goods_old_price":"9.90","image":null},"goods_multi_spec":null},{"goods_id":12450,"goods_name":"兵团大地红香妃","selling_point":"","image":"http://btys.vshop365.cn/uploads/20200925160909b55140600.jpg","goods_image":"http://btys.vshop365.cn/uploads/20200925160909b55140600.jpg","goods_price":"12.80","goods_old_price":"12.80","line_price":"0.00","goods_sales":3,"goods_stock":2097,"spec_type":10,"goods_sku":{"goods_sku_id":33747,"goods_id":12450,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"12.80","line_price":"0.00","stock_num":2097,"goods_sales":3,"goods_weight":0.12,"goods_old_price":"12.80","image":null},"goods_multi_spec":null},{"goods_id":12452,"goods_name":"兵团大地绿香妃葡萄干","selling_point":"","image":"http://btys.vshop365.cn/uploads/20200925160411f9cc82992.jpg","goods_image":"http://btys.vshop365.cn/uploads/20200925160411f9cc82992.jpg","goods_price":"14.80","goods_old_price":"14.80","line_price":"0.00","goods_sales":5,"goods_stock":2487,"spec_type":10,"goods_sku":{"goods_sku_id":33745,"goods_id":12452,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"14.80","line_price":"0.00","stock_num":2487,"goods_sales":5,"goods_weight":0.12,"goods_old_price":"14.80","image":null},"goods_multi_spec":null},{"goods_id":12443,"goods_name":"兵团大地吊树干杏","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009081752020838d8523.png","goods_image":"http://btys.vshop365.cn/uploads/202009081752020838d8523.png","goods_price":"20.80","goods_old_price":"20.80","line_price":"0.00","goods_sales":3,"goods_stock":2280,"spec_type":10,"goods_sku":{"goods_sku_id":33754,"goods_id":12443,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"20.80","line_price":"0.00","stock_num":2280,"goods_sales":3,"goods_weight":0.24,"goods_old_price":"20.80","image":null},"goods_multi_spec":null},{"goods_id":12454,"goods_name":"兵团大地灰枣夹核桃仁260g","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009081914509db049832.png","goods_image":"http://btys.vshop365.cn/uploads/202009081914509db049832.png","goods_price":"25.80","goods_old_price":"25.80","line_price":"0.00","goods_sales":4,"goods_stock":11996,"spec_type":10,"goods_sku":{"goods_sku_id":33743,"goods_id":12454,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"25.80","line_price":"0.00","stock_num":11996,"goods_sales":4,"goods_weight":0.26,"goods_old_price":"25.80","image":null},"goods_multi_spec":null},{"goods_id":12464,"goods_name":"兵团大地光辉单品若羌灰枣350g","selling_point":"","image":"http://btys.vshop365.cn/uploads/2020090911241346d069876.jpg","goods_image":"http://btys.vshop365.cn/uploads/2020090911241346d069876.jpg","goods_price":"26.80","goods_old_price":"26.80","line_price":"0.00","goods_sales":0,"goods_stock":8450,"spec_type":10,"goods_sku":{"goods_sku_id":33740,"goods_id":12464,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"26.80","line_price":"0.00","stock_num":8450,"goods_sales":0,"goods_weight":0.35,"goods_old_price":"26.80","image":null},"goods_multi_spec":null},{"goods_id":12465,"goods_name":"兵团大地光辉单品薄皮核桃","selling_point":"","image":"http://btys.vshop365.cn/uploads/2020090911285533c235809.jpg","goods_image":"http://btys.vshop365.cn/uploads/2020090911285533c235809.jpg","goods_price":"29.80","goods_old_price":"29.80","line_price":"0.00","goods_sales":0,"goods_stock":3623,"spec_type":10,"goods_sku":{"goods_sku_id":33732,"goods_id":12465,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"29.80","line_price":"0.00","stock_num":3623,"goods_sales":0,"goods_weight":0.27,"goods_old_price":"29.80","image":null},"goods_multi_spec":null},{"goods_id":12466,"goods_name":"兵团大地光辉单品和田骏枣250g","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009091131563241b8882.jpg","goods_image":"http://btys.vshop365.cn/uploads/202009091131563241b8882.jpg","goods_price":"29.80","goods_old_price":"29.80","line_price":"0.00","goods_sales":0,"goods_stock":5261,"spec_type":10,"goods_sku":{"goods_sku_id":33731,"goods_id":12466,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"29.80","line_price":"0.00","stock_num":5261,"goods_sales":0,"goods_weight":0.25,"goods_old_price":"29.80","image":null},"goods_multi_spec":null},{"goods_id":12458,"goods_name":"兵团大地红枸杞","selling_point":"新疆特产","image":"http://btys.vshop365.cn/uploads/20200909105220df3ac9927.png","goods_image":"http://btys.vshop365.cn/uploads/20200909105220df3ac9927.png","goods_price":"32.00","goods_old_price":"32.00","line_price":"0.00","goods_sales":0,"goods_stock":4244,"spec_type":10,"goods_sku":{"goods_sku_id":33734,"goods_id":12458,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"32.00","line_price":"0.00","stock_num":4244,"goods_sales":0,"goods_weight":0.18,"goods_old_price":"32.00","image":null},"goods_multi_spec":null},{"goods_id":12445,"goods_name":"兵团大地无花果干","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009081825090f69f6912.jpg","goods_image":"http://btys.vshop365.cn/uploads/202009081825090f69f6912.jpg","goods_price":"32.80","goods_old_price":"32.80","line_price":"0.00","goods_sales":2,"goods_stock":2108,"spec_type":10,"goods_sku":{"goods_sku_id":33752,"goods_id":12445,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"32.80","line_price":"0.00","stock_num":2108,"goods_sales":2,"goods_weight":0.21,"goods_old_price":"32.80","image":null},"goods_multi_spec":null},{"goods_id":12444,"goods_name":"兵团大地原味巴旦木","selling_point":"","image":"http://btys.vshop365.cn/uploads/20200908182111f977b0473.png","goods_image":"http://btys.vshop365.cn/uploads/20200908182111f977b0473.png","goods_price":"35.60","goods_old_price":"35.60","line_price":"0.00","goods_sales":2,"goods_stock":2278,"spec_type":10,"goods_sku":{"goods_sku_id":33753,"goods_id":12444,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"35.60","line_price":"0.00","stock_num":2278,"goods_sales":2,"goods_weight":0.21,"goods_old_price":"35.60","image":null},"goods_multi_spec":null},{"goods_id":12442,"goods_name":"兵团大地薄皮核桃","selling_point":"","image":"http://btys.vshop365.cn/uploads/202009081748259fa347422.jpg","goods_image":"http://btys.vshop365.cn/uploads/202009081748259fa347422.jpg","goods_price":"36.00","goods_old_price":"36.00","line_price":"0.00","goods_sales":0,"goods_stock":2281,"spec_type":10,"goods_sku":{"goods_sku_id":33755,"goods_id":12442,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"36.00","line_price":"0.00","stock_num":2281,"goods_sales":0,"goods_weight":0.21,"goods_old_price":"36.00","image":null},"goods_multi_spec":null},{"goods_id":12462,"goods_name":"兵团大地新疆特产光辉单品吊树干杏500g","selling_point":"新疆特产","image":"http://btys.vshop365.cn/uploads/20200909111731db80c3053.jpg","goods_image":"http://btys.vshop365.cn/uploads/20200909111731db80c3053.jpg","goods_price":"51.80","goods_old_price":"51.80","line_price":"0.00","goods_sales":0,"goods_stock":3216,"spec_type":10,"goods_sku":{"goods_sku_id":33738,"goods_id":12462,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"51.80","line_price":"0.00","stock_num":3216,"goods_sales":0,"goods_weight":0.5,"goods_old_price":"51.80","image":null},"goods_multi_spec":null},{"goods_id":12459,"goods_name":"兵团大地新疆特产黑枸杞","selling_point":"新疆特产","image":"http://btys.vshop365.cn/uploads/20200909105438ef8402176.png","goods_image":"http://btys.vshop365.cn/uploads/20200909105438ef8402176.png","goods_price":"59.00","goods_old_price":"59.00","line_price":"0.00","goods_sales":0,"goods_stock":3609,"spec_type":10,"goods_sku":{"goods_sku_id":33735,"goods_id":12459,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"59.00","line_price":"0.00","stock_num":3609,"goods_sales":0,"goods_weight":0.125,"goods_old_price":"59.00","image":null},"goods_multi_spec":null},{"goods_id":12468,"goods_name":"兵团大地高寒蜂蜜500g","selling_point":"","image":"http://btys.vshop365.cn/uploads/20200909114743309041451.png","goods_image":"http://btys.vshop365.cn/uploads/20200909114743309041451.png","goods_price":"65.00","goods_old_price":"65.00","line_price":"0.00","goods_sales":0,"goods_stock":3231,"spec_type":10,"goods_sku":{"goods_sku_id":33729,"goods_id":12468,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"65.00","line_price":"0.00","stock_num":3231,"goods_sales":0,"goods_weight":0.5,"goods_old_price":"65.00","image":null},"goods_multi_spec":null},{"goods_id":12463,"goods_name":"兵团大地光辉单品原味巴旦木400g","selling_point":"","image":"http://btys.vshop365.cn/uploads/20200909111934274721923.jpg","goods_image":"http://btys.vshop365.cn/uploads/20200909111934274721923.jpg","goods_price":"79.60","goods_old_price":"79.60","line_price":"0.00","goods_sales":0,"goods_stock":5264,"spec_type":10,"goods_sku":{"goods_sku_id":33739,"goods_id":12463,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"79.60","line_price":"0.00","stock_num":5264,"goods_sales":0,"goods_weight":0.4,"goods_old_price":"79.60","image":null},"goods_multi_spec":null},{"goods_id":12440,"goods_name":"兵团大地小兵坚果礼盒750g","selling_point":"营养丰富口感好","image":"http://btys.vshop365.cn/uploads/2020090816231978dc05966.png","goods_image":"http://btys.vshop365.cn/uploads/2020090816231978dc05966.png","goods_price":"148.00","goods_old_price":"148.00","line_price":"0.00","goods_sales":0,"goods_stock":789,"spec_type":10,"goods_sku":{"goods_sku_id":33662,"goods_id":12440,"spec_sku_id":"0","image_id":0,"goods_no":"131646","balance_price":"0.00","goods_price":"148.00","line_price":"0.00","stock_num":789,"goods_sales":0,"goods_weight":0.75,"goods_old_price":"148.00","image":null},"goods_multi_spec":null}]},{"name":"线下门店","type":"shop","params":{"source":"choice","auto":{"showNum":6}},"style":[],"defaultData":[{"shop_name":"此处显示门店名称","logo_image":"http://btys.vshop365.cn/assets/store/img/diy/circular.png","phone":"010-6666666","region":{"province":"xx省","city":"xx市","region":"xx区"},"address":"xx街道"},{"shop_name":"此处显示门店名称","logo_image":"http://btys.vshop365.cn/assets/store/img/diy/circular.png","phone":"010-6666666","region":{"province":"xx省","city":"xx市","region":"xx区"},"address":"xx街道"}],"data":[{"shop_id":10021,"shop_name":"兵团果业红山路店","logo_image":"http://btys.vshop365.cn/uploads/20201009162126c8e0c4730.jpg","phone":"0991-8862707","region":{"province":"新疆维吾尔自治区","city":"乌鲁木齐市","region":"天山区"},"address":"乌鲁木齐市天山区红山路120号"}]}]
         */

        private PageBean page;
        private List<ItemsBean> items;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class PageBean {
            /**
             * type : page
             * name : 页面设置
             * params : {"name":"兵团优选","title":"兵团优选","share_title":"兵团优选"}
             * style : {"titleTextColor":"white","titleBackgroundColor":"#d20000"}
             */

            private String type;
            private String name;
            private ParamsBean params;
            private StyleBean style;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public StyleBean getStyle() {
                return style;
            }

            public void setStyle(StyleBean style) {
                this.style = style;
            }

            public static class ParamsBean {
                /**
                 * name : 兵团优选
                 * title : 兵团优选
                 * share_title : 兵团优选
                 */

                private String name;
                private String title;
                private String share_title;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getShare_title() {
                    return share_title;
                }

                public void setShare_title(String share_title) {
                    this.share_title = share_title;
                }
            }

            public static class StyleBean {
                /**
                 * titleTextColor : white
                 * titleBackgroundColor : #d20000
                 */

                private String titleTextColor;
                private String titleBackgroundColor;

                public String getTitleTextColor() {
                    return titleTextColor;
                }

                public void setTitleTextColor(String titleTextColor) {
                    this.titleTextColor = titleTextColor;
                }

                public String getTitleBackgroundColor() {
                    return titleBackgroundColor;
                }

                public void setTitleBackgroundColor(String titleBackgroundColor) {
                    this.titleBackgroundColor = titleBackgroundColor;
                }
            }
        }

        public static class ItemsBean {
            /**
             * name : 辅助线
             * type : guide
             * style : {"background":"#ffffff","lineStyle":"solid","lineHeight":"1","lineColor":"#000000","paddingTop":"0"}
             * params : {"placeholder":"搜索","address":"西湖国际广场A座1608"}
             * data : [{"imgUrl":"http://btys.vshop365.cn/uploads/20200924115726f1e1a7005.jpg","linkUrl":"pages/tree/indexup/indexup"},{"imgUrl":"http://btys.vshop365.cn/uploads/202009241257367f26b4302.jpg","linkUrl":"pages/category/list"},{"imgUrl":"http://btys.vshop365.cn/uploads/20201015181701f4bea2457.jpg","linkUrl":"pages/article/detail/index?article_id=8"},{"imgUrl":"http://btys.vshop365.cn/uploads/2020093018124213ea24876.jpg","linkUrl":"pages/tree/indexup/indexup"}]
             * defaultData : [{"article_title":"张小龙4小时演讲：你和高手之间，隔着\u201c简单\u201d二字"},{"article_title":"张小龙4小时演讲：你和高手之间，隔着\u201c简单\u201d二字"}]
             */

            private String name;
            private String type;
            @SerializedName("style")
            @JsonAdapter(RawStringJsonAdapter.class)
            private String style;
            private ParamsBeanX params;
            private List<DataBean> data;
            private List<DefaultDataBean> defaultData;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getStyle() {
                return style;
            }

            public void setStyle(String style) {
                this.style = style;
            }

            public ParamsBeanX getParams() {
                return params;
            }

            public void setParams(ParamsBeanX params) {
                this.params = params;
            }

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public List<DefaultDataBean> getDefaultData() {
                return defaultData;
            }

            public void setDefaultData(List<DefaultDataBean> defaultData) {
                this.defaultData = defaultData;
            }

            public static class StyleBeanX {
                /**
                 * background : #ffffff
                 * lineStyle : solid
                 * lineHeight : 1
                 * lineColor : #000000
                 * paddingTop : 0
                 */

                private String background;
                private String lineStyle;
                private String lineHeight;
                private String lineColor;
                private String paddingTop;

                public String getBackground() {
                    return background;
                }

                public void setBackground(String background) {
                    this.background = background;
                }

                public String getLineStyle() {
                    return lineStyle;
                }

                public void setLineStyle(String lineStyle) {
                    this.lineStyle = lineStyle;
                }

                public String getLineHeight() {
                    return lineHeight;
                }

                public void setLineHeight(String lineHeight) {
                    this.lineHeight = lineHeight;
                }

                public String getLineColor() {
                    return lineColor;
                }

                public void setLineColor(String lineColor) {
                    this.lineColor = lineColor;
                }

                public String getPaddingTop() {
                    return paddingTop;
                }

                public void setPaddingTop(String paddingTop) {
                    this.paddingTop = paddingTop;
                }
            }

            public static class ParamsBeanX {
                /**
                 * placeholder : 搜索
                 * address : 西湖国际广场A座1608
                 */

                private String placeholder;
                private String address;

                public String getPlaceholder() {
                    return placeholder;
                }

                public void setPlaceholder(String placeholder) {
                    this.placeholder = placeholder;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }
            }

            public static class DataBean {
                /**
                 * imgUrl : http://btys.vshop365.cn/uploads/20200924115726f1e1a7005.jpg
                 * linkUrl : pages/tree/indexup/indexup
                 */

                private String imgUrl;
                private String linkUrl;
                private String text;
                private int article_id;
                private String article_title;

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

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getImgUrl() {
                    return imgUrl;
                }

                public void setImgUrl(String imgUrl) {
                    this.imgUrl = imgUrl;
                }

                public String getLinkUrl() {
                    return linkUrl;
                }

                public void setLinkUrl(String linkUrl) {
                    this.linkUrl = linkUrl;
                }
            }

            public static class DefaultDataBean {
                /**
                 * article_title : 张小龙4小时演讲：你和高手之间，隔着“简单”二字
                 */

                private String article_title;

                public String getArticle_title() {
                    return article_title;
                }

                public void setArticle_title(String article_title) {
                    this.article_title = article_title;
                }
            }
        }
    }
}
