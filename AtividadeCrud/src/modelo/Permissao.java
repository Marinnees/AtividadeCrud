package modelo;

public class Permissao {
	// Atributos
	private int id_permissao;
	private String tipo_permissao;

	// Construtor
	public Permissao(int id_permissao, String tipo_permissao) {
		this.id_permissao = id_permissao;
		this.tipo_permissao = tipo_permissao;
	}

	public Permissao() {
	}

	// Gets e Sets
	public int getId_permissao() {
		return id_permissao;
	}

	public void setId_permissao(int id_permissao) {
		this.id_permissao = id_permissao;
	}

	public String getTipo_permissao() {
		return tipo_permissao;
	}

	public void setTipo_permissao(String tipo_permissao) {
		this.tipo_permissao = tipo_permissao;
	}

}