import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Barbeiro extends UnicastRemoteObject implements BarbeiroInterface {

  private boolean ocupado;
  private int totalCortes;
  private boolean expedienteFinalizado;

  public Barbeiro() throws RemoteException {
    this.ocupado = false;
    this.totalCortes = 0;
    this.expedienteFinalizado = false;
  }

  public String cortarCabelo(int idCliente) throws RemoteException {
    return executarServico(
      "Cortando cabelo...",
      "Cabelo cortado!",
      idCliente,
      3000
    );
  }

  public String cortarBarba(int idCliente) throws RemoteException {
    return executarServico(
      "Cortando barba...",
      "Barba cortada!",
      idCliente,
      4000
    );
  }

  public String cortarBigode(int idCliente) throws RemoteException {
    return executarServico(
      "Cortando bigode...",
      "Bigode cortado!",
      idCliente,
      5000
    );
  }

  private synchronized String executarServico(
    String servico,
    String servicoConcluido,
    int idCliente,
    long tempo
  ) {
    if (!ocupado && totalCortes < 20) {
      ocupado = true;
      System.out.println("Cliente " + idCliente + ": " + servico);
      try {
        Thread.sleep(tempo);
        totalCortes++;
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println("Cliente " + idCliente + ": " + servicoConcluido);
        ocupado = false;
        if (totalCortes >= 20 && !expedienteFinalizado) {
          System.out.println("Expediente finalizado");
          expedienteFinalizado = true;
        }
      }
      return servicoConcluido;
    } else if (ocupado) {
      System.out.println(
        "Cliente " +
        idCliente +
        ": Barbeiro ocupado. Tentando novamente mais tarde."
      );
      return "Barbeiro ocupado. Tentando novamente mais tarde.";
    } else {
      return "O barbeiro já fez 20 cortes e não aceitará mais pedidos.";
    }
  }
}
