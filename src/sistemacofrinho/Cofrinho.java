package sistemacofrinho;
import java.util.ArrayList;

public class Cofrinho {
	private ArrayList<Moeda> listaMoedas;
	private Dolar totalMoedasDolar;
	private Euro totalMoedasEuro;
	private Real totalMoedasReal;
	private Dolar totalConvertidoParaDolar;
	private Euro totalConvertidoParaEuro;
	private Real totalConvertidoParaReal;
	
	public Dolar getTotalMoedasDolar() {
		return totalMoedasDolar;
	}

	public void setTotalMoedasDolar(Dolar totalMoedasDolar) {
		this.totalMoedasDolar = totalMoedasDolar;
	}

	public Euro getTotalMoedasEuro() {
		return totalMoedasEuro;
	}

	public void setTotalMoedasEuro(Euro totalMoedasEuro) {
		this.totalMoedasEuro = totalMoedasEuro;
	}

	public Real getTotalMoedasReal() {
		return totalMoedasReal;
	}

	public void setTotalMoedasReal(Real totalMoedasReal) {
		this.totalMoedasReal = totalMoedasReal;
	}

	public Dolar getTotalConvertidoParaDolar() {
		return totalConvertidoParaDolar;
	}

	public void setTotalConvertidoParaDolar(Dolar totalConvertidoParaDolar) {
		this.totalConvertidoParaDolar = totalConvertidoParaDolar;
	}

	public Euro getTotalConvertidoParaEuro() {
		return totalConvertidoParaEuro;
	}

	public void setTotalConvertidoParaEuro(Euro totalConvertidoParaEuro) {
		this.totalConvertidoParaEuro = totalConvertidoParaEuro;
	}

	public Real getTotalConvertidoParaReal() {
		return totalConvertidoParaReal;
	}

	public void setTotalConvertidoParaReal(Real totalConvertidoParaReal) {
		this.totalConvertidoParaReal = totalConvertidoParaReal;
	}

	public ArrayList<Moeda> getListaMoedas() {
		return listaMoedas;
	}
	
	public void operacaoComMoedas(Moeda moeda, String operacao) {
		String nomeMoeda = moeda.getNomeMoeda();
		if (nomeMoeda == "Dólar") {
			Dolar totalDolar = this.getTotalMoedasDolar();
			Double valorTotalDolar = totalDolar.getValor();
			if (operacao == "adicionar") { 
				valorTotalDolar += moeda.getValor();
			} 
			else {
				valorTotalDolar -= moeda.getValor();
			}
			Dolar novoTotalDolar = new Dolar(valorTotalDolar);
			this.setTotalMoedasDolar(novoTotalDolar);
		}
		else if (nomeMoeda == "Euro") {
			Euro totalEuro = this.getTotalMoedasEuro();
			Double valorTotalEuro = totalEuro.getValor();
			if (operacao == "adicionar") { 
				valorTotalEuro += moeda.getValor();
			} 
			else {
				valorTotalEuro -= moeda.getValor();
			}
			Euro novoTotalEuro = new Euro(valorTotalEuro);
			this.setTotalMoedasEuro(novoTotalEuro);
		}
		else {
			Real totalReal = this.getTotalMoedasReal();
			Double valorTotalReal = totalReal.getValor();
			if (operacao == "adicionar") { 
				valorTotalReal += moeda.getValor();
			} 
			else {
				valorTotalReal -= moeda.getValor();
			}
			Real novoTotalReal = new Real(valorTotalReal);
			this.setTotalMoedasReal(novoTotalReal);
		}
	}
	
	public void adicionar(Moeda moeda) {
		this.operacaoComMoedas(moeda, "adicionar");
	}
	
	public void remover(Moeda moeda) {
		this.operacaoComMoedas(moeda, "remover");
	}
	
	public String listagemMoedas() {
//		
	}
	
	public double totalConvertido(String paraQualMoeda) {
		
	}
}
