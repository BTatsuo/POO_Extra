import java.util.ArrayList;

public class Carrinho {
    private String nome;
    private ArrayList<Produto> pedido;

    private float taxaServico;
    private float valorTotal;

    public Carrinho(String nome){
        this.nome=nome;
        pedido = new ArrayList<>();
        this.taxaServico = 1.10f;
        this.valorTotal =0f;
    }
    public void add(Produto produto){
        pedido.add(produto);
        System.out.println("O " + produto.getNome() + " foi adicionado com sucesso! ");
    }
    public float valorPagar(){
        float valor =0f;
        for (Produto p:pedido){
            valor+=p.getPreco();
        }
        valor=valor*taxaServico;
        return valor;
    }
    public float valorPagar(float tax){
        float valor =0f;
        for (Produto p:pedido){
            valor+=p.getPreco();
        }
        valor=valor*tax;
        return valor;
    }
    public void imprimirRecibo(){
        int i=0;
        System.out.println("------------RECIBO---------------");
        System.out.println("Cliente:  " + nome);
        for(Produto p:pedido){
            System.out.printf("%d : %15s  %.2f\n",i,p.getNome(),p.getPreco());
            i+=1;
        }
        System.out.println("Valor Total:  " + valorPagar());

    }

}
