package org.example;

import org.example.business_logic.*;
import org.example.data_model.Polynomial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class MyInterface extends JFrame {
    private JPanel panel1;
    private JTextField Polinom1;
    private JTextField Polinom2;
    private JTextField Result;
    private JButton AddButton;
    private JButton SubButton;
    private JButton ProdButton;
    private JButton DivButton;
    private JButton DerivateButton;
    private JButton IntegralButton;

    public MyInterface() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("MyInterface");
        setSize(600, 600);
        setContentPane(panel1);
        setVisible(true);
        pack();
        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Regex r1 = new Regex();
                Polynomial p1 = new Polynomial();
                Polynomial p2 = new Polynomial();
                r1.Regex(Polinom1.getText(), p1);
                r1.Regex(Polinom2.getText(), p2);
                Add sum = new Add();
                try {
                    Polynomial resultSum = sum.addPolynomials(p1, p2);
                    int ok = 0;
                    for (Map.Entry<Integer, Double> entry1 : resultSum.getMap().descendingMap().entrySet()) {
                        if (entry1.getValue() != 0) {
                            ok = 1;
                            break;
                        }
                    }
                    if (ok == 0) Result.setText("0.0");
                    else Result.setText(resultSum.afisarePolinomString());
                } catch (Exception excep) {
                    JOptionPane.showMessageDialog(panel1, excep.getMessage());
                }
            }
        });
        SubButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Regex r1 = new Regex();
                Polynomial p1 = new Polynomial();
                Polynomial p2 = new Polynomial();
                r1.Regex(Polinom1.getText(), p1);
                r1.Regex(Polinom2.getText(), p2);
                Substract dif = new Substract();
                try {
                    Polynomial resultDif = dif.substractPolynomials(p1, p2);
                    Result.setText(resultDif.afisarePolinomString());
                } catch (Exception excep) {
                    JOptionPane.showMessageDialog(panel1, excep.getMessage());
                }
            }
        });
        ProdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Regex r1 = new Regex();
                Polynomial p1 = new Polynomial();
                Polynomial p2 = new Polynomial();
                r1.Regex(Polinom1.getText(), p1);
                r1.Regex(Polinom2.getText(), p2);
                Multiplication mul = new Multiplication();
                try {
                    Polynomial resultMul = mul.MultiplicatePolynomials(p1, p2);
                    int ok = 0;
                    for (Map.Entry<Integer, Double> entry1 : resultMul.getMap().descendingMap().entrySet()) {
                        if (entry1.getValue() != 0) {
                            ok = 1;
                            break;
                        }
                    }
                    if (ok == 0) Result.setText("0.0");
                    else Result.setText(resultMul.afisarePolinomString());
                } catch (Exception excep) {
                    JOptionPane.showMessageDialog(panel1, excep.getMessage());
                }
            }
        });
        DivButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Regex r1 = new Regex();
                Polynomial p1 = new Polynomial();
                Polynomial p2 = new Polynomial();
                r1.Regex(Polinom1.getText(), p1);
                r1.Regex(Polinom2.getText(), p2);
                Division div = new Division();
                try {
                    int verificareMaiMare = 0;
                    for (Map.Entry<Integer, Double> entry1 : p1.getMap().descendingMap().entrySet()) {
                        for (Map.Entry<Integer, Double> entry2 : p2.getMap().descendingMap().entrySet()) {
                            if (entry1.getKey() < entry2.getKey()) verificareMaiMare = 1;
                            break;
                        }
                        break;
                    }
                    int checkFirst = 0;
                    for (Map.Entry<Integer, Double> entry1 : p1.getMap().descendingMap().entrySet()) {
                        if (entry1.getValue() != 0) {
                            checkFirst = 1;
                            break;
                        }
                    }
                    int checkSecond = 0;
                    for (Map.Entry<Integer, Double> entry2 : p2.getMap().descendingMap().entrySet()) {
                        if (entry2.getValue() != 0) {
                            checkSecond = 1;
                            break;
                        }
                    }

                    if (checkFirst == 0 && p1.getMap().isEmpty() != true) Result.setText("cat: 0" + " rest: 0");
                    else {
                        if (checkSecond == 0 && p2.getMap().isEmpty() != true) {
                            JOptionPane.showMessageDialog(panel1, "Impartire cu 0!");
                        } else if (p1.getMap().isEmpty() || p2.getMap().isEmpty()) {
                            JOptionPane.showMessageDialog(panel1, "Nu se poate face impartirea!");
                        } else {
                            Polynomial[] vector = new Polynomial[2];
                            vector = div.DivPolynomialCat(p1, p2);
                            String cat = vector[0].afisarePolinomString();
                            String rest;
                            if (vector[1].getMap().isEmpty()) rest = "0";
                            else rest = vector[1].afisarePolinomString();
                            if (verificareMaiMare == 1) Result.setText("cat: 0" + " rest: " + rest);
                            else Result.setText("cat: " + cat + " rest: " + rest);
                        }
                    }
                } catch (Exception excep) {
                    JOptionPane.showMessageDialog(panel1, excep.getMessage());
                }
            }
        });
        DerivateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Regex r1 = new Regex();
                Polynomial p1 = new Polynomial();
                r1.Regex(Polinom1.getText(), p1);
                Derivation der = new Derivation();
                int valMaxima = -1;
                for (Map.Entry<Integer, Double> entry1 : p1.getMap().descendingMap().entrySet()) {
                    valMaxima = entry1.getKey();
                    break;
                }
                try {
                    Polynomial resultDer = der.DerivatePolynomial(p1);
                    if (valMaxima == 0) Result.setText("0");
                    else Result.setText(resultDer.afisarePolinomString());
                } catch (Exception excep) {
                    JOptionPane.showMessageDialog(panel1, excep.getMessage());
                }
            }
        });
        IntegralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Regex r1 = new Regex();
                Polynomial p1 = new Polynomial();
                r1.Regex(Polinom1.getText(), p1);
                Integration integr = new Integration();
                int ctr = 0;
                for (Map.Entry<Integer, Double> entry1 : p1.getMap().descendingMap().entrySet()) {
                    if (entry1.getValue() == 0 && entry1.getKey() == 0) ctr = 1;
                    break;
                }
                try {
                    Polynomial resultIntegr = integr.IntegratePolynomial(p1);
                    if (ctr == 1) Result.setText("0");
                    else Result.setText(resultIntegr.afisarePolinomString());
                } catch (Exception excep) {
                    JOptionPane.showMessageDialog(panel1, excep.getMessage());
                }
            }
        });
    }
}
