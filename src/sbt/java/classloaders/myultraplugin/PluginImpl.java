package sbt.java.classloaders.myultraplugin;

import sbt.java.classloaders.Plugin;

public class PluginImpl implements Plugin{
    @Override
    public void doSomething() {
        System.out.println(100000);
    }
}
