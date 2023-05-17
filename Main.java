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
                    pedido(nome);
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
    private static void pedido(String nome){
        Scanner sc =new Scanner(System.in);
        Carrinho pedido = new Carrinho(nome);

        while (true){
            Cardapio.cardapio();
            try {
                System.out.println("Escolha sua Opção: ");
                int prato = sc.nextInt();

                switch (prato) {
                    case 1:
                        String tam="";
                        try{
                            while (true){
                                System.out.println("Escolha o Tamanho: (P/G)");
                                String tamanho = sc.next();
                                if (tamanho.equals("P") | tamanho.equals("G")){
                                    tam = tamanho;
                                    break;
                                }else{
                                    System.out.println("Insira uma opção válida!");
                                }
                            }
                        }catch (InputMismatchException e){
                            System.out.println("Valor inválido!");
                        }
                        pedido.add(new Yakisoba("Yakisoba de Camarão",tam,(tam.equals("G"))?75.5f:55.0f));
                        continue;
                    case 2:
                        String tam2="";
                        try{
                            while (true){
                                System.out.println("Escolha o Tamanho: (P/G)");
                                String tamanho = sc.next();
                                if (tamanho.equals("P") | tamanho.equals("G")){
                                    tam2 = tamanho;
                                    break;
                                }else{
                                    System.out.println("Insira uma opção válida!");
                                }
                            }
                        }catch (InputMismatchException e){
                            System.out.println("Valor inválido!");
                        }

                        pedido.add(new Yakisoba("Yakisoba de Carne",tam2,(tam2.equals("G"))?58.90f:42.50f));
                        continue;
                    case 3:
                        String tam3="";
                        try{
                            while (true){
                                System.out.println("Escolha o Tamanho: (P/G)");
                                String tamanho = sc.next();
                                if (tamanho.equals("P") | tamanho.equals("G")){
                                    tam3 = tamanho;
                                    break;
                                }else{
                                    System.out.println("Insira uma opção válida!");
                                }
                            }
                        }catch (InputMismatchException e){
                            System.out.println("Valor inválido!");
                        }
                        pedido.add(new Yakisoba("Yakisoba de Frango",tam3,(tam3.equals("G"))?49.90f:34.90f));
                        continue;
                    case 4:
                        String tam4="";
                        try{
                            while (true){
                                System.out.println("Escolha o Tamanho: (P/G)");
                                String tamanho = sc.next();
                                if (tamanho.equals("P") | tamanho.equals("G")){
                                    tam4 = tamanho;
                                    break;
                                }else{
                                    System.out.println("Insira uma opção válida!");
                                }
                            }
                        }catch (InputMismatchException e){
                            System.out.println("Valor inválido!");
                        }
                        pedido.add(new Rolinho("Rolinho Doce",tam4,(tam4.equals("G"))?26.90f:15.90f));
                        continue;
                    case 5:
                        String tam5="";
                        try{
                            while (true){
                                System.out.println("Escolha o Tamanho: (P/G)");
                                String tamanho = sc.next();
                                if (tamanho.equals("P") | tamanho.equals("G")){
                                    tam5 = tamanho;
                                    break;
                                }else{
                                    System.out.println("Insira uma opção válida!");
                                }
                            }
                        }catch (InputMismatchException e){
                            System.out.println("Valor inválido!");
                        }
                        pedido.add(new Rolinho("Rolinho Primavera",tam5,(tam5.equals("G"))?21.50f:12.00f));
                        continue;
                    case 6:
                        String tam6="";
                        try{
                            while (true){
                                System.out.println("Escolha o Tamanho: (P/G)");
                                String tamanho = sc.next();
                                if (tamanho.equals("P") | tamanho.equals("G")){
                                    tam6 = tamanho;
                                    break;
                                }else{
                                    System.out.println("Insira uma opção válida!");
                                }
                            }
                        }catch (InputMismatchException e){
                            System.out.println("Valor inválido!");
                        }
                        pedido.add(new Rolinho("Rolinho Primavera",tam6,(tam6.equals("G"))?21.90f:12.50f));
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


