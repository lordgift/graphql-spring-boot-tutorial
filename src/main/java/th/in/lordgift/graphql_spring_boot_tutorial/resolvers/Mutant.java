package th.in.lordgift.graphql_spring_boot_tutorial.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import th.in.lordgift.graphql_spring_boot_tutorial.repository.entity.MyUser;
import th.in.lordgift.graphql_spring_boot_tutorial.resolvers.schemas.User;
import th.in.lordgift.graphql_spring_boot_tutorial.service.ServiceManager;

import java.time.LocalDateTime;

@Component
public class Mutant implements GraphQLMutationResolver {

    @Autowired
    ServiceManager service;

    public Boolean createUser(User user) {
        MyUser myUser = new MyUser(user.getName(), user.getPosition(), LocalDateTime.now());
        service.addMyUser(myUser);

        return myUser.getId() != null;
    }
}
