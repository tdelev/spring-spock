package me.delev.javaskop17.springspock.service;

import me.delev.javaskop17.springspock.model.Starship;
import me.delev.javaskop17.springspock.repository.StarshipRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

/**
 * Starship import implementation
 */
@Service
public class StarshipImportServiceImpl implements StarshipImportService {

    static final Logger logger = LoggerFactory.getLogger(StarshipImportServiceImpl.class);

    private final StarshipParser starshipParser;
    private final StarshipRepository starshipRepository;

    public StarshipImportServiceImpl(StarshipParser starshipParser,
                                     StarshipRepository starshipRepository) {
        this.starshipParser = starshipParser;
        this.starshipRepository = starshipRepository;
    }

    @Override
    public List<Starship> importStarships(InputStream inputStream) {
        List<Starship> starships = starshipParser.parse(inputStream);
        starships.forEach(starship -> {
            logger.debug("Saving starship: {}", starship);
            starshipRepository.save(starship);
        });
        logger.debug("Starships imported: {}", starships.size());
        return starships;
    }
}
