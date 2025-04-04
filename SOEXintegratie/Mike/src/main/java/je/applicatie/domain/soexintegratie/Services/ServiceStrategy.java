package je.applicatie.domain.soexintegratie.Services;

import je.applicatie.domain.soexintegratie.Adapters.BouwsteenAdapter;
import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;
import je.applicatie.domain.soexintegratie.Repository.BouwsteenRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceStrategy {
    void saveBouwsteen(Bouwsteen bouwsteen);
    Bouwsteen getBouwsteenDataById(int id, Bouwsteen bouwsteen);
    List<Bouwsteen> getBouwstenen(Bouwsteen bouwsteen);
    void getApiData();
}
