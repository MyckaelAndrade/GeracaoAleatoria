import java.util.Random;

class No {
    int valor;
    No proximo;
    No anterior;

    public No(int valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }
}

class ListaDuplamenteEncadeada {
    private No cabeca;
    private No cauda;

    public ListaDuplamenteEncadeada() {
        this.cabeca = null;
        this.cauda = null;
    }

    public void inserirOrdenado(int valor) {
        No novoNo = new No(valor);

        if (cabeca == null) {
            cabeca = novoNo;
            cauda = novoNo;
        } else if (valor <= cabeca.valor) {
            novoNo.proximo = cabeca;
            cabeca.anterior = novoNo;
            cabeca = novoNo;
        } else if (valor >= cauda.valor) {
            cauda.proximo = novoNo;
            novoNo.anterior = cauda;
            cauda = novoNo;
        } else {
            No atual = cabeca;
            while (atual.proximo != null && atual.proximo.valor < valor) {
                atual = atual.proximo;
            }

            novoNo.proximo = atual.proximo;
            novoNo.anterior = atual;
            atual.proximo.anterior = novoNo;
            atual.proximo = novoNo;
        }
    }

    public void imprimirCrescente() {
        No atual = cabeca;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public void imprimirDecrescente() {
        No atual = cauda;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.anterior;
        }
        System.out.println();
    }
}

public class Lista {
    public static void main(String[] args) {
        int[] numerosAleatorios = new int[1000];
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            numerosAleatorios[i] = random.nextInt(19999) - 9999;
            System.out.print(numerosAleatorios[i] + " ");
        }
        System.out.println();

        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        for (int i = 0; i < 1000; i++) {
            lista.inserirOrdenado(numerosAleatorios[i]);
        }

        System.out.println("Lista em ordem crescente:");
        lista.imprimirCrescente();

        System.out.println("Lista em ordem decrescente:");
        lista.imprimirDecrescente();
    }
}
