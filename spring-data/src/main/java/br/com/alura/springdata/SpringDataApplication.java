package br.com.alura.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.springdata.service.CrudCargoService;
import br.com.alura.springdata.service.CrudFuncionarioService;
import br.com.alura.springdata.service.CrudUnidadeTrabalhoService;
import br.com.alura.springdata.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Boolean system = true;
	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final RelatoriosService relatorioService;
	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;

	public SpringDataApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService,
			RelatoriosService relatorioService, CrudUnidadeTrabalhoService unidadeTrabalhoService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.relatorioService = relatorioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual acao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade Trabalho");
			System.out.println("4 - Relatorios");

			int action = scanner.nextInt();
			switch (action) {
			case 1: {
				cargoService.inicial(scanner);
				break;
			}
			case 2: {
				funcionarioService.inicial(scanner);
				break;
			}
			case 3: {
				unidadeTrabalhoService.inicial(scanner);
				break;
			}
			case 4: {
				relatorioService.inicial(scanner);
				break;
			}
			default:
				break;
			}
		}

	}

}
