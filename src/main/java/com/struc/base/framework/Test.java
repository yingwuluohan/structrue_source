package com.struc.base.framework;

import com.struc.base.framework.annotation.ModelAttribute;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;

/**
 * 如何把自己创建的对象交给spring管理
 * Return  (T) Proxy.newProxyInstance( mapperInterface.getClassLoader() ,
 * new Class[]{ mapperInterface} , mapperProxy )
 *
 *
 *
 *
 *
 *
 *
 */
public class Test {

    public void getInfo(   @ModelAttribute("param") Param param){

        System.out.println( "[ param ]"+ param );

    }
    public static void main(String[] args) throws ClassNotFoundException {
        Test test = new Test();
        Class<?> clazz = Class.forName("com.struc.base.framework.Test");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {

            Annotation[][] paras = method.getParameterAnnotations();
            //先处理命名参数
            for (int i = 0; i < paras.length; i++) {
                for (Annotation a : paras[i]) {

                    if( a instanceof ModelAttribute) {
                        String paraName = ((ModelAttribute) a).value().trim();
                        Class<?>[] param = method.getParameterTypes();
                        Parameter[] parameters = method.getParameters();
                        System.out.println("[param]" + param.getClass());

                    }

                }

            }
        }


        URL url = test.getClass().getClassLoader().getResource("com.struc.base.framework" );

        File classDir = new File(url.getFile());
        for (File fileT : classDir.listFiles()) {

        }
    }

}

class Param {



}
