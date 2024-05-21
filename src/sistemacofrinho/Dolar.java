package sistemacofrinho;

import java.util.Arrays;

public class Dolar extends Moeda {
	//classe implementa a clase abstrata  moeda 
	//contem métodos e atributos  da moeda Dolar 
	public Dolar(double valor) { //método construtor  que inicializa a moeda Dolar 
		super(valor, "Dólar", "USD", Arrays.asList(0.01, 0.05, 0.10, 0.25, 1.00));
	}

	private static final double TAXA_CAMBIO_DOLAR_PARA_EURO = 0.92;
	private static final double TAXA_CAMBIO_DOLAR_PARA_REAL = 5.1031;

	@Override
	public Double converter(String paraQualMoedaSeraConvertida) { 
		//método para retornar valor convertido para Euro e Real
		if (paraQualMoedaSeraConvertida == "Euro") {
			return this.getValor() * TAXA_CAMBIO_DOLAR_PARA_EURO;
		}
		else if (paraQualMoedaSeraConvertida == "Real") {
			return this.getValor() * TAXA_CAMBIO_DOLAR_PARA_REAL;
		}
		else 
			return this.getValor();
	}

}
