package bethacode.clinimais.resource;

import bethacode.clinimais.model.*;

import java.time.LocalDateTime;

public class AgendamentoDTO {

    private Long id;
    private String title;
    private String backgroundColor;
    private LocalDateTime end;
    private LocalDateTime start;
    private PacienteDTO paciente;
    private ProfissionalDTO profissional;
    private ProcedimentoDTO procedimento;
    private String observacao;
    private SituacaoConsulta situacao;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }

    public ProfissionalDTO getProfissional() {
        return profissional;
    }

    public void setProfissional(ProfissionalDTO profissional) {
        this.profissional = profissional;
    }

    public ProcedimentoDTO getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(ProcedimentoDTO procedimento) {
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
        dto.setTitle(agendamento.getPaciente().getNome());
        dto.setId(agendamento.getId());
        dto.setBackgroundColor(agendamento.getBackgroundColor());
        dto.setEnd(agendamento.getEnd());
        dto.setStart(agendamento.getStart());
        dto.setPaciente(PacienteDTO.toDTO(agendamento.getPaciente()));
        dto.setProfissional(ProfissionalDTO.toDTO(agendamento.getProfissional()));
        dto.setProcedimento(ProcedimentoDTO.toDTO(agendamento.getProcedimento()));
        dto.setObservacao(agendamento.getObservacao());
        dto.setSituacao(agendamento.getSituacao());

        return dto;
    }

    public static Agendamento fromDTO(AgendamentoDTO dto){
        Agendamento entity = new Agendamento();
        entity.setId(dto.getId());
        entity.setBackgroundColor(dto.getBackgroundColor());
        entity.setEnd(dto.getEnd());
        entity.setStart(dto.getStart());
        entity.setPaciente(PacienteDTO.fromDTO(dto.getPaciente()));
        entity.setProfissional(ProfissionalDTO.fromDTO(dto.getProfissional()));
        entity.setProcedimento(ProcedimentoDTO.fromDTO(dto.getProcedimento()));
        entity.setObservacao(dto.getObservacao());
        entity.setSituacao(dto.getSituacao());

        return entity;
    }
}
