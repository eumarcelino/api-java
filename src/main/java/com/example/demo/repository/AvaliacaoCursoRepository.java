package com.example.demo.repository;

import com.example.demo.entity.AvaliacaoCurso;
import com.example.demo.entity.AvaliacaoCursoKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AvaliacaoCursoRepository extends JpaRepository<AvaliacaoCurso, AvaliacaoCursoKey> {
}
