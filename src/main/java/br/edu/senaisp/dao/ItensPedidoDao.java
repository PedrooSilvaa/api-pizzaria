package br.edu.senaisp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.edu.senaisp.model.PedidoItens;
import br.edu.senaisp.model.Sabor;

public class ItensPedidoDao {

	private final String SQLINSERT = 
			"INSERT INTO itens_pedido (id_sabor, preco) VALUES( ?, ?)";
	
	private final String SQLSELECT = 
			"SELECT id, id_sabor, preco FROM itens_pedido";
	
	private final String SQLDELETE = 
			"DELETE FROM itens_pedido WHERE id = ?";	
	
	private final String SQLSELECT_ID = 
			"SELECT id, id_sabor, preco FROM itens_pedido WHERE id = ?";
	
	private String SQLUPDATE = 
			"UPDATE itens_pedido SET preco = ? WHERE id = ?";
	
	
	public void novo(PedidoItens pedidoItens) {
		
		System.out.println(pedidoItens.getPreco());
		
		try {
			
			Connection con = dao.conexao();
			
			if(!con.isClosed()) {
				PreparedStatement ps = con.prepareStatement(SQLINSERT);
				
				Sabor s = new Sabor();
				
				ps.setInt(1, s.getId());
				ps.setFloat(2, pedidoItens.getId());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
