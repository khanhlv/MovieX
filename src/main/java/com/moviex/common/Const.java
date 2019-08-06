package com.moviex.common;

import java.util.HashMap;
import java.util.Map;

public final class Const {
    public final static int TIMEOUT = 10000;
    public final static Map<String, Integer> MAP_CATEGORY = new HashMap<>();

    static {
        MAP_CATEGORY.put("Hài Hước", 8);
        MAP_CATEGORY.put("Tình Cảm", 9);
        MAP_CATEGORY.put("Viễn Tưởng", 7);
        MAP_CATEGORY.put("Kinh Dị", 6);
    }
}
