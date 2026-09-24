package com.checkr.interviews;

import java.util.HashMap;
import java.util.Map;

public class MapeamentoFinanciamento {

    public static Map<String, String> mapRow(String[] linha) {
        Map<String, String> mapped = new HashMap<>();

        mapped.put("permalink", linha[0]);
        mapped.put("company_name", linha[1]);
        mapped.put("number_employees", linha[2]);
        mapped.put("category", linha[3]);
        mapped.put("city", linha[4]);
        mapped.put("state", linha[5]);
        mapped.put("funded_date", linha[6]);
        mapped.put("raised_amount", linha[7]);
        mapped.put("raised_currency", linha[8]);
        mapped.put("round", linha[9]);

        return mapped;
    }
}