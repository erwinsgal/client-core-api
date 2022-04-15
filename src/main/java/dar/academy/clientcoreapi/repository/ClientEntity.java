package dar.academy.clientcoreapi.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "client_table")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClientEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String clientId;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String surname;

}
