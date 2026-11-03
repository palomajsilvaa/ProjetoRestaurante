package app;

import cardapio.Lanche;
import pedido.Pedido;
import cardapio.LancheFactory;
import cardapio.ComCheddar;
import cardapio.ComBaconExtra;
import cardapio.ItemCardapio;


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
                    ItemCardapio lanche = null;

                    if (opcaoLanche == 1) {

                        lanche = LancheFactory.xBurger();

                    }

                    else if (opcaoLanche == 2) {

                        lanche = LancheFactory.xSalada();

                    }

                    else if (opcaoLanche == 3) {

                        lanche = LancheFactory.xBacon();

                    }
                    boolean cheddar = menu.desejaCheddar();

                    boolean baconExtra = menu.desejaBaconExtra();

                    if (cheddar) {

                        lanche = new ComCheddar(lanche);

                    }

                    if (baconExtra) {

                        lanche = new ComBaconExtra(lanche);

                    }
                    pedido.adicionarItem(lanche);

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

                        for (ItemCardapio l : p.getItens()) {

                            System.out.println(
                                    l.getDescricao() +
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