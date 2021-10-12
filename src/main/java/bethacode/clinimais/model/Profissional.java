package bethacode.clinimais.model;

import javax.persistence.*;

@Entity
@Table(name = "PROFISSIONAL")
public class Profissional extends Pessoa{
    @Column(name = "TIPO_PROFISSIONAL")
    private TipoProfissional tipoProfissional;

    public TipoProfissional getTipoProfissional() {
        return tipoProfissional;
    }

    public void setTipoProfissional(TipoProfissional tipoProfissional) {
        this.tipoProfissional = tipoProfissional;
    }
}
