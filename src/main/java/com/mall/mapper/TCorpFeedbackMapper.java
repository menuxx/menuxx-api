package com.mall.mapper;

import com.mall.model.TCorpFeedback;
import com.mall.model.TCorpFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCorpFeedbackMapper {
    int countByExample(TCorpFeedbackExample example);

    int deleteByExample(TCorpFeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCorpFeedback record);

    int insertSelective(TCorpFeedback record);

    List<TCorpFeedback> selectByExample(TCorpFeedbackExample example);

    TCorpFeedback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCorpFeedback record, @Param("example") TCorpFeedbackExample example);

    int updateByExample(@Param("record") TCorpFeedback record, @Param("example") TCorpFeedbackExample example);

    int updateByPrimaryKeySelective(TCorpFeedback record);

    int updateByPrimaryKey(TCorpFeedback record);
}