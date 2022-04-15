package dar.academy.clientcoreapi.service.client;

import dar.academy.clientcoreapi.model.ClientRequest;
import dar.academy.clientcoreapi.model.ClientResponse;
import dar.academy.clientcoreapi.repository.ClientEntity;
import dar.academy.clientcoreapi.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {

        clientRequest.setClientId(UUID.randomUUID().toString());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ClientEntity clientEntity = modelMapper.map(clientRequest, ClientEntity.class);

        clientEntity = clientRepository.save(clientEntity);

        return modelMapper.map(clientEntity, ClientResponse.class);

    }

    @Override
    public ClientResponse updateClient(ClientRequest clientRequest) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ClientEntity clientEntity = modelMapper.map(clientRequest, ClientEntity.class);

        ClientEntity dbEntity = clientRepository.getClientEntityByClientId(clientRequest.getClientId());

        clientEntity.setId(dbEntity.getId());

        clientEntity = clientRepository.save(clientEntity);

        return modelMapper.map(clientEntity, ClientResponse.class);

    }

    @Override
    public List<ClientResponse> getAllClients() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return clientRepository.getClientEntitiesBy().stream().map(client -> modelMapper.map(client, ClientResponse.class)).collect(Collectors.toList());

    }

    @Override
    public ClientResponse getClientById(String clientId) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        ClientEntity clientEntity = clientRepository.getClientEntityByClientId(clientId);

        return modelMapper.map(clientEntity, ClientResponse.class);

    }

    @Override
    public void deleteClientById(String clientId) {

        clientRepository.deleteClientEntityByClientId(clientId);

    }
}
