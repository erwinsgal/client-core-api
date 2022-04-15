package dar.academy.clientcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ClientResponse {

    private String clientId;
    private String email;
    private String name;
    private String surname;

}