package com.mall.service.impl;

import com.mall.mapper.TTasteMapper;
import com.mall.model.TTaste;
import com.mall.model.TTasteExample;
import com.mall.service.TasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Supeng on 13/04/2017.
 */
@Service
public class TasteServiceImpl implements TasteService {

    @Autowired
    TTasteMapper tasteMapper;

    @Override
    public List<TTaste> selectTasteByCorp(int corpId) {
        TTasteExample example = new TTasteExample();
        TTasteExample.Criteria criteria = example.createCriteria();

        criteria.andCorpIdEqualTo(corpId);

        return tasteMapper.selectByExample(example);
    }
}
