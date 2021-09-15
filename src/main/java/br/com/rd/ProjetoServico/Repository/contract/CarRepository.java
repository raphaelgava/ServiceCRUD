package br.com.rd.ProjetoServico.Repository.contract;

import br.com.rd.ProjetoServico.Model.Entity.Car;
import br.com.rd.ProjetoServico.Model.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
https://stackoverflow.com/questions/21104434/how-to-turn-off-query-creation-from-method-names-in-spring-jpa/50801663
How Spring handles this is called the Query Lookup Strategy. Queries can be resolved by method names (CREATE), by manual queries (USE_DECLARED_QUERY), or both (CREATE_IF_NOT_FOUND) which defaults to method names if no manual query is found. USE_DECLARED_QUERY would give you the desired functionality, warning you if no manual query is specified.

As Kevin answered, this can be configured in xml. But as a more modern option, you can specify the lookup strategy when configuring your repository in a Java Config class with queryLookupStrategy parameter in the @Enable{store}Repositories annotation.

For example, to force manual queries, you could use the following:

@EnableJpaRepositories(queryLookupStrategy=QueryLookupStrategy.Key.USE_DECLARED_QUERY)
public class MyDatabaseConfig {
    ...
}
 */

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByYear(Integer year);
}
