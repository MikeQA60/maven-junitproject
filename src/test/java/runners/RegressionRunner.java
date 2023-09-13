package runners;


//import org.junit.platform.suite.api.*;




import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key=GLUE_PROPERTY_NAME, value ="steps")
//@ConfigurationParameter(key="cucumber.glue", value ="steps")
        //"cucumber.glue", value ="steps")
        //key="cucumber.glue", value="steps")

@ExcludeTags("IGNORE")
public class RegressionRunner {

}
