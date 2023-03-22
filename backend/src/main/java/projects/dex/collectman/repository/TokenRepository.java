package projects.dex.collectman.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projects.dex.collectman.repository.entity.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {

    // JPQL
    // @Query(value = """
    //         select t from Token t inner join UserBase u\s
    //         on t.user.id = u.id\s
    //         where u.id = :id and (t.expired = false or t.revoked = false)\s
    //         """)
    // List<Token> findAllValidTokenByUser(Long id);


    // native query
	@Query(value =  "\n select                        " +
                    "\n     t.*                       " +
                    "\n from                          " +
                    "\n     token t                   " + 
                    "\n inner join user_base u on     " +
                    "\n     t.user_id = u.id          " +
                    "\n where                         " +
                    "\n     u.id = :id                " +
                    "\n     and (t.expired = false    " +
                    "\n         or t.revoked = false) "
       , nativeQuery=true
     )
    List<Token> findAllValidTokenByUser(@Param("id") Long id);
  
    Optional<Token> findByToken(String token);
  }
  