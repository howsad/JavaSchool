package sbt.java.classloaders;

import java.net.URL;
import java.net.URLClassLoader;

public class PluginClassLoader extends URLClassLoader {

    public PluginClassLoader(URL[] urls) {
        super(urls, null);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.equals("sbt.java.classloaders.Plugin") || name.startsWith("java")) {
             return ClassLoader.getSystemClassLoader().loadClass(name);
        } else {
            return super.loadClass(name);
        }
    }
}
