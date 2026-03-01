package com.felipe.linktrackr_backend.ShortLink;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortLinkRepository extends JpaRepository<ShortLinkEntity, Long> {

    Optional<ShortLinkEntity> findByShortCode(String shortCode);

}
