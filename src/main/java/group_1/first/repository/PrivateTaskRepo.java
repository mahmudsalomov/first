package group_1.first.repository;

import group_1.first.model.PrivateTask;
import group_1.first.model.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivateTaskRepo extends JpaRepository<PrivateTask,Long> {

    List<PrivateTask> findAllByOrderByIdAsc();
}
