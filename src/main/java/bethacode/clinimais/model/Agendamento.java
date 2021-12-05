package bethacode.clinimais.model;

import bethacode.clinimais.enterprise.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Agendamento extends AbstractEntity {
    private String backgroundColor;
    private String title;
    private String titulo;
    @Column(name = "DATA_FINAL")
    private LocalDateTime end;
    @Column(name = "DATA_INICIAL")
    private LocalDateTime start;
    @ManyToOne
    @JoinColumn(name = "ID_PACIENTE", referencedColumnName = "ID")
//    @NotNull
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "ID_PROFISSIONAL", referencedColumnName = "ID")
//    @NotNull
    private Profissional profissional;
    @ManyToOne
    @JoinColumn(name = "ID_PROCEDIMENTO", referencedColumnName = "ID")
//    @NotNull
    private Procedimento procedimento;
    @Column(name = "OBSERVACAO")
    @Size(max = 255)
    private String observacao;
    @Column(name = "SITUACAO")
//    @NotNull
    private SituacaoConsulta situacao;

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
}