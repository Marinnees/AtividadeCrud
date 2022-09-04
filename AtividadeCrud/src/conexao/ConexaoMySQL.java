package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoMySQL {

	private static final String USERNAME = "root";

	private static final String PASSWORD = "senha";

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/atividadecrud";

	public static Connection createConnectionToMySQL() throws Exception {

		// Faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Cria a conexão com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;
	}

	public static void main(String[] args) throws Exception {
		// Recupera uma conexão com o banco de dados
		Connection con = createConnectionToMySQL();

		// testar a conexão
		if (con != null) {
			System.out.println(con + "\n Conectado \n");
			con.close();
		}
	}

}