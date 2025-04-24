
package kaioestudos;

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
    
}
