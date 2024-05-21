package sistemacofrinho;

import java.util.Arrays;

public class Euro extends Moeda {
	//classe implementa a clase abstrata  moeda 
		///contem m�todos e atributos  da moeda Euro  
	public Euro(double valor) { //m�todo construtor  que inicializa a moeda Euro
		super(valor, "Euro", "EUR", Arrays.asList(0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1.00, 2.00));
	}

	private static final double TAXA_CAMBIO_EURO_PARA_DOLAR = 1.09;
	private static final double TAXA_CAMBIO_EURO_PARA_REAL = 5.55;

	@Override
	public Double converter(String paraQualMoedaSeraConvertida) {
		//m�todo para retornar valor convertido para D�lar e Real
		if (paraQualMoedaSeraConvertida == "Euro") {
			return this.getValor() * TAXA_CAMBIO_EURO_PARA_DOLAR;
		}
		else if (paraQualMoedaSeraConvertida == "Real") {
			return this.getValor() * TAXA_CAMBIO_EURO_PARA_REAL;
		}
		else 
			return this.getValor();
	}

}
