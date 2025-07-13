package com.example.to_do_list.infrastructure.persistance.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.to_do_list.infrastructure.models.TodoEntity;

@Repository
public interface JpaTodoRepository extends JpaRepository<TodoEntity, UUID> {
    Optional<TodoEntity> findOneByTitle(String title);
}
