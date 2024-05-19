package sistemacofrinho;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Cofrinho {
	private ArrayList<Moeda> listaMoedas;
	private Double totalConvertidoParaDolar;
	private Double totalConvertidoParaEuro;
	private Double totalConvertidoParaReal;

	public ArrayList<Moeda> getListaMoedas() {
		return listaMoedas;
	}
	
	public void setListaMoedas(ArrayList<Moeda> listaMoedas) {
		this.listaMoedas = listaMoedas;
	}

	public void adicionar(Moeda moeda) {
		Boolean moedaValorValido = moeda.verificaValorValido();
		if (moedaValorValido == true) {
			listaMoedas = this.getListaMoedas();
			listaMoedas.add(moeda);
			this.setListaMoedas(listaMoedas);
		}
	}
	
	public void remover(Moeda moeda) {
		double epsilon = 0.0001;
		listaMoedas = this.getListaMoedas();
		List<Moeda> moedasComValorBuscado = listaMoedas.stream()
				.filter(moedaNaLista -> moedaNaLista.getNomeMoeda().equals(moeda.getNomeMoeda()))
				.filter(moedaNaLista -> Math.abs(moedaNaLista.getValor() - moeda.getValor()) < epsilon)
				.collect(Collectors.toList());
		if (!moedasComValorBuscado.isEmpty()) {
			Moeda moedaParaRemover = moedasComValorBuscado.get(0);
			listaMoedas.remove(moedaParaRemover);
			this.setListaMoedas(listaMoedas);
		}
	}
	
	public String listagemMoedas() {
//		
	}
	
	public double totalConvertido(String paraQualMoeda) {
		
	}
}
