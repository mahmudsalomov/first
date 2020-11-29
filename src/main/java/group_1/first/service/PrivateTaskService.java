package group_1.first.service;


import group_1.first.model.PrivateTask;
import group_1.first.model.UserCourse;
import group_1.first.repository.PrivateTaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PrivateTaskService {

    @Autowired
    private PrivateTaskRepo privateTaskRepo;

    public PrivateTask save(PrivateTask privateTask){
        return privateTaskRepo.save(privateTask);
    }

    public List<PrivateTask> getAll(){
        return privateTaskRepo.findAllByOrderByIdAsc();
    }

    public PrivateTask getOne(Long id){
        return privateTaskRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(Integer.toString(Math.toIntExact(id))));
    }



}
