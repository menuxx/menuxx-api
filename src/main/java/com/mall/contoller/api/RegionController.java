package com.mall.contoller.api;

import com.mall.model.TRegion;
import com.mall.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Supeng on 17/01/2017.
 */
@Controller
public class RegionController extends BaseAPIController {

    @Autowired
    RegionService regionService;

    /**
     * 4006 加载地区
     * @param parentId
     * @return
     */
    @RequestMapping(value = "regions/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getRegionByParent(@PathVariable int parentId) {
        if (parentId == 0) {
            parentId = 1;
        }

        List<TRegion> regionList = regionService.selectRegionByParent(parentId);
        return new ResponseEntity<Object>(regionList, HttpStatus.OK);
    }
}
