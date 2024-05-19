package sistemacofrinho;

public class Real extends Moeda {
	public Real(double valor) {
		super(valor, "Real", "R$");
	}

	private static final double TAXA_CAMBIO_REAL_PARA_DOLAR = 0.19591;
	private static final double TAXA_CAMBIO_REAL_PARA_EURO = 0.18;

	@Override
	public Moeda converter(String paraQualMoedaSeraConvertida) {
		if (paraQualMoedaSeraConvertida == "D�lar") {
			return new Dolar(this.getValor() * TAXA_CAMBIO_REAL_PARA_DOLAR);
		}
		else if (paraQualMoedaSeraConvertida == "Euro") {
			return new Euro(this.getValor() * TAXA_CAMBIO_REAL_PARA_EURO);
		}
		else 
			return this;
		
	}

}
