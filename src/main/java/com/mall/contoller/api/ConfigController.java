package com.mall.contoller.api;

import com.mall.model.TConfig;
import com.mall.model.TShopBusinessTime;
import com.mall.model.TShopConfig;
import com.mall.service.ConfigService;
import com.yingtaohuo.service.ShopConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConfigController extends BaseCorpController {

    @Autowired
    ConfigService configService;

    @Autowired
    ShopConfigService shopConfigService;

    @GetMapping("/shop_configs")
    public TShopConfig getShopConfig(@PathVariable("dinerId") Integer shopId) {
        TShopConfig config = shopConfigService.getShopConfig(shopId);
        return config;
    }

    @GetMapping("/configs")
    @Deprecated
    public List<TConfig> fetchMyConfigs(@PathVariable("dinerId") Integer dinerId) {
        return configService.selectMyConfigs(dinerId);
    }

    @GetMapping("/config")
    @Deprecated
    public TShopConfig getConfig(@PathVariable("dinerId") Integer shopId) {
        return configService.selectConfig(shopId);
    }






}
