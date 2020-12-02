package com.hfcsbc.operation.carlife.order.job.feign;

import com.hfcsbc.utils.result.Results;
import org.springframework.stereotype.Component;

/**
 * @author qidongliang
 * @email 18919656953@163.com
 * @dateTime 2020/10/19
 * @description xxx
 */
@Component
public class CarLifeCallback implements CarLifeFeign{

    @Override
    public Results<String> timerUpdateOrderQuantity() {
        return Results.failure(null, "请求失败");
    }

    @Override
    public Results<String> timerCreateRecordWithoutClassesYesterday() {
        return Results.failure(null, "请求失败");
    }

    @Override
    public Results<String> createReport() {
        return Results.failure(null, "请求失败");
    }

    @Override
    public Results<String> couponSettingOverDue() {
        return Results.failure(null, "请求接口失败");
    }

}
