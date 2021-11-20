package bethacode.clinimais.resource;

import bethacode.clinimais.model.Paciente;
import bethacode.clinimais.model.Profissional;
import bethacode.clinimais.model.TipoProfissional;

public class ProfissionalDTO {
    private Long id;
    private String nome;
    private TipoProfissional tipoProfissional;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoProfissional getTipoProfissional() {
        return tipoProfissional;
    }

    public void setTipoProfissional(TipoProfissional tipoProfissional) {
        this.tipoProfissional = tipoProfissional;
    }

    public static ProfissionalDTO toDTO(Profissional profissional){
        ProfissionalDTO dto = new ProfissionalDTO();
        dto.setId(profissional.getId());
        dto.setNome(profissional.getNome());
        dto.setTipoProfissional(profissional.getTipoProfissional());

        return dto;
    }

    public static Profissional fromDTO(ProfissionalDTO dto){
        Profissional entity = new Profissional();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setTipoProfissional(dto.getTipoProfissional());

        return entity;
    }
}
