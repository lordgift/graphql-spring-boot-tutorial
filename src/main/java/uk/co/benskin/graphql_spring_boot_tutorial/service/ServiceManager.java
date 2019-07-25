package uk.co.benskin.graphql_spring_boot_tutorial.service;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import uk.co.benskin.graphql_spring_boot_tutorial.repository.MyUserPaging;
import uk.co.benskin.graphql_spring_boot_tutorial.repository.PersistenceRepository;
import uk.co.benskin.graphql_spring_boot_tutorial.repository.QueryRepository;
import uk.co.benskin.graphql_spring_boot_tutorial.repository.entity.MyUser;

import java.util.List;

@Service
public class ServiceManager {

    @Autowired
    QueryRepository queryRepository;

    @Autowired
    PersistenceRepository persistenceRepository;

    @Autowired
    MyUserPaging myUserPaging;

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<MyUser> queryNativeMyUser() {
        return queryRepository.queryNativeMyUser();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<MyUser> queryMyUser() {
        return queryRepository.queryMyUser();
    }

    @Transactional(rollbackFor = ConstraintViolationException.class)
    public MyUser addMyUser(MyUser myUser) throws ConstraintViolationException {
        return persistenceRepository.addMyUser(myUser);
    }

    public Page<MyUser> queryMyUser(Pageable pageable) {
        return myUserPaging.findAll(pageable);
    }
}