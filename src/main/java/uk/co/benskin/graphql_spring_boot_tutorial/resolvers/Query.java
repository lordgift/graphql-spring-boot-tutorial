package uk.co.benskin.graphql_spring_boot_tutorial.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import uk.co.benskin.graphql_spring_boot_tutorial.entities.Homeless;
import uk.co.benskin.graphql_spring_boot_tutorial.entities.Pet;
import uk.co.benskin.graphql_spring_boot_tutorial.enums.Animal;

import java.util.ArrayList;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    public List<Pet> pets() {
        List<Pet> pets = new ArrayList<>();
        Pet aPet = new Pet();
        aPet.setId(1l);
        aPet.setName("Bill");
        aPet.setAge(9);
        aPet.setType(Animal.MAMMOTH);
        pets.add(aPet);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return pets;
    }

    public List<Homeless> homeless() {
        List<Homeless> homelesses = new ArrayList<>();
        Homeless homeless = new Homeless();
        homeless.setId(1l);
        homeless.setType(Animal.MAMMOTH);

        homelesses.add(homeless);
        return homelesses;
    }
}