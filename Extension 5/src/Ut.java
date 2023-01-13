//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Random;
import java.util.Scanner;

public class Ut {
    public Ut() {
    }

    public static void afficher(String var0) {
        System.out.print(var0);
    }

    public static void afficherSL(String var0) {
        afficher(var0);
        passerLigne();
    }

    public static void afficher(int var0) {
        System.out.print("" + var0);
    }

    public static void afficherSL(int var0) {
        afficher(var0);
        passerLigne();
    }

    public static void passerLigne() {
        System.out.println("");
    }

    public static void passerALaLigne() {
        passerLigne();
    }

    public static void sauterALaLigne() {
        passerLigne();
    }

    public static void sautLigne() {
        passerLigne();
    }

    public static void afficher(double var0) {
        System.out.print("" + var0);
    }

    public static void afficherSL(double var0) {
        afficher(var0);
        passerLigne();
    }

    public static void afficher(float var0) {
        System.out.print("" + var0);
    }

    public static void afficherSL(float var0) {
        afficher(var0);
        passerLigne();
    }

    public static void afficher(char var0) {
        System.out.print("" + var0);
    }

    public static void afficherSL(char var0) {
        afficher(var0);
        passerLigne();
    }

    public static void afficher(boolean var0) {
        System.out.print("" + var0);
    }

    public static void afficherSL(boolean var0) {
        afficher(var0);
        passerLigne();
    }

    public static void afficher(int[][] var0) {
        for(int var1 = 0; var1 < var0.length; ++var1) {
            for(int var2 = 0; var2 < var0[var1].length; ++var2) {
                System.out.print(var0[var1][var2] + "\t");
            }

            sautLigne();
        }

    }

    public static void afficherSL(int[][] var0) {
        afficher(var0);
        passerLigne();
    }

    public static int saisirEntier() {
        Scanner var0 = new Scanner(System.in);
        String var1 = var0.nextLine();
        int var2 = 456;

        try {
            var2 = Integer.parseInt(var1);
        } catch (NumberFormatException var4) {
            System.out.println("Ce n'est pas un entier valide");
        }

        return var2;
    }

    public static double saisirDouble() {
        return saisirReel();
    }

    public static double saisirReel() {
        Scanner var0 = new Scanner(System.in);
        String var1 = var0.nextLine();
        double var2 = -123.987;

        try {
            var2 = Double.parseDouble(var1);
        } catch (NumberFormatException var5) {
            System.out.println("Ce n'est pas un reel valide");
        }

        return var2;
    }

    public static float saisirFlottant() {
        Scanner var0 = new Scanner(System.in);
        String var1 = var0.nextLine();
        float var2 = -123.987F;

        try {
            var2 = Float.parseFloat(var1);
        } catch (NumberFormatException var4) {
            System.out.println("Ce n'est pas un reel valide");
        }

        return var2;
    }

    public static char saisirCaractere() {
        Scanner var0 = new Scanner(System.in);
        char var1 = var0.next().charAt(0);
        return var1;
    }

    public static boolean saisirBooleen() {
        Scanner var0 = new Scanner(System.in);
        boolean var1 = var0.nextBoolean();
        return var1;
    }

    public static String saisirChaine() {
        Scanner var0 = new Scanner(System.in);
        String var1 = var0.nextLine();
        return var1;
    }

    public static char[] saisirCharArray() {
        Scanner var0 = new Scanner(System.in);
        String var1 = var0.nextLine();
        char[] var2 = var1.toCharArray();
        return var2;
    }

    public static int alphaToIndex(char var0) {
        return var0 - 97;
    }

    public static char indexToAlpha(int var0) {
        return (char)(var0 + 97);
    }

    public static int pgcd(int var0, int var1) {
        var0 = Math.abs(var0);

        int var2;
        for(var1 = Math.abs(var1); var1 != 0; var0 = var2) {
            var2 = var1;
            var1 = var0 % var1;
        }

        return var0;
    }

    public static int randomMinMax(int var0, int var1) {
        Random var2 = new Random();
        int var3 = var2.nextInt(var1 - var0 + 1) + var0;
        return var3;
    }

    public static void clearConsole() {
        System.out.print("\u001b[H\u001b[2J");
    }

    public static void pause(int var0) {
        try {
            Thread.sleep((long)var0);
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

    }

    public static boolean estEntier(double var0) {
        return (double)((int)var0) == var0;
    }

    public static int modulo2(int var0, int var1) {
        return var0 - var1 * (int)Math.floor((double)var0 / (double)var1);
    }

    public static boolean estBissextile(int var0) {
        return var0 % 400 == 0 || var0 % 4 == 0 && var0 % 100 != 0;
    }

    public static char indexToMaj(int var0) {
        return (char)(var0 + 65);
    }

    public static int majToIndex(char var0) {
        return var0 - 65;
    }
}

