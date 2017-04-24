package org.cloud.packet.server.repository;

import java.io.Serializable;

import org.cloud.packet.server.model.PacUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacUserRepository extends JpaRepository<PacUser, Serializable> {

}
