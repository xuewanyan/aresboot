package com.cn.action;

import com.cn.vo.Company;
import com.cn.vo.CompanyDepyVo;
import com.cn.vo.Dept2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dept/*")
@Slf4j
public class DeptAction {

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
}
