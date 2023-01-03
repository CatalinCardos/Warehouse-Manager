package businesslogic;

import dataAccess.ClientDAO;
import model.Client;
import model.Product;

import java.util.List;
import java.util.Vector;

public class ClientBLL {

    private ClientDAO clientDAO;

    public ClientBLL() {
        clientDAO = new ClientDAO();
    }

    public List<Client> findALL()
    {
        List<Client> clients = clientDAO.findAll();

        return clients;
    }
    public void insertClient(Client client)
    {
        clientDAO.insert(client);
    }
    public Client findbyId(int id){
       return clientDAO.findById(id);
    }
    public Client findByNume(String nume){
        return clientDAO.findByName(nume);
    }
    public void delete(int id,String chosenType)
    {
        clientDAO.deleteById(id,chosenType);
    }
    public void update(Client client)
    {
        clientDAO.update(client);
    }
}
