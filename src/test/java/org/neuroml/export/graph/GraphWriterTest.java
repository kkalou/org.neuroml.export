package org.neuroml.export.graph;

import java.io.File;
import java.io.IOException;

import org.lemsml.jlems.core.expression.ParseError;
import org.lemsml.jlems.core.sim.ContentError;
import org.lemsml.jlems.core.sim.ParseException;
import org.lemsml.jlems.core.type.BuildException;
import org.lemsml.jlems.core.type.Lems;
import org.lemsml.jlems.core.xml.XMLException;
import org.lemsml.jlems.io.util.FileUtil;
import org.neuroml.export.AppTest;
import org.neuroml.export.Utils;

import junit.framework.TestCase;

public class GraphWriterTest extends TestCase {

	public void testGetMainScript() throws ContentError, ParseError, ParseException, BuildException, XMLException, IOException {
        //Note: only works with this example at the moment!!

    	String exampleFilename = "LEMS_NML2_Ex9_FN.xml";
    	
        File exampleFile = new File(AppTest.getLemsExamplesDir(), exampleFilename);
        
        ///exampleFile = new File("/home/padraig/org.neuroml.import/src/test/resources/Simple3Species_SBML.xml");
        
		Lems lems = Utils.loadLemsFile(exampleFile);
        System.out.println("Loaded: "+exampleFile.getAbsolutePath());

		GraphWriter gw = new GraphWriter(lems);
        //System.out.println("new GraphWriter(lems)");
        String gv = gw.getMainScript();

        //System.out.println(gv);

        File gvFile = new File(AppTest.getTempDir(),exampleFile.getName().replaceAll("xml", "gv"));
        System.out.println("Writing to: "+gvFile.getAbsolutePath());
        
        FileUtil.writeStringToFile(gv, gvFile);

        
        assertTrue(gvFile.exists());
	}

}
