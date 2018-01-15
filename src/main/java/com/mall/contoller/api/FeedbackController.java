package com.mall.contoller.api;

import com.mall.model.TCorpFeedback;
import com.mall.service.CorpFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Supeng on 27/03/2017.
 */
@Controller
public class FeedbackController extends BaseCorpController {

    @Autowired
    CorpFeedbackService corpFeedbackService;

    /**
     * 2013 意见反馈
     * @param dinerId
     * @param feedback
     * @return
     */
    @RequestMapping(value = "feedback", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createFeedback(@PathVariable("dinerId") int dinerId, @RequestBody TCorpFeedback feedback) {
        feedback.setCorpId(dinerId);
        corpFeedbackService.createFeedback(feedback);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
