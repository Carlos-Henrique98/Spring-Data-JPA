package br.com.alura.springdata.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.repository.FuncionarioRepository;

@Service
public class RelatoriosService {

	private Boolean system = true;

	private final FuncionarioRepository funcionarioRepository;

	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao de funcionario deseja executar");
			System.out.println("0 - Sair ");
			System.out.println("1 - Busca funcionario nome: ");

			int action = scanner.nextInt();

			switch (action) {
			case 1: {
				buscarFuncionarioNome(scanner);
				break;
			}
			default:
				system = false;
				break;
			}
		}
	}

	private void buscarFuncionarioNome(Scanner scanner) {
		System.out.println("Qual o nome deseja pesquisar: ");
		String nome = scanner.next();
		List<Funcionario> list = funcionarioRepository.findByNome(nome);
		list.forEach(System.out::println);
	}
}
