package iuh.fit.se.ltwww_java_18092025_tuan5_nguyentranlong.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

public class JpaUtil {
    @Getter
    private static EntityManagerFactory emf;

    public static void init(){
        if(emf ==null){
            emf= Persistence.createEntityManagerFactory("default");
        }
    }

    public static void destroy(){
        if(emf.isOpen()){
            emf.close();
        }
    }

}
