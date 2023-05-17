public class Produto {
    private String nome;
    private String tamanho;
    private float preco;

    public Produto(String nome, String tamanho, float preco) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public float getPreco() {
        return preco;
    }
}
