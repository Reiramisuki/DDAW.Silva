package ar.org.centro8.curso.java.web.repositories.list;
/* @author Elizabeth Belén Silva */
public class ClienteRepositoryF {
    private static ClienteRepository cr = new ClienteRepository();
    private ClienteRepositoryF() {
    }

    public static ClienteRepository getClienteRepository() {
        return cr;
    }
}
