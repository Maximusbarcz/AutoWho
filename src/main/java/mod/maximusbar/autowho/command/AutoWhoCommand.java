package mod.maximusbar.autowho.command;

import gg.essential.api.EssentialAPI;
import gg.essential.api.commands.Command;
import gg.essential.api.commands.DefaultHandler;
import mod.maximusbar.autowho.autoWho;

public class AutoWhoCommand extends Command {
    public AutoWhoCommand() {
        super("autowho", true);
    }

    @DefaultHandler
    public void handle() {
        EssentialAPI.getGuiUtil().openScreen(autoWho.config.gui());
    }
}
