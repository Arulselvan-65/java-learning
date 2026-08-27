package com.springboot.contact_manager.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class CommonUtil {

    public static boolean checkIsNullOrEmpty(Object data) {
        return data == null || data == "";
    }

    public static boolean checkIsNullOrEmpty(Collection<?> data) {
        return data == null || data.isEmpty();
    }

}
