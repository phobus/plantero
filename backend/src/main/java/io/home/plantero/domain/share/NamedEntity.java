package io.home.plantero.domain.share;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class NamedEntity extends BaseEntity {

    private String name;

    public NamedEntity() {
    }

    public NamedEntity(Long id, long version, String name) {
        super(id, version);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
