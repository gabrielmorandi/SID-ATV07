import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {

  public static void main(String args[]) {
    try {
      Barbeiro obj = new Barbeiro();
      Registry registry = LocateRegistry.createRegistry(1099);
      registry.bind("Barbeiro", obj);

      System.err.println("Servidor pronto");
    } catch (Exception e) {
      System.err.println("Exceção do servidor: " + e.toString());
      e.printStackTrace();
    }
  }
}
