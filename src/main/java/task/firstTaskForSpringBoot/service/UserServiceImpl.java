package task.firstTaskForSpringBoot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task.firstTaskForSpringBoot.dao.UserDAO;
import task.firstTaskForSpringBoot.model.User;


import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;



    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override

    public User save(User user) {
        return userDAO.save(user);
    }

    @Override

    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }
}