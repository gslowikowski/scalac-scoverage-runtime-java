package scoverage;

import java.io.IOException;

public class Invoker {

    public static void invoked(final int id, final String dataDir) throws IOException  {
        Invoker$.MODULE$.invoked(id, dataDir);
    }

}
