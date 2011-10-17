package se.linjekoll.persistency.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.linjekoll.persistency.entities.Role;
import se.linjekoll.persistency.entities.superclasses.TimeStampedEntity_;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-10-17T12:09:11")
@StaticMetamodel(User.class)
public class User_ extends TimeStampedEntity_ {

    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> passwordSalt;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, Role> role;
    public static volatile SingularAttribute<User, String> passwordHash;

}