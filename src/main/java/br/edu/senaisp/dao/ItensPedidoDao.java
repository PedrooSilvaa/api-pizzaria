package br.edu.senaisp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.senaisp.model.Cliente;
import br.edu.senaisp.model.PedidoItens;
import br.edu.senaisp.model.Sabor;

public class ItensPedidoDao {

	private final String SQLINSERT = 
			"INSERT INTO itens_pedido (id_sabor, id_pedido, preco) VALUES( ?, ? ?)";
	
	private final String SQLSELECT = 
			"SELECT id, id_sabor, id_pedido, preco FROM itens_pedido";
	
	private final String SQLDELETE = 
			"DELETE FROM itens_pedido WHERE id = ?";	
	
	private final String SQLSELECT_ID = 
			"SELECT id, id_sabor, id_pedido, preco FROM itens_pedido WHERE id = ?";
	
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
				ps.setFloat(2, pedidoItens.getId_sabor());
				ps.setFloat(3, pedidoItens.getId_pedido());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public List<PedidoItens> lista() {
		
		List<PedidoItens> pedidoItens = new ArrayList<PedidoItens>();
		
		try {
			Connection con = dao.conexao();
			
            if (!con.isClosed()) {
            	PreparedStatement ps = 
            	con.prepareStatement(SQLSELECT);
            	ResultSet rs = ps.executeQuery();
            	
            	PedidoItens tmp = null;
            	while (rs.next()) {
            		
            		tmp = new PedidoItens();
            		tmp.setId( rs.getInt("id") );
            		tmp.setId_sabor(rs.getInt("id_sabor"));
            		tmp.setId_sabor(rs.getInt("id_pedido"));
            		tmp.setPreco(rs.getFloat("preco"));
            		
            		pedidoItens.add(tmp);
            	}
            	
            	con.close();
            }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pedidoItens;
	}
	
	public void Delete(int numero) {
		
		try {
			Connection con = dao.conexao();
			
            if (!con.isClosed()) {
            	PreparedStatement ps = 
            	con.prepareStatement(SQLDELETE);
            		
            		ps.setInt(1, numero);
            		ps.execute();
            		
            	}
            	
            	con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public PedidoItens buscaPorId(int id) {
		PedidoItens pedidoItens = null; 
		
		try {
			Connection con = dao.conexao();
			
            if (!con.isClosed()) {
            	PreparedStatement ps = 
            	con.prepareStatement(SQLSELECT_ID);
            	ps.setInt(1, id);
            	
            	ResultSet rs = ps.executeQuery();
            	
            	
            	if (rs.next()) {
            		
            		pedidoItens = new PedidoItens();
            		
            		pedidoItens.setId(rs.getInt("id") );
            		pedidoItens.setId_sabor(rs.getInt("id_sabor"));
            		pedidoItens.setId_sabor(rs.getInt("id_pedido"));
            		pedidoItens.setPreco(rs.getFloat("preco"));
            		
               	}
            	
            	con.close();
            }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pedidoItens;
	}
	
	public void Update(PedidoItens pedidoItens) {

		try {
			Connection con = dao.conexao();
		 if (!con.isClosed()) {
            	PreparedStatement ps = 
            			con.prepareStatement(SQLUPDATE);
            	
            	ps.setFloat(1, pedidoItens.getPreco());
            	ps.setInt(2, pedidoItens.getId());
            	
            	ps.execute();
            }
            	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
