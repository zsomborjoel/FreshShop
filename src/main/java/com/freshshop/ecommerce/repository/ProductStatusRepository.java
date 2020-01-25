package com.freshshop.ecommerce.repository;

import com.freshshop.ecommerce.model.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStatusRepository extends JpaRepository<ProductStatus, Long> {

}