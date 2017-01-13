package com.mall.contoller.api;

import com.mall.model.Item;
import com.mall.wrapper.ItemWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Supeng on 13/01/2017.
 */
@Controller
public class ItemController extends BaseAPIController {

    @Autowired
    ItemWrapper itemWrapper;

    @RequestMapping(value = "items/{itemId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getItemDetail(@PathVariable int corpId, @PathVariable int itemId) {
        Item item = itemWrapper.getItemDetail(corpId, itemId);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

}
