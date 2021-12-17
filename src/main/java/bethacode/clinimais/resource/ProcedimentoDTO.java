package bethacode.clinimais.resource;

import bethacode.clinimais.model.Procedimento;

public class ProcedimentoDTO {

    private String id;
    private String descricao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static ProcedimentoDTO toDTO(Procedimento procedimento){
        ProcedimentoDTO dto = new ProcedimentoDTO();
        dto.setId(procedimento.getId().toString());
        dto.setDescricao(procedimento.getDescricao());

        return dto;
    }

    public static Procedimento fromDTO(ProcedimentoDTO dto){
        Procedimento entity = new Procedimento();
        entity.setId(Long.getLong(dto.getId()));
        entity.setDescricao(dto.getDescricao());

        return entity;
    }
}
