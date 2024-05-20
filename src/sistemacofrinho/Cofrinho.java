package sistemacofrinho;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Cofrinho {
	//classe com os métodos  e atributos do cofrinho de moedas 
	private ArrayList<Moeda> listaMoedas = new ArrayList<Moeda>();//lista de moedas do cofrinho 

	public ArrayList<Moeda> getListaMoedas() { //obter lista de moedas do cofrinho 
		return listaMoedas;
	}
	
	public void setListaMoedas(ArrayList<Moeda> listaMoedas) {//difinir  lista de moedas  do cofrinho 
		this.listaMoedas = listaMoedas;
	}

	public Boolean adicionar(Moeda moeda) { //método para adicionar um moeda por vez no cofrinho 
		Boolean moedaValorValido = moeda.verificaValorValido(); //verifica se o valor é válido para essa moeda
		if (moedaValorValido == true) { //adiciona moeda na lista de moedas do cofrinho
			listaMoedas = this.getListaMoedas();
			listaMoedas.add(moeda);
			this.setListaMoedas(listaMoedas);
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean remover(Moeda moeda) { //método para remover uma moeda especifica  do cofrinho 
		double epsilon = 0.0001; //valor auxiliar utilizado na comparação de igualdade de valores monetários 
		listaMoedas = this.getListaMoedas(); //obter lista de moedas  do cofrinho
		//busca se na lista de moedas do cofrinho existe essa moeda especifica (nome e valor)
		List<Moeda> moedasComValorBuscado = listaMoedas.stream()
				.filter(moedaNaLista -> moedaNaLista.getNomeMoeda().equals(moeda.getNomeMoeda()))
				.filter(moedaNaLista -> Math.abs(moedaNaLista.getValor() - moeda.getValor()) < epsilon)
				.collect(Collectors.toList());
		if (!moedasComValorBuscado.isEmpty()) { //se a moeda especifica foi encontrada no cofrinho, remove ela do cofrinho
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
		// método que retorna  a listagem de moedas do cofrinho agrupada por nome da moeda e valor, e exibe  quantidade de cada moeda
		StringBuilder stringMoedasAgrupadasPorNomeValor = new StringBuilder();
		stringMoedasAgrupadasPorNomeValor.append("Listagem de moedas \n\n");
		listaMoedas = this.getListaMoedas(); //obter lista de moedas  do cofrinho 
		//agrupa as moedas por nome e valor e conta  a quantidade de cada moeda/valor
		Map<String, Map<Double, Long>> moedasAgrupadasComContagem = listaMoedas.stream()
				.collect(Collectors.groupingBy(Moeda::getNomeMoeda, 
						Collectors.groupingBy(Moeda::getValor,
								Collectors.counting())));
		moedasAgrupadasComContagem.forEach((nomeMoeda, mapValorContagem) -> 
		{ //para cada moeda/valor mota uma linha na string
			stringMoedasAgrupadasPorNomeValor.append("Moeda:").append(nomeMoeda).append("\n");
			mapValorContagem.forEach((valor, contagem) -> {
				stringMoedasAgrupadasPorNomeValor.append("\tValor: ").append(valor).append(" - Quantidade:")
				.append(contagem).append("\n");
			});
		});
		//retorna lista de moedas  agrupada  por moeda/valor e contendo a quantidade de cada grupo
		return stringMoedasAgrupadasPorNomeValor.toString(); 
	}
	
	public Double totalConvertido() { 
		//método para retornar total das moedas do cofrinho convertidas para Real
		final double[] total = {0};
		listaMoedas = this.getListaMoedas(); //obter lista de moedas do cofrinho 
		listaMoedas.forEach(moeda -> total[0] += moeda.converter("Real")); //coverte cada moeda do cofrinho para Real
		return total[0]; //retorna total das moesdas do cofrinho covertidas para Real
	}
}
