import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente5 {

  public static void main(String[] args) {
    try {
      String host = "192.168.0.107";
      int port = 1099;
      Registry registry = LocateRegistry.getRegistry(host, port);
      BarbeiroInterface barbeiro = (BarbeiroInterface) registry.lookup(
        "Barbeiro"
      );
      System.out.println(barbeiro.cortarCabelo(5));
      System.out.println(barbeiro.cortarBarba(5));
      System.out.println(barbeiro.cortarBigode(5));
    } catch (Exception e) {
      System.err.println("Exceção do cliente: " + e.toString());
      e.printStackTrace();
    }
  }
}
