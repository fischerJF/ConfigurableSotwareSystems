package tests;

import java.io.File;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import specifications.Configuration;
import main.Board;
import main.BoardManager;
import main.Field;
import main.Structure;
import main.SudokuFacade;
import main.SudokuGenerator;

public class TestMAB extends SudokuTest{

  @Before
  public void setup() {
    Field.POSSIBILITIES = 9;
  }
  
  @Test
  public void test01() {
//    Assume.assumeTrue(SudokuVariables.getSINGLETON().getSOLVER___());
    if(Configuration.SOLVER ) {
    SudokuFacade sf = new SudokuFacade();
    sf.loadFile(new File("inputTest1.txt"));
    System.out.println("entrou");
    Assert.assertTrue(sf.solutionHint());
    sf.setField(Structure.BOX, 1, 2, 4);
    Assert.assertTrue(sf.solutionHint());
    }
  }
  
  @Test
  public void test02() {
    System.out.println("test2");
//    Assume.assumeTrue(SudokuVariables.getSINGLETON().getGENERATOR___());
//    Assume.assumeFalse(SudokuVariables.getSINGLETON().getEXTENDEDSUDOKU___());
    if(Configuration.GENERATOR && Configuration.EXTENDEDSUDOKU ) {
    SudokuGenerator g = new SudokuGenerator();
    BoardManager bm = new BoardManager();
    bm.setPossibilities(15); //to make sure that extendedSudoku is disabled 
    
    Board b = new Board();
    SudokuGenerator.fillBoard(b);
    
    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        Field f = b.getField(Structure.ROW, i,j);
        if (f.getRemainingPos().size() == 0) {
          Assert.assertTrue(f.getValue() < 10);
          Assert.assertTrue(f.getValue() > 0);
        }
      }
    }
   }
  }

  //error with SOLVER__ = true
  @Test
  public void test03() {
    System.out.println("test3");
//    Assume.assumeTrue(SudokuVariables.getSINGLETON().getSTATES___());
//    Assume.assumeTrue(SudokuVariables.getSINGLETON().getEXTENDEDSUDOKU___());
    if(Configuration.STATES && Configuration.EXTENDEDSUDOKU ) {
      
    SudokuFacade sf = new SudokuFacade();
    sf.setPossibilities(2);

    sf.loadFile(new File("minisudoku.txt"));
    System.out.println("test3 depois de ler");
    Board b = sf.getBm().getBoard();
    Assert.assertNotNull(b);
    Assert.assertNotNull(b.getField(Structure.ROW, 0, 0));
    Assert.assertEquals(b.getField(Structure.ROW, 0, 0).getValue(), 1);
   }
  }

}
