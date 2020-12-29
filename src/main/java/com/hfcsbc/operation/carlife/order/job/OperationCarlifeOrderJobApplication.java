package com.hfcsbc.operation.carlife.order.job;

import com.hfcsbc.operation.carlife.order.job.service.CariLifeOilOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@ComponentScan(value = "com.hfcsbc.*")
@EnableFeignClients
@SpringBootApplication
public class OperationCarlifeOrderJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperationCarlifeOrderJobApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CariLifeOilOrderService cariLifeOilOrderService) {
        return e -> {
            // 更新加油站人气
            cariLifeOilOrderService.timerUpdateOrderQuantity();
            // 定时任务重新生成失败的报表
            cariLifeOilOrderService.timerRepeatCreateFailedReport();
            // 商品券状态更新
            cariLifeOilOrderService.couponSettingOverDue();
            // 定时任务统计昨日订单量
            cariLifeOilOrderService.timerStatistics();
        };
    }

}
