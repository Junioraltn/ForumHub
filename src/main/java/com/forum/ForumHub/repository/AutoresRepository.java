package com.forum.ForumHub.repository;

import com.forum.ForumHub.domain.autores.Autores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AutoresRepository extends JpaRepository<Autores, Long> {

    UserDetails findByEmail(String email);

}
