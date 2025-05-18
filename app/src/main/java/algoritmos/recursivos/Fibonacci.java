package algoritmos.recursivos;

import java.util.Arrays;

public class Fibonacci {

    public static int fibonacciRecursivo(int n){
        if ((n == 0) || (n == 1)){
            return n;
        }
        else {
            return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
        }
    }

    public static int fibonacciIterativo(int n) {
        int i, fibonacci = 0;
        int fibAnterior = 0;
        int fibPosterior = 1;
        if ((n == 0) || (n == 1)){
            return n;
        }
        else {
            for (i = 2; i <= n; i++){
                fibonacci = fibAnterior + fibPosterior;
                fibAnterior = fibPosterior;
                fibPosterior = fibonacci;
            }
            return fibonacci;
        }
    }

    public static int fibonacciRecursivoMemo(int n, int[] memo){
        if ((n == 0) || (n == 1)){
            return n;
        }

        //Verificar se o resultado já esta na tabela de memo
        if (memo[n] != -1){
            return memo[n];
        }

        //Caso recursivo: calcular o número de Fibonacci e armazenar na memória (memo)
        memo[n] = fibonacciRecursivoMemo(n - 1, memo) + fibonacciRecursivoMemo(n - 2, memo);
        return memo[n];

    }    

    public static void main(String[] args) {
        int n = 4;
       
        //Medição do tempo para versão recursiva
        long inicioRecursivo = System.nanoTime();
        int resultadoRecursivo = fibonacciRecursivo(n);
        long fimRecursivo = System.nanoTime();
        long tempoRecursivo = fimRecursivo - inicioRecursivo;

        //Medição do tempo para versão iterativa
        long inicioIterativo = System.nanoTime();
        int resultadoIterativo = fibonacciIterativo(n);
        long fimIterativo = System.nanoTime();
        long tempoIterativo = fimIterativo - inicioIterativo;

        //Medição de tempo para versão recursiva com memoização
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        long inicioRecursivoComMemoria = System.nanoTime();
        int resultadoRecursivoComMemoria = fibonacciRecursivoMemo(n, memo);
        long fimRecursivoComMemoria = System.nanoTime();
        long tempoRecursivoComMemoria = fimRecursivoComMemoria - inicioRecursivoComMemoria;

        //Apresentação dos Resultados Medidos
        System.out.println("Resultado recursivo: " + resultadoRecursivo);
        System.out.println("Tempo recursivo (ns): " + tempoRecursivo);
        System.out.println("Resultado iterativo: " + resultadoIterativo);
        System.out.println("Tempo iterativo (ns): " + tempoIterativo);
        System.out.println("Resultado Recursivo com Memoria: " + resultadoRecursivoComMemoria);
        System.out.println("Tempo Recursivo com Memoria(ns): " + tempoRecursivoComMemoria);
        System.out.println("Diferença (ns) - tempoRecursivo - tempoIterativo: " + (tempoRecursivo - tempoIterativo));
        System.out.println("Diferença (ns) - tempoRecursivo - tempoRecursivoComMemoria: " + (tempoRecursivo - tempoRecursivoComMemoria));
        System.out.println("Diferença (ns)-  tempoIterativo - tempoRecursivoComMemoria: " + (tempoIterativo - tempoRecursivoComMemoria));
    }

}
