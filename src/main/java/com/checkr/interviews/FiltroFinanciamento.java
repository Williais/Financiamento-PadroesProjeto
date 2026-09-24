package com.checkr.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FiltroFinanciamento {

    public static List<Map<String, String>> filter(List<Map<String, String>> data, Map<String, String> options) {
        List<Map<String, String>> results = new ArrayList<>();

        for (Map<String, String> row : data) {
            if (matchesAllOptions(row, options)) {
                results.add(row);
            }
        }
        return results;
    }

    private static boolean matchesAllOptions(
            Map<String, String> row,
            Map<String, String> options) {

        for (Map.Entry<String, String> option : options.entrySet()) {
            String key = option.getKey();
            String expectedValue = option.getValue();

            if (!row.containsKey(key) || !row.get(key).equals(expectedValue)) {
                return false;
            }
        }

        return true;
    }
}