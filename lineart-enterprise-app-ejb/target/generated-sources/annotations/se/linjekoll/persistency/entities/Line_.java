package se.linjekoll.persistency.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.linjekoll.persistency.entities.Provider;
import se.linjekoll.persistency.entities.Stop;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-10-06T14:15:14")
@StaticMetamodel(Line.class)
public class Line_ { 

    public static volatile SingularAttribute<Line, Integer> id;
    public static volatile SingularAttribute<Line, Date> updatedAt;
    public static volatile SingularAttribute<Line, String> lid;
    public static volatile ListAttribute<Line, Stop> stops;
    public static volatile SingularAttribute<Line, Date> createdAt;
    public static volatile SingularAttribute<Line, Provider> provider;

}