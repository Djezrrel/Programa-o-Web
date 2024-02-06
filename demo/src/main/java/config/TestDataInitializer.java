package config;

import entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositories.UserRepository;

@Configuration
public class TestDataInitializer {

    @Bean
    public CommandLineRunner initializeTestData(UserRepository userRepository) {
        return args -> {
            // Adicionar a lógica para inicializar e popular os dados
            User user1 = new User(null, "Nome1", "email1@example.com", "123456789", "password1");
            User user2 = new User(null, "Nome2", "email2@example.com", "987654321", "password2");
            
            userRepository.save(user1);
            userRepository.save(user2);
        };
    }
}
