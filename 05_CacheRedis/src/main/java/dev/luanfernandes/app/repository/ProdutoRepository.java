package dev.luanfernandes.app.repository;

import dev.luanfernandes.app.entity.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto,Long> {
}
