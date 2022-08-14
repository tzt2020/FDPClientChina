package net.ccbluex.liquidbounce.injection.transformers;

import net.minecraft.launchwrapper.IClassTransformer;

public class DisplayTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if(name.startsWith("org.lwjgl"))
            System.out.println("【found】"+name);
        if(name.equals("org.lwjgl.opengl.Display")) {
            System.out.println(name);
            //final ClassNode classNode = ASMUtils.INSTANCE.toClassNode(basicClass);
            //final MethodNode setTitle = classNode.methods.stream().filter(node -> node.name.equals("setTitle")).findFirst().get();
            //setTitle.instructions.clear();
        }
        return basicClass;
    }
}