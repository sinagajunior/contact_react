package sinagajunior.com.contact.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sinagajunior.com.contact.models.Contact;
import sinagajunior.com.contact.respositories.ContactRespository;

import java.util.Optional;

@RestController
public class ContactController {

    @Autowired
    ContactRespository contactRespository;



    @GetMapping("/contacts")
    public  Iterable<Contact> contacts() {
        return  contactRespository.findAll();
    }

    @PostMapping("contact")
    public Contact save(@RequestBody Contact contact) {
        contactRespository.save(contact);
    return  contact;
    }

   @PutMapping("/contacts/{id}")
   public Contact update(@PathVariable String id,@RequestBody Contact contact) {
       Optional<Contact> optionalContact = contactRespository.findById(id);
       Contact c = optionalContact.get();
       if(!contact.getName().equals(null))
            c.setName(contact.getName());
       if(!contact.getAddress().equals(null))
           c.setAddress(contact.getAddress());
       if(!contact.getCity().equals(null))
           c.setCity(contact.getCity());
       if(!contact.getPhone().equals(null))
           c.setPhone(contact.getPhone());
       if(!contact.getEmail().equals(null))
           c.setEmail(contact.getEmail());
       contactRespository.save(c);
        return  c;
   }

   @DeleteMapping("/contacts/{id}")
    public String delete(@PathVariable String id){
        Optional<Contact> optionalContact = contactRespository.findById(id);
        Contact contact = optionalContact.get();
        contactRespository.delete(contact);
        return "";

   }


}
