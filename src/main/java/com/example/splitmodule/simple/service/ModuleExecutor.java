package com.example.splitmodule.simple.service;


import com.example.splitmodule.simple.constant.ModuleEnum;
import com.example.splitmodule.simple.context.ModuleContext;
import com.example.splitmodule.simple.exception.ErrorCodeEnum;
import com.example.splitmodule.simple.exception.ExceptionBuilder;
import com.example.splitmodule.simple.service.holder.ModuleServiceHolder;
import lombok.extern.slf4j.Slf4j;

/**
 * 模块执行器
 */
@Slf4j
public class ModuleExecutor {
    /**
     * @param module  {@link ModuleEnum}
     * @param context 上下文对象
     */
    public static void execute(ModuleContext context, ModuleEnum module) {

        try {
            ModuleService service = ModuleServiceHolder.getModuleServiceCached(module);

            if (null == service) {
                log.error("{}【模块映射】没有匹配到对应的映射服务:{}", context.getLogPre(), module.getDesc());
                throw ExceptionBuilder.buildException(ErrorCodeEnum.SYSTEM_ERROR, "【模块映射】没有匹配到对应的映射服务：" + module.getDesc() + ",请检查配置");
            }

            long beginTime = System.nanoTime();

            log.info("{}【模块映射】模块:{}, 执行服务:{}", context.getLogPre(), module.getDesc(), service.getClass().getName());

            service.execute(context);

            log.info(context.getLogPre() + "【模块映射】模块：" + module.getDesc() + "， " + "验证耗时(ms)：" + (System.nanoTime() - beginTime) / 1e6);


        } catch (Exception ex) {
            log.error(context.getLogPre() + "【模块映射】模块：" + module.getDesc() + ", 发生未知异常：" + ex.getMessage(), ex);
        } finally {

        }
    }
}
