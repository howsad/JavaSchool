package sbt.java.classloaders;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class EncryptedClassLoader extends ClassLoader {
    private final String key;
    private final File dir;


    public EncryptedClassLoader(String key, File dir, ClassLoader parent) {
        super(parent);
        this.key = key;
        this.dir = dir;
    }

    public static void encryptToFile(String key, String from, String to, boolean encrypt) throws IOException {
        try (FileOutputStream out = new FileOutputStream(to)) {
            File file = new File(from);
            byte[] bytes = encrypt(key, file, encrypt);
            for (byte b : bytes) {
                out.write(b);
            }
        }
    }

    public static byte[] encrypt(String key, File from, boolean encrypt) throws IOException {
        byte[] out;
        try (FileInputStream in = new FileInputStream(from)) {
            int c;
            int len = key.length();
            int i = 0;
            int sign = 1;
            if (encrypt) {
                sign = -1;
            }
            out = new byte[(int) from.length()];
            while ((c = in.read()) != -1) {
                out[i] = (byte) (c - sign * key.charAt(i++ % len));
            }
        }
        return out;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String[] filepath = name.split("\\.");
        String filename = filepath[filepath.length - 1] + ".class";
        for (File f : dir.listFiles()) {
            if (f.getName().equals(filename)) {
                try {
                     return super.defineClass(name, encrypt(key, f, false), 0, (int) f.length());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new ClassNotFoundException();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {
/*        encryptToFile("butts", "out/production/Javaschool/sbt/java/classloaders/Main.class",
                "out/production/Javaschool/sbt/java/classloaders/Maim.class", true);*/
        File dir = new File("out/production/Javaschool/sbt/java/classloaders");
        EncryptedClassLoader classLoader = new EncryptedClassLoader("butts", dir, null);
        Class<?> clazz = classLoader.findClass("sbt.java.classloaders.Main");
        clazz.getMethod("hi").invoke(null);
    }
}
