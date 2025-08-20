package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author lyh
 * @date 2025/8/19
 */
@RestController
public class OrderController{
    /**
     * 这里的URL是服务提供者的地址
     * 在实际项目中，应该使用注册中心来获取服务提供者的地址
     * 这里为了简单起见，直接写死了
     */
    public static final String PaymentSrv_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    /**
     * 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求
     * 我们底层调用的是post方法，模拟消费者发送get请求，客户端消费者
     * 参数可以不添加@RequestBody
     * @param payDTO
     * @return
     */
    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add",payDTO,ResultData.class);
    }
    // 删除+修改操作作为家庭作业，O(∩_∩)O。。。。。。。

    @PutMapping("/consumer/pay/update")
    public ResultData updateOrder(@RequestBody PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/update",payDTO,ResultData.class);
    }

    @DeleteMapping("/consumer/pay/delete/{id}")
    public ResultData deleteOrder(@PathVariable Integer id){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/delete/"+id, ResultData.class, id);
    }


    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/"+id, ResultData.class, id);
    }

    @GetMapping("/consumer/pay/getAll")
    public ResultData getPayAll(){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/getAll", ResultData.class);
    }

}