package com.fluxafinance.api.usuario;

public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String enderecoUsuario;
    private String empresa;

    public UsuarioResponseDTO(String nome, String email, String telefone, String enderecoUsuario, String empresa) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.enderecoUsuario = enderecoUsuario;
        this.empresa = empresa;
    }

    /* getters */
    public Long getId() { return id; }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEnderecoUsuario() {
        return enderecoUsuario;
    }

    public String getEmpresa() {
        return empresa;
    }

    /* setters */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEnderecoUsuario(String enderecoUsuario) {
        this.enderecoUsuario = enderecoUsuario;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
