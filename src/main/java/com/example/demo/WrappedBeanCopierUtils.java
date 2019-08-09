package com.example.demo;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.String.format;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/2 13:44
 * @Email: 15290810931@163.com
 */
public class WrappedBeanCopierUtils {

    private static final Map<String,BeanCopier> beanCopierCache = new ConcurrentHashMap<>();
    private static final Map<String,ConstructorAccess> constructorAccessCache = new ConcurrentHashMap<>();

    private static void copyProperties(Object source,Object target){
        BeanCopier copier = getBeanCopier(source.getClass(),target.getClass());
        copier.copy(source,target,null);
    }
    private static BeanCopier getBeanCopier(Class sourceClass, Class targetClass) {
      String beanKey = generateKey(sourceClass,targetClass);
      BeanCopier copier = null;
      if (!beanCopierCache.containsKey(beanKey)){
          copier = BeanCopier.create(sourceClass,targetClass,false);
          beanCopierCache.put(beanKey,copier);
      }else{
          copier = beanCopierCache.get(beanKey);
      }
      return copier;
    }
    private static String generateKey(Class sourceClass, Class targetClass) {
        return sourceClass.toString() + targetClass.toString();
    }
    public static <T> T copyProperties(Object source, Class<T> targetClass) {
        T t = null;
        try{
            t = targetClass.newInstance();
        }catch (InstantiationException | IllegalAccessException e){
            throw new RuntimeException(format("Create new instance or %s failed: %s",targetClass,e.getMessage()));
        }
        copyProperties(source,t);
        return t;
    }
    public static <T> List<T> copyPropertiesOfList(List<?> sourceList, Class<T> targetClass) {
        if (CollectionUtils.isEmpty(sourceList)){
            return Collections.emptyList();
        }
        ConstructorAccess<T> constructorAccess = getConstructorAccess(targetClass);
        List<T> resultList = new ArrayList<>(sourceList.size());
        for (Object o: resultList){
            T t = null;
            try{
                t = constructorAccess.newInstance();
                copyProperties(o,t);
                resultList.add(t);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
        return resultList;
    }

    private static <T> ConstructorAccess<T> getConstructorAccess(Class<T> targetClass) {
        ConstructorAccess<T> constructorAccess = constructorAccessCache.get(targetClass.toString());
        if (constructorAccess != null){
            return constructorAccess;
        }
        try{
            constructorAccess = ConstructorAccess.get(targetClass);
            constructorAccess.newInstance();
            constructorAccessCache.put(targetClass.toString(),constructorAccess);
        }catch (Exception e){
            throw new RuntimeException(format("Create new instance of %s failed: %s",targetClass,e.getMessage()));
        }
        return constructorAccess;
    }
}
