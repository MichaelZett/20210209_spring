package de.zettsystems.netzfilm.cart.domain;

public interface ShoppingCartRepository {

    void save(Product product);

    void save(ShoppingCart shoppingCart);
}
