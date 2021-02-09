package de.zettsystems.netzfilm.cart.domain;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ShoppingCartRepositoryImpl implements ShoppingCartRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Product product) {
        this.entityManager.persist(product);
    }

    @Override
    @Transactional
    public void save(ShoppingCart shoppingCart) {
        this.entityManager.persist(shoppingCart);
    }
}
