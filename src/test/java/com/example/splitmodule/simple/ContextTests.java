package com.example.splitmodule.simple;

import com.example.splitmodule.simple.context.ModuleContext;
import com.example.splitmodule.simple.context.Order;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: yangxu
 * @Date: 2019/9/9 下午10:03
 */
public class ContextTests {

    @Test
    public void contextBuild(){
        Order order = new Order();
        order.setExternalOrderNo("123");
        ModuleContext context = ModuleContext.build()
                .buildWithTid(System.nanoTime())
                .buildWithLogPre("order1")
                .buildWithOrder(order);
        Assert.assertNotNull(context);
        Assert.assertEquals("order1",context.getLogPre());
        Assert.assertEquals("123",context.getOrder().getExternalOrderNo());

    }

}
