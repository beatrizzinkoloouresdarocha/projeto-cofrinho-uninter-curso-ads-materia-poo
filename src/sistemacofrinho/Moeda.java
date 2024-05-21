package sistemacofrinho;

import java.util.List;

public abstract class Moeda {
	//classe abstrata contendo os métodos e atributos da moeda 
	private double valor;
	private String nomeMoeda;
	private String simboloMoeda;
	private List<Double> valoresDeMoedaValidos; //lista de valores válidos para a moeda 

	public Moeda(double valor, String nomeMoeda, String simboloMoeda, List<Double> valoresDeMoedaValidos) {
		//método construtor  para inicializar a moeda 
		this.valor = valor;
		this.nomeMoeda = nomeMoeda;
		this.simboloMoeda = simboloMoeda;
		this.valoresDeMoedaValidos = valoresDeMoedaValidos;
	}
	
	public double getValor() { //obter valor da moeda 
		return valor;
	}
	
	public void setValor(double valor) { //difinir valor da moeda 
		this.valor = valor;
	}
	
	public String getNomeMoeda() { //obter nome da moeda 
		return nomeMoeda;
	}
	
	public void setNomeMoeda(String nomeMoeda) { //definir nome da moeda 
		this.nomeMoeda = nomeMoeda;
	}
	
	public String getSimboloMoeda() { //obter simbolo da moeda 
		return simboloMoeda;
	}

	public void setSimboloMoeda(String simboloMoeda) { //difinir simbolo da moeda 
		this.simboloMoeda = simboloMoeda;
	}
	
	public List<Double> getValoresDeMoedaValidos() { //obter valores válidos da moeda 
		return valoresDeMoedaValidos;
	}
	
	public String info() {
		return this.getSimboloMoeda() + this.getValor(); //retornar string formatada com simbolo mais valor da moeda 
	};
	
	public Boolean verificaValorValido() { //verifica se o valor da moeda é válida 
		return this.getValoresDeMoedaValidos().contains(this.getValor());
	};
	
	//método abstrato que ira retornar  o valor da moeda convertida para outra moeda 
	public abstract Double converter(String paraQualMoedaSeraConvertida); 
	
}
