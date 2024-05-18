package sistemacofrinho;

public abstract class Moeda {
	private double valor;
	private String nomeMoeda;
	
	public Moeda(double valor, String nomeMoeda) {
		this.valor = valor;
		this.nomeMoeda = nomeMoeda;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getNomeMoeda() {
		return nomeMoeda;
	}
	public void setNomeMoeda(String nomeMoeda) {
		this.nomeMoeda = nomeMoeda;
	}
	public abstract String info();
	public abstract Moeda converter(String paraQualMoedaSeraConvertida);
	
}
