package me.delev.javaskop17.springspock.service

import me.delev.javaskop17.springspock.model.Starship
import me.delev.javaskop17.springspock.repository.StarshipRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.dao.DataIntegrityViolationException
import spock.lang.Specification

import static me.delev.javaskop17.springspock.service.TestUtils.loadCsvFile

/**
 * Starship import service implementation unit tests
 */
class StarshipImportServiceImplSpec extends Specification {

    static final Logger logger = LoggerFactory.getLogger(StarshipImportServiceImplSpec.class)

    StarshipImportService starshipImportService

    StarshipRepository starshipRepositoryMock

    def setup() {
        starshipRepositoryMock = Mock()
        starshipImportService = new StarshipImportServiceImpl(new CsvStarshipParser(), starshipRepositoryMock)
    }


    def "should import from csv file"() {
        given:
        InputStream csvFile = loadCsvFile("starships.csv")

        when:
        List<Starship> result = starshipImportService.importStarships(csvFile)

        then:
        result != null
        result.size() == 3

        3 * starshipRepositoryMock.save(_) >> {
            Starship starship ->
                logger.debug("Mock saving: {}", starship)
                starship
        }
    }

    def "should fail on longer name"() {
        given:
        InputStream csvFile = loadCsvFile("starships.csv")

        when:
        List<Starship> result = starshipImportService.importStarships(csvFile)

        then:
        DataIntegrityViolationException e = thrown()

        (1..3) * starshipRepositoryMock.save(_) >> {
            Starship starship ->
                if (starship.name.length() > 5) {
                    throw new DataIntegrityViolationException("Length can not be longer then 5")
                }
                logger.debug("Mock saving: {}", starship)
                starship
        }
    }
}
