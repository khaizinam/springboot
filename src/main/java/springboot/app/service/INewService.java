package springboot.app.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import springboot.app.dto.NewDTO;

public interface INewService {
    NewDTO save(NewDTO newDTO);
    void delete(long[] ids);
    List<NewDTO> findAll(Pageable pageable);
    List<NewDTO> findAll();
    List<NewDTO> findByCategoryCode(String categoryCode);
    int totalItem();
}
