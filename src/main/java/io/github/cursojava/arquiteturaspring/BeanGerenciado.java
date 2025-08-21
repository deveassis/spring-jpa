package io.github.cursojava.arquiteturaspring;

import io.github.cursojava.arquiteturaspring.todos.TodoEntity;
import io.github.cursojava.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

// singleton = e um escopo padrao de projeto
// onde tem uma instancia unica de projeto que ira atender toda aplicacao
// para definiar um escopo basta usar a annotation @Scope("")
//@Scope("singleton"); ou @Scope(BeanDefinition.SCOPE_SINGLETON)
//@Scope("prototype"); ou @Scope(BeanDefinition.PROTOTYPE)
//@Scope("request"); ou @Scope(WebApplicationContext.SCOPE_REQUEST)
//@Scope("session"); @Scope(WebApplicationContext.SCOPE_SESSION)
//@Scope("application"); @Scope(WebApplicationContext.SCOPE_APPLICATION)

@Scope(BeanDefinition.SCOPE_SINGLETON)
@Component
public class BeanGerenciado {

    @Autowired
    private TodoValidator validator;

    @Autowired
    public BeanGerenciado(TodoValidator validator) {
        this.validator = validator;
    }

    public void utilizar(){
        var todo = new TodoEntity();
        validator.validar(todo);
    }

    @Autowired
    public void setValidator(TodoValidator validator) {
        this.validator = validator;
    }
}
