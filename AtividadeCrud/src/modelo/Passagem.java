package modelo;

public class Passagem {
	// Atributos
	private int id_passagem;
	private String empresa;
	private String embarque;
	private String desembarque;
	private double valor_passagem;

	// Construtor
	public Passagem(int id_passagem, String empresa, String embarque, String desembarque, double valor_passagem) {
		this.id_passagem = id_passagem;
		this.empresa = empresa;
		this.embarque = embarque;
		this.desembarque = desembarque;
		this.valor_passagem = valor_passagem;
	}

	public Passagem() {
	}

	// Gets e Sets
	public int getId_passagem() {
		return id_passagem;
	}

	public void setId_passagem(int id_passagem) {
		this.id_passagem = id_passagem;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getEmbarque() {
		return embarque;
	}

	public void setEmbarque(String embarque) {
		this.embarque = embarque;
	}

	public String getDesembarque() {
		return desembarque;
	}

	public void setDesembarque(String desembarque) {
		this.desembarque = desembarque;
	}

	public double getValor_passagem() {
		return valor_passagem;
	}

	public void setValor_passagem(double valor_passagem) {
		this.valor_passagem = valor_passagem;
	}

	public int getPassagem() {
		return id_passagem;
	}

}