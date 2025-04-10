package com.example.demo.repository;

import com.example.demo.model.Category;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

// Suggested code may be subject to a license. Learn more: ~LicenseLog:1682243742.
// Suggested code may be subject to a license. Learn more: ~LicenseLog:227466006.
   List<Category>  findByUserId(Long userId);
}