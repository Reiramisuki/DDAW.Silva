package ar.org.centro8.curso.java.web.test;
import ar.org.centro8.curso.java.web.connectors.Connector;
import ar.org.centro8.curso.java.web.entidades.Cliente;
import ar.org.centro8.curso.java.web.repositories.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.web.repositories.jdbc.ClienteRepository;
import ar.org.centro8.curso.java.web.enums.TipoDocumento;
/* @author Elizabeth Belén Silva */
public class TestClienteRepository {
    public static void main(String[] args) {
        I_ClienteRepository cr = new ClienteRepository(Connector.getConnection());
        cr.save(new Cliente("Juliana", "Sanchez", 33, "Venesuela 20", "gomez@mail", "44444444", TipoDocumento.DNI, "38928459"));
        cr.save(new Cliente("Eva", "Gimenez", 36, "Rivadavia 133", "perez@mail", "898988989", TipoDocumento.DNI, "20304958"));
        cr.save(new Cliente("Laura", "Lopez", 24, "Rioja", "perez@mail", "12345678", TipoDocumento.DNI, "70695087"));
        cr.save(null);
        cr.remove(cr.getById(3));

        Cliente cliente = cr.getById(2);
        if (cliente != null && cliente.getId() != 0) {
            cliente.setTelefono("11111111");
            cr.update(cliente);}
        System.out.println("****Lista de todos los clientes****");
        cr.getAll().forEach(System.out::println);
        System.out.println("****Lista de clientes con apellido 'Go...'****");
        cr.getLikeApellido("Go").forEach(System.out::println);
    }}