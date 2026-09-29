package domain.repository;

import domain.entity.Contact;
import java.util.List;
import java.util.Optional;

/**
 * Port (kontrak) penyimpanan data kontak.
 */
public interface IContactRepository {
    List<Contact> findAll();
    Optional<Contact> findById(int id);
    Contact save(String name, String phone, String email);
    boolean deleteById(int id);
    void update(Contact contact);
}