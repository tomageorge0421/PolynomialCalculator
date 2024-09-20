package org.example.business_logic;

import org.example.data_model.Polynomial;

import java.util.Map;
import java.util.TreeMap;

public class Division {
    public Division() {
    }

    public int CalculeazaGrad(Polynomial p1, Polynomial p2) {
        TreeMap<Integer, Double> m1 = p1.getMap();
        TreeMap<Integer, Double> m2 = p2.getMap();
        int check = -1;
        for (Map.Entry<Integer, Double> entry1 : m1.descendingMap().entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : m2.descendingMap().entrySet()) {
                if (entry2.getKey() >= entry1.getKey()) check = 1;
                else check = 0;
                break;
            }
            break;
        }
        return check;
    }

    public Polynomial[] DivPolynomialCat(Polynomial p1, Polynomial p2) {
        Polynomial[] vector = new Polynomial[2];
        Polynomial cat = new Polynomial();
        Polynomial rest = new Polynomial();
        TreeMap<Integer, Double> m1 = p1.getMap();
        TreeMap<Integer, Double> m2 = p2.getMap();
        TreeMap<Integer, Double> mapCat = cat.getMap();
        TreeMap<Integer, Double> mapRest = rest.getMap();
        Polynomial outputCat = new Polynomial();
        TreeMap<Integer, Double> mapOuputCat = outputCat.getMap();
        int check = -1;
        for (Map.Entry<Integer, Double> entry1 : m1.descendingMap().entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : m2.descendingMap().entrySet()) {
                if (entry2.getKey() > entry1.getKey()) check = 2;
                else check = 1;
                break;
            }
            break;
        }
        if (check == 1) {
            for (Map.Entry<Integer, Double> entry1 : m1.descendingMap().entrySet()) {
                mapCat.put(entry1.getKey(), (double) 0);
                mapRest.put(entry1.getKey(), (double) 0);
            }
        } else if (check == 2) {
            for (Map.Entry<Integer, Double> entry2 : m2.descendingMap().entrySet()) {
                mapCat.put(entry2.getKey(), (double) 0);
                mapRest.put(entry2.getKey(), (double) 0);
            }
        }
        if (check == 1) {
            int grad = -1;
            double coef = (double) 0;
            int verificare = 1;
            while (verificare == 1) {
                for (Map.Entry<Integer, Double> entry1 : m1.descendingMap().entrySet()) {
                    for (Map.Entry<Integer, Double> entry2 : m2.descendingMap().entrySet()) {
                        grad = entry1.getKey() - entry2.getKey();
                        coef = entry1.getValue() / entry2.getValue();
                        mapCat.put(grad, coef);
                        break;
                    }
                    break;
                }
                Multiplication mul = new Multiplication();
                try {
                    Polynomial resultMul = mul.MultiplicatePolynomials(p2, cat);
                    rest.setMap(resultMul.getMap());
                    Substract dif = new Substract();
                    try {
                        Polynomial resultDif = dif.substractPolynomials(p1, rest);
                        p1.setMap((resultDif.getMap()));
                        m1 = p1.getMap();
                        TreeMap<Integer, Double> mapaAuxiliara = new TreeMap<>();
                        for (Map.Entry<Integer, Double> entry1 : m1.descendingMap().entrySet()) {
                            if (entry1.getValue() != 0) {
                                mapaAuxiliara.put(entry1.getKey(), entry1.getValue());
                            }
                        }
                        m1 = mapaAuxiliara;
                        p1.setMap(m1);
                        mapaAuxiliara = new TreeMap<>();
                        for (Map.Entry<Integer, Double> entry1 : cat.getMap().descendingMap().entrySet()) {
                            if (entry1.getValue() != 0) {
                                mapaAuxiliara.put(entry1.getKey(), entry1.getValue());
                            }
                        }
                        mapCat = mapaAuxiliara;
                        cat.setMap(mapaAuxiliara);
                        mapaAuxiliara = new TreeMap<>();
                        for (Map.Entry<Integer, Double> entry1 : rest.getMap().descendingMap().entrySet()) {
                            if (entry1.getValue() != 0) {
                                mapaAuxiliara.put(entry1.getKey(), entry1.getValue());
                            }
                        }
                        mapRest = mapaAuxiliara;
                        rest.setMap(mapaAuxiliara);
                        for (Map.Entry<Integer, Double> entry1 : cat.getMap().descendingMap().entrySet()) {
                            if (entry1.getValue() != 0) {
                                mapOuputCat.put(entry1.getKey(), entry1.getValue());
                            }
                        }
                        outputCat.setMap(mapOuputCat);
                        mapCat.clear();
                        verificare = CalculeazaGrad(p2, p1);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } else if (check == 2) {
            mapOuputCat.put(0, (double) 0);
            outputCat.setMap(mapOuputCat);
        }
        vector[0]=outputCat;
        vector[1]=p1;
        return vector;
    }
}
