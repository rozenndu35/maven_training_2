package fr.lernejo.tester;

import fr.lernejo.tester.api.TestMethod;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Method;
import java.util.Set;

public class TestRunner {

    public static void main(String args[]){
       if (args.length > 0){
           for (String nomPackage : args){
               Reflections reflections = new Reflections(nomPackage, new SubTypesScanner(false));
               Set<Class<?>> allTypes = reflections.getSubTypesOf(Object.class);
              
               System.out.println("Pour le package : "+ nomPackage);
               // Liste les classe trouver dans le package
               System.out.println("___________________ Liste des classe ________________");
               for (Class<?> classeDescr : allTypes){
                   System.out.println(classeDescr.getName());
               }
               
               // lancer toute les methodes de test
               System.out.println("___________________ Test des methode ________________");
               int nbTestLancer = 0;
               int nbTestEchoue = 0;
               long lStartTime = System.currentTimeMillis();
               for  (Class<?> classetester : allTypes){
                   Method[] declareMethods = classetester.getDeclaredMethods();
                   for (Method method : declareMethods) {
                       if (method.getAnnotation(TestMethod.class) != null) {
                           nbTestLancer ++;
                           String reussi = " ok ";
                           long lStartTimeMethod = System.currentTimeMillis();
                           try{
                        	   Object testInstance = classetester.getConstructor().newInstance();
                        	   method.invoke(testInstance);
                        	   
                               //lancer method
                           }catch (Exception e){
                               nbTestEchoue ++;
                               reussi = " ko ";
                           }finally {
                               //recuperer temps
                               long lEndTimeMethod = System.currentTimeMillis();
                               long executionMethod = lEndTimeMethod - lStartTimeMethod;
                               System.out.println(classetester.getName() + "#" + method.getName()+ reussi + " " + executionMethod+" ms");
                           }
                       }
                   }
                   
               }
               long lEndTime = System.currentTimeMillis();
               long execution = lEndTime - lStartTime;
               System.out.println("");
               System.out.println(nbTestLancer + " " + nbTestEchoue + " " + execution + " ms");

           }
       }else{
           System.out.println("vous n'avez rien passer en parametre");
       }

    }

}
