package org.generation.jaita138.pip;
import org.generation.jaita138.pip.cli.CliManager;
import org.generation.jaita138.pip.database.service.RoleService;
import org.generation.jaita138.pip.database.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PipApplication implements CommandLineRunner {
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(PipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new CliManager(utenteService, roleService);
	}

}