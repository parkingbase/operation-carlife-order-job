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
     * 请求更新商品券状态
     */
    void couponSettingOverDue();

}
