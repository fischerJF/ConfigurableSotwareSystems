package adapter;

import org.junit.runner.JUnitCore;

import testset.TestSuiteForVarexJReflect;

public class VarexJAdapter {

	public void varexjRun() {

		JUnitCore junit = new JUnitCore();
		//junit.addListener(new TextListener(System.out));
		org.junit.runner.Result result = junit.run(TestSuiteForVarexJReflect.class);

	}
}
