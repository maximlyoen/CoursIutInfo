package fr.iut;

/**
    * Main entry point for demo
    */
public class Main {
    public static void main(String[] args) {
        sample.deprecatedMethod();
        DeprecatedAnnotationSample sample = new DeprecatedAnnotationSample();
        sample.nonDeprecatedMethod();
    }   
}
