package org.cloud.packet.server.repository;

import java.io.Serializable;

import org.cloud.packet.server.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftRepository extends JpaRepository<Gift, Serializable> {

}
