package sinagajunior.com.contact.respositories;

import org.springframework.data.repository.CrudRepository;
import sinagajunior.com.contact.models.Contact;

public interface ContactRespository extends CrudRepository<Contact,String >{

    @Override
    void delete(Contact contact);
}
