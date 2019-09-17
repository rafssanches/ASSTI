package br.rafsanches.assti_Aula_05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.rafsanches.assti_Aula_05.model.bean.Veiculo;
import br.rafsanches.assti_Aula_05.model.repository.VeiculoRepository;
import br.rafsanches.assti_Aula_05.util.Calculadora;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository veiculoRepo;
	
	@Autowired
	private Calculadora calculadora;
	
	public void salvar (Veiculo veiculo) {
		veiculoRepo.save(veiculo);
	}
	
	public List<Veiculo> listarTodos () {
		List <Veiculo> veiculos = veiculoRepo.findAll();
		for (Veiculo veiculo : veiculos) {
			veiculo.setEficiencia(calculadora.calculaEficiencia(veiculo.getLitroAtual(), veiculo.getRendimento()));
		}
		return veiculos;
	}
}
