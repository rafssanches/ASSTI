package br.rafsanches.assti_Aula_05.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.rafsanches.assti_Aula_05.model.bean.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
