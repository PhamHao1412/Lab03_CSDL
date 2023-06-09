package lab3.demo.repository;

import lab3.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
    @Query("SELECT r.id FROM Role r where r.name=?1")
    Long getRoleByName(String roleName);
}
