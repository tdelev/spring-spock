package me.delev.javaskop17.springspock.service;

import me.delev.javaskop17.springspock.model.Starship;

import java.io.InputStream;
import java.util.List;

/**
 * Importing starships from various sources
 */
public interface StarshipImportService {

    List<Starship> importStarships(InputStream inputStream);
}
