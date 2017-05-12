package org.cloud.packet.server.repository;

import java.util.List;

import org.cloud.packet.server.model.PacProduct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacProductRepository extends JpaRepository<PacProduct, Long> {
	
	public PacProduct findByProductid(long productid);
	
	public List<PacProduct> findByCatid(long catid,Pageable pageable);
	/**
	 * 根据产品编号集合获取优选包产品列表
	 * @param productids
	 * @return
	 */
	@Query(value="select * from packet_category_product o where o.productid in(?1) and gifid !=0",nativeQuery=true)
	public List<PacProduct> findByProductids(List<Long> productids);
}
