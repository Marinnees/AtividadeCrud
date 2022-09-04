package modelo;

public class Login {
	private String senha;
	private String email;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Login(String senha, String email) {
		this.senha = senha;
		this.email = email;
	}

	public Login() {
	}
}