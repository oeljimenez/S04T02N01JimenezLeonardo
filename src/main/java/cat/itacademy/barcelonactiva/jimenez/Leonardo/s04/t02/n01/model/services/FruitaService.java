package cat.itacademy.barcelonactiva.jimenez.Leonardo.s04.t02.n01.model.services;

import cat.itacademy.barcelonactiva.jimenez.Leonardo.s04.t02.n01.model.domain.Fruita;

import java.util.List;
import java.util.Optional;

public interface FruitaService {
    public void add(Fruita fruita);

    public void update(Fruita fruita);

    public void deleteById(Long id);

    public Optional<Fruita> findById(Long id);

    public List<Fruita> getAll();

}

