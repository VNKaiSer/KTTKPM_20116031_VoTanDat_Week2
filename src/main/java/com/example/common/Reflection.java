package com.example.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;

public class Reflection {
    public static void reflect(Class<?> clazz) {
        Class<?> superClass = clazz.getSuperclass();
        System.out.println("Class: " + clazz.getName());
        System.out.println("Super class: " + superClass.getName());
        System.out.println("Package: " + clazz.getPackage().getName());
        // Modifier
        int modifiers = clazz.getModifiers();
        boolean isPublic = Modifier.isPublic(modifiers);
        boolean isInterface = Modifier.isInterface(modifiers);
        boolean isAbstract = Modifier.isAbstract(modifiers);
        boolean isFinal = Modifier.isFinal(modifiers);
        System.out.println("\nModifier");
        System.out.println("Is Public? " + isPublic);
        System.out.println("Is Final? " + isFinal);
        System.out.println("Is Interface? " + isInterface);
        System.out.println("Is Abstract? " + isAbstract);

        System.out.println("\nInterfaces: ");
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> i : interfaces) {
            System.out.println(i.getName());
        }


        System.out.println("\nFields: ");
        java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
        for (java.lang.reflect.Field field : fields) {
            System.out.println(field.getName());
        }

        System.out.println("\nMethods: ");
        java.lang.reflect.Method[] methods = clazz.getDeclaredMethods();
        for (java.lang.reflect.Method method : methods) {
            System.out.println(method.getName());
        }

        System.out.println("\nConstructors: ");
        java.lang.reflect.Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (java.lang.reflect.Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }
        System.out.println("\nAnnotation:");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation ann : annotations) {
            System.out.println("+ " + ann.annotationType().getSimpleName());
        }

    }
}
