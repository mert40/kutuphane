package com.example.kutuphane.repositories.base;



import com.example.kutuphane.entities.abstracts.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@NoRepositoryBean
@RepositoryRestResource(exported = false)
public interface IBaseEntityRepo<T extends BaseEntity, ID extends Long> extends JpaRepository<T, ID> {

    @Override
    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.isActive = true")
    List<T> findAll();

    @Override
    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.id in ?1 and e.isActive = true")
    List<T> findAllById(Iterable<ID> ids);

    @Override
    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.id = ?1 and e.isActive = true")
    T getOne(ID id);

    //Look up deleted entities
    @Query("select e from #{#entityName} e where e.isActive = false")
    @Transactional(readOnly = true)
    List<T> findInactive();

    @Override
    @Transactional(readOnly = true)
    @Query("select count(e) from #{#entityName} e where e.isActive = true")
    long count();

    @Override
    @Transactional(readOnly = true)
    default boolean existsById(ID id) {
        return getOne(id) != null;
    }

    @Override
    @Query("update #{#entityName} e set e.isActive=false where e.id = ?1")
    @Transactional
    @Modifying
    void deleteById(Long id);


    @Override
    @Transactional
    default void delete(T entity) {
        deleteById(entity.getId());
    }

    @Override
    @Transactional
    default void deleteAll(Iterable<? extends T> entities) {
        entities.forEach(entitiy -> deleteById(entitiy.getId()));
    }

    @Override
    @Query("update #{#entityName} e set e.isActive=false")
    @Transactional
    @Modifying
    void deleteAll();

}
