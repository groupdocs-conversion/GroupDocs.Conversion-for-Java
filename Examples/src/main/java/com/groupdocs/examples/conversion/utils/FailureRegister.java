package com.groupdocs.examples.conversion.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * The class is singleton.
 * It registers exceptions in samples and at the end of running examples prints the number of failed samples, their names and Exception object.
 */
public class FailureRegister {

    private static final Object lock = new Object();
    private static FailureRegister instance;
    private final HashMap<String, Throwable> failedSamples;
    private boolean _throwExceptionsImmediately;

    /**
     * Private constructor to ensure singleton behavior.
     */
    private FailureRegister() {
        this.failedSamples = new HashMap<>();
    }

    /**
     * Gets the instance of the singleton class.
     *
     * @return The instance of the singleton class.
     */
    public static FailureRegister getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new FailureRegister();
                }
            }
        }
        return instance;
    }

    /**
     * Registers a failed sample with its exception.
     *
     * @param exception The exception that occurred in the sample.
     */
    public void registerFailedSample(Throwable exception) {
        if (isThrowExceptionsImmediately()) {
            throw new RuntimeException(exception);
        } else {
            final String sampleName = obtainSampleName(exception.getStackTrace());
            this.failedSamples.put(sampleName, exception);
        }
    }

    /**
     * Analyzes the stack trace to obtain sample class and method names.
     * Uses sample class and method names to form sample name.
     *
     * @param stackTrace Stacktrace elements
     * @return Sample name in format 'ClassName/MethodName'
     */
    private String obtainSampleName(StackTraceElement[] stackTrace) {
        if (stackTrace == null) {
            return "<unknown sample>";
        }

        for (StackTraceElement stackTraceElement : stackTrace) {
            final String className = stackTraceElement.getClassName();
            final int classNameIndex = className.lastIndexOf(".");
            String packageName = className.substring(0, classNameIndex);
            if (packageName.startsWith("com.groupdocs.examples")) {
                return className.substring(classNameIndex + 1) + "/" + stackTraceElement.getMethodName();
            }
        }

        return "<unknown sample>";
    }

    /**
     * Prints the number of failed samples, their names and Exception objects at the end of running examples.
     */
    public void printFailedSamples(boolean printStackTraces) {
        if (this.failedSamples.isEmpty()) {
            System.out.println("\n======================= ALL SAMPLES PASSED =======================");
        } else {
            System.err.println("\n======================= FAILED SAMPLES =======================");
            for (Map.Entry<String, Throwable> entry : this.failedSamples.entrySet()) {
                System.err.println("Sample name: " + entry.getKey());
                if (printStackTraces) {
                    entry.getValue().printStackTrace();
                } else {
                    System.err.println("\tException message: " + entry.getValue().getMessage());
                }
                System.err.println();
            }
            System.err.println("-----------------------");
            System.err.println("Number of failed samples: " + this.failedSamples.size());
        }
    }

    public int getFailedSamplesCount() {
        return this.failedSamples.size();
    }

    /**
     * Checks if the direct throw mode is enabled. If true, exceptions will be thrown directly instead of being registered.
     * This method is primarily for testing purposes and allows toggling between registering exceptions or throwing them immediately.
     *
     * @return The current value of the direct throw mode.
     */
    public boolean isThrowExceptionsImmediately() {
        return _throwExceptionsImmediately;
    }

    /**
     * Sets the direct throw mode. If true, exceptions will be thrown directly instead of being registered.
     * This method is primarily for testing purposes and allows toggling between registering exceptions or throwing them immediately.
     *
     * @param throwExceptionsImmediately The boolean value to set for direct throw mode.
     */
    public void setThrowExceptionsImmediately(boolean throwExceptionsImmediately) {
        this._throwExceptionsImmediately = throwExceptionsImmediately;
    }
}
