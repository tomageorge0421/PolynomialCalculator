package org.example.business_logic;

import org.example.data_model.Polynomial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Add {
    public Add() {
    }

    public Polynomial addPolynomials(Polynomial p1, Polynomial p2) throws Exception {
        if (p1.getMap().isEmpty() || p2.getMap().isEmpty()) {
            throw new Exception("Nu poti face adunarea");
        }
        Polynomial p3 = new Polynomial();
        TreeMap<Integer, Double> m1 = p1.getMap();
        TreeMap<Integer, Double> m2 = p2.getMap();
        TreeMap<Integer, Double> m3 = p3.getMap();
        int check = -1;
        for (Map.Entry<Integer, Double> entry1 : m1.descendingMap().entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : m2.descendingMap().entrySet()) {
                if (entry1.getKey() > entry2.getKey()) check = 1;
                else check = 2;
                break;
            }
            break;
        }
        if (check == 1) {
            for (Map.Entry<Integer, Double> entry1 : m1.descendingMap().entrySet()) {
                m3.put(entry1.getKey(), (double) 0);
            }
        } else if (check == 2) {
            for (Map.Entry<Integer, Double> entry2 : m2.descendingMap().entrySet()) {
                m3.put(entry2.getKey(), (double) 0);
            }
        }
        for (Map.Entry<Integer, Double> entry1 : m1.descendingMap().entrySet()) {
            m3.put(entry1.getKey(), entry1.getValue());
        }
        for (Map.Entry<Integer, Double> entry2 : m2.descendingMap().entrySet()) {
            if (m3.get(entry2.getKey()) == null) m3.put(entry2.getKey(), (double) 0);
            m3.put(entry2.getKey(), m3.get(entry2.getKey()) + entry2.getValue());
        }
        p3.setMap(m3);
        return p3;
    }
}
