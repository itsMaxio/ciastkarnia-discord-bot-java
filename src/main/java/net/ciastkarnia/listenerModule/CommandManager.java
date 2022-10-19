package net.ciastkarnia.listenerModule;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.ciastkarnia.Config;
import net.ciastkarnia.listenerModule.commands.MainCommand;
import net.ciastkarnia.listenerModule.commands.PrefixChanger;
import net.ciastkarnia.listenerModule.commands.Help;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandManager {

    public void handle(MessageReceivedEvent event, String prefix){
        String rawMessage = event.getMessage().getContentRaw().toLowerCase();
        String[] message = rawMessage.replaceFirst("\\"+Config.getPrefix(), "").split("\\s+"); // do poprawienia bo wywala gdy nie widzi
        String[] messageAfterPrefix = Arrays.copyOfRange(message, 0, message.length);
        String commandName = message[0];                    //komenda po prefiksie
        
        Map<String, MainCommand> commandMap = new HashMap<String, MainCommand>();
        commandMap.put("help", new Help());             //rejestrowanie komend do poprawy
        commandMap.put("prefix", new PrefixChanger());
        // Szukanie komendy
        MainCommand command;
        if (commandMap.containsKey(commandName)){           // jeśli commandName czyli komenda po prefiksie będzie równa wartości z commandMapy 
            command = commandMap.get(commandName);          // wtedy przypisz ją do command
        }else{
            return;                                         // jeśli nie to przerwij CommandManagera
        }

        // Egzekutor
        try {
            command.execute(event, messageAfterPrefix ,prefix);                 // egzekutuje command wyszukaną powyżej 
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
