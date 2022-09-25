package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.connection;
import model.Passagem;

public class PassagemDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Passagem passagem) {
		String sql = "INSERT INTO Passagem (empresa, embarque, desembarque, valor_passagem) values(?, ?, ?, ?)";

		try {
			// Cria uma conexão com o banco
			conn = connection.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql

			pstm.setString(1, passagem.getEmpresa());
			
			pstm.setString(2, passagem.getEmbarque());

			pstm.setString(3, passagem.getDesembarque());

			pstm.setDouble(4, passagem.getValor_passagem());

			
			// Executar a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// Metodo para Ler
	public List<Passagem> getPassagem() {
		String sql = "select * from Passagem;";

		List<Passagem> Passagem = new ArrayList<Passagem>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Passagem passagem = new Passagem();

				passagem.setId_passagem(rset.getInt("id_passagem"));

				passagem.setEmpresa(rset.getString("empresa"));
				
				passagem.setEmbarque(rset.getString("embarque"));
				
				passagem.setDesembarque(rset.getString("desembarque"));

				passagem.setValor_passagem(rset.getDouble("valor_passagem"));

				Passagem.add(passagem);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return Passagem;
	}
	// Metodo pra atualizar

	public void update(Passagem passagem) {
		String sql = "UPDATE Passagem set empresa = ?, embarque = ?, desembarque = ?, valor_passagem = ? where id_passagem = ?;";

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, passagem.getEmpresa());
			
			pstm.setString(2, passagem.getEmbarque());
			
			pstm.setString(3, passagem.getDesembarque());

			pstm.setDouble(4, passagem.getValor_passagem());

			pstm.setInt(5, passagem.getId_passagem());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Metodo para deletar
	public void deleteById(int id) {
		String sql = "DELETE FROM Passagem WHERE id_passagem = ?";

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Passagem getpassagemById(int id) {
		String sql = "SELECT * FROM Passagem WHERE id_passagem = ?;";

		Passagem passagem = new Passagem();

		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			passagem.setId_passagem(rset.getInt("id_passagem"));

			passagem.setEmpresa(rset.getString("empresa"));
			
			passagem.setEmbarque(rset.getString("embarque"));
			
			passagem.setDesembarque(rset.getString("desembarque"));

			passagem.setValor_passagem(rset.getDouble("valor_passagem"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return passagem;
	}

}