package br.com.datasource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.model.Pedido;

public abstract class ArquivoDataSource extends BaseDatasource {

	private final String diretorioPedidosDB = "/aulajava/src/br/com/datasource/dbArquivo";

	public ArquivoDataSource() {
		// TODO Auto-generated constructor stub
		super();
		iniciaArquivo();
	}

	private void iniciaArquivo() {
		File dir = new File(diretorioPedidosDB);
		
		try {
			FileInputStream arqInput = new FileInputStream(diretorioPedidosDB);
			ObjectInputStream objInput = new ObjectInputStream(arqInput);
			
			List<Pedido> arqPedido = new ArrayList<Pedido>();
			
			arqPedido = (List<Pedido>) objInput.readObject();
			
			carregaPedidosArquivo(arqPedido);
			
			objInput.close();
			
		}catch(Exception e){
			System.err.println(e.getMessage());
		}				
	}
	
	private void regravaArquivo(List<Pedido> arqPed) {
		File dir = new File(diretorioPedidosDB);
		
		try {
			FileOutputStream arqOutput = new FileOutputStream(diretorioPedidosDB);
			ObjectOutputStream objOutput = new ObjectOutputStream(arqOutput);
			
			
			objOutput.reset();
			objOutput.writeObject(arqPed);			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		super.listar();
	}

	@Override
	public void incluir() {
		// TODO Auto-generated method stub
		super.incluir();
	}

	@Override
	public void alterar() {
		// TODO Auto-generated method stub
		super.alterar();
	}

	@Override
	public void exibeMenuAltera(Pedido p) {
		// TODO Auto-generated method stub
		super.exibeMenuAltera(p);
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		super.excluir();
	}

}
