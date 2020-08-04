package inst.agent.loader;

/*-
 * #%L
 * BootstrapAppender
 * %%
 * Copyright (C) 2020 Timothy Hoffman
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

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
