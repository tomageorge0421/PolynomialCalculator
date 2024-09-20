package org.example.business_logic;

import org.example.data_model.Polynomial;

import java.util.Map;
import java.util.TreeMap;

public class Multiplication {
    public Multiplication() {
    }

    public Polynomial MultiplicatePolynomials(Polynomial p1, Polynomial p2) throws Exception {
        if(p1.getMap().isEmpty() || p2.getMap().isEmpty()){
            throw new Exception("Nu poti face inmultirea");
        }
        Polynomial p3 = new Polynomial();
        TreeMap<Integer, Double> m1 = p1.getMap();
        TreeMap<Integer, Double> m2 = p2.getMap();
        TreeMap<Integer, Double> m3 = p3.getMap();
        for (Map.Entry<Integer, Double> entry1 : m1.descendingMap().entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : m2.descendingMap().entrySet()) {
                m3.put(entry1.getKey() + entry2.getKey(), (double) 0);
            }
        }
        for (Map.Entry<Integer, Double> entry1 : m1.descendingMap().entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : m2.descendingMap().entrySet()) {
                m3.put(entry1.getKey() + entry2.getKey(), m3.get(entry1.getKey() + entry2.getKey()) + (entry1.getValue() * entry2.getValue()));
            }
        }
        p3.setMap(m3);
        return p3;
    }
}
