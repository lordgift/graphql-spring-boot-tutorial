package th.in.lordgift.graphql_spring_boot_tutorial.entities;

import th.in.lordgift.graphql_spring_boot_tutorial.entities.enums.Animal;

import java.time.LocalDateTime;


public class Homeless {

    private long id;
    private Animal type;
    private String location;
    private LocalDateTime foundAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Animal getType() {
        return type;
    }

    public void setType(Animal type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getFoundAt() {
        return foundAt;
    }

    public void setFoundAt(LocalDateTime foundAt) {
        this.foundAt = foundAt;
    }
}