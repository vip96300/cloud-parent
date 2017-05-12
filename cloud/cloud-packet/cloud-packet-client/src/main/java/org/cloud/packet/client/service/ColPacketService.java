package org.cloud.packet.client.service;

import org.cloud.packet.client.service.breaker.ColPacketServiceBreaker;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-packet-server",fallback=ColPacketServiceBreaker.class)
public interface ColPacketService {
	
	@RequestMapping(value="/packet/collect/packet/upd_colid",method=RequestMethod.PUT)
	public void updByColid(@RequestParam(value="colid",required=true)long colid,
			@RequestParam(value="catid",required=true)long catid,
			@RequestParam(value="proid",required=true)long proid);
}
