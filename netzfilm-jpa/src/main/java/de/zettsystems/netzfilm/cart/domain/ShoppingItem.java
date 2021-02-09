package de.zettsystems.netzfilm.cart.domain;


import javax.persistence.*;

@Entity
public class ShoppingItem {

    @Id
    @GeneratedValue
    private long id;
    @Version
    private long version;
    @Column(unique = true, nullable = false, updatable = false, length = 36)
    private String uuid;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_cart_id", nullable = false)
    private ShoppingCart shoppingCart;
    @Column(nullable = false)
    private int quantity;

    public ShoppingItem() {
        super();
    }

    public ShoppingItem(Product product, ShoppingCart shoppingCart, int quantity) {
        this.product = product;
        this.shoppingCart = shoppingCart;
        this.quantity = quantity;
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

    public Product getProduct() {
        return product;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public int getQuantity() {
        return quantity;
    }
}
