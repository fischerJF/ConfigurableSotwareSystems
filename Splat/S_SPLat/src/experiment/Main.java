package experiment;

import splat.NotepadVariables;
public class Main {

	public static void main(String[] args) throws Exception {

		ExperimentRunner exp= new ExperimentRunner();
		
		String[] input = new String[4];
		input[0]="notepad";
		input[1]="false";
		input[2]="1";
		input[3]="true";

		NotepadVariables notepad= NotepadVariables.getSINGLETON();
		ExperimentRunner.runExp(input, notepad);
		
		
		
	}

}
