package com.cn.xy;

/**
 * 试试
 * @author xy
 * @date 2021-8-5
 */
public abstract class SendRequest {

    public final String[] getBean(String api){
        String imports[] = this.selectImports(api);
        return imports;
    }

    protected abstract String[] selectImports(String api);
}
