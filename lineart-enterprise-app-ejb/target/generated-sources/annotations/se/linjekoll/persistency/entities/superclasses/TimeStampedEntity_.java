package se.linjekoll.persistency.entities.superclasses;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-10-19T13:28:31")
@StaticMetamodel(TimeStampedEntity.class)
public class TimeStampedEntity_ { 

    public static volatile SingularAttribute<TimeStampedEntity, Date> updatedAt;
    public static volatile SingularAttribute<TimeStampedEntity, Date> createdAt;

}