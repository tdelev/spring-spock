package me.delev.javaskop17.springspock.service;

import me.delev.javaskop17.springspock.model.Starship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CSV Starship parser implementation
 */
public class CsvStarshipParser implements StarshipParser {

    static final Logger logger = LoggerFactory.getLogger(CsvStarshipParser.class);

    @Override
    public List<Starship> parse(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines()
                    .map(this::parseFromLine)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("Error parsing CSV file");
            logger.error("Exception: ", e);
        }
        return null;
    }

    public Starship parseFromLine(String line) {
        String[] parts = line.split(";");
        Starship starship = new Starship();
        starship.setId(parts[0]);
        starship.setName(parts[1]);
        return starship;
    }
}
