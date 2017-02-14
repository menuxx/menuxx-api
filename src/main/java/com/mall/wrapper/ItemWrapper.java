package com.mall.wrapper;

import com.mall.model.TItem;

import java.util.List;
import java.util.Map;

/**
 * Created by Supeng on 13/01/2017.
 */
public interface ItemWrapper {

    Map<Integer, List<TItem>> selectItemsByCorp(int corpId);

}
