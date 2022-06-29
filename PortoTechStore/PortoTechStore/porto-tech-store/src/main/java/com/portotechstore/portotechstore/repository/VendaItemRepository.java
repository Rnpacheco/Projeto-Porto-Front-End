package com.portotechstore.portotechstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portotechstore.portotechstore.model.VendaItemModel;

public interface VendaItemRepository extends JpaRepository<VendaItemModel, Long>{

	Optional<Long> findFirstByOrderByIdCarrinhoDesc();
	
}
