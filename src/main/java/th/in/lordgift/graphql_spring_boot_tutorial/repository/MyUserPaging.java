package th.in.lordgift.graphql_spring_boot_tutorial.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import th.in.lordgift.graphql_spring_boot_tutorial.repository.entity.MyUser;

@Repository
public interface MyUserPaging extends PagingAndSortingRepository<MyUser, Long> {

}
