package group.jpa.ogm.app.xam;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface XamInterface extends Remote {
    void getName() throws RemoteException;
}
