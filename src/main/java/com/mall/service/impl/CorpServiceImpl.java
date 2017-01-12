package com.mall.service.impl;

import com.mall.mapper.TCorpMapper;
import com.mall.model.TCorp;
import com.mall.model.TCorpExample;
import com.mall.service.CorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Supeng on 11/01/2017.
 */
@Service
public class CorpServiceImpl implements CorpService {

    @Autowired
    TCorpMapper corpMapper;

    @Override
    public List<TCorp> selectAllCorp() {
        return corpMapper.selectByExample(new TCorpExample());
    }
}
