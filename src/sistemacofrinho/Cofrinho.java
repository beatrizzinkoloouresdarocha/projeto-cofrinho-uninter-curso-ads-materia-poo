package sistemacofrinho;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

	public Boolean adicionar(Moeda moeda) {
		Boolean moedaValorValido = moeda.verificaValorValido();
		if (moedaValorValido == true) {
			listaMoedas = this.getListaMoedas();
			listaMoedas.add(moeda);
			this.setListaMoedas(listaMoedas);
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean remover(Moeda moeda) {
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
			return true;
		}
		else {
			return false;
		}
	}
	
	public String listagemMoedas() {
		StringBuilder stringMoedasAgrupadasPorNomeValor = new StringBuilder();
		stringMoedasAgrupadasPorNomeValor.append("Listagem de moedas");
		listaMoedas = this.getListaMoedas();
		Map<String, Map<Double, Long>> moedasAgrupadasComContagem = listaMoedas.stream()
				.collect(Collectors.groupingBy(Moeda::getNomeMoeda, 
						Collectors.groupingBy(Moeda::getValor,
								Collectors.counting())));
		moedasAgrupadasComContagem.forEach((nomeMoeda, mapValorContagem) -> 
		{
			stringMoedasAgrupadasPorNomeValor.append("Moeda:").append(nomeMoeda).append("\n");
			mapValorContagem.forEach((valor, contagem) -> {
				stringMoedasAgrupadasPorNomeValor.append("\tValor: ").append(valor).append(" - Quantidade:")
				.append(contagem).append("\n");
			});
		});
		return stringMoedasAgrupadasPorNomeValor.toString();
	}
	
//	public double totalConvertido(String paraQualMoeda) {
//		
//	}
}
