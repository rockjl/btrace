package com.sun.btrace;

import java.net.URL;
import java.util.ServiceLoader;

public class TestRock {
    public static void main(String[] args) throws Exception{
        ServiceLoader<java.util.spi.ToolProvider> serviceLoader = ServiceLoader.load(java.util.spi.ToolProvider.class);
        for (java.util.spi.ToolProvider fs : serviceLoader) {
            System.out.println(fs.toString());
        }
        System.out.println("---------------------");
        Class clazz = Class.forName("com.sun.btrace.agent.PerfReaderImpl");
        System.out.println("::=" + clazz);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i=0; i<stackTrace.length; i++) {
            System.out.println("("+i+")" + stackTrace[i].getClassName() + ":" + stackTrace[i].getLineNumber());
        }
    }
}
