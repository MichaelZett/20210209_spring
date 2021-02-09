package de.zettsystems.netzfilm.cart.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private long id;
    @Version
    private long version;
    @Column(unique = true, nullable = false, updatable = false, length = 36)
    private String uuid;
    private String name;

    public Product() {
        super();
    }

    public Product(String name) {
        this();
        this.name = name;
        this.uuid = UUID.randomUUID().toString();
    }

    public long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", version=" + version +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
