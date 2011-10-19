package se.linjekoll.persistency.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.linjekoll.persistency.entities.Provider;
import se.linjekoll.persistency.entities.Stop;
import se.linjekoll.persistency.entities.VehicleType;
import se.linjekoll.persistency.entities.superclasses.TimeStampedEntity_;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-10-19T16:53:37")
@StaticMetamodel(Line.class)
public class Line_ extends TimeStampedEntity_ {

    public static volatile SingularAttribute<Line, Integer> id;
    public static volatile SingularAttribute<Line, String> lid;
    public static volatile ListAttribute<Line, Stop> stops;
    public static volatile SingularAttribute<Line, String> backgroundColor;
    public static volatile SingularAttribute<Line, String> name;
    public static volatile SingularAttribute<Line, VehicleType> vehicleType;
    public static volatile SingularAttribute<Line, Provider> provider;
    public static volatile SingularAttribute<Line, String> foregroundColor;

}