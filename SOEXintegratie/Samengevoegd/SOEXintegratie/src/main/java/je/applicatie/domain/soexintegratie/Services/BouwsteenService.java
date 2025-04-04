package je.applicatie.domain.soexintegratie.Services;

import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;
import je.applicatie.domain.soexintegratie.Domain.factory.BouwsteenFactory;
import je.applicatie.domain.soexintegratie.Repository.BouwsteenRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

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

