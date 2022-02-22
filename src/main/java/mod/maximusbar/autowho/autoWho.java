package mod.maximusbar.autowho;


import mod.maximusbar.autowho.command.AutoWhoCommand;
import mod.maximusbar.autowho.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;
import java.util.concurrent.TimeUnit;

//Some registering stuff

@Mod(modid = "autowhoreborn", name = "autoWho Reborn", version = "1.0")


public class autoWho {

    private boolean running;
    public static File jarFile;
    public static File modDir = new File(new File(Minecraft.getMinecraft().mcDataDir, "config"), "AutoWho");
    public static Config config;



    @Mod.Instance("autoWho")
    public static autoWho instance;

    @Mod.EventHandler
    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
    @Mod.EventHandler
    protected void onFMLPreInitialization(FMLPreInitializationEvent event) {
        if (!modDir.exists()) modDir.mkdirs();
        jarFile = event.getSourceFile();
    }

    @Mod.EventHandler
    protected void onInitialization(FMLInitializationEvent event) {
        config = new Config();
        config.preload();
        new AutoWhoCommand().register();

    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        String msg = event.message.getUnformattedText();
        if (msg.startsWith(Config.ign) && msg.contains(" has joined (") && (Config.toggle)) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage(
                    "/who"
                );



        } else if (msg.startsWith(Config.ignAlt) && msg.contains(" has joined (") && (Config.toggle)) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage(
                    "/who"
            );



        }

    }

}

