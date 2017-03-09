package me.delev.javaskop17.springspock.service;

import me.delev.javaskop17.springspock.model.Starship;
import me.delev.javaskop17.springspock.repository.StarshipRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Starship service implementation
 */
@Service
public class StarshipServiceImpl implements StarshipService {

    static final Logger logger = LoggerFactory.getLogger(StarshipServiceImpl.class);

    private final StarshipRepository starshipRepository;

    public StarshipServiceImpl(StarshipRepository starshipRepository) {
        this.starshipRepository = starshipRepository;
    }

    @Override
    public List<Starship> findAll() {
        return starshipRepository.findAll();
    }

    @Override
    public Starship create(Starship starship) {
        if (starship.getId() == null) {
            starship.setId(UUID.randomUUID().toString());
        }
        logger.debug("Saving starship: {}", starship);
        return starshipRepository.save(starship);
    }
}
