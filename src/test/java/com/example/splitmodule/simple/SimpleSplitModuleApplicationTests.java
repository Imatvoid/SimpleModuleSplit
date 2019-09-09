package com.example.splitmodule.simple;

import com.example.splitmodule.simple.constant.ModuleEnum;
import com.example.splitmodule.simple.context.ModuleContext;
import com.example.splitmodule.simple.context.Order;
import com.example.splitmodule.simple.exception.ErrorCodeEnum;
import com.example.splitmodule.simple.exception.ExceptionBuilder;
import com.example.splitmodule.simple.exception.XXException;
import com.example.splitmodule.simple.service.ModuleExecutor;
import com.example.splitmodule.simple.service.ModuleService;
import com.example.splitmodule.simple.service.holder.ModuleServiceHolder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleSplitModuleApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    ModuleServiceHolder moduleServiceHolder;

    @Test
    public void getModule() {
        ModuleService moduleServiceA = ModuleServiceHolder.getModuleServiceCached(ModuleEnum.A);
        Assert.assertNotNull(moduleServiceA);

        ModuleService moduleServiceB = ModuleServiceHolder.getModuleServiceCached(ModuleEnum.B);
        Assert.assertNotNull(moduleServiceB);

        ModuleService moduleServiceC = ModuleServiceHolder.getModuleServiceCached(ModuleEnum.C);
        Assert.assertNotNull(moduleServiceC);
    }

    @Test
    public void Executor() {

        Order order = new Order();
        order.setExternalOrderNo("order1");
        order.setOrderDetailList(null);
        try {
            ModuleContext context = ModuleContext.build()
                    .buildWithTid(System.nanoTime())
                    .buildWithLogPre("[测试订单,no=order1]")
                    .buildWithOrder(order);

            ModuleExecutor.execute(context, ModuleEnum.A);
            ModuleExecutor.execute(context, ModuleEnum.B);
            ModuleExecutor.execute(context, ModuleEnum.C);

        } catch (XXException e) {
            e.setErrorMessage("下单失败。" + e.getErrorMessage());
            throw e;
        } catch (Exception e) {
            throw ExceptionBuilder.buildException(ErrorCodeEnum.UNKNOWN_ERROR, "下单失败,未知异常");
        }
    }


}
