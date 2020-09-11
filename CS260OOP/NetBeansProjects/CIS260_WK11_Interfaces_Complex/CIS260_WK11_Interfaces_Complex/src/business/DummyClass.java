package business;

import helpers.OutputHelpers;

//this is a dummy class that illustrates that any
//class can implement any Interface and then be used in 
//a dynamically bound method

public class DummyClass implements IDynamicShape{

    @Override
    public void rotate() {
        StringBuilder str = new StringBuilder();

        str.append("\n-----------------------------------------------------------------");
        str.append("\nThis is a dummy class, implementing the IDynamicShape Interface");
        str.append("\n-----------------------------------------------------------------");
        OutputHelpers.showConsole(str.toString());
    }

}
