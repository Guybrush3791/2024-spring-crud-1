package org.java.crud_test1;

import java.util.List;
import java.util.Optional;

import org.java.crud_test1.db.pojo.ContoBancario;
import org.java.crud_test1.db.serv.ContoBancarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * REPO:
 * 2024-spring-crud-1
 * 
 * TODO:
 * 
 * Generare nuovo progetto SpringBoot, e, dopo aver importato le dipendenze per
 * il db
 * collegare correttamente il progetto a nuovo db tramite DbEaver.
 * 
 * Creare l'entita' ContoBancario descritta come segue:
 * Questa classe rappresenta un conto bancario.
 * Un conto bancario ha un saldo iniziale di 0.
 * Un conto bancario può essere incrementato o decrementato.
 * Se si tenta di prelevare più di quanto si ha, viene lanciata un'eccezione.
 * Se si tenta di depositare un importo negativo, viene lanciata un'eccezione.
 * 
 * Dopo aver definito e testato la classe, aggiungere le annotazioni per
 * renderla
 * una tabella del db.
 * 
 * Dopo aver verificato il corretto funzionamento, predisporre repository e
 * service
 * per le 4 operazioni di CRUD (Create, Read, Update, Delete).
 * 
 * Testare adeguatamente la classe pura e tutte le operazini di CRUD all'interno
 * del
 * metodo run della classe principale (Application) dopo aver opportunamente
 * implementato l'interfaccia CommandLineRunner.
 * 
 */

@SpringBootApplication
public class CrudTest1Application
		implements CommandLineRunner {

	@Autowired
	private ContoBancarioService contoBancarioService;

	public static void main(String[] args) {
		SpringApplication.run(CrudTest1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Hello, World!");

		// contoDepositoTest();
		contoDepositoDbTest();

		System.out.println("The end");
	}

	public void contoDepositoTest() {

		ContoBancario cb1 = new ContoBancario("Guybrush", "Threepwood");

		System.out.println("-------------------------------");

		System.out.println(cb1);
		System.out.println("-------------------------------");

		cb1.deposit(1000);
		System.out.println(cb1);
		System.out.println("-------------------------------");

		cb1.withdraw(500);
		System.out.println(cb1);
		System.out.println("-------------------------------");

		try {

			cb1.deposit(-100);
		} catch (IllegalArgumentException e) {
			System.out.println("Deposito error: " + e.getMessage());
		}

		try {

			cb1.withdraw(5000);
		} catch (IllegalArgumentException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
	}

	public void contoDepositoDbTest() {

		ContoBancario cb1 = new ContoBancario("Guybrush", "Threepwood");
		ContoBancario cb2 = new ContoBancario("Elaine", "Marley");
		ContoBancario cb3 = new ContoBancario("LeChuck", "LeChuck");

		cb1.deposit(1000);
		cb2.deposit(2000);
		cb3.deposit(3500);

		contoBancarioService.save(cb1);
		contoBancarioService.save(cb2);
		contoBancarioService.save(cb3);

		List<ContoBancario> conti = contoBancarioService.getAll();

		System.out.println("-------------------------------");
		System.out.println(conti);

		contoBancarioService.delete(cb3);

		conti = contoBancarioService.getAll();

		System.out.println("-------------------------------");
		System.out.println(conti);

		Optional<ContoBancario> guybrushConto = contoBancarioService.getById(1);

		if (guybrushConto.isPresent()) {
			System.out.println("-------------------------------");
			System.out.println(guybrushConto.get());
		} else {
			System.out.println("-------------------------------");
			System.out.println("Guybrush conto not found");
		}
	}
}
