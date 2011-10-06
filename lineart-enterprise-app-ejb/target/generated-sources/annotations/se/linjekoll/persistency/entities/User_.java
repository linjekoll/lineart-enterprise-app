package se.linjekoll.persistency.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.linjekoll.persistency.entities.Role;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-10-06T14:15:14")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, Date> updatedAt;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> passwordSalt;
    public static volatile SingularAttribute<User, Date> createdAt;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, Role> role;
    public static volatile SingularAttribute<User, String> passwordHash;

}