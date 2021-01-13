package com.hfcsbc.operation.carlife.order.job.service;

/**
 * @author qidongliang
 * @email 18919656953@163.com
 * @dateTime 2020/10/19
 * @description 处理加油订单
 */
public interface CariLifeOilOrderService {

    /**
     * 获取前一天的订单量更新加油站人气
     */
    void timerUpdateOrderQuantity();

    /**
     * 重新生成失败的报表
     */
    void timerRepeatCreateFailedReport();

    /**
     * 重新生成失败的报表 (权益卡)
     */
    void timerRepeatCreateFailedReportCard();

    /**
     * 请求更新商品券状态
     */
    void couponSettingOverDue();

    /**
     * 定时任务统计昨日订单量
     */
    void timerStatistics();

    /**
     * 定时任务发放储值卡权益
     */
    void timerWelfare();

}
