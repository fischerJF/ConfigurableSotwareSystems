package tests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;


import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import gov.nasa.jpf.util.test.TestJPF;

public class TestSuiteForVarexJReflect extends TestJPF {

  /**
   * modify only here
   * TODO (?) try properties file and Class.forName for test classes on each project (system)
   */
  @SuppressWarnings("unchecked")
  static Class<?>[] testCaseClasses = new Class[] { 
		 
		ConnectedTests_Caio.class,
  	    CycleRelated_Caio.class,
	    GraphReturnTests_Caio.class,
	    MultiFeatureTest_Caio.class,
		NumberTests_Caio.class,
		TestSuite_NEW.class,
		 
		  
  };

  @Test
  public void testAll() {
    Set<String> methodsSet = new HashSet<>();
    int countTests = 0;

    if (verifyNoPropertyViolation(VarexJConstants.JPF_CONFIGURATION)) { // VarexJ specific invocation (must be if)

      for (Class<?> testCaseClass : testCaseClasses) {

        Object testCaseInstance = null;
        try {
          testCaseInstance = testCaseClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e1) {
          e1.printStackTrace();
        }

        Method beforeMethod = null; 
        Method afterMethod = null; 
        Method[] testCase = testCaseClass.getMethods();
        
        for (Method m : testCase) {
          if (m.isAnnotationPresent(Before.class)) {
            beforeMethod = m;
            try {
              beforeMethod.setAccessible(true);
            } catch (SecurityException e1) {
              e1.printStackTrace();
            }
          }
          else if (m.isAnnotationPresent(After.class)) {
            afterMethod = m;
            try {
              afterMethod.setAccessible(true);
            } catch (SecurityException e1) {
              e1.printStackTrace();
            }
          }
        }

        for (Method m : testCase) {

          if (m.isAnnotationPresent(Test.class) && !m.isAnnotationPresent(Ignore.class)) {
            
//            methodsSet.add(m.getDeclaringClass().getName() + "." + m.getName());
            System.out.println("Running test case: " + testCaseClass.getName() + '.' + m.getName()); ///mostra qual o teste esta sendo executado
            ++countTests;
            
            try {
              if (beforeMethod != null)
                beforeMethod.invoke(testCaseInstance);

// TODO JP TRY THIS. annot.setTimeout !!!
              
              Class<? extends Throwable> expectedExeption = m.getAnnotation(Test.class).expected();
              if (!expectedExeption.isAssignableFrom(Test.None.class)) {
                
                try {
                  m.invoke(testCaseInstance);
                } catch (InvocationTargetException ite) {
                  if (!ite.getCause().getClass().isAssignableFrom(expectedExeption)) {
                    throw ite;
                  }
                }
              }
              else {
                m.invoke(testCaseInstance);
              }

              if (afterMethod != null)
                afterMethod.invoke(testCaseInstance);

            } catch (IllegalAccessException | IllegalArgumentException e) {
              e.printStackTrace();
              System.err.println("REFLECT-EXCEPTION");
            } catch (InvocationTargetException e) {
              System.out.println(testCaseClass.getName() + '.' + m.getName());
//              System.out.println(e.getMessage());
//              System.out.println(e.getCause());
//              e.getTargetException().printStackTrace(); //eliminate "Caused by" log
              e.printStackTrace();
              System.out.println("INVOKE-EXCEPTION");
            } catch (Error e) {
              e.printStackTrace();
              System.err.println("ERROR");
            } catch (Exception e) {
              System.out.println("EXCEPTION");
            } catch (Throwable t) {
              System.out.println("THROWABLE");
            }
          }
        }
      }

//      System.out.println("All test methods: " + methodsSet);
    } //END OF VarexJ particular if
    
    System.out.println("Tests ran: " + countTests);
  }
}
