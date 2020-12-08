package group_1.first.service;

import group_1.first.dto.TaskSpecDto;
import group_1.first.model.PrivateTask;
import group_1.first.model.UserCourse;
import group_1.first.repository.PrivateTaskRepo;
import group_1.first.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private PrivateTaskRepo privateTaskRepo;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserCourse save(UserCourse userCourse){
        return userRepository.save(userCourse);
    }

    public UserCourse getOne(Long id){
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Integer.toString(Math.toIntExact(id))));
    }

    public List<UserCourse> getAll(){
        return userRepository.findAll();
    }

    public List<UserCourse> getAllSort(){
        return userRepository.findAllByOrderByIdAsc();
    }


    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public List<PrivateTask> findAllTaskByUsername(String username){
        return privateTaskRepo.findAllByUsername(username);
    }

    public List<TaskSpecDto> getAllTaskSpecial(String username){
        List<PrivateTask> list=privateTaskRepo.findAllByUsername(username);
        List<TaskSpecDto> taskSpecDtoList=new ArrayList<>();
        for (PrivateTask privateTask : list) {
            TaskSpecDto taskSpecDto = new TaskSpecDto();
            taskSpecDto.setId(privateTask.getId());
            taskSpecDto.setQuestion(privateTask.getQuestion());
            taskSpecDto.setAttempt(privateTask.getAttempt());
            taskSpecDto.setLastCode(privateTask.getLastCode());
            taskSpecDto.setSolve(privateTask.isSolve());
            taskSpecDto.setTitle(privateTask.getTitle());
            taskSpecDtoList.add(taskSpecDto);
        }
        return taskSpecDtoList;
    }


}
