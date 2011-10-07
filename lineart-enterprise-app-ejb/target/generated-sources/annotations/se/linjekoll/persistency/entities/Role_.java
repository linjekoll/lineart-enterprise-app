package se.linjekoll.persistency.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.linjekoll.persistency.entities.User;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-10-06T21:20:01")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, Integer> id;
    public static volatile SingularAttribute<Role, Date> updatedAt;
    public static volatile ListAttribute<Role, User> users;
    public static volatile SingularAttribute<Role, Date> createdAt;
    public static volatile SingularAttribute<Role, String> name;

}