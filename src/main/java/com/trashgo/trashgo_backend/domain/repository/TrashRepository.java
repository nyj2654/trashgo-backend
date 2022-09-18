package com.trashgo.trashgo_backend.domain.repository;

import com.trashgo.trashgo_backend.domain.model.Trash;
import com.trashgo.trashgo_backend.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrashRepository extends JpaRepository<Trash, Long> {
    Optional<Trash> findById(Long id);

    List<Trash> findAll();
}
