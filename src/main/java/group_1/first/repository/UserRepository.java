package group_1.first.repository;

import group_1.first.model.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserCourse,Long> {

    UserCourse findByUsername(String username);
    boolean existsByUsername(String username);

    List<UserCourse> findAllByOrderByIdAsc();
}
