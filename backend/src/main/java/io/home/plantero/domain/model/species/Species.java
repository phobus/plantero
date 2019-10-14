package io.home.plantero.domain.model.species;

import io.home.plantero.domain.share.NamedEntity;

import javax.persistence.Entity;

@Entity
public class Species extends NamedEntity {

    private String url;

    public Species() {
    }

    public Species(Long id, long version, String name, String url) {
        super(id, version, name);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
