package com.mall.contoller.api;

import com.mall.model.Category;
import com.mall.model.Item;
import com.mall.model.TTable;
import com.mall.service.ItemService;
import com.mall.service.TableService;
import com.mall.utils.Constants;
import com.mall.wrapper.CategoryWrapper;
import com.mall.wrapper.ItemWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    ItemWrapper itemWrapper;

    @Autowired
    ItemService itemService;

    /**
     * 1001 加载首页
     * @param dinerId
     * @return
     */
    @RequestMapping(value = "home", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getHomeItems(@PathVariable("dinerId") int dinerId) {
        Map<String, Object> homeMap = new HashMap<>();

        List<Category> categoryList = categoryWrapper.selectCategoriesByCorp(dinerId);
        homeMap.put("categoryList", categoryList);

        List<TTable> tableList = tableService.selectTablesByCorp(dinerId);
        homeMap.put("tableList", tableList);

        return new ResponseEntity<Object>(homeMap, HttpStatus.OK);
    }

    /**
     * 2002 加载菜单
     * @param dinerId
     * @return
     */
    @RequestMapping(value = "items", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getItems(@PathVariable("dinerId") int dinerId) {
        List<Item> itemList = itemWrapper.selectItems(dinerId);
        return new ResponseEntity<Object>(itemList, HttpStatus.OK);
    }

    /**
     * 2003 修改菜单
     * @param itemId
     * @param item
     * @return
     */
    @RequestMapping(value = "items/{itemId}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateItem(@PathVariable int itemId, @RequestBody Item item) {
        itemService.updateItem(item);
        return new ResponseEntity<Object>(item, HttpStatus.OK);
    }

    /**
     * 2007 单品下架
     * @param itemId
     * @return
     */
    @RequestMapping(value = "items/{itemId}/soldout", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> setSoldout(@PathVariable int itemId) {
        itemWrapper.setSoldout(itemId);

        Item item = itemWrapper.selectItem(itemId);

        return new ResponseEntity<Object>(item, HttpStatus.OK);
    }

    /**
     * 2008 单品上架
     * @param itemId
     * @return
     */
    @RequestMapping(value = "items/{itemId}/soldout", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> cancelSoldout(@PathVariable int itemId) {
        itemWrapper.cancelSoldout(itemId);

        Item item = itemWrapper.selectItem(itemId);

        return new ResponseEntity<Object>(item, HttpStatus.OK);
    }

    /**
     * 2009 创建单品
     * @param item
     * @return
     */
    @RequestMapping(value = "items", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createItem(@PathVariable int corpId, @RequestBody Item item) {
        item.setCorpId(corpId);

        if (StringUtils.isBlank(item.getItemName())) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }

        if (item.getProductPrice() == null || item.getProductPrice().doubleValue() == 0.0) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }

        if (item.getCategory() == null) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }

        if (item.getSoldout() == null) {
            item.setSoldout(Constants.ZERO);
        }


        itemService.createItem(item);

        item = itemWrapper.selectItem(item.getId());

        return new ResponseEntity<Object>(item, HttpStatus.OK);
    }


}
