package nl.han.ene.soex.service;
import nl.han.ene.soex.domain.Bouwsteen;
import nl.han.ene.soex.domain.factory.BouwsteenFactory;
import nl.han.ene.soex.repository.BouwsteenRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BouwsteenService {
    private final BouwsteenRepository repository;

    public BouwsteenService(BouwsteenRepository repository) {
        this.repository = repository;
    }

    public Bouwsteen createBouwsteen(BouwsteenFactory factory, Map<String, Object> details) {
        Bouwsteen bouwsteen = factory.createBouwsteen(details);
        repository.save(bouwsteen);
        return bouwsteen;
    }

    public void deleteBouwsteen(Long bouwsteenId) {
        repository.delete(bouwsteenId);
    }

    public Optional<Bouwsteen> getBouwsteenById(Long bouwsteenId) {
        return repository.findById(bouwsteenId);
    }
}

