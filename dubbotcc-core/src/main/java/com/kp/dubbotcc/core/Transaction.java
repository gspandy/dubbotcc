package com.kp.dubbotcc.core;

import com.kp.dubbotcc.commons.emuns.TransactionStatus;
import com.kp.dubbotcc.commons.utils.Assert;
import com.kp.dubbotcc.commons.utils.DateUtils;
import com.kp.dubbotcc.commons.utils.GenerateUniqueId;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 事务处理对象
 *
 * @author chenbin@kuparts.com
 * @author chenbin
 * @version 1.0
 **/
public class Transaction implements Serializable {
    /**
     * 事务ID号
     */
    private String transId;
    /**
     * 事务开始是间
     */
    private long startTime;
    /**
     * 事务执行状态
     */
    private TransactionStatus status;
    /**
     * 需要调用的服务点
     */
    private List<ServicePoint> points = null;

    /**
     * 初始化事务信息
     */
    public Transaction() {
        transId = GenerateUniqueId.getInstance().getUniqIDHashString();
        startTime = DateUtils.nowEpochSecond();
        status = TransactionStatus.BEGIN;
        points = new CopyOnWriteArrayList<ServicePoint>();
    }

    /**
     * 获取事务ID
     *
     * @return 事务唯一ID
     */
    public String getTransId() {
        return transId;
    }

    /**
     * 事务开始时间
     *
     * @return 时间long
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * 事务当前的执行状态
     *
     * @return 状态
     */
    public TransactionStatus getStatus() {
        return status;
    }

    /**
     * 修改事务状态
     *
     * @param status 状态
     * @see TransactionStatus
     */
    public void modifyStatus(TransactionStatus status) {
        this.status = status;
    }

    /**
     * 获取事务的服务点信息
     *
     * @return 所有服务点信息
     */
    public List<ServicePoint> getPotins() {
        return points;
    }

    /**
     * 增加一个服务点
     *
     * @param point 服务点信息
     * @see ServicePoint
     */
    public void addServicePotin(ServicePoint point) {
        Assert.notNull(point, "servicePoint is null");
        points.add(point);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transId='" + transId + '\'' +
                ", startTime=" + startTime +
                ", status=" + status +
                ", potins=" + points +
                '}';
    }
}
