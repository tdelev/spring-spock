package me.delev.javaskop17.springspock.service

import me.delev.javaskop17.springspock.model.Starship
import spock.lang.Specification

import static me.delev.javaskop17.springspock.service.TestUtils.loadCsvFile

/**
 * CSV Starship parsing
 */
class CsvStarshipParserSpec extends Specification {

    def starshipParser = new CsvStarshipParser()

    def "should parse single line starship"() {
        given:
        String line = "id;Starship"

        when:
        Starship result = starshipParser.parseFromLine(line)

        then:
        with(result) {
            id == "id"
            name == "Starship"
        }
    }

    def "should parse valid CSV file"() {
        given:
        InputStream is = loadCsvFile("starships.csv")

        when:
        List<Starship> result = starshipParser.parse(is)

        then:
        result != null
        result.size() == 3
    }


}
