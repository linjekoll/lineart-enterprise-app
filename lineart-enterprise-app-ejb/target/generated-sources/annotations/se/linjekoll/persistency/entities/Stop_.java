package se.linjekoll.persistency.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.linjekoll.persistency.entities.Line;
import se.linjekoll.persistency.entities.Provider;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-10-06T21:20:01")
@StaticMetamodel(Stop.class)
public class Stop_ { 

    public static volatile SingularAttribute<Stop, Integer> id;
    public static volatile SingularAttribute<Stop, Date> updatedAt;
    public static volatile SingularAttribute<Stop, String> sid;
    public static volatile SingularAttribute<Stop, String> coordinate;
    public static volatile SingularAttribute<Stop, Date> createdAt;
    public static volatile SingularAttribute<Stop, String> name;
    public static volatile SingularAttribute<Stop, Provider> provider;
    public static volatile ListAttribute<Stop, Line> lines;

}