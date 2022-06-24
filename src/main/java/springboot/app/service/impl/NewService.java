package springboot.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
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
}
