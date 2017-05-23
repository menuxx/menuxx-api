package com.mall.service;

import com.mall.model.TScene;

import java.util.List;
import java.util.Map;

/**
 * Created by yinchangsheng on 2017/5/8.
 */
public interface SceneService {

    List<TScene> getCorpSceneTabsWithEnable(int corpId);

    Map<Integer, String> getTabNames(int corpId);

}
