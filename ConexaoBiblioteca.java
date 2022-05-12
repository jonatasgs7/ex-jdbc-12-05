package jg.br.ExConexaoBiblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBiblioteca {

	public static void main(String[] args) {
		
		Connection conexao;
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String urlBD = "jdbc:mysql://localhost:3306/bibliotecadb?user=root&password=";
		String queryBD = "SELECT * FROM livro";
		
		// Inserindo autor
		// String queryInsert = "INSERT INTO autor (nome, nacionalidade) VALUES ('Ernest Cline', 'Estados Unidos')";
		
		// Inserindo editora
		// String queryInsert = "INSERT INTO editora (nome) VALUES ('Intrínseca')";
		
		// Inserindo livroAutor
		// String queryInsert = "INSERT INTO livroAutor (fk_autor, fk_livro) VALUES (7, '8544103162')";
		
		// Inserindo Livro
		// String queryInsert = "INSERT INTO livro (isbn, titulo, ano, fk_editora, fk_autor, fk_categoria) VALUES ('8544103162', 'Jogador Número 1', 2011, 6, 7, 2)";
		
		// String queryUpdate = "UPDATE tabela SET column = 'novoValor' WHERE ID = X";
		// String queryDelete = "DELETE FROM tabela WHERE ID = X";
		
		Statement st;
		ResultSet resultado;
		
		try {
			Class.forName(driver);
			conexao = (Connection) DriverManager.getConnection(urlBD);
			System.out.println("Conectado");
			
			
			// SELECT no banco
			st = conexao.createStatement();
			resultado = st.executeQuery(queryBD);
			
			// Fazendo o SELECT da tabela livros e mostrando o livro inserido (Jogador Número 1)
			if (resultado != null) {
				while (resultado.next()) {
					System.out.println("isbn: " + resultado.getString("isbn") + "\t titulo: " + resultado.getString("titulo")
							+ "\t ano: " + resultado.getString("ano"));
				}
			}	
			
			// Para Inserir
			// st.execute(queryInsert);
			
			// Para Atualizar
			//st.execute(queryUpdate);
			
			// Para Remover
			//st.execute(queryDelete);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Class not found");
		}
		
	}
	
}
