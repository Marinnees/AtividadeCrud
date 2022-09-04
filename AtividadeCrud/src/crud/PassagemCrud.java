package crud;

import java.util.Scanner;

import dao.PassagemDao;
import modelo.Passagem;

public class PassagemCrud {
	public static void main(String[] args) {
		PassagemDao passagemDao = new PassagemDao();
		Passagem passagem = new Passagem();
	
		String empresa = "";
		String embarque = "";
		String desembarque = "";
		double valorPassagem = 0;
		int id = 0;
		int opcao = 0;
		Scanner entrada = new Scanner(System.in);

		do {
		
			System.out.println(" Seja bem vindo ao menu de cadastro da passagem, o que você deseja?  \n");
			System.out.println("1 - Cadastrar a passagem");
			System.out.println("2 - Atualizar a passagem");
			System.out.println("3 - Deletar a passagem");
			System.out.println("4 - Mostrar a passagem");
			System.out.println("5 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1:
				// Salvar passagem
				System.out.println("Cadastrar Passagem \n");
				System.out.println("Digite o nome da Companhia Aérea- \n");
				empresa = entrada.next();
				
				System.out.println("Digite o a sigla do Estado do seu embarque \n");
				embarque = entrada.next();
				
				System.out.println("Digite o a sigla do Estado onde ocorrerá o desembarque \n");
				desembarque = entrada.next();		
				
				System.out.println("Digite apenas os números do valor total da sua passagem");
				valorPassagem = entrada.nextDouble();

				Passagem passagemCadastro = new Passagem(id, empresa, embarque,  desembarque, valorPassagem);
				passagemDao.saveTicket(passagemCadastro);
				
				System.out.println("Passagem cadastrada com sucesso! \n");

				break;
			case 2:
				// Atualizar passagem
				
				System.out.println("--- Atualizar Passagem ----");
				System.out.println("Digite o id da passagem");
				id  = entrada.nextInt();
				
				System.out.println("\n Digite a nova Companhia Aérea desejada");
				empresa = entrada.next();
				
				System.out.println("\n Digite a nova sigla do Estado do seu embarque");
				embarque = entrada.next();
				
				System.out.println("\n Digite a nova sigla do Estado do seu desembarque");
				desembarque = entrada.next();
				
				System.out.println("\n Digite apenas os números do novo valor total da sua passagem");
				valorPassagem = entrada.nextDouble();
				
				passagem.setEmpresa(empresa);
				passagem.setEmbarque(embarque);
				passagem.setDesembarque(desembarque);
				passagem.setValor_passagem(valorPassagem);
				passagem.setId_passagem(id);
				
				passagemDao.updateTicket(passagem);
				break;
			case 3:
				// Deletar o user
				System.out.println("Informe o número do ID para exclusão");
				id = entrada.nextInt();
				passagemDao.deleteTicket(id);
				break;
			case 4:
				//Mostrar users
				for(Passagem p : passagemDao.readTicket()) {
					System.out.println("Id: " + p.getId_passagem() 
					+ "\n Empresa: " + p.getEmpresa() 
					+ "\n Embarque: " + p.getEmbarque()
					+ "\n Desembarque: " + p.getDesembarque()
					+ "\n Valor: " + p.getValor_passagem()
					+ "\n ------------------------------------------------------------------------");
				}

				break;
			case 5:
				System.out.println("Obrigado, volte sempre!");

				break;

			default:
				System.out.println(opcao + " - Opcao invalida! \n");
			}

		} while (opcao != 5);
		entrada.close();
	}

	}

