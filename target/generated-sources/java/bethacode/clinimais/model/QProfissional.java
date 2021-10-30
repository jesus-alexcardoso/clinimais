package bethacode.clinimais.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProfissional is a Querydsl query type for Profissional
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProfissional extends EntityPathBase<Profissional> {

    private static final long serialVersionUID = 1772275124L;

    public static final QProfissional profissional = new QProfissional("profissional");

    public final QPessoa _super = new QPessoa(this);

    //inherited
    public final StringPath compelemento = _super.compelemento;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath nome = _super.nome;

    //inherited
    public final StringPath telefone = _super.telefone;

    public final EnumPath<TipoProfissional> tipoProfissional = createEnum("tipoProfissional", TipoProfissional.class);

    public QProfissional(String variable) {
        super(Profissional.class, forVariable(variable));
    }

    public QProfissional(Path<? extends Profissional> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProfissional(PathMetadata metadata) {
        super(Profissional.class, metadata);
    }

}

