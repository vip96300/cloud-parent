package org.cloud.packet.server.repository;

import java.io.Serializable;

import org.cloud.packet.server.model.Packet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacketRepository extends JpaRepository<Packet, Long> {

}
