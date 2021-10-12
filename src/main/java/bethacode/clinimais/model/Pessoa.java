package bethacode.clinimais.model;

import bethacode.clinimais.enterprise.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Pessoa extends AbstractEntity {
    @Column(name = "NOME")
    @Size(max = 60, min = 3)
    @NotNull
    private String nome;
    @Column(name = "TELEFONE")
    @Size(max = 11)
    private String telefone;
    @Column(name = "COMPLEMENTO")
    @Size(max = 255)
    private String compelemento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCompelemento() {
        return compelemento;
    }

    public void setCompelemento(String compelemento) {
        this.compelemento = compelemento;
    }
}
