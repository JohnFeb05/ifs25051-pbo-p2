package adapter.repository;

import domain.entity.Contact;
import domain.repository.IContactRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementasi repository menggunakan penyimpanan in-memory.
 */
public class ContactRepository implements IContactRepository {
    private final List<Contact> data = new ArrayList<>();
    private int idCounter = 0;

    @Override
    public List<Contact> findAll() {
        return new ArrayList<>(data); // Salinan defensif
    }

    @Override
    public Optional<Contact> findById(int id) {
        return data.stream().filter(c -> c.getId() == id).findFirst();
    }

    @Override
    public Contact save(String name, String phone, String email) {
        Contact contact = new Contact(nextId(), name, phone, email);
        data.add(contact);
        return contact;
    }

    @Override
    public boolean deleteById(int id) {
        return data.removeIf(c -> c.getId() == id);
    }

    @Override
    public void update(Contact contact) {
        // Entity mutable & disimpan by-reference
    }

    private int nextId() {
        return ++idCounter;
    }
}