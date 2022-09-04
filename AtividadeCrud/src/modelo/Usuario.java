package modelo;

public class Usuario {
	// atributos
	private int id_usuario;
	private String nome;
	private String email;
	private String senha;
	private String endereco;
	private Permissao permissao;

	// Contrutor
	public Usuario(String nome, String email, String senha, String endereco, Permissao permissao) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.permissao = permissao;
	}

	public Usuario() {
	}

	//Gets e Sets
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	//Metodo 
	public String mostrarUsuario() {
		return "Id: "+ this.id_usuario +" Nome: " +this.nome 
				+ " Email: " + this.email 
				+ " Senha: " + this.senha
				+ " Tipo permissão: " + this.permissao.getTipo_permissao(); 
	}
}