package com.mmall.controller;

import com.mmall.config.ProjectConfig;
import com.mmall.service.NacosClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/nacos-client")
public class NacosClientController {

    private final NacosClientService nacosClientService;
    private final ProjectConfig projectConfig;

    public NacosClientController(NacosClientService nacosClientService,
                                 ProjectConfig projectConfig) {
        this.nacosClientService = nacosClientService;
        this.projectConfig = projectConfig;
    }


    @GetMapping("/service-instance")
    public List<ServiceInstance> logNacosConfig(@RequestParam (defaultValue = "e-commerce-nacos-client") String serviceId){
        return nacosClientService.getNacosClientInfo(serviceId);
    }

}
