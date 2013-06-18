package br.edu.unidavi.bsi.leonardo.model;

import java.io.Serializable;

public class Cliente implements Serializable {
    
    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private boolean ativo = true;
    private String enderecoRua;
    private String enderecoNumero;
    private String enderecoBairro;
    private String enderecoCep;
    private String enderecoCidade;
    private String enderecoEstado;
    
    public Cliente(){
    }
    
    public Cliente(String nome, String email, String senha, String telefone, boolean ativo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.ativo = ativo;
    }
    
    public Cliente(String nome, String email, String senha, String telefone, boolean ativo,
            String enderecoRua, String enderecoNumero, String enderecoBairro, String enderecoCep,
            String enderecoCidade, String enderecoEstado ) {
        this(nome,email,senha,telefone,ativo);
        this.enderecoRua = enderecoRua;
        this.enderecoNumero = enderecoNumero;
        this.enderecoBairro = enderecoBairro;
        this.enderecoCep = enderecoCep;
        this.enderecoCidade = enderecoCidade;
        this.enderecoEstado = enderecoEstado;
    }
    
    public Cliente(Integer id, String nome, String email, String senha, String telefone, boolean ativo,
            String enderecoRua, String enderecoNumero, String enderecoBairro, String enderecoCep,
            String enderecoCidade, String enderecoEstado ) {
        this(nome,email,senha,telefone,ativo,enderecoRua,enderecoNumero,enderecoBairro,enderecoCep,
                enderecoCidade,enderecoEstado);
        this.id = id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public boolean isAtivo() {
        return ativo;
    }
    
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public String getEnderecoBairro() {
        return enderecoBairro;
    }
    
    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }
    
    public String getEnderecoCep() {
        return enderecoCep;
    }
    
    public void setEnderecoCep(String enderecoCep) {
        this.enderecoCep = enderecoCep;
    }
    
    public String getEnderecoCidade() {
        return enderecoCidade;
    }
    
    public void setEnderecoCidade(String enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }
    
    public String getEnderecoEstado() {
        return enderecoEstado;
    }
    
    public void setEnderecoEstado(String enderecoEstado) {
        this.enderecoEstado = enderecoEstado;
    }
    
    public String getEnderecoNumero() {
        return enderecoNumero;
    }
    
    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }
    
    public String getEnderecoRua() {
        return enderecoRua;
    }
    
    public void setEnderecoRua(String enderecoRua) {
        this.enderecoRua = enderecoRua;
    }
    
    public String toString() {
        return getNome() + " - " + getId();
    }
    
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        boolean result = false;
        if (o instanceof Cliente) {
            Cliente outro = (Cliente) o;
            result = this.getEmail() != null &&
                    this.getEmail().equals(outro.getEmail());
        }
        return result;
    }
    
    public int hashCode() {
        int result = getEmail() != null ? getEmail().hashCode() : 41;
        return result;
    }
    
}