package com.mall.contoller.api;

import com.mall.service.WXComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wx")
public class WXComponentController {

    @Autowired
    WXComponentService componentService;

    @PostMapping("component_token")
    public void updateComponentCache(@RequestBody HashMap<String, String> cacheData) {
        componentService.updateCache(cacheData);
    }

    @GetMapping("component_token")
    public Map<String, String> getComponentCache() {
        return componentService.getCache();
    }

}