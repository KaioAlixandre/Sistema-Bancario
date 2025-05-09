
package kaioestudos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection conectar() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/banco"; // Nome do banco
            String user = "root"; // Seu usuário do MySQL
            String password = ""; // Sua senha (em branco, se padrão)

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }

        return conn;
    }
}

