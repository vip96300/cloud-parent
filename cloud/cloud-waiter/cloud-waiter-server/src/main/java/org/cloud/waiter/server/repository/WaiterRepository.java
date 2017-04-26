package org.cloud.waiter.server.repository;

import java.io.Serializable;

import org.cloud.waiter.server.model.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaiterRepository extends JpaRepository<Waiter, Serializable>{

}
