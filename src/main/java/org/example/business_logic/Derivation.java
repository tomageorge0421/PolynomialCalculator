package org.example.business_logic;

import org.example.data_model.Polynomial;

import java.util.Map;
import java.util.TreeMap;

public class Derivation {

    public Derivation() {
    }
    public Polynomial DerivatePolynomial(Polynomial p1) throws Exception {
        if(p1.getMap().isEmpty()){
            throw new Exception("Nu poti face derivarea");
        }
        Polynomial p3 = new Polynomial();
        TreeMap<Integer, Double> m1 = p1.getMap();
        TreeMap<Integer, Double> m3 = p3.getMap();
        for (Map.Entry<Integer, Double> entry1 : m1.descendingMap().entrySet()) {
            m3.put(entry1.getKey(), (double) 0);
        }
        for (Map.Entry<Integer, Double> entry1 : m1.descendingMap().entrySet()) {
            double val = entry1.getKey() * entry1.getValue();
            if(entry1.getKey()>0) m3.put(entry1.getKey()-1,val);
        }
        p3.setMap(m3);
        return p3;
    }
}
