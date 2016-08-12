package sbt.java.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeansUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) throws InvocationTargetException, IllegalAccessException {
        Map<String, Method> getters = new HashMap<>();
        for (Method m : from.getClass().getMethods()) {
            Class<?> returnType = m.getReturnType();
            String mName = m.getName();
            boolean getsBoolean = mName.startsWith("is") && returnType == boolean.class;
            if (returnType != void.class && m.getParameterCount() == 0) {
                String varName;
                if (mName.startsWith("get")) {
                    varName = mName.substring(3);
                } else if (getsBoolean) {
                    varName = mName.substring(2);
                } else {
                    continue;
                }
                getters.put(varName, m);
            }
        }
        for (Method m : to.getClass().getMethods()) {
            String mName = m.getName();
            if (m.getReturnType() == void.class && m.getParameterCount() == 1 && mName.startsWith("set")) {
                Method getter = getters.get(mName.substring(3));
                if (getter != null && m.getParameterTypes()[0].isAssignableFrom(getter.getReturnType())) {
                    m.invoke(to, getter.invoke(from));
                }
            }
        }
    }

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Transmitter transmitter = new Transmitter();
        try {
            assign(receiver, transmitter);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        for (Method m : receiver.getClass().getMethods()) {
            Class<?> returnType = m.getReturnType();
            String mName = m.getName();
            boolean getsBoolean = mName.startsWith("is") && returnType == boolean.class;
            if (returnType != void.class && m.getParameterCount() == 0 && (mName.startsWith("get") || getsBoolean)) {
                try {
                    System.out.println(m.getReturnType().getSimpleName() + ": " +  m.invoke(receiver));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
