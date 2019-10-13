package group.jpa.ogm.app.xam;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class XamImpl extends UnicastRemoteObject implements XamInterface {
    public XamImpl() throws RemoteException {
        super();
    }

    public void getName(){
        System.out.println("Xammm vccc");
    }
}
