package br.com.datasource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.model.ItemPedido;
import br.com.model.Pedido;

public abstract class BaseDatasource implements IDataSource {
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	static int codPed = 1;
	
	public void carregaPedidosArquivo(List<Pedido> ped) {
		pedidos = ped;
	}

	public void listar() {
		if (pedidos.size() > 0) {
			List<ItemPedido> itens = new ArrayList<ItemPedido>();
			for (Pedido p : pedidos) {
				System.out.println("Número do Pedido: " + p.getCodigo());
				System.out.println("Nome do Cliente: " + p.getNomeCliente());
				System.out.println("Filial: " + p.getNomeFilial());

				itens = p.getItens();
				for (ItemPedido itm : itens) {
					StringBuilder str = new StringBuilder();
					str.append("Código: ");
					str.append(itm.getCodigo()+"\t");
					str.append("Produto: ");
					str.append(itm.getNome() + "\t");
					str.append("Qtde.: ");
					str.append(itm.getQuantidade() + "\t");
					str.append("Valor: ");
					str.append(itm.getValor()+"\n");
					System.out.println(str);
				}
				System.out.println("Valor Total: " + p.getTotal());
				System.out.println("Data Inclusão: " + p.getDataHoraInclusao());
				System.out.println("Data última alteração: " + p.getDataHoraEdicao()+"\n");
			}
		}else {
			System.out.println("Nenhum pedido encontrado!");
		}
	}

	public void incluir() {
		int codItem = 1;
		Pedido p = new Pedido();
		Scanner input = new Scanner(System.in);
		String stopItem = "S";

		p.setCodigo(codPed++);
		System.out.println("Digite o nome do cliente: ");
		p.setNomeCliente(input.nextLine());
		System.out.println("Digite o nome da filial: ");
		p.setNomeFilial(input.nextLine());

		do {
			ItemPedido itm = new ItemPedido();
			itm.setCodigo(codItem++);

			System.out.println("Nome do Produto: ");
			itm.setNome(input.nextLine());

			System.out.println("Valor do Produto: ");
			itm.setValor(BigDecimal.valueOf(input.nextDouble()));

			System.out.println("Qtde do Produto: ");
			itm.setQuantidade(input.nextInt());

			p.setItens(itm);

			System.out.println("Deseja inserir mais?(S/N): ");
			stopItem = input.next();
			
		}while(stopItem.toString().toUpperCase().equals("S"));

		Date data = new Date(System.currentTimeMillis());
		p.setDataHoraInclusao(data);
		p.setDataHoraEdicao(data);
		
		pedidos.add(p);
		
		System.out.println("Pedido inserido!");
	}

	public void alterar() {
		
		if (pedidos.size() == 0) {
			System.out.print("Não existem pedidos para alterar!");
		}
		if (pedidos.size() > 0) {
			System.out.print("Digite o número do Pedido que deseja alterar: ");

			Scanner input = new Scanner(System.in);

			int opcao = input.nextInt();

			for (Pedido p : pedidos) {
				int codBusca = p.getCodigo();
				if (codBusca == opcao) {
					exibeMenuAltera(p);
					// pedidos.remove(p);
				}
			}
			System.out.println("Pedido alterado!");
		}

	}
	
	public void exibeMenuAltera(Pedido p) {
		List<ItemPedido> itens = new ArrayList<ItemPedido>();
		Scanner input = new Scanner(System.in);
		int opc;
		
		System.out.println("Cliente: " + p.getNomeCliente());
		System.out.println("Filial: " + p.getNomeFilial());

		itens = p.getItens();
		for (ItemPedido itm : itens) {
			
			System.out.print("Produto: " + itm.getNome());
			System.out.print("Qtde: " + itm.getQuantidade());
			System.out.print("Valor Produto: " + itm.getValor());

			System.out.println("");
			System.out.println("==========================");
			System.out.println("1 - Nome do Cliente");
			System.out.println("2 - Nome da Filial");
			System.out.println("3 - Produto");
			System.out.println("4 - Quantidade do produto");
			System.out.println("5 - Valor do produto");
			System.out.println("==========================");
			System.out.print("O que deseja alterar? ");
			
			opc = input.nextInt();
			
			switch (opc) {
			case 1:
				System.out.println("Digite o Nome Cliente: ");
				p.setNomeCliente(input.nextLine());
				break;
			case 2:
				System.out.println("Digite o Nome Filial: ");
				p.setNomeFilial(input.nextLine());
				break;
			case 3:
				//Implementar
				//System.out.println("Digite o Produto: ");
				//p.setNomeCliente(input.nextLine());
				break;
			case 4:
				//Implementar
				//System.out.println("Digite o Nome: ");
				//p.setNomeCliente(input.nextLine());
				break;
			case 5:
				//Implementar
				//System.out.println("Digite o Nome: ");
				//p.setNomeCliente(input.nextLine());
				break;
			default:
				break;
			}
		}
		Date data = new Date(System.currentTimeMillis());
		p.setDataHoraEdicao(data);
	}

	public void excluir() {
		if (pedidos.size() == 0) {
			System.out.print("Não existem pedidos a excluir!");
		}
		if (pedidos.size() > 0) {
			System.out.print("Digite o número do Pedido que deseja excluir: ");

			Scanner input = new Scanner(System.in);

			int opcao = input.nextInt();

			for (Pedido p : pedidos) {
				int codBusca = p.getCodigo();
				if (codBusca == opcao) {
					pedidos.remove(p);
					break;
				}
			}

			System.out.println("Pedido removido!");
		}
	}
}
