package dar.academy.clientcoreapi.controller;

import dar.academy.clientcoreapi.model.ClientModel;
import dar.academy.clientcoreapi.service.deprecated.ClientServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("deprecated/client")

public class ClientControllerOld {


    @Autowired
    private ClientServiceOld clientServiceOld;

    @GetMapping("/check")
    public String check(){
        return "client-core-api is working";
    }

    @GetMapping("/{clientId}")
    public ClientModel getClientById(@PathVariable String clientId){
        return clientServiceOld.getClientById(clientId);
    }

    @GetMapping("/all")
    public List<ClientModel> getAllClients() {
        return clientServiceOld.getAllClients();
    }

    @PostMapping
    public ResponseEntity<String> createClient(@Valid @RequestBody ClientModel clientModel) {
        clientServiceOld.createClient(clientModel);
        return new ResponseEntity<String>("Successfully created", HttpStatus.OK);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<String> updateClientById(@PathVariable String clientId, @Valid @RequestBody ClientModel clientModel) {
        clientServiceOld.updateClientById(clientId, clientModel);
        return new ResponseEntity<String>("Successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteClientById(@PathVariable String clientId) {
        clientServiceOld.deleteClientById(clientId);
        return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);

    }
}
