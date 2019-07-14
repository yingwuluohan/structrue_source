package com.struc.base.framework.webmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FLHandlerAdapter {
    private FLHandlerMapping handlerMapping;
    //记录本Method所有形式参数的位置,为了以后实例参数数组使用
//    private Map<String, Integer> methodParasMap = new HashMap<>();
    private Map<Object, Integer> methodParasMap = new HashMap<>();

//    public FLHandlerAdapter(FLHandlerMapping handlerMapping, Map<String, Integer> methodParasMap) {
    public FLHandlerAdapter(FLHandlerMapping handlerMapping, Map<Object, Integer> methodParasMap) {
        this.handlerMapping = handlerMapping;
        this.methodParasMap = methodParasMap;
    }

    public Map<Object, Integer> getMethodParasMap() {
        return methodParasMap;
    }

    private Object caseStringValue(String value,Class<?> clazz){
        if(clazz == String.class){
            return value;
        }else if(clazz == Integer.class){
            return  Integer.valueOf(value);
        }else if(clazz == int.class){
            return Integer.valueOf(value).intValue();
        }else {
            return null;
        }
    }

    public FLModelAndView handler(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, InstantiationException {
        //1. 从Request中获取所有参数

        Class<?>[] methodParameterTypes = handlerMapping.getMethod().getParameterTypes();

        Map<String, String[]> requsetParametes = request.getParameterMap();

        Object[] realParas = new Object[methodParameterTypes.length];

        //2. 根据形参列表,获得实参列表

        for (Map.Entry<Object, Integer> mapP : this.methodParasMap.entrySet()) {
            Object paraName = mapP.getKey();
            if (requsetParametes.containsKey(paraName)) {
                int index=mapP.getValue();
                String requestValues=Arrays.toString(requsetParametes.get(paraName)).replace("\\[|\\]", "");

                //对结果进行格式化
                realParas[mapP.getValue()] = caseStringValue(requestValues,methodParameterTypes[index]);
            }
        }

        //传入request, response
        for (int i = 0; i < methodParameterTypes.length; i++) {
            if (methodParameterTypes[i] == HttpServletRequest.class) {
                realParas[i] = request;
                continue;
            }
            if (methodParameterTypes[i] == HttpServletResponse.class) {
                realParas[i] = response;
                continue;
            }
        }

        for (int i = 0; i < realParas.length; i++) {
            if(realParas[i]==null){
                realParas[i]= methodParameterTypes[i].newInstance();
            }
        }

        //3. 传入实参,invoke method
        Object controller = this.handlerMapping.getController();
        try {
            Object result = this.handlerMapping.getMethod().invoke(controller, realParas);
            if(result==null){
                return null;
            }

            if(this.handlerMapping.getMethod().getReturnType()==FLModelAndView.class){
                return (FLModelAndView) result;
            }else
            {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
