package com.mall.service.impl;

import com.mall.mapper.TFormatMapper;
import com.mall.model.TFormat;
import com.mall.model.TFormatExample;
import com.mall.service.FormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Supeng on 19/04/2017.
 */
@Service
public class FormatServiceImpl implements FormatService {

    @Autowired
    TFormatMapper formatMapper;

    @Override
    public List<TFormat> selectFormatByCorpId(int corpId) {
        TFormatExample example = new TFormatExample();
        TFormatExample.Criteria criteria = example.createCriteria();

        criteria.andCorpIdEqualTo(corpId);

        return formatMapper.selectByExample(example);
    }
}
