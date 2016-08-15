package sbt.java.classloaders;

import java.net.MalformedURLException;
import java.net.URL;

public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) throws MalformedURLException,
            ClassNotFoundException, IllegalAccessException, InstantiationException {
        URL url = new URL(pluginRootDirectory);
        PluginClassLoader loader = new PluginClassLoader(new URL[]{url});
        Class<?> pluginClass = loader.loadClass(pluginClassName);
        return (Plugin) pluginClass.newInstance();
    }

    public static void main(String[] args) throws MalformedURLException, IllegalAccessException,
            InstantiationException, ClassNotFoundException {
        PluginManager manager = new PluginManager(Plugin.class.getProtectionDomain().getCodeSource()
                .getLocation().toString());
        Plugin p1 =  manager.load("myplugin", "sbt.java.classloaders.myplugin.PluginImpl");
        Plugin p2 = manager.load("myultraplugin", "sbt.java.classloaders.myultraplugin.PluginImpl");
        System.out.println(p1.getClass().getSimpleName());
        System.out.println(p2.getClass().getSimpleName());
        System.out.println(p1.getClass().equals(p2.getClass()));
        System.out.println(p1.getClass().getClassLoader());
        System.out.println(p2.getClass().getClassLoader());
        System.out.println(Plugin.class.getClassLoader());
        p1.doSomething();
        p2.doSomething();
    }
}
