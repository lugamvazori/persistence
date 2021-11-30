package dev.luanfernandes.app.repository;

import dev.luanfernandes.app.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {

    Funcionario findFuncionariosByMatricula(UUID numMatricula);

}
