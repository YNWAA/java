package ru.stqa.pft.sandbox;
import java.util.List;

public class Collections {
    public static void main(String[] args){
        String[] langs={"Java","Python","C#","PHP"};

        List<String> languages = java.util.Arrays.asList("Java","Python","C#","PHP") ;

        for(String l : languages){
            System.out.println("Я хочу выучить "+l);
        }
    }
}
