package sistemacofrinho;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

	//Essa é a classe principal que contém o método main que executa o sistema do cofrinho 
	
	public static void main(String[] args) {
		Cofrinho cofrinho = new Cofrinho(); //instancia da classe cofrinho 
		int opcaoMenuPrincipal;
		int moedaEscolhida;
		double valor;
		Moeda moeda = null;
		
		Scanner scanner = new Scanner(System.in); //instancia da classe Scanner é usada pra ler o que o usuário digitar 
		try {
			while (true) { //para executar o sistema em loop até que o usuário digite a opção  0-encerrar
				System.out.println("Digite a opção desejada: \n 1-Adicionar moeda \n 2-Remover moeda \n 3-Listar moedas \n " + 
									"4-Calcular total convertido \n 0-Encerrar");
				
				try {
					opcaoMenuPrincipal = scanner.nextInt(); //ler o proximo número digitado 
				}
				catch (InputMismatchException e) { //tratamento de erro caso o usúario não digite um número
					System.out.println("O valor digitado é inválido, digite apenas números.");
					scanner.nextLine(); //para avançar uma linha no scanner e não da erro 
					continue; //voltando ao inicio do loop 
				}
				
				if (opcaoMenuPrincipal == 1) { //adicionar moeda
					while (true) { //executar em loop até que seja selecionada uma opção válida 
						System.out.println("Digite a opção desejada: \n 1-Real \n 2-Dólar \n 3-Euro");
						moedaEscolhida = scanner.nextInt(); //ler a opção digitada pelo usúario 
						System.out.println("Digite o valor:");
						try {
							valor = scanner.nextDouble(); //ler o valor digitado pelo usúario 
						}
						catch (InputMismatchException e) { //tratamento de erro para caso ou usúario digite um valor inválido
							System.out.println("O valor digitado é inválido, digite apenas números." + 
											  "Utilize a vírgula como separador decimal.");
							scanner.nextLine();  //para avançar uma linha no scanner e não dar erro 
							continue; //voltando ao inicio do loop 
						}
						if (moedaEscolhida == 1) { 
							moeda = new Real(valor); //cria uma moeda de Real com o valor passado pelo usúario 
						}
						else if (moedaEscolhida == 2) {
							moeda = new Dolar(valor); //cria uma moeda de Dolar com o valor passado pelo usúario 
						}
						else if (moedaEscolhida == 3) {
							moeda = new Euro(valor); //cria uma moeda de Euro com o valor passado pelo usúario 
						}
						
						if (moedaEscolhida >= 1 && moedaEscolhida <=3) { //se foi selecionada uma opção válida 
							Boolean adicionadaComSucesso = cofrinho.adicionar(moeda); //adiciona moeda no cofrinho 
							if (adicionadaComSucesso == true) { //verefica se moeda foi adicionada com sucesso no cofrinho 
								System.out.println("Moeda adicionada com sucesso!");
							}
							else { //exibe uma mensagem ao o usúario informando que o valor digitado é invalido e 
								//e informa  os valores válidos para a  moeda selecionada 
								List<Double> moedaValoresValidos = moeda.getValoresDeMoedaValidos();
								StringBuilder stringDigiteValoresMoedaValidos = new StringBuilder();
								stringDigiteValoresMoedaValidos.append("Erro ao adicionar moeda!" +
								"Só podem ser adicionados os seguintes valores de " + 
								moeda.getNomeMoeda() + ": "); //buscar nome da moeda 
								//monta string apartir da lista de valores  válidos para essa moeda 
								String somenteValoresValidos = moedaValoresValidos.stream()
		                                  .map(Object::toString)
		                                  .collect(Collectors.joining(", "));
								stringDigiteValoresMoedaValidos.append(somenteValoresValidos);
								System.out.println(stringDigiteValoresMoedaValidos);
							}
							break; //sair desse loop 
						}
					}
				}
				else if (opcaoMenuPrincipal == 2) { //remover moeda
					while (true) { //executar em loop até que seja selecionada uma opção válida 
						System.out.println("Digite a opção desejada: \n 1-Real \n 2-Dólar \n 3-Euro");
						moedaEscolhida = scanner.nextInt(); //ler a opção digitada pelo usúario 
						System.out.println("Digite o valor:"); 
						try {
							valor = scanner.nextDouble();  //ler o valor digitado pelo usúario 
						} 
						catch (InputMismatchException e){ // tratamento de erro para  caso o usúario digite um valor inválido
							System.out.println("O valor digitado é inválido, digite apenas números. " + 
											  "Utilize a vírgula como separador decimal");
							scanner.nextLine(); //para avançar uma linha no scanner e não dar erro 
							continue; // //voltando ao inicio do loop 
						}
						if (moedaEscolhida == 1) {
							moeda = new Real(valor); //cria uma moeda de Real com o valor passado pelo usúario 
						}
						else if (moedaEscolhida == 2) {
							moeda = new Dolar(valor); //cria uma moeda de Dolar com o valor passado pelo usúario 
						}
						else if (moedaEscolhida == 3) {
							moeda = new Euro(valor); //cria uma moeda de Euro com o valor passado pelo usúario 
						}
						
						if (moedaEscolhida >= 1 && moedaEscolhida <=3) {//se foi selecionada uma opção válida 
							Boolean removidaComSucesso = cofrinho.remover(moeda);//remove moeda do cofrinho 
							if (removidaComSucesso == true) { //verifica se moeda foi adicionada com sucesso no cofrinho 
								System.out.println("Moeda removida com sucesso!");
							}
							else {
								System.out.println("Erro ao remover moeda! Nenhuma moeda do valor informado está no cofrinho.");
							}
							break;//sair desse loop 
						}
					}
				}
				else if (opcaoMenuPrincipal == 3) { //listar moedas
					String listagemMoedas = cofrinho.listagemMoedas();//obter lista de moedas que estão no cofrinho
					System.out.println(listagemMoedas); //exibir para o usúario  a lista de moedas que estão no cofrinho 
				}
				else if (opcaoMenuPrincipal == 4) { //calcular total convertido
					//calcular total das moedas do cofrinho convertidas para Real 
					Double totalConvertidoParaReal = cofrinho.totalConvertido(); 
					//ixibi para usúario total das moedas do cofrinho convertidas para Real 
					System.out.println("Total convertido para reais: R$" + totalConvertidoParaReal);
				}
				else if (opcaoMenuPrincipal == 0) { //encerrar
					break;//sair desse loop e encerrar o programa 
				}
					
			}
		} catch (Exception e){ //tratamento de erro caso ocorra um erro inesperado no programa 
			System.out.println("Erro inesperado no sistema cofrinho. O sistema será encerrado.");
		} finally {
			scanner.close();//liberar o objeto Scanner da memória 
		}
			
	}
}
