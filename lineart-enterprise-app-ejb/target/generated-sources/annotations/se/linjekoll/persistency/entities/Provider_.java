package se.linjekoll.persistency.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.linjekoll.persistency.entities.Line;
import se.linjekoll.persistency.entities.Stop;
import se.linjekoll.persistency.entities.superclasses.TimeStampedEntity_;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-10-17T15:53:19")
@StaticMetamodel(Provider.class)
public class Provider_ extends TimeStampedEntity_ {

    public static volatile SingularAttribute<Provider, Integer> id;
    public static volatile ListAttribute<Provider, Stop> stops;
    public static volatile SingularAttribute<Provider, String> name;
    public static volatile ListAttribute<Provider, Line> lines;

}