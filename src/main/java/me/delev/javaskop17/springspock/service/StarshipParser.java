package me.delev.javaskop17.springspock.service;

import me.delev.javaskop17.springspock.model.Starship;

import java.io.InputStream;
import java.util.List;

/**
 * Starship Parser
 */
public interface StarshipParser {

    List<Starship> parse(InputStream inputStream);
}
