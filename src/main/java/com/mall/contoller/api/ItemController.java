package com.mall.contoller.api;

import com.mall.model.Category;
import com.mall.model.TTable;
import com.mall.service.TableService;
import com.mall.wrapper.CategoryWrapper;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 13/01/2017.
 */
@Controller
public class ItemController extends BaseCorpController {

    @Autowired
    CategoryWrapper categoryWrapper;

    @Autowired
    TableService tableService;
    /**
     * 1001 商品详情
     * @param corpId
     * @return
     */
    @RequestMapping(value = "home", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getHomeItems(@PathVariable int corpId) {
        Map<String, Object> homeMap = new HashMap<>();

        List<Category> categoryList = categoryWrapper.selectCategoriesByCorp(corpId);
        homeMap.put("categoryList", categoryList);

        List<TTable> tableList = tableService.selectTablesByCorp(corpId);
        homeMap.put("tableList", tableList);

        return new ResponseEntity<Object>(homeMap, HttpStatus.OK);
    }

}
