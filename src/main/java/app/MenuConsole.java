package app;

import java.util.Scanner;

public class MenuConsole {

    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {

        System.out.println("\n=== RESTAURANTE ===");
        System.out.println("1 - Registrar novo pedido");
        System.out.println("2 - Listar pedidos do dia");
        System.out.println("3 - Fechar restaurante");
        System.out.println("4 - Cancelar pedido");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    public int lerOpcao() {

        try {

            int opcao = sc.nextInt();
            sc.nextLine();

            return opcao;

        } catch (Exception e) {

            System.out.println("Digite apenas números.");
            sc.nextLine();

            return -1;
        }
    }

    public String lerNomeCliente() {

        System.out.print("Nome do cliente: ");
        return sc.nextLine();

    }
    public int lerOpcaoLanche() {

        System.out.println("\n1 - X-Burger (R$ 16,00)");
        System.out.println("2 - X-Salada (R$ 18,00)");
        System.out.println("3 - X-Bacon (R$ 22,00)");
        System.out.print("Escolha o lanche: ");

        try {

            int opcao = sc.nextInt();
            sc.nextLine();

            return opcao;

        } catch (Exception e) {

            System.out.println("Digite apenas números.");
            sc.nextLine();

            return -1;
        }
    }

    public boolean desejaCheddar() {

        System.out.print("Deseja cheddar? (s/n): ");

        String resposta = sc.nextLine();

        return resposta.equalsIgnoreCase("s");
    }


    public boolean desejaBaconExtra() {

        System.out.print("Deseja bacon extra? (s/n): ");

        String resposta = sc.nextLine();

        return resposta.equalsIgnoreCase("s");
    }

    public boolean retirarQueijo() {

        System.out.print("Retirar queijo? (s/n): ");

        return sc.nextLine().equalsIgnoreCase("s");
    }

    public boolean retirarAlface() {

        System.out.print("Retirar alface? (s/n): ");

        return sc.nextLine().equalsIgnoreCase("s");
    }
    public boolean retirarTomate() {

        System.out.print("Retirar tomate? (s/n): ");

        return sc.nextLine().equalsIgnoreCase("s");
    }

    public boolean retirarCebola() {

        System.out.print("Retirar cebola? (s/n): ");

        return sc.nextLine().equalsIgnoreCase("s");
    }

    public int lerNumeroPedido() {

        System.out.print("Número do pedido: ");

        return sc.nextInt();

    }

}
