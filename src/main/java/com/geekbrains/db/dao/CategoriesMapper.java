package com.geekbrains.db.dao;

import java.util.List;
import com.geekbrains.db.model.Categories;
import com.geekbrains.db.model.CategoriesExample;
import org.apache.ibatis.annotations.Param;

public interface CategoriesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Thu Jul 15 21:09:11 MSK 2021
     */
    long countByExample(CategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Thu Jul 15 21:09:11 MSK 2021
     * @param example
     */
    int deleteByExample(Categories example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Thu Jul 15 21:09:11 MSK 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Thu Jul 15 21:09:11 MSK 2021
     */
    int insert(Categories record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Thu Jul 15 21:09:11 MSK 2021
     */
    int insertSelective(Categories record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Thu Jul 15 21:09:11 MSK 2021
     */
    List<Categories> selectByExample(CategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Thu Jul 15 21:09:11 MSK 2021
     */
    Categories selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Thu Jul 15 21:09:11 MSK 2021
     */
    int updateByExampleSelective(@Param("record") Categories record, @Param("example") CategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Thu Jul 15 21:09:11 MSK 2021
     */
    int updateByExample(@Param("record") Categories record, @Param("example") CategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Thu Jul 15 21:09:11 MSK 2021
     */
    int updateByPrimaryKeySelective(Categories record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table categories
     *
     * @mbg.generated Thu Jul 15 21:09:12 MSK 2021
     */
    int updateByPrimaryKey(Categories record);
}