package org.example.business_logic;

import org.example.data_model.Polynomial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public void Regex(String sir, Polynomial p1) {
        String regex = "([+\\-]?(?:\\d*\\.?\\d+)?)(?:\\s*[xX](?:\\^(\\d+))?)?";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sir);

        while (matcher.find()) {
            String match = matcher.group();
            if (!match.isEmpty()) { // Check if match is not empty
                int ok = 0;
                String coefficientStr = matcher.group(1); // Coefficient of x
                String exponentStr = matcher.group(2);    // Power of x (null if not present)

                double coefficient;
                if (coefficientStr == null || coefficientStr.isEmpty()) {
                    // Handle the case where coefficientStr is empty
                    if (match.startsWith("-")) {
                        coefficient = -1;
                    } else if (match.startsWith("+")) {
                        coefficient = 1;
                    } else {
                        coefficient = 1; // Default coefficient to 1
                    }
                } else {
                    if (coefficientStr.equals("+")) {
                        coefficient = 1.0;
                    } else if (coefficientStr.equals("-")) {
                        coefficient = -1.0;
                    } else {
                        coefficient = Double.parseDouble(coefficientStr);
                        ok = 1;
                    }
                }
                int exponent;
                if (ok == 1 && exponentStr == null && match.endsWith("x") != true) exponent = 0;
                else {
                    exponent = (exponentStr == null || exponentStr.isEmpty()) ? 1 : Integer.parseInt(exponentStr);
                }
                p1.getMap().put(exponent, coefficient);
            }
        }
    }
}
