package com.mall.service.impl;

import com.mall.mapper.TCorpFeedbackMapper;
import com.mall.model.TCorpFeedback;
import com.mall.service.CorpFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Supeng on 27/03/2017.
 */
@Service
public class CorpFeedbackServiceImpl implements CorpFeedbackService {

    @Autowired
    TCorpFeedbackMapper corpFeedbackMapper;

    @Override
    public void createFeedback(TCorpFeedback feedback) {
        corpFeedbackMapper.insert(feedback);
    }
}
