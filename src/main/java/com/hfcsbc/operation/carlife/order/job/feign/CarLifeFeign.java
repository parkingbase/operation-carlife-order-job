package com.hfcsbc.operation.carlife.order.job.feign;

import com.hfcsbc.utils.result.Results;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(method = RequestMethod.POST, value = "/carLife/station/classRecord/timer/createRecordWithoutClassesYesterday", consumes = MediaType.APPLICATION_JSON_VALUE)
    Results<String> timerCreateRecordWithoutClassesYesterday();

    @RequestMapping(method = RequestMethod.POST, value = "/carLife/oil/report/timer/createReport", consumes = MediaType.APPLICATION_JSON_VALUE)
    Results<String> createReport();

}
