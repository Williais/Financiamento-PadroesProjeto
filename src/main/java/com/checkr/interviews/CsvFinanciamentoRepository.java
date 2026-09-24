package com.checkr.interviews;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CsvFinanciamentoRepository implements FinanciamentoRepository {
    private final String caminhoArquivo;

    public CsvFinanciamentoRepository(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    @Override
    public List<Map<String, String>> getAllData() throws IOException {
        List<Map<String, String>> data = new ArrayList<>();

        // try-with-resources
        try (CSVReader reader = new CSVReader(new FileReader(caminhoArquivo))) {
            String[] linha;
            reader.readNext();

            while ((linha = reader.readNext()) != null) {
                data.add(MapeamentoFinanciamento.mapRow(linha));
            }
        }
        return data;
    }
}