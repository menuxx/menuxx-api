package com.mall.mapper;

import com.mall.model.TPrinter;
import com.mall.model.TPrinterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPrinterMapper {
    int countByExample(TPrinterExample example);

    int deleteByExample(TPrinterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPrinter record);

    int insertSelective(TPrinter record);

    List<TPrinter> selectByExample(TPrinterExample example);

    TPrinter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPrinter record, @Param("example") TPrinterExample example);

    int updateByExample(@Param("record") TPrinter record, @Param("example") TPrinterExample example);

    int updateByPrimaryKeySelective(TPrinter record);

    int updateByPrimaryKey(TPrinter record);
}