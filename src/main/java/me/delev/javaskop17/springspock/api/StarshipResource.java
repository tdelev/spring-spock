package me.delev.javaskop17.springspock.api;

import me.delev.javaskop17.springspock.model.Starship;
import me.delev.javaskop17.springspock.service.StarshipService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Starship resource
 */
@RestController
@RequestMapping(value = "/api/starships", produces = MediaType.APPLICATION_JSON_VALUE)
public class StarshipResource {

    private final StarshipService starshipService;

    public StarshipResource(StarshipService starshipService) {
        this.starshipService = starshipService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Starship> getAll() {
        return starshipService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Starship create(@RequestBody @Valid Starship starship) {
        return starshipService.create(starship);
    }
}
