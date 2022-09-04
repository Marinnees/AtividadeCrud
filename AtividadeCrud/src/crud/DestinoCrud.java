package crud;

import java.util.Scanner;

import dao.DestinoDao;
import modelo.Destino;

public class DestinoCrud {

	public static void main(String[] args) {
		DestinoDao destinoDao = new DestinoDao();

		Scanner s = new Scanner(System.in);
		int opcao = 0;
		int posicao=0;

		int id = 0;
		String nome = "";

		do {
			System.out.println("=== Seja bem vindo, escolha a opção desejada ===");
			System.out.println("1 - Cadastrar um Destino");
			System.out.println("2 - Consultar um Destino");
			System.out.println("3 - Atualizar um Destino");
			System.out.println("4 - Deletar um Destino");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("Digite o nome do páis de destino: ");
				nome = s.nextLine();
				
				Destino e1 = new Destino(id, nome);
				
				destinoDao.save(e1);
				
				System.out.println("\n***  Cadastrado  ***\n");

				break;
			case 2:
				// READ
				for (Destino e : destinoDao.getDestino()) {
					System.out.println("Id: " + e.getId() + " Nome: " + e.getNome());
				}
				
				System.out.println("consultou");
				break;
			case 3:
				// UPDATE
				System.out.println("Digite o id do destino: ");
				posicao = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome do destino: ");
				nome = s.nextLine();
				
				Destino e2 = new Destino(posicao, nome);
			
				destinoDao.update(e2);
	
				System.out.println("atualizou");
				break;
			case 4:
				// DELETE
				System.out.println("Digite o id do destino: ");
				posicao = s.nextInt();
				
				destinoDao.deleteById(posicao);
				
				break;
			case 5:
				// buscar por id
				System.out.println("Digite o id do destino: ");
				posicao = s.nextInt();
				
				Destino e3 = destinoDao.getdestinoById(posicao);
				
				System.out.println("Id: " + e3.getId() + " Nome: " + e3.getNome());
				
				break;
			default:
				System.out.println(opcao != 0 ? "opção invalida, digite novamente." : "");
				break;

			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();
	}

}