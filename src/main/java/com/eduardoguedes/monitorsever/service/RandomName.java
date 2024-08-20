package com.eduardoguedes.monitorsever.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class RandomName {

  private final List<String> names = Arrays.asList("Bruno", "Maria", "Bob", "Ana", "Carlos", "Fernanda", "Pedro", "Júlia", "Lucas", "Paula", "Ricardo", "Camila", "Mateus", "Sofia", "Roberto", "Isabela", "Thiago", "Clara", "Rafael", "Letícia", "Gustavo", "Amanda", "Felipe", "Juliana", "Eduardo", "Mariana", "Victor", "Larissa", "Daniel", "Natália", "João", "Tatiane", "Marcelo", "Vanessa", "Hugo", "Bruna", "Arthur", "Letícia"
  );
  private final Random random = new Random();

  public String drawName() {
    return names.get(random.nextInt(names.size()));
  }

}
