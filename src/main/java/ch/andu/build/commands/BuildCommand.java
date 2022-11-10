package ch.andu.build.commands;

import ch.andu.build.Build;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            return false;
        }
        Player player = ((Player) sender).getPlayer();
        if(args.length == 0){

            if(player.hasPermission("T.Build")){
                if(Build.onbuild.containsKey(player.getName())){
                    Build.onbuild.remove(player.getName());
                    player.sendMessage(Build.prefix+" §cDu hast den Baumodus verlassen.");
                    return false;
                }
                Build.onbuild.put(player.getName(),true);
                player.sendMessage(Build.prefix+" §aDu hast den Baumodus betreten.");

            }
        }else if(args.length == 1){
            Player target = Bukkit.getPlayer(args[0]);
            if(!Bukkit.getOnlinePlayers().contains(target)){
                return true;
            }
            if(player.hasPermission("T.Build.others")){
                if(Build.onbuild.containsKey(target.getName())){
                    Build.onbuild.remove(target.getName());
                    target.sendMessage(Build.prefix+" §cDu hast den Baumodus verlassen.");
                    return false;
                }
                Build.onbuild.put(target.getName(),true);
                target.sendMessage(Build.prefix+" §aDu hast den Baumodus betreten.");

            }



        }

        return false;
    }
}
