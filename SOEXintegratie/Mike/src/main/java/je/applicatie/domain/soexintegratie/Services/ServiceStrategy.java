package je.applicatie.domain.soexintegratie.Services;

import je.applicatie.domain.soexintegratie.Adapters.BouwsteenAdapter;
import je.applicatie.domain.soexintegratie.Domain.Bouwsteen;
import je.applicatie.domain.soexintegratie.Repository.BouwsteenRepo;
import org.springframework.stereotype.Service;

@Service
public interface ServiceStrategy {
    void saveBouwsteen(Bouwsteen bouwsteen);
    void getBouwstenen(Bouwsteen bouwsteen);
    void getBouwsteenDataById(int id, Bouwsteen bouwsteen);
    void getApiData();
}
