package com.hfcsbc.operation.carlife.order.job.service;

import com.hfcsbc.operation.carlife.order.job.feign.CarLifeFeign;
import com.hfcsbc.utils.result.Code;
import com.hfcsbc.utils.result.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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
     * 生成前一天的无班次记录
     */
    @Override
    public void timerCreateRecordWithoutClassesYesterday() {
        log.info("------------------------------------------------------------");
        log.info("------------------------------------------------------------");
        log.info("------------------------ 生成无班次记录 start -------------------");
        Results<String> result = carLifeFeign.timerCreateRecordWithoutClassesYesterday();
        log.info((Code.SUCCESS.getBCode() == result.getCode()) ? "成功"
                : String.format("-- 失败:%s", result.getMsg()));
        log.info("------------------------ 生成无班次记录 end --------------------");
        log.info("------------------------------------------------------------");
        log.info("------------------------------------------------------------");
    }

    /**
     * 定时任务生成处理无报表数据
     */
    @Override
    public void createReport() {
        log.info("------------------------------------------------------------");
        log.info("------------------------------------------------------------");
        log.info("------------------------ 有班次记录无报表处理 start -------------------");
        Results<String> result = carLifeFeign.createReport();
        log.info((Code.SUCCESS.getBCode() == result.getCode()) ? "成功" : String.format("-- 失败:%s", result.getMsg()));
        log.info("------------------------ 有班次记录无报表处理 end --------------------");
        log.info("------------------------------------------------------------");
        log.info("------------------------------------------------------------");
    }

}
