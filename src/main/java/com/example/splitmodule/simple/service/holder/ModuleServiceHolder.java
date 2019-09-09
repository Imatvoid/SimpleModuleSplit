package com.example.splitmodule.simple.service.holder;

import com.example.splitmodule.simple.anno.Module;
import com.example.splitmodule.simple.constant.ModuleEnum;
import com.example.splitmodule.simple.service.ModuleService;
import com.example.splitmodule.simple.utils.AopTargetUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Lazy(false)
@Component
public class ModuleServiceHolder implements InitializingBean, ApplicationContextAware {
    private ApplicationContext applicationContext;
    // 模块map
    private static final Map<ModuleEnum, ModuleService> cachedMap = new ConcurrentHashMap<>();

    public static ModuleService getModuleServiceCached(ModuleEnum module) {
        return cachedMap.get(module);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("【模块服务持有器】开始初始化");
        // 按照验证的业务粒度分类
        Map<String, ModuleService> moduleMap = this.applicationContext.getBeansOfType(ModuleService.class,false,true);
        log.info("【模块服务持有器】扫描到MapperService的实现：" + moduleMap.keySet());
        ModuleEnum key;

        for (ModuleService service : moduleMap.values()) {
            // 考虑被代理的情况
            ModuleService target = (ModuleService) AopTargetUtils.getTarget(service);
            if (null == target) {
                return;
            }
            key = target.getClass().getAnnotation(Module.class).value();
            log.info("【模块服务持有器】[" + key.getDesc() + "]：" + service.getClass().getName());
            if (!cachedMap.containsKey(key)) {
                cachedMap.put(key, service);
            }
        }
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
