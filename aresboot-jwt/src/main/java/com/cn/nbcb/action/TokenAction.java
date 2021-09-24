package com.cn.nbcb.action;

import com.cn.nbcb.annotation.CheckToken;
import com.cn.nbcb.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author xy
 * @date 2021-9-22
 */
@RestController
@RequestMapping("token/*")
public class TokenAction {

    @Autowired
    private ITokenService iTokenService;

    @PostMapping("getToken")
    public Object getToken(){
        Map<String,Object> map = new HashMap<>();
        map.put("mid","xueyan");
        map.put("name","薛焱");
        String id = "xueyan-" + UUID.randomUUID();
        return this.iTokenService.creatToken(id,map);
    }

    @PostMapping("parseToken")
    public Object parseToken(){
        String token = "eyJtb2RlYWwiOiJhcmVzLWJvb3QteHkiLCJhdXRob3IiOiJ4dWV5YW4iLCJhbGciOiJIUzI1NiIsImRlc2MiOiJoZWFkZXIgZGVzYyJ9.eyJzdWIiOiJ7XCJyaWRzXCI6XCJVU0VSX0lEXCIsXCJuYW1lXCI6XCLolpvnhLFcIixcIm1pZFwiOlwieHVleWFuXCJ9Iiwic2l0ZSI6Ind3dy55aXRvbmcuY29tIiwiYm9vayI6InNwcmluZ2Jvb3QiLCJpc3MiOiJ4eSIsImNvbXBhbnkiOiLlsbnpgJrnp5HmioAiLCJleHAiOjE2MzIzNjgwODEsImlhdCI6MTYzMjM1ODA4MSwianRpIjoieHVleWFuLTFhN2IxYzEyLTc5NTAtNDU5MC1iNGY5LTc0OGVkYWNlNjFkNiJ9.DLmIQIItjzPqQpubZ083TKpzIpVRLgCTZlv6EsWEFD4";
        return this.iTokenService.parseToken(token);
    }

    @PostMapping("checkToken")
    @CheckToken(required = true)
    public void checkToken(){
    }
}
