package bethacode.clinimais.resource;

import bethacode.clinimais.model.*;

import java.time.LocalDateTime;

public class AgendamentoDTO {
    private String backgroundColor;
    private LocalDateTime end;
    private LocalDateTime start;

    private Paciente paciente;
    private Profissional profissional;
    private Procedimento procedimento;
    private String observacao;
    private SituacaoConsulta situacao;

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public SituacaoConsulta getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoConsulta situacao) {
        this.situacao = situacao;
    }

    public static AgendamentoDTO toDTO(Agendamento agendamento){
        AgendamentoDTO dto = new AgendamentoDTO();
        dto.setBackgroundColor(agendamento.getBackgroundColor());
        dto.setEnd(agendamento.getEnd());
        dto.setStart(agendamento.getStart());
        dto.setPaciente(agendamento.getPaciente());
        dto.setProfissional(agendamento.getProfissional());
        dto.setProcedimento(agendamento.getProcedimento());
        dto.setObservacao(agendamento.getObservacao());
        dto.setSituacao(agendamento.getSituacao());

        return dto;
    }

    public static Agendamento fromDTO(AgendamentoDTO dto){
        Agendamento entity = new Agendamento();
        entity.setBackgroundColor(dto.getBackgroundColor());
        entity.setEnd(dto.getEnd());
        entity.setStart(dto.getStart());
        entity.setPaciente(dto.getPaciente());
        entity.setProfissional(dto.getProfissional());
        entity.setProcedimento(dto.getProcedimento());
        entity.setObservacao(dto.getObservacao());
        entity.setSituacao(dto.getSituacao());

        return entity;
    }
}
