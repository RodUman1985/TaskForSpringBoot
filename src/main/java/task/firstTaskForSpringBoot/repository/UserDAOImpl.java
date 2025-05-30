package task.firstTaskForSpringBoot.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import task.firstTaskForSpringBoot.model.User;


import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {

    private final EntityManager em;


    @Override
    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(em.find(User.class, id));
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }
    }

    @Override
    public void deleteById(Long id) {
        findById(id).ifPresent(em::remove);

    }

}
