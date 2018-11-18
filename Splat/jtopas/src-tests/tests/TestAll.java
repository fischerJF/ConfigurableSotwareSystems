package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  
  TestMain.class,
  TestPatternMatching.class,
  TestTokenizerFlags.class,
 // TestTextAccess.class,
 // TestTokenizerProperties.class,
//  TestDifficultSituations.class
  
  
})

public class TestAll extends JTopasTest{ }