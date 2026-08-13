package com.fluxafinance.api.repository;

import com.fluxafinance.api.test.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Aluno, Long>{
}
