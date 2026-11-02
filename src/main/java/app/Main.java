package app;

import cardapio.Lanche;
import pedido.Pedido;

public class Main {

    public static void main(String[] args) {

        MenuConsole menu = new MenuConsole();
        RestauranteFacade sistema = new RestauranteFacade();

        int opcao = -1;

        while (opcao != 0) {

            menu.exibirMenu();

            opcao = menu.lerOpcao();

            switch (opcao) {

                case 1:

                    String nomeCliente = menu.lerNomeCliente();

                    Pedido pedido = sistema.criarPedido(nomeCliente);

                    int opcaoLanche = menu.lerOpcaoLanche();

                    if (opcaoLanche == 1) {

                        pedido.adicionarItem(
                                new Lanche("X-Burger", 16.0)
                        );

                    }

                    else if (opcaoLanche == 2) {

                        pedido.adicionarItem(
                                new Lanche("X-Salada", 18.0)
                        );

                    }

                    else if (opcaoLanche == 3) {

                        pedido.adicionarItem(
                                new Lanche("X-Bacon", 22.0)
                        );

                    }

                    System.out.println(
                            "Pedido criado com número: "
                                    + pedido.getNumero()
                    );

                    break;

                case 2:

                    for (Pedido p : sistema.listarPedidos()) {

                        System.out.println(
                                "Pedido " +
                                        p.getNumero() +
                                        " - Cliente: " +
                                        p.getNomeCliente()
                        );

                        for (Lanche l : p.getItens()) {

                            System.out.println(
                                    l.getNome() +
                                            " - R$ " +
                                            l.getPreco()
                            );

                        }

                        System.out.println(
                                "Total: R$ " +
                                        p.calcularTotal()
                        );

                        System.out.println("-----------------------");
                    }

                    break;

                case 3:

                    double totalDia = sistema.calcularTotalDoDia();

                    System.out.println(
                            "Total vendido no dia: R$ "
                                    + totalDia
                    );

                    break;

                case 0:

                    System.out.println("Encerrando sistema...");

                    break;

                default:

                    System.out.println("Opção inválida.");

            }

        }

    }
}