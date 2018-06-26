package com.majunwei.jbone.sm.admin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

import cn.jbone.sm.admin.JboneSmAdminBanner;
import de.codecentric.boot.admin.config.EnableAdminServer;

@EnableTurbine
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
@EnableAdminServer
@EnableFeignClients
public class JboneSmAdminApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(JboneSmAdminApplication.class).banner(new JboneSmAdminBanner())
                .logStartupInfo(true).run(args);
    }
}
