package sistemacofrinho;

import java.util.Arrays;

public class Real extends Moeda {
	public Real(double valor) {
		super(valor, "Real", "R$", Arrays.asList(0.01, 0.05, 0.10, 0.25, 0.50, 1.00));
	}

	private static final double TAXA_CAMBIO_REAL_PARA_DOLAR = 0.19591;
	private static final double TAXA_CAMBIO_REAL_PARA_EURO = 0.18;

	@Override
	public Double converter(String paraQualMoedaSeraConvertida) {
		if (paraQualMoedaSeraConvertida == "Dólar") {
			return this.getValor() * TAXA_CAMBIO_REAL_PARA_DOLAR;
		}
		else if (paraQualMoedaSeraConvertida == "Euro") {
			return this.getValor() * TAXA_CAMBIO_REAL_PARA_EURO;
		}
		else 
			return this.getValor();
	}

}
