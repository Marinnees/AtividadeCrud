package crud;

import java.util.Scanner;

import dao.UsuarioDao;
import modelo.Login;
import modelo.Permissao;
import modelo.Usuario;

public class UsuarioCrud {

	public static void main(String[] args) {

		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = new Usuario();
		Login autenticar = new Login();

		String nome = "";
		String email = "";
		String senha = "";
		String endereco = "";
		int id = 0;
		int opcao = 0;
		Scanner entrada = new Scanner(System.in);

		do {
		
			System.out.println("Seja bem vindo ao cadastro de Usuário, selecione a opção desejada \n");
			System.out.println("1 - Cadastrar um Usuario");
			System.out.println("2 - Atualizar um Usuario");
			System.out.println("3 - Deletar um Usuario");
			System.out.println("4 - Mostrar os Usuarios");
			System.out.println("5 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1:
				// Salvar usuario
				Permissao admUser = new Permissao(1, "Administrador");
				Permissao commUser = new Permissao(2, "Usuario Comum");

				System.out.println("Digite seu nome \n");
				nome = entrada.next();
				
				System.out.println("Digite seu email \n");
				email = entrada.next();
				
				System.out.println("Digite sua senha \n");
				entrada.nextLine();
				senha = entrada.nextLine();
				
				System.out.println("Digite seu Endereço \n");
				endereco = entrada.nextLine();

				Usuario cadastroUsuario = new Usuario(nome, email, senha, endereco, commUser);

				usuarioDao.saveUser(cadastroUsuario);

				System.out.println("Usuario cadastrado com sucesso! \n");

				break;
			case 2:
				// Atualizar usuario
				// Atualizar usuario
				System.out.println("Digite seu email cadastrado \n");
				email = entrada.next();
				
				System.out.println("Digite sua senha cadastrada \n");
				senha = entrada.next();

				autenticar = usuarioDao.validarUsuario(senha, email);

				if (senha.equals(autenticar.getSenha()) && email.equals(autenticar.getEmail())) {
					System.out.println("Digite um novo nome \n");
					entrada.nextLine();
					nome = entrada.nextLine();
					System.out.println("Digite seu novo endereço \n");
					endereco = entrada.nextLine();

					usuario.setNome(nome);
					usuario.setEndereco(endereco);
					usuario.setEmail(email);
					usuario.setSenha(senha);
					usuarioDao.updateUser(usuario);
				} else {
					System.out.println("ERRO: Usuario ou Senha não cadastrado \n");
				}

				break;
			case 3:
				// Deletar usuario
				System.out.println("Digite número do ID do usuário para deletar");
				id = entrada.nextInt();
				usuarioDao.deleteUser(id);
				break;
			case 4:
				//Mostrar usuarios
				for(Usuario user : usuarioDao.readUser()) {
					System.out.println("Id: " + user.getId_usuario() + "\n Nome: " + user.getNome() 
					+ "\n Endereco: " + user.getEndereco()
					+ "\n ------------------------------------------------------------------------");
				}

				break;
			case 5:
				System.out.println("Obrigado por usar nossos serviços, fim.");

				break;

			default:
				System.out.println(opcao + " - Opcao invalida! \n");
			}

		} while (opcao != 5);
		entrada.close();
	}
}
