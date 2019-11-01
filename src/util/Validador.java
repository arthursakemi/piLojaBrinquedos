/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

public class Validador {

    public static boolean validarInt(String x) {

        try {
            int n = Integer.parseInt(x);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static boolean validarDouble(String x) {
        try {
            double n = Double.parseDouble(x);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static boolean validarData(String data) {

        String[] dia = data.split("/");
        int[] dataInt = new int[3];

        boolean diaV, mesV;

        try {
            dataInt[0] = Integer.parseInt(dia[0]);
            dataInt[1] = Integer.parseInt(dia[1]);
            dataInt[2] = Integer.parseInt(dia[2]);
        } catch (NumberFormatException e) {
            return false;
        }

        diaV = dataInt[0] >= 1 && dataInt[0] <= 31;
        mesV = dataInt[1] >= 1 && dataInt[1] <= 12;

        if (!diaV || !mesV) {
            return false;
        }

        return true;
    }

    public static boolean validarCPF(String cpf) {
        if (cpf.length() < 11) {
            return false;
        }
        try {
            long n = Long.parseLong(cpf);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
