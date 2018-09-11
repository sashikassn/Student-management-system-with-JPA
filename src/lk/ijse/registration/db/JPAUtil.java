package lk.ijse.registration.db;

import javax.persistence.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class JPAUtil {

private static JPAUtil jpaUtil;
private EntityManagerFactory entityManagerFactory;




private JPAUtil(){
    Properties jpaproperties = new Properties();



    try{
        File jpaPropFile = new File("application.properties");
        FileReader propertyReader = new FileReader(jpaPropFile);
        jpaproperties.load(propertyReader);
    }catch (FileNotFoundException e){
        e.printStackTrace();
    }catch (IOException e){
        e.printStackTrace();
    }


    entityManagerFactory = Persistence.createEntityManagerFactory("appBoot",jpaproperties);

}
    public static JPAUtil getInstance(){
    if (jpaUtil == null){
        jpaUtil = new JPAUtil();

    }

    return jpaUtil;

    }
public EntityManagerFactory getEntityManagerFactory(){
    return entityManagerFactory;

}
}


