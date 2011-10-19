package se.linjekoll.persistency.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.linjekoll.persistency.entities.User;
import se.linjekoll.persistency.entities.superclasses.TimeStampedEntity_;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-10-19T16:53:37")
@StaticMetamodel(Role.class)
public class Role_ extends TimeStampedEntity_ {

    public static volatile SingularAttribute<Role, Integer> id;
    public static volatile ListAttribute<Role, User> users;
    public static volatile SingularAttribute<Role, String> name;

}