package com.cn.action;

import com.cn.vo.Company;
import com.cn.vo.CompanyDepyVo;
import com.cn.vo.Dept2;
import com.yitong.voa.Detp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dept/*")
@Slf4j
public class DeptAction {

    @Autowired
    private Detp detp;

    @Autowired
    private List<String> books;

    @PostMapping(value = "dept")
    public Object getDept(@RequestBody CompanyDepyVo company){
        log.info("company===,{}",company);
        Map <String,Object> map = new HashMap<>();
        map.put("company",company);
        return map;
    }

    /**
     * 无效-------------
     * @param company
     * @param dept2
     * @return
     */
    @PostMapping(value = "company")
    public Object getCompany(@ModelAttribute("company") Company company,@ModelAttribute("dept2") Dept2 dept2){
        log.info("company===,{}",company);
        log.info("dept2===,{}",dept2);
        Map <String,Object> map = new HashMap<>();
        map.put("company",company);
        map.put("dept2",dept2);
        return map;
    }

    @PostMapping(value = "books")
    public Object getBooks(){
        log.info("this.detp:{}",this.detp);
        log.info("this.books:{}",this.books);
        File file = new File("ddd");
        return null;
    }
}
