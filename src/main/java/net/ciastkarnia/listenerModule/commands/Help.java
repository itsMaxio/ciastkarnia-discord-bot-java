package net.ciastkarnia.listenerModule.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Help extends MainCommand{

    @Override
    public void execute(MessageReceivedEvent event, String[] messageAfterPrefix, String prefix) {


        System.out.println("embed here");

        
    }

}
