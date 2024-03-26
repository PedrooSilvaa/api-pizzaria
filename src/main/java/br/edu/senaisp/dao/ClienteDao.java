package br.edu.senaisp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.senaisp.model.Cliente;

public class ClienteDao {

			private final String SQLINSERT = 
					"INSERT INTO cliente (nome, telefone, rua, nr, bairro) VALUES(?, ?, ?, ?, ?)";
			
			private final String SQLSELECT = 
					"SELECT id, nome, telefone, rua, nr, bairro  FROM Cliente";
			
			private final String SQLDELETE = 
					"DELETE FROM cliente WHERE id = ?";	
			
			private final String SQLSELECT_ID = 
					"SELECT id, nome, telefone, rua, nr, bairro FROM cliente WHERE id = ?";
			
			private String SQLUPDATE = 
					"UPDATE cliente SET nome = ?, telefone = ?, rua = ?, nr = ?, bairro = ? WHERE id = ?";
			
			public void novo(Cliente cliente) {
				try {
					Connection con = dao.conexao();
					
		            if (!con.isClosed()) {
		            	PreparedStatement ps = 
		            			con.prepareStatement(SQLINSERT);
		            	
		            	ps.setString(1, cliente.getNome());
		            	ps.setString(2, cliente.getTelefone());
		            	ps.setString(3, cliente.getRua());
		            	ps.setInt(4, cliente.getNr());
		            	ps.setString(5, cliente.getBairro());
		            	
		            	ps.execute();
		            }
		            	
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			public List<Cliente> lista() {
				
				List<Cliente> clientes = new ArrayList<Cliente>();
				
				try {
					Connection con = dao.conexao();
					
		            if (!con.isClosed()) {
		            	PreparedStatement ps = 
		            	con.prepareStatement(SQLSELECT);
		            	ResultSet rs = ps.executeQuery();
		            	
		            	Cliente tmp = null;
		            	while (rs.next()) {
		            		
		            		tmp = new Cliente();
		            		tmp.setId( rs.getInt("id") );
		            		tmp.setNome(rs.getString("nome") );
		            		tmp.setTelefone(rs.getString("telefone"));
		            		tmp.setRua(rs.getString("rua"));
		            		tmp.setNr(rs.getInt("nr") );
		            		tmp.setBairro(rs.getString("bairro"));
		            		
		            		clientes.add(tmp);
		            	}
		            	
		            	con.close();
		            }
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				return clientes;
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
			
			public Cliente buscaPorId(int id) {
				Cliente cliente = null; 
				
				try {
					Connection con = dao.conexao();
					
		            if (!con.isClosed()) {
		            	PreparedStatement ps = 
		            	con.prepareStatement(SQLSELECT_ID);
		            	ps.setInt(1, id);
		            	
		            	ResultSet rs = ps.executeQuery();
		            	
		            	
		            	if (rs.next()) {
		            		
		            		cliente = new Cliente();
		            		
		            		cliente.setId(rs.getInt("id") );
		            		cliente.setNome(rs.getString("nome") );
		            		cliente.setTelefone(rs.getString("telefone"));
		            		cliente.setRua(rs.getString("rua"));
		            		cliente.setNr(rs.getInt("nr") );
		            		cliente.setBairro(rs.getString("bairro"));
		               	}
		            	
		            	con.close();
		            }
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				return cliente;
			}
			
			public void Update(Cliente cliente) {

				try {
					Connection con = dao.conexao();
				 if (!con.isClosed()) {
		            	PreparedStatement ps = 
		            			con.prepareStatement(SQLUPDATE);
		            	
		            	ps.setString(1, cliente.getNome());
		            	ps.setString(2, cliente.getTelefone());
		            	ps.setString(3, cliente.getRua());
		            	ps.setInt(4, cliente.getNr());
		            	ps.setString(5, cliente.getBairro());
		            	ps.setInt(6, cliente.getId());
		            	
		            	ps.execute();
		            }
		            	
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
			}
}
