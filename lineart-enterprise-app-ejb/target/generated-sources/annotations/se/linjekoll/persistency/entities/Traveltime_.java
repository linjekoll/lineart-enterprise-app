package se.linjekoll.persistency.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.linjekoll.persistency.entities.Line;
import se.linjekoll.persistency.entities.Stop;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-10-07T13:16:04")
@StaticMetamodel(Traveltime.class)
public class Traveltime_ { 

    public static volatile SingularAttribute<Traveltime, Integer> id;
    public static volatile SingularAttribute<Traveltime, Date> updatedAt;
    public static volatile SingularAttribute<Traveltime, Integer> time;
    public static volatile SingularAttribute<Traveltime, Date> createdAt;
    public static volatile SingularAttribute<Traveltime, Stop> origin;
    public static volatile SingularAttribute<Traveltime, Line> line;
    public static volatile SingularAttribute<Traveltime, Stop> destination;

}