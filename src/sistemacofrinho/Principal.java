package sistemacofrinho;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

	public static void main(String[] args) {
		Cofrinho cofrinho = new Cofrinho();
		int opcaoMenuPrincipal;
		int moedaEscolhida;
		double valor;
		Moeda moeda = null;
		
		Scanner scanner = new Scanner(System.in);
		try {
			while (true) {
				System.out.println("Digite a opção desejada: \n 1-Adicionar moeda \n 2-Remover moeda \n 3-Listar moedas \n " + 
									"4-Calcular total convertido \n 0-Encerrar");
				
				try {
					opcaoMenuPrincipal = scanner.nextInt();
				}
				catch (InputMismatchException e) {
					System.out.println("O valor digitado é inválido, digite apenas números.");
					scanner.nextLine();
					continue;
				}
				
				if (opcaoMenuPrincipal == 1) { //adicionar moeda
					while (true) {
						System.out.println("Digite a opção desejada: \n 1-Real \n 2-Dólar \n 3-Euro");
						moedaEscolhida = scanner.nextInt();
						System.out.println("Digite o valor:");
						try {
							valor = scanner.nextDouble();
						}
						catch (InputMismatchException e) {
							System.out.println("O valor digitado é inválido, digite apenas números." + 
											  "Utilize a vírgula como separador decimal.");
							scanner.nextLine();
							continue;
						}
						if (moedaEscolhida == 1) {
							moeda = new Real(valor);
						}
						else if (moedaEscolhida == 2) {
							moeda = new Dolar(valor);
						}
						else if (moedaEscolhida == 3) {
							moeda = new Euro(valor);
						}
						
						if (moedaEscolhida >= 1 && moedaEscolhida <=3) {
							Boolean adicionadaComSucesso = cofrinho.adicionar(moeda);
							if (adicionadaComSucesso == true) {
								System.out.println("Moeda adicionada com sucesso!");
							}
							else {
								List<Double> moedaValoresValidos = moeda.getValoresDeMoedaValidos();
								StringBuilder stringDigiteValoresMoedaValidos = new StringBuilder();
								stringDigiteValoresMoedaValidos.append("Erro ao adicionar moeda!" +
								"Só podem ser adicionados os seguintes valores de " + 
								moeda.getNomeMoeda() + ": ");
								String somenteValoresValidos = moedaValoresValidos.stream()
		                                  .map(Object::toString)
		                                  .collect(Collectors.joining(", "));
								stringDigiteValoresMoedaValidos.append(somenteValoresValidos);
								System.out.println(stringDigiteValoresMoedaValidos);
							}
							break;
						}
					}
				}
				else if (opcaoMenuPrincipal == 2) { //remover moeda
					while (true) {
						System.out.println("Digite a opção desejada: \n 1-Real \n 2-Dólar \n 3-Euro");
						moedaEscolhida = scanner.nextInt();
						System.out.println("Digite o valor:");
						try {
							valor = scanner.nextDouble();
						} 
						catch (InputMismatchException e){
							System.out.println("O valor digitado é inválido, digite apenas números. " + 
											  "Utilize a vírgula como separador decimal");
							scanner.nextLine();
							continue;
						}
						if (moedaEscolhida == 1) {
							moeda = new Real(valor);
						}
						else if (moedaEscolhida == 2) {
							moeda = new Dolar(valor);
						}
						else if (moedaEscolhida == 3) {
							moeda = new Euro(valor);
						}
						
						if (moedaEscolhida >= 1 && moedaEscolhida <=3) {
							Boolean removidaComSucesso = cofrinho.remover(moeda);
							if (removidaComSucesso == true) {
								System.out.println("Moeda removida com sucesso!");
							}
							else {
								System.out.println("Erro ao remover moeda! Nenhuma moeda do valor informado está no cofrinho.");
							}
							break;
						}
					}
				}
				else if (opcaoMenuPrincipal == 3) { //listar moedas
					String listagemMoedas = cofrinho.listagemMoedas();
					System.out.println(listagemMoedas);
				}
				else if (opcaoMenuPrincipal == 4) { //calcular total convertido
					Double totalConvertidoParaReal = cofrinho.totalConvertido();	
					System.out.println("Total convertido para reais: R$" + totalConvertidoParaReal);
				}
				else if (opcaoMenuPrincipal == 0) { //encerrar
					break;
				}
					
			}
		} catch (Exception e){
			System.out.println("Erro inesperado no sistema cofrinho. O sistema será encerrado.");
		} finally {
			scanner.close();
		}
			
	}
}
