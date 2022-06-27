package springboot.app.api.output;

import java.util.List;
import java.util.ArrayList;
import springboot.app.dto.NewDTO;

public class NewByCate {
    private String categoryCode;
    private int totalPage;
    private List<NewDTO> listResult = new ArrayList<>();
    public String getCategoryCode() {
        return categoryCode;
    }
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
    public List<NewDTO> getListResult() {
        return listResult;
    }
    public void setListResult(List<NewDTO> listResult) {
        this.listResult = listResult;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    
}
