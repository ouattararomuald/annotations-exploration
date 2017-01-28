package com.rouattara;

import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import java.util.Set;

@AutoService(Processor.class) @SupportedAnnotationTypes({ "com.rouattara.annotations.Getter" })
@SupportedSourceVersion(SourceVersion.RELEASE_8) public class GetterProcessor
    extends AbstractProcessor {

  private Types types;
  private Elements elements;
  private Messager messager;
  private Filer filer;

  @Override public void init(ProcessingEnvironment processingEnv) {
    super.init(processingEnv);
    types = processingEnv.getTypeUtils();
    elements = processingEnv.getElementUtils();
    messager = processingEnv.getMessager();
    filer = processingEnv.getFiler();
  }

  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    for (TypeElement typeElement : annotations) {
      for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(typeElement)) {
      }
    }
    return false;

    //    // Process all annotations
    //    for (TypeElement currentAnnotation : annotations) {
    //      Name qualifiedName = currentAnnotation.getQualifiedName();
    //      // check if it is a Version annotation
    //      if (qualifiedName.contentEquals("com.rouattara.annotations.Getter")) {
    //        // Look at all elements that have Version annotations
    //        Set<? extends Element> annotatedElements;
    //        annotatedElements = roundEnv.getElementsAnnotatedWith(currentAnnotation);
    //        for (Element element : annotatedElements) {
    //          Getter v = element.getAnnotation(Getter.class);
    //
    //          MethodSpec main = MethodSpec.methodBuilder("main")
    //              .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
    //              .returns(Void.class)
    //              .addParameter(String[].class, "args")
    //              .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
    //              .build();
    //
    //          TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
    //              .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
    //              .addMethod(main)
    //              .build();
    //
    //          JavaFile javaFile = JavaFile.builder("foo.bar", helloWorld).build();
    //          try {
    //            javaFile.writeTo(System.out);
    //          } catch (IOException e) {
    //            e.printStackTrace();
    //          }
    //          //          JavaFileObject builderFile = processingEnv.getFiler()
    //          //              .createSourceFile(builderClassName);
    //          //          try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {
    //          //            // writing generated file to out …
    //          //          } catch (IOException e) {
    //          //            e.printStackTrace();
    //          //          }
    //        }
    //      }
    //    }
    //    return true;
  }
}