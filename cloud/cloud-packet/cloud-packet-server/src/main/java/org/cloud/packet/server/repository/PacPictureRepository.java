package org.cloud.packet.server.repository;

import java.io.Serializable;

import org.cloud.packet.server.model.PacPicture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacPictureRepository extends JpaRepository<PacPicture, Long> {

}
