/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sıralama_bubble_selection;

import java.util.Random;

/**
 *
 * @author BMB
 */
public class Sıralama_Bubble_Selection {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {

        Random rand = new Random();
        int dizi[] = new int[10];
        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = rand.nextInt(50) + 1;
        }
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + "-");
        }
        System.out.println("");
        BubbleSort(dizi);
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + "-");
        }
        System.out.println("");
        System.out.println("-----------------------------");
        SelectionSort(dizi);
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + "-");
        }
    }

    public static void BubbleSort(int[] dizi) {
        int sayac = 0, sayac1 = 0;

        int temp;   // Yer değiştirmede kullanılacak geçici değişken
        for (int i = 1; i < dizi.length; i++) {
            for (int j = 0; j < dizi.length - i; j++) {
                sayac1++;
                if (dizi[j] > dizi[j + 1]) {
                    temp = dizi[j];
                    dizi[j] = dizi[j + 1];
                    dizi[j + 1] = temp;
                    sayac++;
                }//Önce gelen elaman bir sonrakinden büyükse ikisi yer değiştiriyor
            }
            // Dizinin ardışık elamanlarını karşılaştırmak için kullandığımız döngü
        }
        System.out.println("Sawp :" + sayac);
        System.out.println("Comparison :" + sayac1);
        // Her karşılaştırmadan sonra yeniden kaldığımız yerden devam etmemizi sağlayan döngü
    }

    public static void SelectionSort(int[] dizi) {
        int yedek;
        int minIndex;
        int sayac = 0, sayac1 = 0;
        for (int i = 0; i < dizi.length - 1; i++) {
            minIndex = i;
            for (int j = i; j < dizi.length; j++) {
                sayac1++;
                if (dizi[j] < dizi[minIndex]) {
                    minIndex = j;
                }
            }
            yedek = dizi[i];
            dizi[i] = dizi[minIndex];
            dizi[minIndex] = yedek;
            sayac++;
        }
        System.out.println("Sawp:" + sayac);
        System.out.println("Comparison:" + sayac1);
    }
}
