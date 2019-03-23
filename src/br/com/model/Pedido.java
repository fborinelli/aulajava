package br.com.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido extends Base {
	private String nomeCliente;
	private String nomeFilial;
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeFilial() {
		return nomeFilial;
	}

	public void setNomeFilial(String nomeFilial) {
		this.nomeFilial = nomeFilial;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(ItemPedido itens) {
		this.itens.add(itens);
	}
	
	public BigDecimal getTotal() {
		if (itens.isEmpty()) {
			return BigDecimal.ZERO;
		} else {
			BigDecimal total = BigDecimal.ZERO;
			for (ItemPedido it : itens) {
				total = total.add(it.getValor().multiply(BigDecimal.valueOf(it.getQuantidade())));
			}

			return total;
		}
	}

}
