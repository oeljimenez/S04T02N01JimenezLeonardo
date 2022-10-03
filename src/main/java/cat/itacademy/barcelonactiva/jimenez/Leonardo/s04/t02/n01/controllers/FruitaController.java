package cat.itacademy.barcelonactiva.jimenez.Leonardo.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.jimenez.Leonardo.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.jimenez.Leonardo.s04.t02.n01.model.services.FruitaService;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruita")
public class FruitaController {
    Logger logger = (Logger) LoggerFactory.getLogger(FruitaController.class);

    @Autowired
    FruitaService fruitaService;

    @PostMapping("/add")
    public ResponseEntity<Fruita> add(@RequestBody Fruita fruita) {
        logger.info("Calling add method");
        try {
            fruitaService.add(fruita);
            return new ResponseEntity<>(fruita, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruita> update(@PathVariable("id") long id, @RequestBody Fruita fruitaDetails) {
        logger.info("Calling update method");
        try {
            Optional<Fruita> fruita = fruitaService.findById(id);
            if (fruita.isPresent()) {
                fruita.get().setNom(fruitaDetails.getNom());
                fruita.get().setQuantitatQuilos(fruitaDetails.getQuantitatQuilos());
                fruitaService.update(fruita.get());
                return new ResponseEntity<>(fruitaService.findById(id).get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Fruita> delete(@PathVariable("id") long id) {
        logger.info("Calling delete method");
        try {
            Optional<Fruita> fruita = fruitaService.findById(id);
            if (fruita.isPresent()) {
                fruitaService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getOne(@PathVariable("id") long id) {
        logger.info("Calling getOne method");
        try {
            Optional<Fruita> fruita = fruitaService.findById(id);
            if (fruita.isPresent()) {
                fruitaService.deleteById(id);
                return new ResponseEntity<>(fruita.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAll() {
        logger.info("Calling getAll method");
        try {
            List<Fruita> fruites = fruitaService.getAll();
            return new ResponseEntity<>(fruites, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
