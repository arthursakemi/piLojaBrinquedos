/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Sakemi
 */
public class Utilidades {

    public static String formatCPF(String raw) {
        return raw.substring(0, 3) + "." + raw.substring(3, 6) + "." + raw.substring(6, 9) + "/" + raw.substring(9);

    }

    public static boolean buscaPeriodo(String data, String inicio, String fim) {
        boolean maiorInicio = dataPosterior(data.split("/"), inicio.split("/")),
                menorFim = dataAnterior(data.split("/"), fim.split("/"));

        return maiorInicio && menorFim ? true : false;
    }

    public static boolean dataPosterior(String[] data, String[] limite) {
        int[] dataPesquisa = new int[3];
        int[] dataLimite = new int[3];
        boolean anoMaior, mesMaior, diaMaior,
                anoIgual, mesIgual, diaIgual;

        for (int i = 0; i < 3; i++) {
            dataPesquisa[i] = Integer.parseInt(data[i]);
            dataLimite[i] = Integer.parseInt(limite[i]);
        }

        anoMaior = dataPesquisa[2] > dataLimite[2];
        mesMaior = dataPesquisa[1] > dataLimite[1];
        diaMaior = dataPesquisa[0] > dataLimite[0];
        anoIgual = dataPesquisa[2] == dataLimite[2];
        mesIgual = dataPesquisa[1] == dataLimite[1];
        diaIgual = dataPesquisa[0] == dataLimite[0];

        if (anoMaior) {
            return true;
        } else if (anoIgual && mesMaior) {
            return true;
        } else if (anoIgual && mesIgual && diaMaior) {
            return true;
        } else if (anoIgual && mesIgual && diaIgual) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean dataAnterior(String[] data, String[] limite) {
        int[] dataPesquisa = new int[3];
        int[] dataLimite = new int[3];
        boolean anoMenor, mesMenor, diaMenor,
                anoIgual, mesIgual, diaIgual;

        for (int i = 0; i < 3; i++) {
            dataPesquisa[i] = Integer.parseInt(data[i]);
            dataLimite[i] = Integer.parseInt(limite[i]);
        }

        anoMenor = dataPesquisa[2] < dataLimite[2];
        mesMenor = dataPesquisa[1] < dataLimite[1];
        diaMenor = dataPesquisa[0] < dataLimite[0];
        anoIgual = dataPesquisa[2] == dataLimite[2];
        mesIgual = dataPesquisa[1] == dataLimite[1];
        diaIgual = dataPesquisa[0] == dataLimite[0];

        if (anoMenor) {
            return true;
        } else if (anoIgual && mesMenor) {
            return true;
        } else if (anoIgual && mesIgual && diaMenor) {
            return true;
        } else if (anoIgual && mesIgual && diaIgual) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String data = "18/07/1990",
                inicio = "17/07/1991",
                fim = "20/08/1991";

        System.out.println(buscaPeriodo(data, inicio, fim));
    }

}
