package bethacode.clinimais.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QConsulta is a Querydsl query type for Consulta
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConsulta extends EntityPathBase<Consulta> {

    private static final long serialVersionUID = -1496013178L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QConsulta consulta = new QConsulta("consulta");

    public final bethacode.clinimais.enterprise.QAbstractEntity _super = new bethacode.clinimais.enterprise.QAbstractEntity(this);

    public final DatePath<java.time.LocalDate> dataHoraConsulta = createDate("dataHoraConsulta", java.time.LocalDate.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath observacao = createString("observacao");

    public final QPaciente paciente;

    public final QProcedimento procedimento;

    public final QProfissional profissional;

    public final EnumPath<SituacaoConsulta> situacao = createEnum("situacao", SituacaoConsulta.class);

    public QConsulta(String variable) {
        this(Consulta.class, forVariable(variable), INITS);
    }

    public QConsulta(Path<? extends Consulta> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QConsulta(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QConsulta(PathMetadata metadata, PathInits inits) {
        this(Consulta.class, metadata, inits);
    }

    public QConsulta(Class<? extends Consulta> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.paciente = inits.isInitialized("paciente") ? new QPaciente(forProperty("paciente")) : null;
        this.procedimento = inits.isInitialized("procedimento") ? new QProcedimento(forProperty("procedimento")) : null;
        this.profissional = inits.isInitialized("profissional") ? new QProfissional(forProperty("profissional")) : null;
    }

}

