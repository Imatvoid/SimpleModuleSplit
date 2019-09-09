package com.example.splitmodule.simple.anno;


import com.example.splitmodule.simple.constant.ModuleEnum;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Module {

    /**
     * 所属模块, 参考：{@link ModuleEnum}
     *
     */
    ModuleEnum value();
}
