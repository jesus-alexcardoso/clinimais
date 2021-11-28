package bethacode.clinimais.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAgendamento is a Querydsl query type for Agendamento
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAgendamento extends EntityPathBase<Agendamento> {

    private static final long serialVersionUID = -1542625260L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAgendamento agendamento = new QAgendamento("agendamento");

    public final bethacode.clinimais.enterprise.QAbstractEntity _super = new bethacode.clinimais.enterprise.QAbstractEntity(this);

    public final StringPath backgroundColor = createString("backgroundColor");

    public final DateTimePath<java.time.LocalDateTime> end = createDateTime("end", java.time.LocalDateTime.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath observacao = createString("observacao");

    public final QPaciente paciente;

    public final QProcedimento procedimento;

    public final QProfissional profissional;

    public final EnumPath<SituacaoConsulta> situacao = createEnum("situacao", SituacaoConsulta.class);

    public final DateTimePath<java.time.LocalDateTime> start = createDateTime("start", java.time.LocalDateTime.class);

    public final StringPath title = createString("title");

    public final StringPath titulo = createString("titulo");

    public QAgendamento(String variable) {
        this(Agendamento.class, forVariable(variable), INITS);
    }

    public QAgendamento(Path<? extends Agendamento> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAgendamento(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAgendamento(PathMetadata metadata, PathInits inits) {
        this(Agendamento.class, metadata, inits);
    }

    public QAgendamento(Class<? extends Agendamento> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.paciente = inits.isInitialized("paciente") ? new QPaciente(forProperty("paciente")) : null;
        this.procedimento = inits.isInitialized("procedimento") ? new QProcedimento(forProperty("procedimento")) : null;
        this.profissional = inits.isInitialized("profissional") ? new QProfissional(forProperty("profissional")) : null;
    }

}

