package springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.app.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
    CategoryEntity findOneByCode(String code);
}