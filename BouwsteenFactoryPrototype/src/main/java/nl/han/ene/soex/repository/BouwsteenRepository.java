package nl.han.ene.soex.repository;

import nl.han.ene.soex.domain.Bouwsteen;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BouwsteenRepository {
    private final Map<Long, Bouwsteen> database = new HashMap<>();
    private long currentId = 1;

    public void save(Bouwsteen bouwsteen) {
        database.put(currentId++, bouwsteen);
    }

    public void delete(Long bouwsteenId) {
        database.remove(bouwsteenId);
    }

    public Optional<Bouwsteen> findById(Long bouwsteenId) {
        return Optional.ofNullable(database.get(bouwsteenId));
    }
}
