/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mart16;

import java.util.Random;

/**
 *
 * @author BMB
 */
public class Mart16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        int dizi[] = new int[500];
        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = rand.nextInt(50) + 1;
        }
        int[] dizi1=dizi.clone();
        int[] dizi2=dizi.clone();
        int[] dizi3=dizi.clone();
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
        System.out.println("");
        System.out.println("-----------------------------");
        InsertionSort(dizi3);
        for (int i = 0; i < dizi3.length; i++) {
            System.out.print(dizi[i] + "-");
        }
        System.out.println("");
        System.out.println("-----------------------------");
        shell(dizi);
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

    public static void InsertionSort(int[] num) {
        int j;                     // the number of items sorted so far
        int key;                // the item to be inserted
        int i;
        int sayac = 0, sayac1 = 0;
        for (j = 1; j < num.length; j++) // Start with 1 (not 0)
        {
            key = num[ j];
            for (i = j - 1; (i >= 0) && (num[ i] < key); i--) // Smaller values are moving up
            {sayac++;
                sayac1++;
                num[ i + 1] = num[ i];
            }
            num[ i + 1] = key;    // Put the key in its proper location

            sayac1++;
        }
        System.out.println("ıns Sawp:" + sayac);
        System.out.println("ıns Comparison:" + sayac1);
    }

    public static void shell( int[] a)
    {
        int karsilastir=0;
        int swap=0;
        for( int gap = a.length / 2; gap > 0;
                     gap = gap == 2 ? 1 : (int) ( gap / 2.2 ) )
            for( int i = gap; i < a.length; i++ )
            {
                int tmp = a[ i ];
                int j = i;
                
                for( ; j >= gap && tmp < a[ j - gap ] ; j -= gap ){
                    a[ j ] = a[ j - gap ];
                    swap++;
                    karsilastir++;
                }
                a[ j ] = (int) tmp;
                karsilastir++;
            }
    System.out.println(" shellsort karsilaştirma : " + karsilastir);
    System.out.println(" shellsort swap : " + swap); 
    }}
