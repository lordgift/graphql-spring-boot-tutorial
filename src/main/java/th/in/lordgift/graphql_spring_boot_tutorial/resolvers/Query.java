package th.in.lordgift.graphql_spring_boot_tutorial.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import th.in.lordgift.graphql_spring_boot_tutorial.resolvers.schemas.Animal;
import th.in.lordgift.graphql_spring_boot_tutorial.resolvers.schemas.Homeless;
import th.in.lordgift.graphql_spring_boot_tutorial.resolvers.schemas.Pet;
import th.in.lordgift.graphql_spring_boot_tutorial.resolvers.schemas.User;
import th.in.lordgift.graphql_spring_boot_tutorial.service.ServiceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    ServiceManager service;

    /**
     * hardcode return with get value from SecurityContext
     */
    public List<Pet> pets() {
        List<Pet> pets = new ArrayList<>();
        Pet aPet = new Pet();
        aPet.setId(1l);
        aPet.setName("Bill");
        aPet.setAge(9);
        aPet.setType(Animal.MAMMOTH);
        pets.add(aPet);

        // get value from SecurityContext (TokenAuthenticationFilter.java)
        // try to debug here !
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return pets;
    }

    /**
     * hardcode return
     */
    public List<Homeless> homeless() {
        List<Homeless> homelesses = new ArrayList<>();
        Homeless homeless = new Homeless();
        homeless.setId(1l);
        homeless.setType(Animal.MAMMOTH);

        homelesses.add(homeless);
        return homelesses;
    }

    /**
     * query from MySQL
     */
    public List<User> users() {
        return service.queryMyUser().stream()
                .map(elm -> new User(elm.getName(), elm.getPosition()))
                .collect(Collectors.toList());
    }
}