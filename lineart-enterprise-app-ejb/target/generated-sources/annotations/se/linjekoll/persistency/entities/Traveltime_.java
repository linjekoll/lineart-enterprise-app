package se.linjekoll.persistency.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.linjekoll.persistency.entities.Line;
import se.linjekoll.persistency.entities.Stop;
import se.linjekoll.persistency.entities.superclasses.TimeStampedEntity_;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-10-17T15:53:19")
@StaticMetamodel(Traveltime.class)
public class Traveltime_ extends TimeStampedEntity_ {

    public static volatile SingularAttribute<Traveltime, Integer> id;
    public static volatile SingularAttribute<Traveltime, Integer> position;
    public static volatile SingularAttribute<Traveltime, Integer> duration;
    public static volatile SingularAttribute<Traveltime, Stop> previous;
    public static volatile SingularAttribute<Traveltime, Stop> next;
    public static volatile SingularAttribute<Traveltime, Line> line;

}