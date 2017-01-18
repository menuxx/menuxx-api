package com.mall.mapper;

import com.mall.model.TAddress;
import com.mall.model.TAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    int countByExample(TAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    int deleteByExample(TAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    int insert(TAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    int insertSelective(TAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    List<TAddress> selectByExample(TAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    TAddress selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    int updateByExampleSelective(@Param("record") TAddress record, @Param("example") TAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    int updateByExample(@Param("record") TAddress record, @Param("example") TAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    int updateByPrimaryKeySelective(TAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbggenerated Wed Jan 18 15:35:21 CST 2017
     */
    int updateByPrimaryKey(TAddress record);
}