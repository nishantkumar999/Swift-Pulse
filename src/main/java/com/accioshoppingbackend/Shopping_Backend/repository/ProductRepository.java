package com.accioshoppingbackend.Shopping_Backend.repository;

import com.accioshoppingbackend.Shopping_Backend.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Transactional
    @Modifying
    @Query(value = "update product set quantity =:quantity where id =:pid", nativeQuery = true)
    public void updateProductQuantity(int quantity, UUID pid);

    @Transactional
    @Modifying
    @Query(value = "update product set quantity_sold =:quantity where id =:pid", nativeQuery = true)
    public void updateTotalProductQuantity(int quantity, UUID pid);

    @Query(value = "select * from product where name like %:searchProduct%", nativeQuery = true)
    public List<Product> SearchProductByName(String searchProduct, String sort);

    @Query(value = "select * from product where category like %:searchProductByCategory%", nativeQuery = true)
    public List<Product> SearchProductByCategory(String searchProductByCategory, String sort);
}
