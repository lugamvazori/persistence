package dev.luanfernandes.app.repository;

import dev.luanfernandes.app.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    @Query("select p from Produto p where p.nome = :nome")
    List<Produto> findByName(@Param("nome") String nome);

    List<Produto> findByNome(String nome);
}
