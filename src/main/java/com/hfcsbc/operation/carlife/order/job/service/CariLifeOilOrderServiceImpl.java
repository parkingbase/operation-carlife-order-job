package com.hfcsbc.operation.carlife.order.job.service;

import com.hfcsbc.operation.carlife.order.job.feign.CarLifeFeign;
import com.hfcsbc.utils.result.Code;
import com.hfcsbc.utils.result.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @author qidongliang
 * @email 18919656953@163.com
 * @dateTime 2020/10/19
 * @description xxx
 */
@Slf4j
@Component
public class CariLifeOilOrderServiceImpl implements CariLifeOilOrderService {

    @Resource
    private CarLifeFeign carLifeFeign;

    /**
     * 获取前一天的订单量更新加油站人气
     */
    @Override
    public void timerUpdateOrderQuantity() {
        log.info("------------------------------------------------------------");
        log.info("------------------------------------------------------------");
        log.info("------------------------ 更新油站人气 start -------------------");
        Results<String> result = carLifeFeign.timerUpdateOrderQuantity();
        log.info((Code.SUCCESS.getBCode() == result.getCode()) ? String.format("-- 成功！%s", result.getData())
                : String.format("-- 失败！%s", result.getMsg()));
        log.info("------------------------ 更新油站人气 end --------------------");
        log.info("------------------------------------------------------------");
        log.info("------------------------------------------------------------");
    }

    /**
     * 重新生成失败的报表
     */
    @Override
    public void timerRepeatCreateFailedReport() {
        log.info("------------------------------------------------------------");
        log.info("------------------------------------------------------------");
        log.info("------------------------ 重新生成失败的报表 start -------------------");
        Results<String> result = carLifeFeign.timerRepeatCreateFailedReport();
        log.info((Code.SUCCESS.getBCode() == result.getCode()) ? String.format("-- 成功！%s", result.getData())
                : String.format("-- 失败！%s", result.getMsg()));
        log.info("------------------------ 重新生成失败的报表 end --------------------");
        log.info("------------------------------------------------------------");
        log.info("------------------------------------------------------------");
    }

    /**
     * 请求更新商品券状态
     */
    @Override
    public void couponSettingOverDue() {
        log.info("------------------------------------------------------------");
        log.info("------------------------ 商品券状态变更 开始 -------------------");
        Results<String> result = carLifeFeign.couponSettingOverDue();
        log.info( ObjectUtils.nullSafeEquals(result.getCode(), 8888) ? String.format("-- 成功！%s", result.getData()) : String.format("-- 失败！%s", result.getMsg()));
        log.info("------------------------ 商品券状态变更 结束 --------------------");
        log.info("------------------------------------------------------------");
    }

    /**
     * 定时任务统计昨日订单量
     */
    @Override
    public void timerStatistics() {
        log.info("------------------------------------------------------------");
        log.info("------------------------ 定时任务统计昨日订单量 开始 -------------------");
        Results<String> result = carLifeFeign.timerStatistics(-1);
        log.info( ObjectUtils.nullSafeEquals(result.getCode(), 8888) ? String.format("-- 成功！%s", result.getData()) : String.format("-- 失败！%s", result.getMsg()));
        log.info("------------------------ 定时任务统计昨日订单量 结束 --------------------");
        log.info("------------------------------------------------------------");
    }

    /**
     * 定时任务发放储值卡权益
     */
    @Override
    public void timerWelfare() {
        log.info("------------------------------------------------------------");
        log.info("------------------------ 定时任务发放储值卡权益 开始 -------------------");
        Results<String> result = carLifeFeign.timerWelfare();
        log.info( ObjectUtils.nullSafeEquals(result.getCode(), 8888) ? String.format("-- 成功！%s", result.getData()) : String.format("-- 失败！%s", result.getMsg()));
        log.info("------------------------ 定时任务发放储值卡权益 结束 --------------------");
        log.info("------------------------------------------------------------");
    }


}
