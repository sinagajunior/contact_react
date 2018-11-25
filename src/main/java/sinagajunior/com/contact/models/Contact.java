package sinagajunior.com.contact.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Contact {
    @Id
    String id;
    String name;
    String address;
    String city;
    String phone;
    String email;
}
