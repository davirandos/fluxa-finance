package com.fluxafinance.api.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Setter;

public class UsuarioRequestDTO {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min=6)
    private String senha;

    @NotBlank
    private String telefone;

    @NotBlank
    private String enderecoUsuario;

    @NotBlank
    private String empresa;

    public UsuarioRequestDTO(String nome, String email, String senha, String telefone, String enderecoUsuario, String empresa) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.enderecoUsuario = enderecoUsuario;
        this.empresa = empresa;
    }

    /* getters */
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
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

    public void setSenha(String senha) {
        this.senha = senha;
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
