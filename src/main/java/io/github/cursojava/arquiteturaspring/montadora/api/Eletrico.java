package io.github.cursojava.arquiteturaspring.montadora.api;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)


@Target({ElementType.FIELD, ElementType.METHOD}) // aqui estou falando que pode ser utilizado em
// campos ou metodos
@Qualifier("motorEletrico")
public @interface Eletrico {
}
