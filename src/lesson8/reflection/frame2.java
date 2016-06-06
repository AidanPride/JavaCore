package lesson8.reflection;
import lesson8.generics.domain.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.Annotation;
import java.util.*;

public class Frame2 {

    public static void main(String[] args) {
        Class jew = new Jewelry().getClass();
        Map<String , Object> info = new HashMap<>();
        info.put("count" , 1);
        info.put("name" , "Ne4to");
        info.put("price" , 10);
        info.put("article" , "ART15");
        setPrivates(jew , info);

        List<Object> list = new ArrayList<>();
        list.add("ART15");
        list.add(1);
        list.add("Ne4to");
        list.add(10);

         initClass(Jewelry.class , list);


        printClassInfo(Jewelry.class);
        printClassMethod(Jewelry.class);
        printClassFields(Jewelry.class);

        inspectService(Jewelry.class);
    }

    public static void inspectService(Class c){
        if (c.isAnnotationPresent(Service.class)){
            Service ann = (Service) c.getAnnotation(Service.class);
            System.out.println(ann.name());
        }
        else {
            System.out.println("Sorry, annotation not found");
        }

    }

    public static void printClassInfo(Class c){
        System.out.println("Class's name is "+c.getSimpleName());
        System.out.println("Class' parent is "+c.getSuperclass().getSimpleName());
    }

    public static void printClassMethod(Class c){
        System.out.println("Class's constructor is "+Arrays.toString(c.getConstructors()));
        System.out.println("Class's methods is "+Arrays.toString(c.getMethods()));
    }

    public static void printClassFields(Class c){
        System.out.println("Class's fields is "+ Arrays.toString(c.getDeclaredFields()));
    }

    public  static  <T> void setPrivates(Class<T> tClass , Map<String , Object> stringObjectMap){
        try{
            T o = tClass.newInstance();
            Field [] classFields = tClass.getDeclaredFields();
            for(String key: stringObjectMap.keySet() ){
                for (Field field : classFields){
                    if(field.getName().contains(key)){
                        System.out.println(field.getName() + " = " + stringObjectMap.get(key));
                        field.setAccessible(true);
                        field.set(o , stringObjectMap.get(key));
                    }
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static <T> T initClass (Class<T> c, List<Object> list) {

        try {

            Class[] paramTypes = new Class[list.size()];
            for(int i = 0; i < paramTypes.length; i++) {
                System.out.println(list.get(i).getClass());
                paramTypes[i] = list.get(i).getClass();
            }

            Object[] o = list.toArray(new Object[list.size()]);

            Constructor<T> tConstructor = c.getDeclaredConstructor(paramTypes);
            System.out.println(list);
            tConstructor.newInstance(o);
            System.out.println("Constructor = " + tConstructor.toString());

        }
        catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException el) {
            el.printStackTrace();
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return (T) c;
    }

}
