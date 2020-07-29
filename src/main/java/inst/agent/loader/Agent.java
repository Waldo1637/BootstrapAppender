package inst.agent.loader;

import java.io.PrintStream;
import java.lang.instrument.Instrumentation;
import java.util.jar.JarFile;

/**
 * Adds the jar file given by the 'options' parameter to the bootstrap class
 * loader search path for the active {@link Instrumentation}.
 *
 * @author Timothy Hoffman
 */
public class Agent {

    public static void premain(String agentArgs, Instrumentation instr) throws Exception {
        instr.appendToBootstrapClassLoaderSearch(new JarFile(agentArgs));
    }

    public static void main(String[] args) {
        final PrintStream out = System.out;
        out.println("==============================================================");
        out.println("Bootstrap Path Appender " + Agent.class.getPackage().getImplementationVersion());
        out.println("==============================================================");
        out.println("Use as a java agent (listed prior to other java agents) to add");
        out.println("the jar file given by the 'options' parameter to the bootstrap");
        out.println("ClassLoader for the active Instrumentation.");
        out.println(" EXAMPLE: java -javaagent:BootstrapAppender.jar=content.jar ..");
        out.println("==============================================================");
    }
}
