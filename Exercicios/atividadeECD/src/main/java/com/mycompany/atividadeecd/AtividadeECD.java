package com.mycompany.atividadeecd;

import java.util.Scanner;

/**
 *
 * @author Damy
 */
public class AtividadeECD {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantos números você quer na sua lista?");
        int n = scanner.nextInt();

        int[] numInformados = new int[n];

        System.out.println("Digite os números e entre eles use o ESPAÇO "
                + "(ex: '1 2 3 4': ");
        for (int i = 0; i < n; i++) {
            numInformados[i] = scanner.nextInt();
        }
        bubbleSort(numInformados);
        
        System.out.println("Números ordenados: ");
        for (int num : numInformados) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Qual número deseja procurar: ");
        int numProcurar = scanner.nextInt();

        int numPosicao = pesquisaLinear(numInformados, numProcurar);
        
        if (numPosicao != -1) {
            System.out.println("O número " + numProcurar + 
                    " foi achado na posição " + numPosicao + " da sua lista.");
        } else {
            System.out.println("Você não digitou o número " + numProcurar + " .");
        }
    }
    private static void bubbleSort(int[] numInformados) {
        int n = numInformados.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numInformados[j] > numInformados[j + 1]) {
                    // Troca arr[j] e arr[j+1]
                    int temp = numInformados[j];
                    numInformados[j] = numInformados[j + 1];
                    numInformados[j + 1] = temp;
                }
            }
        }
    } 
    private static int pesquisaLinear(int[] arr, int numProcurar) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == numProcurar) {
                return i;
            }
        }
        return -1;
    }
}
