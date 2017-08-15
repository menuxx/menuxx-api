package com.mall.mapper;

import com.mall.model.TFeiePrinter;
import com.mall.model.TFeiePrinterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TFeiePrinterMapper {
    int countByExample(TFeiePrinterExample example);

    int deleteByExample(TFeiePrinterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TFeiePrinter record);

    int insertSelective(TFeiePrinter record);

    List<TFeiePrinter> selectByExample(TFeiePrinterExample example);

    TFeiePrinter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TFeiePrinter record, @Param("example") TFeiePrinterExample example);

    int updateByExample(@Param("record") TFeiePrinter record, @Param("example") TFeiePrinterExample example);

    int updateByPrimaryKeySelective(TFeiePrinter record);

    int updateByPrimaryKey(TFeiePrinter record);
}