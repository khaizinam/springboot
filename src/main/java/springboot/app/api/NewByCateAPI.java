package springboot.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.app.api.output.NewByCate;
import springboot.app.service.INewService;

@CrossOrigin
@RestController
public class NewByCateAPI {
    
    @Autowired
	private INewService newService;
    @GetMapping(value = "/new_code")
    public NewByCate showNewByCode(@RequestParam(value = "code",required = false) String code){
		NewByCate result = new NewByCate();
		result.setCategoryCode(code);
		result.setListResult(newService.findByCategoryCode(code));
        result.setTotalPage((int) newService.totalItem());
        return result;
    }
}
