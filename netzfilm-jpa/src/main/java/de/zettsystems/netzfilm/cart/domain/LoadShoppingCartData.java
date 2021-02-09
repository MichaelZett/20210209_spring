package de.zettsystems.netzfilm.cart.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class LoadShoppingCartData {
    private static final Logger LOG = LoggerFactory.getLogger(LoadShoppingCartData.class);
    private final ShoppingCartRepository shoppingCartRepository;

    public LoadShoppingCartData(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @PostConstruct
    public void createMovies() {
        Product iPhone = new Product("iPhone");
        shoppingCartRepository.save(iPhone);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(iPhone, 2);
        shoppingCartRepository.save(cart);

        LOG.info("Found product: {}", iPhone);
        LOG.info("Found shopping cart: {}", cart);
    }

}
