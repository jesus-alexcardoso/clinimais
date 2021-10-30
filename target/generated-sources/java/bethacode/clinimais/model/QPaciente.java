package bethacode.clinimais.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPaciente is a Querydsl query type for Paciente
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPaciente extends EntityPathBase<Paciente> {

    private static final long serialVersionUID = -179095550L;

    public static final QPaciente paciente = new QPaciente("paciente");

    public final QPessoa _super = new QPessoa(this);

    //inherited
    public final StringPath compelemento = _super.compelemento;

    public final StringPath cpf = createString("cpf");

    public final DatePath<java.time.LocalDate> dataCadastro = createDate("dataCadastro", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> dataNascimento = createDate("dataNascimento", java.time.LocalDate.class);

    public final StringPath email = createString("email");

    public final StringPath endereco = createString("endereco");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath nome = _super.nome;

    //inherited
    public final StringPath telefone = _super.telefone;

    public QPaciente(String variable) {
        super(Paciente.class, forVariable(variable));
    }

    public QPaciente(Path<? extends Paciente> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPaciente(PathMetadata metadata) {
        super(Paciente.class, metadata);
    }

}

