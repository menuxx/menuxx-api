package com.mall.contoller.api;

import com.github.pagehelper.PageInfo;
import com.mall.configure.page.Page;
import com.mall.model.Category;
import com.mall.model.TItem;
import com.mall.service.ItemService;
import com.mall.utils.Constants;
import com.mall.wrapper.CategoryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Supeng on 12/01/2017.
 */
@Controller
public class CategoryController extends BaseAPIController {

    @Autowired
    CategoryWrapper categoryWrapper;

    @Autowired
    ItemService itemService;

    /**
     * 2001 加载分类
     * @param corpId
     * @return
     */
    @RequestMapping(value = "category", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getRootCategory(@PathVariable int corpId) {
        Category root = categoryWrapper.buildCategory(corpId);
        return new ResponseEntity<>(root, HttpStatus.OK);
    }

    /**
     * 1004 根据分类加载商品
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "categories/{categoryId}/items", method = RequestMethod.GET)
    @ResponseBody
    @Page
    public ResponseEntity<?> getItems(@PathVariable int categoryId, @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGENUM) int pageNum,
                                      @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGESIZE) int pageSize) {
        PageInfo<TItem> pageInfo = itemService.selectItemsByCategory(categoryId);
        return new ResponseEntity<>(pageInfo, HttpStatus.OK);
    }
}
