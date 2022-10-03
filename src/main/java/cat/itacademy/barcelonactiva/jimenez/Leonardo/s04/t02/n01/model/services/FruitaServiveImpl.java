package cat.itacademy.barcelonactiva.jimenez.Leonardo.s04.t02.n01.model.services;

import cat.itacademy.barcelonactiva.jimenez.Leonardo.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.jimenez.Leonardo.s04.t02.n01.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitaServiveImpl implements  FruitaService{

    @Autowired
    private FruitaRepository fruitaRepository;

    @Override
    public void add(Fruita fruita) {
        fruitaRepository.save(fruita);
    }

    @Override
    public void update(Fruita fruita) {
        fruitaRepository.save(fruita);
    }

    @Override
    public void deleteById(Long id) {
        fruitaRepository.deleteById(id);
    }

    public Optional<Fruita> findById(Long id) {
       return fruitaRepository.findById(id);
    }

    public List<Fruita> getAll() {
        return fruitaRepository.findAll();
    }

}
