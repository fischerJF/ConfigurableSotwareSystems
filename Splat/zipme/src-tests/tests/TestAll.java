package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  
    Example_Paulo.class,  
    Example_Paulo2.class,
    Addler32CheckSumTest.class, 
    CompressAdlerCSTests.class,
    FirstSuit.class, 
    GZIPtest.class, 
    LitleFeatures.class,    
    ExtractTest.class
  //DerivGZIPEXTRTest.class, 
    //DerivGZIPEXTRTest2.class,   
    })
public class TestAll extends ZipMeTest {
}