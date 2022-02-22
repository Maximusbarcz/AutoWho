package mod.maximusbar.autowho.config;

import gg.essential.api.EssentialAPI;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;
import mod.maximusbar.autowho.autoWho;

import java.io.File;
//All the gui components in /autowho
public class Config extends Vigilant {
    @Property(
            type = PropertyType.SWITCH,
            name = "Toggle Mod",
            description = "Toggle the mod's functionality.",
            category = "General"
    )
    public static boolean toggle = true;

    @Property(
            type = PropertyType.TEXT,
            name = "Your ign",
            description = "Input your ign to make this mod work",
            category = "General"
    )
    public static String ign= "";

    @Property(
            type = PropertyType.TEXT,
            name = "Your second ign",
            description = "Input your second ign if you use alts",
            category = "General"
    )
    public static String ignAlt= "";



    public Config() {
        super(new File(autoWho.modDir, "autowho.toml"), "autoWho");
        initialize();


    }
}
