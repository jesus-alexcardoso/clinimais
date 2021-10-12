package bethacode.clinimais.model;

import bethacode.clinimais.enterprise.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PROCEDIMENTO")
public class Procedimento extends AbstractEntity {
    @Column(name = "DESCRICAO")
    @Size(max = 60, min = 3)
    @NotNull
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
