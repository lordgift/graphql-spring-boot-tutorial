package uk.co.benskin.graphql_spring_boot_tutorial.repository;

import org.springframework.stereotype.Repository;
import uk.co.benskin.graphql_spring_boot_tutorial.repository.entity.MyUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersistenceRepository {

    @PersistenceContext
    EntityManager entityManager;

    public MyUser addMyUser(MyUser myUser) {
        entityManager.persist(myUser);
        return myUser;
    }

}
