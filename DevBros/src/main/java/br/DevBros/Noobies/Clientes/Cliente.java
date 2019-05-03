package br.DevBros.Noobies.Clientes;
import java.sql.Date;

public class Cliente {

    private String nome;
    private String email;
    private long telefone;
    private long cpf;

    public Cliente(long cpf) {
        this.cpf = cpf;
    }

    public Cliente(String nome, String email, long telefone, long cpf) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }
    public Cliente(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
}
