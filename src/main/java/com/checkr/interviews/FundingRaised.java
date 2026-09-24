package com.checkr.interviews;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FundingRaised {

    private static final FinanciamentoRepository repository = new CsvFinanciamentoRepository("startup_funding.csv");

    public static List<Map<String, String>> where(Map<String, String> options) throws IOException {
        List<Map<String, String>> allData = repository.getAllData();
        return FiltroFinanciamento.filter(allData, options);
    }

    public static Map<String, String> findBy(Map<String, String> options) throws IOException, NoSuchEntryException {
        List<Map<String, String>> allData = repository.getAllData();
        List<Map<String, String>> filtered = FiltroFinanciamento.filter(allData, options);

        if (filtered.isEmpty()) {
            throw new NoSuchEntryException();
        }

        return filtered.get(0);
    }

    public static void main(String[] args) {
        try {
            Map<String, String> options = new HashMap<>();
            options.put("company_name", "Facebook");
            options.put("round", "a");
            System.out.print(FundingRaised.where(options).size());
        } catch(IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }
}