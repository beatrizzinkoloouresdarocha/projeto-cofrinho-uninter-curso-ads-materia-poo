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
	
	public void adicionar(Moeda moeda) {
		String nomeMoeda = moeda.getNomeMoeda();
		if (nomeMoeda == "Dólar") {
//			this.listaMoedasDolar.add((Dolar) moeda);
		}
		else if (nomeMoeda == "Euro") {
//			this.listaMoedasEuro.add((Euro) moeda);
		}
		else {
//			this.listaMoedasReal.add((Real) moeda);
		}
		
		listaMoedas.add(moeda);
	}
	
	public void remover(Moeda moeda) {
//		listaMoedas.remove
	}
	
	public String listagemMoedas() {
//		
	}
	
	public double totalConvertido() {
		
	}
}
