package org.launchcode.javawebdevtechjobsauthentication.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "Name is required.")
    @Size(min=3, max=50, message = "Name must be between 3 and 50 characters long.")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() { return name;}

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {   return name;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}