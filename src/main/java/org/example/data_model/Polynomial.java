package org.example.data_model;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Polynomial {
    TreeMap<Integer, Double> map = new TreeMap<Integer, Double>();

    public Polynomial() {
    }

    public TreeMap<Integer, Double> getMap() {
        return map;
    }

    public void setMap(TreeMap<Integer, Double> map) {
        this.map = map;
    }

    public void addValue(int key, double value) {
        map.put(key, value);
    }

    public String afisarePolinomString() {
        StringBuilder str = new StringBuilder();
        int ctr = 0;
        for (Map.Entry<Integer, Double> entry : map.descendingMap().entrySet()) {
            if (entry.getKey() == 0) {
                if (entry.getValue() == 0) continue;
                else {
                    if (ctr == 0) {
                        //System.out.print(entry.getValue());
                        str.append(entry.getValue());
                    } else {
                        if (entry.getValue() > 0) str.append("+" + entry.getValue());
                        else str.append(entry.getValue());
                    }
                }
            } else {
                if (entry.getKey() == 1) {
                    if (entry.getValue() == 0) continue;
                    else {
                        if (entry.getValue() < 0) {
                            if (entry.getValue() == -1) str.append("-x");
                            else str.append(entry.getValue() + "x");
                        } else {
                            if (entry.getValue() == 1) {
                                if (ctr == 0) str.append("x");
                                else str.append("+x");
                            } else {
                                if (ctr == 0) str.append(entry.getValue() + "x");
                                else str.append("+" + entry.getValue() + "x");
                            }
                        }
                    }
                } else {
                    if (entry.getValue() == 0) continue;
                    else {
                        if (entry.getValue() > 0) {
                            if (ctr == 0) {
                                if (entry.getValue() == 1) str.append("x^" + entry.getKey());
                                else str.append(entry.getValue() + "x^" + entry.getKey());
                            } else {
                                if (entry.getValue() == 1) str.append("+" + "x^" + entry.getKey());
                                else str.append("+" + entry.getValue() + "x^" + entry.getKey());
                            }
                        } else {
                            if (entry.getValue() == -1) str.append("-x^" + entry.getKey());
                            else str.append(entry.getValue() + "x^" + entry.getKey());
                        }
                    }
                }
            }
            ctr++;
        }
        return String.valueOf(str);
    }

    @Override
    public String toString() {
        return "Polynomial{" +
                "map=" + map +
                '}';
    }
}
