package sistemacofrinho;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Cofrinho cofrinho = new Cofrinho();
		int opcaoMenuPrincipal;
		int moedaEscolhida;
		double valor;
		Moeda moeda = null;
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Digite a opção desejada: \n 1-Adicionar moeda \n 2-Remover moeda \n 3-Listar moedas \n " + 
								"4-Calcular total convertido \n 0-Encerrar");
			
			opcaoMenuPrincipal = scanner.nextInt();
			
			if (opcaoMenuPrincipal == 1) { //adicionar moeda
				while (true) {
					System.out.println("Digite a opção desejada: \n 1-Real \n 2-Dólar \n 3-Euro");
					moedaEscolhida = scanner.nextInt();
					System.out.println("Digite o valor:");
					valor = scanner.nextDouble();
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
							System.out.println("Erro ao adicionar moeda!");
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
					valor = scanner.nextDouble();
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
							System.out.println("Erro ao remover moeda!");
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
				
			}
			else if (opcaoMenuPrincipal == 0) { //encerrar
				break;
			}
				
		}
	}

}
