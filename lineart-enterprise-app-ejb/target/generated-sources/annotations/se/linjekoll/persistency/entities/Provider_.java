package se.linjekoll.persistency.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.linjekoll.persistency.entities.Line;
import se.linjekoll.persistency.entities.Stop;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-10-06T14:15:14")
@StaticMetamodel(Provider.class)
public class Provider_ { 

    public static volatile SingularAttribute<Provider, Integer> id;
    public static volatile SingularAttribute<Provider, Date> updatedAt;
    public static volatile ListAttribute<Provider, Stop> stops;
    public static volatile SingularAttribute<Provider, Date> createdAt;
    public static volatile SingularAttribute<Provider, String> name;
    public static volatile ListAttribute<Provider, Line> lines;

}