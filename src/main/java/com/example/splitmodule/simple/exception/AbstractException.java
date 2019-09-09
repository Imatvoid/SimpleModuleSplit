package com.example.splitmodule.simple.exception;

import java.util.*;

public abstract class AbstractException extends RuntimeException {

    private static final long serialVersionUID = 6969858828423999687L;

    private String code;
    private List args;
    private Stack<String> footPrint = new Stack<String>();

    public AbstractException() {
    }

    public static <T extends AbstractException> T build(Class<T> targetException, String code, Object... args) {
        if (code == null) {
            throw new IllegalArgumentException();
        } else {
            AbstractException exception;
            try {
                exception = (AbstractException)targetException.newInstance();
            } catch (Exception var5) {
                throw new RuntimeException(var5);
            }

            exception.setCode(code);
            if (args != null && args.length > 0) {
                List argsList = new ArrayList(args.length);
                Collections.addAll(argsList, args);
                exception.setArgs(argsList);
            }

            return (T)exception;
        }
    }

    public <T extends AbstractException> T convert(String app, Class<T> targetException) {
        AbstractException target;
        if (this.args != null) {
            target = build(targetException, this.code, this.args.toArray());
        } else {
            target = build(targetException, this.code);
        }

        target.hideStackTrace();
        target.setFootPrint(this.getFootPrint());
        target.addFootprint(app);
        return (T)target;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List getArgs() {
        return this.args;
    }

    public void setArgs(List args) {
        this.args = args;
    }

    public Stack<String> getFootPrint() {
        return this.footPrint;
    }

    public void setFootPrint(Stack<String> footPrint) {
        this.footPrint = footPrint;
    }

    public void addFootprint(String app) {
        this.footPrint.push(app);
    }

    public String generateFootprintInfo() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this.code);
        Iterator var2 = this.footPrint.iterator();

        while(var2.hasNext()) {
            String app = (String)var2.next();
            sb.append(" -> ").append(app);
        }

        return sb.toString();
    }

    public void hideStackTrace() {
        this.setStackTrace(new StackTraceElement[0]);
    }

    public String getMessage() {
        return this.code;
    }
}