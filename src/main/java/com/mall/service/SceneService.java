package com.mall.service;

import com.mall.model.TScene;

import java.util.List;

/**
 * Created by yinchangsheng on 2017/5/8.
 */
public interface SceneService {

    List<TScene> getCorpSceneTabsWithEnable(int corpId);

}
