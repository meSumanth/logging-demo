package com.logging.demo.loggingdemo;

import java.util.Map;

class ThreadLocalUtil {
    private static ThreadLocal<Map<String, Object>> dataTL = new ThreadLocal<>();

    public static void setData(Map map) {
        dataTL.set(map);
    }

    public static Map getData() {
        return dataTL.get();
    }

    public static void clear() {
        dataTL.remove();
    }
}