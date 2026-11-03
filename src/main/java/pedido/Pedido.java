package pedido;

import cardapio.ItemCardapio;
import java.util.ArrayList;

public class Pedido {

    private int numero;
    private String nomeCliente;
    private ArrayList<ItemCardapio> itens = new ArrayList<>();

    public Pedido(int numero, String nomeCliente) {

        this.numero = numero;
        setNomeCliente(nomeCliente);

    }

    public int getNumero() {
        return numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {

        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        this.nomeCliente = nomeCliente;
    }

    public void adicionarItem(ItemCardapio lanche) {

        itens.add(lanche);

    }

    public void removerItem(int indice) {

        if (indice >= 0 && indice < itens.size()) {

            itens.remove(indice);

        }

    }

    public ArrayList<ItemCardapio> getItens() {

        return itens;

    }

    public double calcularTotal() {

        double total = 0;

        for (ItemCardapio lanche : itens) {

            total += lanche.getPreco();

        }

        return total;
    }
}