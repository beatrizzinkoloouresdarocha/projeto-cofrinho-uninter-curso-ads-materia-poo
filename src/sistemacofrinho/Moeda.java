package sistemacofrinho;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public abstract class Moeda {
	private double valor;
	private String nomeMoeda;
	private String simboloMoeda;
	private List<Double> valoresDeMoedaValidos;

	public Moeda(double valor, String nomeMoeda, String simboloMoeda, List<Double> valoresDeMoedaValidos) {
		this.valor = valor;
		this.nomeMoeda = nomeMoeda;
		this.simboloMoeda = simboloMoeda;
		this.valoresDeMoedaValidos = valoresDeMoedaValidos;
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
	
	public List<Double> getValoresDeMoedaValidos() {
		return valoresDeMoedaValidos;
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
	
	public Boolean verificaValorValido() {
		return this.getValoresDeMoedaValidos().contains(this.getValor());
	};
	
	public abstract Double converter(String paraQualMoedaSeraConvertida);
	
}
