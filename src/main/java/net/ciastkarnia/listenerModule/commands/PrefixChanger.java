package net.ciastkarnia.listenerModule.commands;

import net.ciastkarnia.Config;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class PrefixChanger extends MainCommand{

	@Override
	public void execute(MessageReceivedEvent event, String[] messageAfterPrefix, String prefix) {
        
        System.out.println("prefix dziala");

        if (messageAfterPrefix.length != 0) {
            String newPrefix = messageAfterPrefix[1];
            Config.setPrefix(newPrefix);
            System.out.println("prefix został ustawiony na: " + newPrefix);
        }
        else{
            System.out.println("nie ma argumentów");
        }
		
	}
    
}
