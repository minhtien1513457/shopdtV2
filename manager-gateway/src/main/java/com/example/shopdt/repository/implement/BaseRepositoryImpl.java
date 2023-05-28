package com.example.shopdt.repository.implement;

import com.example.shopdt.exception.DbResultNotFoundException;
import com.example.shopdt.exception.NotFoundException;
import com.example.shopdt.repository.BaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.Optional;

public abstract class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {
    private final EntityManager em;
    protected final JPAQueryFactory queryFactory;

    protected BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    public void clear() {
        em.clear();
    }
    public void detach(T entity) {
        em.detach(entity);
    }

    public Optional<T> getByIdNullAble(ID id) {
        return super.findById(id);
    }

    public T getByIdNoneNull(ID id) {
        return super.findById(id).orElseThrow(() -> {
            String errorMessage = String.format("Entity [%s] with id [%s] was not found in DB", getDomainClass().getSimpleName(), id);
            return new NotFoundException(errorMessage);
        });
    }
}
