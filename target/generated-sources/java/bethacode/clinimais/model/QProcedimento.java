package bethacode.clinimais.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProcedimento is a Querydsl query type for Procedimento
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProcedimento extends EntityPathBase<Procedimento> {

    private static final long serialVersionUID = -487150898L;

    public static final QProcedimento procedimento = new QProcedimento("procedimento");

    public final bethacode.clinimais.enterprise.QAbstractEntity _super = new bethacode.clinimais.enterprise.QAbstractEntity(this);

    public final StringPath descricao = createString("descricao");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public QProcedimento(String variable) {
        super(Procedimento.class, forVariable(variable));
    }

    public QProcedimento(Path<? extends Procedimento> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProcedimento(PathMetadata metadata) {
        super(Procedimento.class, metadata);
    }

}

