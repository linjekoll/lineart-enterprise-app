package se.linjekoll.persistency.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.linjekoll.persistency.entities.Line;
import se.linjekoll.persistency.entities.Stop;
import se.linjekoll.persistency.entities.superclasses.TimeStampedEntity_;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-10-19T13:28:31")
@StaticMetamodel(TravelTime.class)
public class TravelTime_ extends TimeStampedEntity_ {

    public static volatile SingularAttribute<TravelTime, Integer> id;
    public static volatile SingularAttribute<TravelTime, Integer> position;
    public static volatile SingularAttribute<TravelTime, Integer> duration;
    public static volatile SingularAttribute<TravelTime, Stop> previous;
    public static volatile SingularAttribute<TravelTime, Stop> next;
    public static volatile SingularAttribute<TravelTime, Line> line;

}