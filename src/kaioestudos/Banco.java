
package kaioestudos;

import model.bean.Pessoa;

public class Banco extends Pessoa {
    //Atributos
    private String tipo;
    
    //Metodos
    
    public void sacar(int s){
        if (s < this.saldo) {
            setSaldo(getSaldo() - s);
        } else {
            System.out.println("Saldo insulficiente");
        }    
    }
    
    public void depositar(int d){
        setSaldo(getSaldo() + d);
    }
    
    public void emprestimo(){
        setSaldo(getSaldo() + 15000);
    }
    
    public void pagarEmprestimo(){
        setSaldo(getSaldo() - 1200);
    }
    
    //Metodos Especiais
    public Banco() {
        if (getTipo().equals("CC")){
          saldo = 50;  
        } else if (getTipo().equals("CP")){
            saldo = 150;
        }
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    
    
    
}
