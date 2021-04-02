package com.lorain.aopdemo.controller;

import com.lorain.aopdemo.config.PropertyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@RequestMapping("/v1/aop/")
public class AOPDemoController {

    @Value("${node.id}")
    private int node_id;

    @Value("${node.role}")
    private String node_role;

    @Autowired
    private Date mookDate;

    @Autowired
    private Environment environment;

    @Autowired
    private PropertyConfig propertyConfig;

    @RequestMapping(value = "node", method = RequestMethod.GET)
    public String get(HttpServletRequest request, HttpServletResponse response){ // request和response对get方法是可选参数
        System.out.println("execute queryNode");
        System.out.println("TOKEN=" + request.getHeader("token"));
        response.addHeader("test", "6666");

        String dateStr = mookDate.toString();

        System.out.println("root.sk=" + environment.getProperty("root.sk"));
        return "{\"id\":" + node_id + ", \"role\":\"" + node_role + "\", \"date\":\""+ dateStr + "\", \"ak\":\"" + propertyConfig.getAk() + "\"}";
    }

}

