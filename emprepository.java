package com.example.springproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface emprepository extends JpaRepository<empentity,Long>{
    boolean existsByUserid(Long userid);
}
