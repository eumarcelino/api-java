package com.example.demo.repository;

import com.example.demo.entity.Estudante;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante,Long> {

    @Query (value = " select e.* FROM api.estudante e " +
                    " left join api.avaliacao_curso ac ON ac.estudante_id = e.id " +
                    " where ac.estudante_id is null ", nativeQuery = true)
    List<Estudante> findByAvaliacaoCursosEstudanteIsNullNativeQuery();

    @Query (value = " SELECT e FROM Estudante e " +
                    " join AvaliacaoCurso ac " +
                    " where ac.estudante.id is null ")
    List<Estudante> findByAvaliacaoCursosEstudanteIsNullJPQL();

    List<Estudante> findByAvaliacaoCursosEstudanteIsNull();
}
