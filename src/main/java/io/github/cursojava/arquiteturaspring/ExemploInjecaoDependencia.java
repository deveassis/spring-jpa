package io.github.cursojava.arquiteturaspring;

import io.github.cursojava.arquiteturaspring.todos.*;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class ExemploInjecaoDependencia {
    public static void main(String[] args) throws Exception {
        DataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("");
        dataSource.setUsername("");
        dataSource.setPassword("password");

        Connection connection = dataSource.getConnection();

        EntityManager entityManager = null;
        TodoRepository repository = null; //new SimpleJpaRepository<TodoEntity, integer>(null, null);
        TodoValidator todoValidator = new TodoValidator(repository);
        MailSender sender = new MailSender();
        TodoService todoService = new TodoService(repository, todoValidator, sender);
    }
}
