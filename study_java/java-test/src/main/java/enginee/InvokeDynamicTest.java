package enginee;


import java.lang.invoke.*;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * @author mengchen
 * @time 18-11-29 下午2:02
 */
public class InvokeDynamicTest {

    public static void main(String[] args) throws Throwable {
        INDY_BootstrapMethod().invokeExact("icyfenix");
    }

    public static void testMethod(String s) {
        System.out.println("Hello World");
    }

    public static CallSite BootstrapMethod(MethodHandles.Lookup lookup, String name, MethodType mt)
            throws NoSuchMethodException, IllegalAccessException {
        return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class, name, mt));
    }

    private static MethodType MT_BootrapMethod() {
        return MethodType.fromMethodDescriptorString(
                "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;" +
                        "Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", null);
    }

    private static MethodHandle MH_BootstrapMethod() throws NoSuchMethodException, IllegalAccessException {
        return lookup().findStatic(InvokeDynamicTest.class, "BootstrapMethod", MT_BootrapMethod());
    }

    private static MethodHandle INDY_BootstrapMethod() throws Throwable {
        CallSite cs = (CallSite) MH_BootstrapMethod().invokeWithArguments(lookup(), "testMethod",
                MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V", null));
        return cs.dynamicInvoker();
    }
}
