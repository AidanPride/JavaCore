package lesson8.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ApplicationManager<T> {

 private boolean checkService;

    public void  init(Class<T> tClass){
        if (tClass.isAnnotationPresent(Service.class)){
          checkService = true;
            System.out.println("Service start");
        }
        else {
            System.out.println("Class without Service, give me another to begin");
        }
    }

    public void haveAnnotation(Class<T> c) {
        Method[] method = c.getMethods();
        for(Method md: method) {
            if(md.isAnnotationPresent(InitService.class)) {
                System.out.println("method have annotation");
            }

        }
    }

 public T getService(Class<T> clazz) throws Exception{
     for (Annotation ann : clazz.getAnnotations()) {

         if (ann instanceof Service) {
             for (Method method : clazz.getClass().getMethods()) {
                 for (Annotation methodAnn : method.getAnnotations()) {
                     if (methodAnn.annotationType().getSimpleName().equals(InitService.class.getSimpleName())) {
                         T service = clazz.newInstance();
                         method.invoke(service);
                         return service;
                     }

                 }

             }
         }

     }
     return null;
 }
}
