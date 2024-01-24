package com.example.common;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.type.Type;


import java.io.*;
import java.util.List;
import java.util.Optional;

public class IteratorFile {
    public static void processFiles(File file) {
        System.out.println("\n");
        System.out.println("Directory folder ");
        new DirExplorer((level, path, f) -> path.endsWith(".java"), (level, path, f) -> {
            System.out.println("Level: " + level + " Path: " + path + " File: " + f.getName());
        }).explore(file);
        System.out.println("\n");

        if (file.isDirectory()) {
            File[] files = file.listFiles();

            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        processFiles(f);
                    } else if (f.getName().endsWith(".java")) {
                        try {
                            FileInputStream in = new FileInputStream(f);
                            JavaParser parser = new JavaParser();
                            ParseResult<CompilationUnit> result = parser.parse(in);
                            Optional<CompilationUnit> optional = result.getResult();

                            if (optional.isPresent()) {
                                CompilationUnit cUnit = optional.get();
                                System.out.println("INFORMATION FIELDS OF FILE: " + f.getName());
                                getField(cUnit);
                                System.out.println("\n");
                                System.out.println("INFORMATION METHODS OF FILE: " + f.getName());
                                getMethod(cUnit);
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void getField(CompilationUnit cu) {
        List<FieldDeclaration> fields = cu.findAll(FieldDeclaration.class);
        for (FieldDeclaration field : fields) {
            List<Modifier> fieldModifiers = field.getModifiers();
            Type fieldType = field.getCommonType();

            for (VariableDeclarator variable : field.getVariables()) {
                String fieldName = variable.getName().asString();
                System.out.println("Field Modifiers: " + fieldModifiers + "Field Type: " + fieldType + "Field Name: " + fieldName);
            }
        }

    }

    public static void getMethod(CompilationUnit cu) {
        List<MethodDeclaration> methods = cu.findAll(MethodDeclaration.class);
        List<ConstructorDeclaration> constructors = cu.findAll(ConstructorDeclaration.class);
        for (ConstructorDeclaration constructorDeclaration : constructors) {
            List<Modifier> methodModifiers = constructorDeclaration.getModifiers();
            System.out.println("Name function: " + constructorDeclaration.getName() + "Method Modifiers: " + methodModifiers);
            for (Parameter parameter : constructorDeclaration.getParameters()) {
                String paramName = parameter.getName().asString();
                Type paramType = parameter.getType();
                System.out.println("Parameter Name: " + paramName+"Parameter Type: " + paramType);
            }
        }
        for (MethodDeclaration method : methods) {
            List<Modifier> methodModifiers = method.getModifiers();
            Type returnType = method.getType();
            System.out.println("Name function: " + method.getName()+"Return Type: " + returnType + "Method Modifiers: " + methodModifiers);
            if (!method.getNameAsString().startsWith("get")) {
                for (Parameter parameter : method.getParameters()) {
                    String paramName = parameter.getName().asString();
                    Type paramType = parameter.getType();
                    System.out.println("Parameter Name: " + paramName+"Parameter Type: " + paramType);
                }
            }
        }

    }


}
