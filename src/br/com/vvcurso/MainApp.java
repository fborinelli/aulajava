package vvcurso;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import datasource.PedidoDatasource;

public class MainApp {
	private static final String file = "C:\\Users\\Faki\\eclipse-workspace\\aulajava\\src\\datasource\\teste";
	public static void main(String[] args) throws IOException{
		String str = IOUtils.toString(new FileReader(file));
		System.out.println(str);
		
		Scanner input = new Scanner(System.in);
		PedidoDatasource pedidoDS = new PedidoDatasource();
		int opcaoMenu = 0;

		while (opcaoMenu != 5) {
			System.out.println(exibeMenu());

			opcaoMenu = input.nextInt();

			trataOpcaoMenu(opcaoMenu, pedidoDS);
		}
	}

	public static String exibeMenu() {
		StringBuilder str = new StringBuilder();
		str.append("\n");
		str.append("====== MENU PEDIDOS ======\n");
		str.append("1 - Listar \n");
		str.append("2 - Incluir\n");
		str.append("3 - Alterar\n");
		str.append("4 - Excluir\n\n");
		str.append("5 - Sair\n");
		str.append("==========================\n");
		str.append("Digite uma opção: ");
		
		return str.toString();
	}

	public static void trataOpcaoMenu(int opcao, PedidoDatasource pedidoDS) {

		switch (opcao) {
		case 1:
			pedidoDS.listar();
			break;
		case 2:
			pedidoDS.incluir();
			break;
		case 3:
			pedidoDS.alterar();
			break;
		case 4:
			pedidoDS.excluir();
			break;
		case 5:
			System.out.println("Finalizando! ");
			break;
		default:
			System.err.println("Opção Inválida! ");
			break;
		}
	}
}
