package sistemacofrinho;

import java.util.Arrays;

public class Dolar extends Moeda {
	public Dolar(double valor) {
		super(valor, "Dólar", "USD", Arrays.asList(0.01, 0.05, 0.10, 0.25, 1.00));
	}

	private static final double TAXA_CAMBIO_DOLAR_PARA_EURO = 0.92;
	private static final double TAXA_CAMBIO_DOLAR_PARA_REAL = 5.1031;

	@Override
	public Moeda converter(String paraQualMoedaSeraConvertida) {
		if (paraQualMoedaSeraConvertida == "Euro") {
			return new Euro(this.getValor() * TAXA_CAMBIO_DOLAR_PARA_EURO);
		}
		else if (paraQualMoedaSeraConvertida == "Real") {
			return new Real(this.getValor() * TAXA_CAMBIO_DOLAR_PARA_REAL);
		}
		else 
			return this;
		
	}

}
