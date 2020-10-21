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
            // 创建昨日无班次记录
            cariLifeOilOrderService.timerCreateRecordWithoutClassesYesterday();
            // 班次无报表创建报表
            cariLifeOilOrderService.createReport();
        };
    }

}
