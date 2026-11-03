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

                    if (lanche instanceof Lanche l) {

                        if (menu.retirarQueijo()) {
                            l.setQueijo(false);
                        }

                        if (menu.retirarAlface()) {
                            l.setAlface(false);
                        }

                        if (menu.retirarTomate()) {
                            l.setTomate(false);
                        }

                        if (menu.retirarCebola()) {
                            l.setCebola(false);
                        }
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
                    int combinacoes =
                            sistema.contarCombinacoesDiferentes();

                    System.out.println(
                            "Total vendido no dia: R$ "
                                    + totalDia
                    );

                    System.out.println(
                            "Combinações diferentes: "
                                    + combinacoes
                    );

                    break;

                case 4:

                    int numeroPedido = menu.lerNumeroPedido();

                    sistema.cancelarPedido(numeroPedido);

                    System.out.println("Pedido cancelado.");

                    break;

                case 5:

                    int numeroPedidoRemover =
                            menu.lerNumeroPedido();

                    Pedido pedidoRemover =
                            sistema.buscarPedido(
                                    numeroPedidoRemover
                            );

                    if (pedidoRemover != null) {

                        int contador = 0;

                        for (ItemCardapio item :
                                pedidoRemover.getItens()) {

                            System.out.println(
                                    contador + " - "
                                            + item.getDescricao()
                            );

                            contador++;
                        }

                        int indice =
                                menu.lerIndiceItem();

                        sistema.removerItemPedido(
                                numeroPedidoRemover,
                                indice
                        );

                        System.out.println(
                                "Item removido."
                        );

                    } else {

                        System.out.println(
                                "Pedido não encontrado."
                        );

                    }

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