package com.cjb666.demo.feign;

import com.cjb666.api.feign.DemoClient;
import com.cjb666.demo.model.Example;
import com.cjb666.demo.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微服接口模版
 * DemoClient 为对外提供的微服务接口
 * ProviderFeignController 为该接口的实现
 **/
@RestController
@Slf4j
public class DemoFeignController implements DemoClient {

    @Autowired
    private ExampleService exampleService;
    public String call(String name) {

        Example example = new Example();
        example.setExampleName("测试样例 AAA");
        example.setStatus(1);
        exampleService.save(example);
        System.out.println(exampleService.getExampleById(example.getExampleId()));
        example.setExampleName("测试样例 BBB");
        exampleService.update(example);
        System.out.println(exampleService.getExampleById(example.getExampleId()));
        exampleService.deleteExampleById(example.getExampleId());
        System.out.println(exampleService.getExampleById(example.getExampleId()));

        //redis
        exampleService.cacheExampleToRedis(example);
        Example example1 = exampleService.getExampleFromRedis(example.getExampleId().toString());

        //redis lua


        System.out.println(example1);

        return "我是服务提供者demo，hello： " + name;
    }
}
