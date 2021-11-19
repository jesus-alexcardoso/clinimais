package bethacode.clinimais.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Paciente extends Pessoa{
    @Column(name = "DATA_CADASTRO")
    //@NotNull
    private LocalDate dataCadastro;
    @Column(name = "DATA_NASC")
    //@NotNull
    private LocalDate dataNascimento;
    @Column(name = "EMAIL")
    @Size(max = 60)
    private String email;
    @Column(name = "ENDERECO")
    @Size(max = 60)
    private String endereco;
    @Column(name = "CPF")
    @Size(max = 11)
    private String cpf;

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
