package sistemacofrinho;
import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Moeda {
	private double valor;
	private String nomeMoeda;
	private String simboloMoeda;
	
	public Moeda(double valor, String nomeMoeda, String simboloMoeda) {
		this.valor = valor;
		this.nomeMoeda = nomeMoeda;
		this.simboloMoeda = simboloMoeda;
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
	
	public String getSimboloMoeda() {
		return simboloMoeda;
	}

	public void setSimboloMoeda(String simboloMoeda) {
		this.simboloMoeda = simboloMoeda;
	}

	public double retornaValorArredondado() {
		double valor = this.getValor();
		BigDecimal bigDecimal = new BigDecimal(Double.toString(valor));
		bigDecimal.setScale(2, RoundingMode.HALF_UP);
		return bigDecimal.doubleValue();
	}
	
	public String info() {
		return this.getSimboloMoeda() + this.getValor();
	};
	
	
	
	
	public abstract Moeda converter(String paraQualMoedaSeraConvertida);
	
}
