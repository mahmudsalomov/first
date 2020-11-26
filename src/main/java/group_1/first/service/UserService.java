package group_1.first.service;

import group_1.first.model.UserCourse;
import group_1.first.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;


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


}
