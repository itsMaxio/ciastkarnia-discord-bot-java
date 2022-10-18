package net.ciastkarnia.listenerModule;

import net.ciastkarnia.Config;
import net.ciastkarnia.listenerModule.commands.Help;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandManager {

    public void handle(MessageReceivedEvent event){
        String rawMessage = event.getMessage().getContentRaw();

        System.out.println(rawMessage); //test

        String[] message = rawMessage.replaceFirst(Config.getPrefix(), "").split("\\s+"); // do poprawienia bo wywala gdy nie widzi

        switch (message[0]) {
            case "help":
                Help help = new Help();
                
                

                break;
        
            default:
                break;
        }

    }
}
