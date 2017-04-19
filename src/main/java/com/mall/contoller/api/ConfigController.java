package com.mall.contoller.api;

import com.mall.model.TConfig;
import com.mall.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ConfigController extends BaseCorpController {

    @Autowired
    ConfigService configService;

    @GetMapping("/configs")
    public List<TConfig> fetchMyConfigs(@PathVariable("dinerId") Integer dinerId) {
        return configService.selectMyConfigs(dinerId);
    }

}
