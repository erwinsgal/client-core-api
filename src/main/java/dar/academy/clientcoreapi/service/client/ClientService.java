package dar.academy.clientcoreapi.service.client;

import dar.academy.clientcoreapi.model.ClientRequest;
import dar.academy.clientcoreapi.model.ClientResponse;

import java.util.List;

public interface ClientService {

    ClientResponse createClient(ClientRequest clientRequest);
    ClientResponse updateClient(ClientRequest clientRequest);
    List<ClientResponse> getAllClients();
    ClientResponse getClientById(String clientId);
    void deleteClientById(String clientId);

}
