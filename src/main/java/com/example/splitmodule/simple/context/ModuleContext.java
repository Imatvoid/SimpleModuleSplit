package com.example.splitmodule.simple.context;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
public class ModuleContext implements Serializable {

    private static final long serialVersionUID = 2300055553282466135L;

    private String no;

    private Order order;

    // 附加属性
    private Map<String, Object> attachmentMap = new HashMap<String, Object>();

    protected static final String KEY_TID = "KEY_TID";
    public static final String KEY_LOG_PRE = "KEY_LOG_PRE";


    public void putTid(Long tid) {
        this.attachmentMap.put(KEY_TID, tid);
    }

    public Long getTid() {
        return (Long) this.attachmentMap.get(KEY_TID);
    }

    public void putLogPre(String pre) {
        this.attachmentMap.put(KEY_LOG_PRE, pre);
    }

    public String getLogPre() {
        return (String) this.attachmentMap.get(KEY_LOG_PRE);
    }

    public static ModuleContext build(){
        return  new ModuleContext();
    }

    public ModuleContext buildWithOrder(Order order) {
        this.order = order;
        return this;
    }

    public ModuleContext buildWithTid(Long tid) {
        this.attachmentMap.put(KEY_TID, tid);
        return this;
    }

    public ModuleContext buildWithLogPre(String pre) {
        this.attachmentMap.put(KEY_LOG_PRE, pre);
        return this;
    }

}
