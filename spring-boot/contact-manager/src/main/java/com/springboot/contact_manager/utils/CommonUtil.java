package com.springboot.contact_manager.utils;


import java.util.Collection;


public class CommonUtil {

    public static boolean checkIsNullOrEmpty(Object data) {
        return data == null;
    }

    public static boolean checkIsNullOrEmpty(String data) {
        return data == null || data.isEmpty();
    }

    public static boolean checkIsNullOrEmpty(Collection<?> data) {
        return data == null || data.isEmpty();
    }

}
