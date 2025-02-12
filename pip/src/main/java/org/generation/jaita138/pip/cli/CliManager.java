package org.generation.jaita138.pip.cli;
import java.util.Scanner;
import org.generation.jaita138.pip.database.entity.Role;
import org.generation.jaita138.pip.database.entity.Utente;
import org.generation.jaita138.pip.database.service.RoleService;
import org.generation.jaita138.pip.database.service.UtenteService;


public class CliManager {
    private Scanner scanner;
    private UtenteService utenteService;
    private RoleService roleService;

    public CliManager(UtenteService utenteService, RoleService roleService) {
        this.utenteService = utenteService;
        this.roleService = roleService;

        scanner = new Scanner(System.in);
        printOptions();
    }

    private void printOptions() {
        System.out.println("Opzioni Disponibili:");
        System.out.println("1. Stampa tutti gli utenti presenti in tabella");
        System.out.println("2. Inserisci un nuovo utente");
        System.out.println("3. Modifica i dettagli di un utente");
        System.out.println("4. Eliminare un utente a partire dall'id");
        System.out.println("5. Trovare tutti gli utenti con nome che inizia per a");
        System.out.println("6. Trovare tutti gli utenti con credito > 10");
        System.out.println("7. Trovare tutti gli utenti con nome o cognome null");
        System.out.println("8. Trovare tutti gli utenti con credito positivo, ma inferiore a 10");
        System.out.println("9. Termina il programma");
        System.out.println();

        int scelta = scanner.nextInt();
        scanner.nextLine();

        switch (scelta) {
            case 1:
                readAll();
                break;
            case 2:
                insert();
                break;
            case 3:
                edit();
                break;
            case 4:
                delete();
                break;
            case 5:
                opt5();
                break;
            case 6:
                opt6();
                break;
            case 7:
                opt7();
                break;
            case 8:
                opt8();
                break;
            case 9:
                return;
            default:
                System.out.println("Operazione non valida");
                break;
        }

        printOptions();
    }

    private void readAll() {
        System.out.println("Utenti:");
        System.out.println(utenteService.findAll());
        System.out.println();
    }

    private void insert() {
        Utente utente = new Utente();

        System.out.print("Nome: ");
        utente.setNome(scanner.nextLine());

        System.out.print("Cognome: ");
        utente.setCognome(scanner.nextLine());

        System.out.print("Username: ");
        utente.setUsername(scanner.nextLine());

        System.out.print("Password: ");
        utente.setPassword(scanner.nextLine());

        System.out.print("Credito: ");
        utente.setCredito(scanner.nextInt());
        scanner.nextLine();

        printRoles();
        System.out.print("Role id: ");
        Role role = roleService.findById(scanner.nextLong()).orElse(null);
        utente.setRole(role);
        scanner.nextLine();

        utenteService.save(utente);
        System.out.println("Utente salvato!");
        System.out.println();
    }

    private void printRoles() {
        System.out.println("Ruoli disponibili");
        System.out.println(roleService.findAll());
        System.out.println();
    }

    private void edit() {
        System.out.print("id: ");
        Utente utente = utenteService.findById(scanner.nextLong());
        scanner.nextLine();

        if (utenteService == null) {
            System.out.println("Utente non trovato!");
            return;
        }

        System.out.print("nome (" + utente.getNome() + "): ");
        utente.setNome(scanner.nextLine());

        System.out.print("cognome (" + utente.getCognome() + "): ");
        utente.setCognome(scanner.nextLine());

        System.out.print("username (" + utente.getUsername() + "): ");
        utente.setUsername(scanner.nextLine());

        System.out.print("password (" + utente.getPassword() + "): ");
        utente.setPassword(scanner.nextLine());

        System.out.print("credito (" + utente.getCredito() + "): ");
        utente.setCredito(scanner.nextInt());
        scanner.nextLine();

        printRoles();
        System.out.print("Role id (" + utente.getRole().getId() + "): ");
        Role role = roleService.findById(scanner.nextLong()).orElse(null);
        utente.setRole(role);
        scanner.nextLine();

        utenteService.save(utente);
        System.out.println("Utente modificato!");
        System.out.println();
    }

    private void printSubReddits(){
        System.out.println("");
    }

    private void delete() {
        System.out.print("id: ");
        Utente utente = utenteService.findById(scanner.nextLong());
        scanner.nextLine();

        if (utente==null) {
            System.out.println("Utente non trovato!");
            return;
        }

        utenteService.delete(utente);
        System.out.println("Utente eliminato!");
        System.out.println();
    }

    private void opt5() {
        System.out.println("Utenti che iniziano con a");
        System.out.println(utenteService.findByNomeStartingWithA());
        System.out.println();
    }

    private void opt6() {
        System.out.println("Utenti con credito superiore a 10");
        System.out.println(utenteService.findByCreditoGreatherThan10());
        System.out.println();
    }

    private void opt7() {
        System.out.println("Utenti con nome o cognome null");
        System.out.println(utenteService.findByNomeNullOrCognomeNull());
        System.out.println();
    }

    private void opt8() {
        System.out.println("Utente con credito positivo e inferiore a 10");
        System.out.println(utenteService.findyByCreditoBetween0And10());
        System.out.println();
    }
}
