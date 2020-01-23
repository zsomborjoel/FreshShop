package com.freshshop.ecommerce.repository;

import com.freshshop.ecommerce.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TagRepository extends JpaRepository<Tag, Long> {

}