package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  Pilot.class,                  //344.0
  Pilot_CommandLine.class,     //529
  Example.class,              //601
  Pilot_REPAIR.class,         //637
  TestBasics.class,           //3612
  TestProxying.class,         //5122               1912.
  TestUndo.class,             //6976               4425          
  TestCombinations.class,     //                   7164
  TestObeservability.class    //                   8953
  
 // TestGUI_Mateus.class,
  //TestMVC.class,
  
})

public class TestAll extends CompaniesTest{ }