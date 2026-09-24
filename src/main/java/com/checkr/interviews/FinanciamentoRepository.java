package com.checkr.interviews;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface FinanciamentoRepository {
    List<Map<String, String>> getAllData() throws IOException;
}