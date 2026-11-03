package app;

import cardapio.Lanche;
import pedido.GerenciadorPedidos;
import pedido.Pedido;

import java.util.Collection;

public class RestauranteFacade {

    private GerenciadorPedidos gerenciador = new GerenciadorPedidos();

    public Pedido criarPedido(String nomeCliente) {

        return gerenciador.criarPedido(nomeCliente);

    }

    public void adicionarItemAoPedido(int numeroPedido, Lanche lanche) {

        Pedido pedido = gerenciador.buscarPedido(numeroPedido);

        if (pedido != null) {
            pedido.adicionarItem(lanche);
        }

    }

    public Collection<Pedido> listarPedidos() {

        return gerenciador.getPedidos();

    }

    public double calcularTotalDoDia() {

        return gerenciador.calcularTotalDoDia();

    }
    public void cancelarPedido(int numero) {

        gerenciador.cancelarPedido(numero);

    }

    public int contarCombinacoesDiferentes() {

        return gerenciador.contarCombinacoesDiferentes();

    }

    public Pedido buscarPedido(int numero) {

        return gerenciador.buscarPedido(numero);

    }

    public void removerItemPedido(
            int numeroPedido,
            int indiceItem
    ) {

        Pedido pedido =
                gerenciador.buscarPedido(numeroPedido);

        if (pedido != null) {

            pedido.removerItem(indiceItem);

        }
    }
}