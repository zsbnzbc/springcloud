package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lyh
 * * @date 2025/8/19
 */
@RestController
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("/pay/add")
    @Operation(summary = "添加支付记录", description = "添加支付记录")
    public ResultData<String> addPay(@RequestBody Pay pay){
        int i = payService.add(pay);

        return ResultData.success("成功添加支付记录，返回值：" + i);
    }

    @DeleteMapping("/pay/del/{id}")
    @Operation(summary = "删除支付记录", description = "根据ID删除支付记录")
    public ResultData<String> detelePay(@PathVariable("id") Integer id) {
        // Implementation for deleting a payment by ID
        // Placeholder return value
        return ResultData.success("成功删除支付记录，返回值：" + id);
    }

    @PutMapping("/pay/update")
    @Operation(summary = "更新支付记录", description = "更新支付记录")
    public ResultData<String > updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        int i = payService.update(pay);
        // Implementation for updating a payment
        // Placeholder return value

        return ResultData.success("成功修改记录，返回值：" + i);
    }

    @GetMapping("/pay/get/{id}")
    @Operation(summary = "获取支付记录", description = "根据ID获取支付记录")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        // Implementation for getting a payment by ID
        // Placeholder return value
        if(id < 0) {
            throw new RuntimeException("id不能为负数");
        }

        Pay pay = payService.getById(id);
        if(pay == null) {
            return ResultData.fail("404","没有找到对应的记录，ID：" + id);
        }
        return ResultData.success(pay);
    }

    @GetMapping("/pay/getAll")
    @Operation(summary = "获取所有支付记录", description = "获取所有支付记录")
    public ResultData<List<Pay>> getAll() {
        // Implementation for getting all payments
        // Placeholder return value
        List<Pay> all = payService.getAll();
        return ResultData.success(all);
    }


    @Value("${server.port}")
    private String port;

    @GetMapping("/pay/get/info")
    public String getInfoByConsul(@Value("${atguigu.info}") String atguiguInfo) {

        return "atguiguInfo: " + atguiguInfo + "port;: " + port;

    }
}
