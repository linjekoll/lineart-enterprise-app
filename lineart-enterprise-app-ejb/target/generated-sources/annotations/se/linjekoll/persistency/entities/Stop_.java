package se.linjekoll.persistency.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.linjekoll.persistency.entities.Line;
import se.linjekoll.persistency.entities.superclasses.TimeStampedEntity_;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-10-17T17:04:47")
@StaticMetamodel(Stop.class)
public class Stop_ extends TimeStampedEntity_ {

    public static volatile SingularAttribute<Stop, Integer> id;
    public static volatile SingularAttribute<Stop, String> sid;
    public static volatile SingularAttribute<Stop, String> coordinate;
    public static volatile SingularAttribute<Stop, String> name;
    public static volatile MapAttribute<Stop, Line, Integer> lines;

}