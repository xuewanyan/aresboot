package com.yitong.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义自动装配bean
 * @author xy
 * @date 2021-8-10
 */
public class DefaultSelectorImport implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.yitong.vo.Detp"};
    }
}
