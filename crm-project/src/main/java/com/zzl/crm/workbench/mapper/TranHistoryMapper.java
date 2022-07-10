package com.zzl.crm.workbench.mapper;

import com.zzl.crm.workbench.pojo.TranHistory;

import java.util.List;

public interface TranHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran_history
     *
     * @mbg.generated Sun May 15 10:52:17 CST 2022
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran_history
     *
     * @mbg.generated Sun May 15 10:52:17 CST 2022
     */
    int insert(TranHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran_history
     *
     * @mbg.generated Sun May 15 10:52:17 CST 2022
     */
    int insertSelective(TranHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran_history
     *
     * @mbg.generated Sun May 15 10:52:17 CST 2022
     */
    TranHistory selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran_history
     *
     * @mbg.generated Sun May 15 10:52:17 CST 2022
     */
    int updateByPrimaryKeySelective(TranHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_tran_history
     *
     * @mbg.generated Sun May 15 10:52:17 CST 2022
     */
    int updateByPrimaryKey(TranHistory record);

    /**
     * 保存创建的交易历史
     * @param tranHistory
     * @return
     */
    int saveCreateTranHistory(TranHistory tranHistory);

    /**
     * 查询当前交易下的历史信息
     * @param tranId
     * @return
     */
    List<TranHistory> inquireTranHistoryByTranId(String tranId);
}
