package springboot.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import springboot.app.converter.NewConverter;
import springboot.app.dto.NewDTO;
import springboot.app.entity.CategoryEntity;
import springboot.app.entity.NewEntity;
import springboot.app.repository.CategoryRepository;
import springboot.app.repository.NewRepository;
import springboot.app.service.INewService;
@Service
public class NewService implements INewService{
    @Autowired
	private NewRepository newRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewConverter newConverter;

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if (newDTO.getId() != null) {
			NewEntity oldNewEntity = newRepository.findOneById(newDTO.getId());
			newEntity = newConverter.toEntity(newDTO, oldNewEntity);
		} else {
		 	newEntity = newConverter.toEntity(newDTO);
		 }
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}
	
	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			newRepository.deleteById(item);
		}
	}

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(pageable).getContent();
		for (NewEntity item: entities){
			NewDTO newDTO = newConverter.toDTO(item);
			results.add(newDTO);
		}
		return results;
	}

	@Override
	public int totalItem() {
		return (int) newRepository.count();	
	}

	@Override
	public List<NewDTO> findAll() {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll();
		for (NewEntity item: entities){
			NewDTO newDTO = newConverter.toDTO(item);
			results.add(newDTO);
		}
		return results;
	}
	@Override
	public List<NewDTO> findByCategoryCode(String categoryCode) {
		List<NewDTO> results = new ArrayList<>(); //khoi tao array DTO de trả về JSON
		List<NewEntity> entities = newRepository.findByCategoryCode(categoryCode);//ạo list entity có chung category code
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(categoryCode);//khỏi tạo Category Entity;
		for (NewEntity item: entities){//vong lặp mỗi entities
			item.setCategory(categoryEntity);
			NewDTO newDTO = newConverter.toDTO(item);
			results.add(newDTO);
		}
		return results;
	}
	
}
