package me.delev.javaskop17.springspock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Starship entity
 */
@Entity
@Table(name = "starships")
public class Starship {

    @Id
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("{id=%s, name=%s}", id, name);
    }
}
