package com.example.springbooty.link.repository;

import com.example.springbooty.link.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LinkRepository
        extends JpaRepository <Link, Long> {
    Optional<Link> findByLinkGiven(String linkGiven);
    Optional<Link> findByLinkShort(Integer linkShort);
}
