import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BarbeiroInterface extends Remote {
  String cortarCabelo(int idCliente) throws RemoteException;
  String cortarBarba(int idCliente) throws RemoteException;
  String cortarBigode(int idCliente) throws RemoteException;
}
