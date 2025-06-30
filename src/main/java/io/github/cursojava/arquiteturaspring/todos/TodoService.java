package io.github.cursojava.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    public TodoRepository repository;

    public TodoService(TodoRepository todoRepository){
        this.repository = todoRepository;
    }

    public TodoEntity salvar(TodoEntity novoTodo){
        return repository.save(novoTodo);
    }
}
