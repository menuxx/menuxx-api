package com.mall.service;

import com.github.pagehelper.PageInfo;
import com.mall.model.TCorpTotal;

import java.util.Date;

/**
 * Created by Supeng on 31/03/2017.
 */
public interface CorpTotalService {

    TCorpTotal selectCorpTotal(int corpId, String day);

    TCorpTotal selectCorpTotal(int corpId, Date day);

    void createCorpTotal(TCorpTotal corpTotal);

    PageInfo<TCorpTotal> selectCorpTotal(int corpId);
}
