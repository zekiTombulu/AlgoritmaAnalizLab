/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veziruygulama;

import java.util.Random;

/**
 *
 * @author zeki
 */
public class VezirUygulama {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] dizi = new int[8][8];
        olustur(dizi);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(dizi[i][j] + "-");

            }
            System.out.println("");
        }
        System.out.println("*************************************");
        testEt(dizi);
        System.out.println("*************************************");
        vezirleriYenidenYerlestir(dizi);
    }

    public static void olustur(int[][] dizi) {

        Random rand = new Random();
        int vezirYerlestirilenSutun;
        for (int i = 0; i < 8; i++) {
            vezirYerlestirilenSutun = rand.nextInt(7) + 1;
            dizi[i][vezirYerlestirilenSutun] = 1;
        }

    }

    public static void testEt(int[][] dizi) {

        int sutunCakismaSayisi = 0;
        int caprazCakismaSayisi = 0;
        int hangiSutundaVezirVar[] = new int[8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (dizi[i][j] == 1) {
                    hangiSutundaVezirVar[i] = j;

                }

            }

        }
        System.out.println("vezirlerinBulunduğu sutunlar :");
        for (int i = 0; i < 8; i++) {
            System.out.print(hangiSutundaVezirVar[i] + "-");
        }
        System.out.println("");

        //aynı sutun cakısma sayisi
        for (int i = 0; i < 8; i++) {
            int satırDegeri = hangiSutundaVezirVar[i];
            for (int j = 0; j < 8; j++) {

                if (satırDegeri != j) {
                    if (satırDegeri == hangiSutundaVezirVar[j]) {
                        sutunCakismaSayisi++;
                    }
                    if (i == j) {
                        sutunCakismaSayisi--;
                    }
                }

            }

        }
        System.out.println("aynı sutunda bulunan vezirlerin cakışma sayisi :" + sutunCakismaSayisi);

        //capraz cakisma sayisi
        for (int i = 0; i < 7; i++) {
            int sutunNo = hangiSutundaVezirVar[i];
            int satırNo = i;

            while (sutunNo < 7) {
                satırNo++;
                sutunNo++;
                if (satırNo < 8 && dizi[satırNo][sutunNo] == 1) {
                    caprazCakismaSayisi++;

                }
            }

        }
        System.out.println("sag asagi tarafa satir ++ ve sutun ++ :" + caprazCakismaSayisi);

        int sol_caprazCakismaSayisi = 0;

        for (int i = 0; i < 7; i++) {
            int sutunNo = hangiSutundaVezirVar[i];
            int satırNo = i;

            while (sutunNo > 0) {
                satırNo++;
                sutunNo--;
                if (satırNo < 8 && dizi[satırNo][sutunNo] == 1) {
                    sol_caprazCakismaSayisi++;

                }
            }

        }
        System.out.println("sol asagi tarafa satir ++ ve sutun -- :" + sol_caprazCakismaSayisi);
        int sagYukaricaprazCakismaSayisi = 0;
        for (int i = 7; i > 0; i--) {
            int sutunNo = hangiSutundaVezirVar[i];
            int satırNo = i;

            while (sutunNo < 7) {
                satırNo++;
                sutunNo++;
                if (satırNo < 8 && dizi[satırNo][sutunNo] == 1) {
                    sagYukaricaprazCakismaSayisi++;

                }
            }

        }
        System.out.println("sag yukarı tarafa satir -- ve sutun -- :" + sagYukaricaprazCakismaSayisi);

        int solYukaricaprazCakismaSayisi = 0;
        for (int i = 7; i > 0; i--) {
            int sutunNo = hangiSutundaVezirVar[i];
            int satırNo = i;

            while (sutunNo > 0) {
                satırNo++;
                sutunNo--;
                if (satırNo < 8 && dizi[satırNo][sutunNo] == 1) {
                    solYukaricaprazCakismaSayisi++;

                }
            }

        }
        System.out.println("sol yukari tarafa satir -- ve sutun -- :" + solYukaricaprazCakismaSayisi);

        int toplamCakisma = solYukaricaprazCakismaSayisi + sagYukaricaprazCakismaSayisi + sol_caprazCakismaSayisi + caprazCakismaSayisi + sutunCakismaSayisi;
        System.out.println("herbir vezir için toplam cakisma sayisi :" + toplamCakisma);

    }

    public static void vezirleriYenidenYerlestir(int[][] dizi) {
      //  int[][] cakismaSayilari = new int[8][8];
        int sutunCakismaSayisi = 0;
        int caprazCakismaSayisi = 0;

        int hangiSutundaVezirVar[] = new int[8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (dizi[i][j] == 1) {
                    hangiSutundaVezirVar[i] = j;

                }

            }

        }

        //vezir yerdegistime ile sutun cakisma sayilari
        int j;
        int k;
        for (int i = 0; i < 8; i++) {

            for (j = 0; j < 8; j++) {
                sutunCakismaSayisi = 0;
                for (k = 0; k < 8; k++) {
                    if (dizi[k][j] == 1) {

                        sutunCakismaSayisi++;
                    }

                }
               // cakismaSayilari[i][j] += sutunCakismaSayisi;
                System.out.println(i + " satırındaki vezir " + j + " sutununa cekilirse " + sutunCakismaSayisi + " sutunda cakisma olur");
            }
            System.out.println("-------------------------------------");
        }

        //vezir yerdegistime ile capraz cakisma sayilari
        int z;
        for (int a = 0; a < 8; a++) {
            for (z = 0; z < 8; z++) {
                int sutunNo = a;
                int satırNo = z;
                caprazCakismaSayisi = 0;
                while (sutunNo < 7) {
                    satırNo++;
                    sutunNo++;
                    if (satırNo < 8 && dizi[satırNo][sutunNo] == 1) {
                        caprazCakismaSayisi++;

                    }
                }
             //   cakismaSayilari[a][z] += caprazCakismaSayisi;
                System.out.println(a + " satırındaki vezir " + z + " sutununa cekilirse  sag asagi tarafa satir:" + caprazCakismaSayisi);
            }

            System.out.println("------------------------------------------");
        }
        int p;
        int sol_caprazCakismaSayisi = 0;

        for (int a = 0; a < 8; a++) {
            for (p = 0; p < 8; p++) {
                int sutunNo = a;
                int satırNo = p;
                sol_caprazCakismaSayisi = 0;
                while (sutunNo > 0) {
                    satırNo++;
                    sutunNo--;
                    if (satırNo < 7 && dizi[satırNo][sutunNo] == 1) {
                        sol_caprazCakismaSayisi = 0;

                    }
                }
               // cakismaSayilari[a][p] += sol_caprazCakismaSayisi;
                System.out.println(a + " satırındaki vezir " + p + " sutununa cekilirse  sag asagi tarafa  :" + sol_caprazCakismaSayisi);
            }

            System.out.println("------------------------------------------");
        }
        int sagYukaricaprazCakismaSayisi = 0;
        for (int a = 0; a < 8; a++) {
            for (p = 8; p > 0; p--) {
                int sutunNo = a;
                int satırNo = p;
                sagYukaricaprazCakismaSayisi = 0;
                while (sutunNo < 7) {
                    satırNo++;
                    sutunNo++;
                    if (satırNo < 8 && dizi[satırNo][sutunNo] == 1) {
                        sagYukaricaprazCakismaSayisi++;

                    }
                }//cakismaSayilari[a][p]+=sagYukaricaprazCakismaSayisi;
                System.out.println(a + " satırındaki vezir " + p + " sutununa cekilirse  sag asagi tarafa :" + sagYukaricaprazCakismaSayisi);
            }

            System.out.println("------------------------------------------");
        }
        int solYukaricaprazCakismaSayisi = 0;
        for (int a = 0; a < 8; a++) {
            for (p = 8; p > 0; p--) {
                int sutunNo = a;
                int satırNo = p;
                solYukaricaprazCakismaSayisi = 0;
                while (sutunNo > 0) {
                    satırNo++;
                    sutunNo--;
                    if (satırNo < 8 && dizi[satırNo][sutunNo] == 1) {
                        solYukaricaprazCakismaSayisi++;

                    }
                }
//               cakismaSayilari[a][p]+=solYukaricaprazCakismaSayisi;
                System.out.println(a + " satırındaki vezir " + p + " sutununa cekilirse  sag asagi tarafa  :" + solYukaricaprazCakismaSayisi);
            }

            System.out.println("------------------------------------------");
            
        
        }
        
//            for (int i = 0; i < cakismaSayilari.length; i++) {
//                System.out.println(cakismaSayilari[i]);
//
//            }
    }
}
