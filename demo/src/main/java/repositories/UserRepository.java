package repositories;

import entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // adicionar métodos de consulta adicionais, se necessário
}
