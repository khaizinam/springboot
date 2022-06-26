package springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import springboot.app.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long>{

    NewEntity findOneById(Long id);
    void deleteById(Long id);

}
