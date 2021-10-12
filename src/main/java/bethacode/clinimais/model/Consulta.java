package bethacode.clinimais.model;

import bethacode.clinimais.enterprise.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table (name = "CONSULTA")
public class Consulta extends AbstractEntity {
  @ManyToOne
  @JoinColumn(name = "ID_PACIENTE", referencedColumnName = "ID")
  @NotNull
  private Paciente paciente;
  @ManyToOne
  @JoinColumn(name = "ID_PROFISSIONAL", referencedColumnName = "ID")
  @NotNull
  private Profissional profissional;
  @ManyToOne
  @JoinColumn(name = "ID_PROCEDIMENTO", referencedColumnName = "ID")
  @NotNull
  private Procedimento procedimento;
  @Column(name = "DATA_HORA_CONSULTA")
  @NotNull
  private LocalDate dataHoraConsulta;
  @Column(name = "OBSERVACAO")
  @Size(max = 255)
  private String observacao;
  @Column(name = "SITUACAO")
  @NotNull
  private SituacaoConsulta situacao;

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

  public LocalDate getDataHoraConsulta() {
    return dataHoraConsulta;
  }

  public void setDataHoraConsulta(LocalDate dataHoraConsulta) {
    this.dataHoraConsulta = dataHoraConsulta;
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
