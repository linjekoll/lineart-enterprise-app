package se.linjekoll.persistency.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.linjekoll.persistency.entities.Line;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-10-07T13:16:04")
@StaticMetamodel(VehicleType.class)
public class VehicleType_ { 

    public static volatile SingularAttribute<VehicleType, Integer> id;
    public static volatile SingularAttribute<VehicleType, Date> updatedAt;
    public static volatile SingularAttribute<VehicleType, Date> createdAt;
    public static volatile SingularAttribute<VehicleType, String> name;
    public static volatile ListAttribute<VehicleType, Line> lines;

}