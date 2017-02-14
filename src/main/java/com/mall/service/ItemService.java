package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.model.TItem;

import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 12/01/2017.
 */
public interface ItemService {

    List<TItem> selectItemsByCorp(int corpId);

}
