package br.edu.senaisp.model;

public class PedidoItens {

	private Integer id;
	private Integer id_sabor;
	private Integer id_pedido;
	private float preco;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_sabor() {
		return id_sabor;
	}
	public void setId_sabor(Integer id_sabor) {
		this.id_sabor = id_sabor;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public Integer getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}
	
	
}
