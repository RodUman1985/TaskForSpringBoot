package task.firstTaskForSpringBoot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task.firstTaskForSpringBoot.model.User;
import task.firstTaskForSpringBoot.repository.UserRepository;


import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;



    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override

    public User save(User user) {
        return userRepository.save(user);
    }

    @Override

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}