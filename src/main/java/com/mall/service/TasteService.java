package com.mall.service;

import com.mall.model.TTaste;

import java.util.List;

/**
 * Created by Supeng on 13/04/2017.
 */
public interface TasteService {

    List<TTaste> selectTasteByCorp(int corpId);
}
