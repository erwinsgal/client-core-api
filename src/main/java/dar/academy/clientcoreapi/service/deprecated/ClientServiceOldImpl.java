package dar.academy.clientcoreapi.service.deprecated;

import dar.academy.clientcoreapi.model.ClientModel;
import dar.academy.clientcoreapi.service.deprecated.ClientServiceOld;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ClientServiceOldImpl implements ClientServiceOld {

    private static final HashMap<String, ClientModel> clientMap = new HashMap<>();

    static {

        ClientModel clientModel1 = new ClientModel("1", "alesha@mail.ru", "Aleksei", "Ivanov");
        ClientModel clientModel2 = new ClientModel("2", "mary@mail.ru", "Mariya", "Ivanov");
        ClientModel clientModel3 = new ClientModel("3", "ivan@mail.ru", "Ivan", "Ivanov");

        clientMap.put(clientModel1.getClientId(), clientModel1);
        clientMap.put(clientModel2.getClientId(), clientModel2);
        clientMap.put(clientModel3.getClientId(), clientModel3);
    }

    @Override
    public void createClient(ClientModel clientModel) {
        clientMap.put(clientModel.getClientId(), clientModel);
    }

    @Override
    public List<ClientModel> getAllClients() {
        return new ArrayList<>(clientMap.values());
    }

    @Override
    public ClientModel getClientById(String clientId) {
        return clientMap.get(clientId);
    }

    @Override
    public void updateClientById(String clientId, ClientModel clientModel) {
        clientModel.setClientId(clientId);
        clientMap.put(clientId, clientModel);
    }

    @Override
    public void deleteClientById(String clientId) {
        clientMap.remove(clientId);
    }
}
