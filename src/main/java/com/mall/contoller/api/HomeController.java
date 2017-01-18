package com.mall.contoller.api;

import com.mall.model.Column;
import com.mall.model.Item;
import com.mall.model.TBanner;
import com.mall.model.TItem;
import com.mall.service.BannerService;
import com.mall.wrapper.BannerItemWrapper;
import com.mall.wrapper.ColumnWrapper;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 12/01/2017.
 */
@Controller
public class HomeController extends BaseCorpContoller {

    @Autowired
    BannerService bannerService;

    @Autowired
    ColumnWrapper columnWrapper;

    @Autowired
    BannerItemWrapper bannerItemWrapper;

    /**
     * 1001 加载首页
     * @param corpId
     * @return
     */
    @RequestMapping(value = "home", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getHomePage(@PathVariable int corpId) {
        Map<String, Object> map = new HashedMap();

        List<TBanner> bannerList = bannerService.selectActivatedBanner(corpId);
        if (bannerList.size() > 0) {
            map.put("banners", bannerList);
        }

        List<Column> columnList = columnWrapper.selectAllColumns(corpId);
        if (columnList.size() > 0) {
            map.put("columns", columnList);
        }

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    /**
     * 1002 获取banner关联商品
     * @param bannerId
     * @return
     */
    @RequestMapping(value = "banners/{bannerId}/items", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getBannerItem(@PathVariable int bannerId) {
        List<Item> itemList = bannerItemWrapper.selectItemsByBanner(bannerId);
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

}
