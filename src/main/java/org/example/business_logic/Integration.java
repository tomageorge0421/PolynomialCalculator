package org.example.business_logic;

import org.example.data_model.Polynomial;

import java.util.Map;
import java.util.TreeMap;

public class Integration {
    public Integration() {
    }

    public Polynomial IntegratePolynomial(Polynomial p1) throws Exception {
        if(p1.getMap().isEmpty()){
            throw new Exception("Nu poti face integrarea");
        }
        Polynomial p3 = new Polynomial();
        TreeMap<Integer, Double> m1 = p1.getMap();
        TreeMap<Integer, Double> m3 = p3.getMap();
        int dim = -1;
        for (Map.Entry<Integer, Double> entry1 : m1.descendingMap().entrySet()) {
            dim = entry1.getKey();
            break;
        }
        m3.put(dim + 1, (double) 0);
        for (Map.Entry<Integer, Double> entry1 : m1.descendingMap().entrySet()) {
            m3.put(entry1.getKey(), (double) 0);
        }
        for (Map.Entry<Integer, Double> entry1 : m1.entrySet()) {
            m3.put(entry1.getKey() + 1, (1.0 / (entry1.getKey() + 1)) * entry1.getValue());
        }
        p3.setMap(m3);
        return p3;
    }
}
