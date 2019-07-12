package com.struc.base.framework.context;


import com.struc.base.framework.beans.FLBeanDefinition;
import com.struc.base.framework.beans.FLBeanWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FLDefaultListableBeanFactory extends FLAbstractApplicationContext {

    //用来存储BeanDefinition的定义
    protected Map<String,FLBeanDefinition> beanDefinitionMap= new ConcurrentHashMap<>();
    //用来存储实例化的单例Bean对象
    protected Map<String,FLBeanWrapper>  singleBeanInstanceMap= new ConcurrentHashMap<>();
//    protected Map<String,FLBeanWrapper>  singleBeanInstanceMap= new ConcurrentHashMap<>();

    protected List<String> beanDefinitionNames = new ArrayList<>();

    @Override
    protected void refreshBeanFactory() {
        System.out.println( "**********refreshBeanFactory***********" );
    }
}
