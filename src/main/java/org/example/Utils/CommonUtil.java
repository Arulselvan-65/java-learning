package org.example.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommonUtil {

    public static boolean checkIsNullOrEmpty(List data) {
        return data == null || data.isEmpty();
    }

    public static boolean checkIsNullOrEmpty(Object data) {
        return data == null;
    }

}
