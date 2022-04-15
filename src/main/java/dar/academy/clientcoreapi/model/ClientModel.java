package dar.academy.clientcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientModel {

    @NotNull(message = "client ID can not be empty")
    private String clientId;
    @Email
    @NotNull(message = "email can not be empty")
    private String email;
    @NotNull(message = "name can not be empty")
    private String name;
    private String surname;

}
