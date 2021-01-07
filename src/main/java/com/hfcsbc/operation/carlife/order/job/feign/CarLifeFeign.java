package com.hfcsbc.operation.carlife.order.job.feign;

import com.hfcsbc.utils.result.Results;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author qidongliang
 * @email 18919656953@163.com
 * @dateTime 2020/10/19
 * @description xxx
 */
@FeignClient(value = "operation-carlife-order-job", url = "http://tyh-operation:9002", fallback = CarLifeCallback.class)
//@FeignClient(value = "operation-carlife-order-job", url = "localhost:9002", fallback = CarLifeCallback.class)
public interface CarLifeFeign {

    @RequestMapping(method = RequestMethod.POST, value = "/carLife/oil/order/timer/updateOrderQuantity", consumes = MediaType.APPLICATION_JSON_VALUE)
    Results<String> timerUpdateOrderQuantity();

    /**
     * 重新生成失败的报表
     */
    @RequestMapping(method = RequestMethod.POST, value = "/carLife/oil/report/timer/repeatCreateFailedReport", consumes = MediaType.APPLICATION_JSON_VALUE)
    Results<String> timerRepeatCreateFailedReport();

    @RequestMapping(method = RequestMethod.POST, value = "/carLife/userGoods/api/setting/overdue/inner", consumes = MediaType.APPLICATION_JSON_VALUE)
    Results<String> couponSettingOverDue();

    /**
     * 定时任务统计每日订单量
     */
    @RequestMapping(method = RequestMethod.POST, value = "/carLife/oilOrderCount/timer/statistics", consumes = MediaType.APPLICATION_JSON_VALUE)
    Results<String> timerStatistics(@RequestParam Integer day);

    /**
     * 定时任务发放权益
     */
    @RequestMapping(method = RequestMethod.POST, value = "/carLife/cardTemplate/timer/welfare", consumes = MediaType.APPLICATION_JSON_VALUE)
    Results<String> timerWelfare();

}
