package com.example.splitmodule.simple.service.impl;

import com.example.splitmodule.simple.anno.Module;
import com.example.splitmodule.simple.constant.ModuleEnum;
import com.example.splitmodule.simple.context.ModuleContext;
import com.example.splitmodule.simple.service.ModuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Module(ModuleEnum.B)
public class ModuleB implements ModuleService {

    @Override
    public void execute(ModuleContext context) {
          log.info("执行模块B");
    }
}
