package springboot.app.service;

import springboot.app.dto.NewDTO;

public interface INewService {
    NewDTO save(NewDTO newDTO);
}
