package com.zzl.crm.settings.mapper;

import com.zzl.crm.settings.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbg.generated Tue Apr 26 12:06:18 CST 2022
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbg.generated Tue Apr 26 12:06:18 CST 2022
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbg.generated Tue Apr 26 12:06:18 CST 2022
     */
    int insertSelective(User user);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbg.generated Tue Apr 26 12:06:18 CST 2022
     */
    User selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbg.generated Tue Apr 26 12:06:18 CST 2022
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbg.generated Tue Apr 26 12:06:18 CST 2022
     */
    int updateByPrimaryKey(User record);

    /**
     * 登录查询
     * @param map
     * @return
     */
    User selectUserByLoginActAndPwd(Map<String,Object>map);

    /**
     * 查询所有
     * @return
     */
    List<User> selectAdd();
}
