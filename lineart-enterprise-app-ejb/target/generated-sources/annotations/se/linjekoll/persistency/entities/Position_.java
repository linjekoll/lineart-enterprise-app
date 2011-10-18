package se.linjekoll.persistency.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.linjekoll.persistency.entities.Line;
import se.linjekoll.persistency.entities.Stop;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-10-17T19:03:47")
@StaticMetamodel(Position.class)
public class Position_ { 

    public static volatile SingularAttribute<Position, Integer> id;
    public static volatile SingularAttribute<Position, Integer> position;
    public static volatile SingularAttribute<Position, Stop> stop;
    public static volatile SingularAttribute<Position, Line> line;

}