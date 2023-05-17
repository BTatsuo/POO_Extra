import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }
    private static void menu(){
        Scanner sc =new Scanner(System.in);

        System.out.println("Restaurante do Tatsuo");
        System.out.println();
        System.out.println("1 - Fazer pedido");
        System.out.println("0 - Sair");
        System.out.println();
        System.out.println("Escolha uma Opção: ");
        try {
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite seu nome: ");
                    String nome = sc.next();
                    pedido();
                case 0:
                    System.out.println("Obrigado pela preferência! Volte Sempre!");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    menu();
            }
        }catch(InputMismatchException e){
            System.out.println("Por favor digite um número");
            menu();
        }
    }
    private static void pedido(){
        Scanner sc =new Scanner(System.in);
        Carrinho pedido = new Carrinho();

        while (true){
            Cardapio.cardapio();
            try {
                System.out.println("Escolha sua Opção: ");
                int prato = sc.nextInt();
                System.out.println("Escolha o Tamanho: ");
                String tam = sc.next();
                if (tam.equals("Grande") | tam.equals("Pequeno")) {
                    switch (prato) {
                        case 1:
                            pedido.add(new Yakisoba("Yakisoba de Camarão",tam,(tam.equals("Grande"))?75.5f:55.0f));
                            continue;
                        case 2:
                            pedido.add(new Yakisoba("Yakisoba de Carne",tam,(tam.equals("Grande"))?58.90f:42.50f));
                            continue;
                        case 3:
                            pedido.add(new Yakisoba("Yakisoba de Frango",tam,(tam.equals("Grande"))?49.90f:34.90f));
                            continue;
                        case 0:
                            System.out.println("A taxa padrão é 10% deseja alterar? (S/N) ");
                            String res= sc.next();
                            if(res.equals("S")){
                                System.out.println("Digite o novo valor: (7 -> 7%");
                                int t = sc.nextInt();
                                float tax=1+(t/100);
                                pedido.valorPagar(tax);
                                pagamento(pedido.valorPagar(tax),pedido);
                            }else{
                                pedido.valorPagar();
                                pagamento(pedido.valorPagar(),pedido);
                            }
                            menu();
                        default:
                            System.out.println("Opção Inválida!");

                    }
                }else{
                    System.out.println("Digite Grande ou Pequeno!");
                }
            }catch(InputMismatchException e){
                    System.out.println("Por favor digite um número");
            }
        }
    }
    private static void pagamento(float valor,Carrinho pedido){
        Scanner sc =new Scanner(System.in);
        System.out.println("Valor Recebido: ");
        float paga =sc.nextFloat();

        float troco = paga-valor;
        pedido.imprimirRecibo();
        System.out.printf("O  troco é de %.2f\n",troco);

    }
}


