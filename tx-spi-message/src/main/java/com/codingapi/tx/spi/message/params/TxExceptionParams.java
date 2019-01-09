package com.codingapi.tx.spi.message.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description:
 * Date: 2018/12/20
 *
 * @author ujued
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TxExceptionParams implements Serializable {

    public static final short NOTIFY_UNIT_ERROR = 0;

    public static final short ASK_ERROR = 1;

    public static final short NOTIFY_GROUP_ERROR = 2;

    private String groupId;

    private String unitId;


    /**
     * 异常情况。-1 【未知】 0 【TxManager通知事务】， 1 【TxClient查询事务状态】 2 【事务发起方通知事务组】
     */
    private Short registrar;

    /**
     * 事务状态 0 回滚 1提交
     */
    private Short transactionState;
}