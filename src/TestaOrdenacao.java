public class TestaOrdenacao {

    public static void main(String[] args) {
        Produto[] produtos = {
                new Produto("Lamborguini", 1000000),
                new Produto("Jipe", 46000),
                new Produto("Brasília", 16000),
                new Produto("Smart", 46000),
                new Produto("Fusca", 17000)
        };

        // selectionSort(produtos, produtos.length);
        insertionSort(produtos, produtos.length);

        for(Produto produto : produtos) {
            System.out.println(produto.getNome() + " custa " + produto.getPreco());
        }
    }

    private static void insertionSort(Produto[] produtos, int qtdElementos) {
        for (int atual = 1; atual<qtdElementos; atual++) {
            int analise = atual;
            while (analise > 0 && produtos[analise].getPreco() < produtos[analise-1].getPreco()) {
                permuta(produtos, analise, analise - 1);
                analise --;
            }
        }
    }

    private static void selectionSort(Produto[] produtos, int qtdElementos) {
        for (int atual=0; atual<qtdElementos - 1; atual++){
            int menor = buscaMenor(produtos, atual, produtos.length);
            permuta(produtos, atual, menor);
        }
    }

    private static int buscaMenor(Produto[] produtos, int inicio, int termino) {
        int maisBarato = inicio;
        for (int atual=inicio; atual<termino; atual++){
            if (produtos[atual].getPreco() < produtos[maisBarato].getPreco()) {
                maisBarato = atual;
            }
        }
        return maisBarato;
    }

    private static void permuta(Produto[] produtos, int primeiro, int segundo) {
        Produto primeiroProduto = produtos[primeiro];
        Produto segundoProduto = produtos[segundo];
        produtos[primeiro] = segundoProduto;
        produtos[segundo] = primeiroProduto;
    }
}
