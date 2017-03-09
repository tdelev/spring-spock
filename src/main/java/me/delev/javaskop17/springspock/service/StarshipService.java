package me.delev.javaskop17.springspock.service;

import me.delev.javaskop17.springspock.model.Starship;

import java.util.List;

/**
 * Starship service
 */
public interface StarshipService {

    List<Starship> findAll();

    Starship create(Starship starship);

}
