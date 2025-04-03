package nl.han.ene.soex.controller;

import nl.han.ene.soex.domain.Bouwsteen;
import nl.han.ene.soex.domain.factory.BouwsteenFactory;
import nl.han.ene.soex.domain.factory.OvernachtingFactory;
import nl.han.ene.soex.domain.factory.VervoerFactory;
import nl.han.ene.soex.service.BouwsteenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/bouwstenen")
public class BouwsteenController {
    private final BouwsteenService service;

    public BouwsteenController(BouwsteenService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Bouwsteen> voegBouwsteenToe(@RequestBody Map<String, Object> request) {
        String type = (String) request.get("type");

        String className = "nl.han.ene.soex.domain.factory." + type + "Factory";
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor();
            BouwsteenFactory factory = (BouwsteenFactory) constructor.newInstance();
            Bouwsteen bouwsteen = service.createBouwsteen(factory, request);
            return ResponseEntity.ok(bouwsteen);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/{bouwsteenId}")
    public ResponseEntity<Void> verwijderBouwsteen(@PathVariable Long bouwsteenId) {
        service.deleteBouwsteen(bouwsteenId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{bouwsteenId}")
    public ResponseEntity<Bouwsteen> haalBouwsteenOp(@PathVariable Long bouwsteenId) {
        Optional<Bouwsteen> bouwsteen = service.getBouwsteenById(bouwsteenId);
        return bouwsteen.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

