
package kaioestudos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Verificador {
    //Metodos
    
    public  boolean verificarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return false; // Nome não pode ser nulo ou vazio
        }

        // Verifica se contém apenas letras (com acentos) e espaços
        if (!nome.matches("^[\\p{L} ]+$")) {
            return false;
        }

        // Tamanho mínimo e máximo (opcional)
        if (nome.length() < 2 || nome.length() > 50) {
            return false;
        }

        return true;
    }
    
    public boolean verificarSenha(String senha) {
        if (senha == null || senha.length() < 8) {
            return false; // Deve ter pelo menos 8 caracteres
        }

        boolean temMaiuscula = senha.matches(".*[A-Z].*");
        boolean temMinuscula = senha.matches(".*[a-z].*");
        boolean temNumero = senha.matches(".*[0-9].*");
        boolean temEspecial = senha.matches(".*[!@#$%^&*()_+=\\-{}\\[\\]:;\"'<>,.?/\\\\|].*");

        return temMaiuscula && temMinuscula && temNumero && temEspecial;
    }
    public boolean verificarTipo(String c){
        if (c == null){
            return false;
        }
        switch (c) {
            case "CC":
                return true;
            case "CP":
                return true;
            default:
                return false;
        }
        
        
        
    }
    public boolean validarLogin(String nome, String senha) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM pessoa WHERE nome = ? AND senha = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Nome ou senha Invalido");
            return false;
        }
    }
    
    public boolean validSenha(String senha){
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM pessoa WHERE senha = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, senha);
            
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Nome ou senha Invalido");
            return false;
        }
    }

    
}
