package services;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;
import service.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Unable to delete user with id: " + id);
        }
    }

    public User update(Long id, User user) {
        try {
            User entity = userRepository.getOne(id);
            updateData(entity, user);
            return userRepository.save(entity);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }

    private void updateData(User entity, User user) {
        entity.setNome(user.getNome());
        entity.setEmail(user.getEmail());
        entity.setTelefone(user.getTelefone());
        entity.setPassword(user.getPassword());
    }
}
