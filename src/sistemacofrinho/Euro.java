package sistemacofrinho;

import java.util.Arrays;

public class Euro extends Moeda {
	public Euro(double valor) {
		super(valor, "Euro", "EUR", Arrays.asList(0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1.00, 2.00));
	}

	private static final double TAXA_CAMBIO_EURO_PARA_DOLAR = 1.09;
	private static final double TAXA_CAMBIO_EURO_PARA_REAL = 5.55;

	@Override
	public Moeda converter(String paraQualMoedaSeraConvertida) {
		if (paraQualMoedaSeraConvertida == "Euro") {
			return new Dolar(this.getValor() * TAXA_CAMBIO_EURO_PARA_DOLAR);
		}
		else if (paraQualMoedaSeraConvertida == "Real") {
			return new Real(this.getValor() * TAXA_CAMBIO_EURO_PARA_REAL);
		}
		else 
			return this;
		
	}

}
