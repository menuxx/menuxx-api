package com.mall.service;

import com.mall.model.TFormat;

import java.util.List;

/**
 * Created by Supeng on 19/04/2017.
 */
public interface FormatService {

    List<TFormat> selectFormatByCorpId(int corpId);

}
