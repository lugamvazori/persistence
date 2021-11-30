package dev.luanfernandes.app.config;

import dev.luanfernandes.app.model.Produto;
import dev.luanfernandes.app.service.ProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@Slf4j
public class TestConfig implements CommandLineRunner {

    @Autowired
    ProdutoService produtoService;


    @Override
    public void run(String... args) {

        produtoService.add(new Produto(1L, "Laranja"));
        produtoService.add(new Produto(2L, "Limao"));

        produtoService.findAll().forEach(System.out::println);

        produtoService.addAll(Arrays.asList(
                new Produto(3L, "Pera"),
                new Produto(4L, "Morango"),
                new Produto(5L, "Maracuja")
        ));

        produtoService.findAll().forEach(System.out::println);
        produtoService.findByName("Maracuja").forEach(System.out::println);
    }

}
