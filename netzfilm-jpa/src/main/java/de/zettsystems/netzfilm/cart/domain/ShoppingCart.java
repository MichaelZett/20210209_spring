package de.zettsystems.netzfilm.cart.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue
    private long id;
    @Version
    private long version;
    @Column(unique = true, nullable = false, updatable = false, length = 36)
    private String uuid;
    @OneToMany(mappedBy = "shoppingCart",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ShoppingItem> items;

    protected ShoppingCart() {
        super();
        this.uuid = UUID.randomUUID().toString();
        this.items = new LinkedList<>();
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

    public List<ShoppingItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(Product product, int quantity) {
        items.add(new ShoppingItem(product, this, quantity));
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", version=" + version +
                ", uuid='" + uuid + '\'' +
                ", items=" + items +
                '}';
    }
}
