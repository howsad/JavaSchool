package sbt.java.classloaders.myplugin;

import sbt.java.classloaders.Plugin;

public class PluginImpl implements Plugin {
    @Override
    public void doSomething() {
        System.out.println(10);
    }
}
