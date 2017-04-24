package org.cloud.packet.server.repository;

import java.io.Serializable;

import org.cloud.packet.server.model.GifPicture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GifPictureRepository extends JpaRepository<GifPicture, Serializable> {

}
