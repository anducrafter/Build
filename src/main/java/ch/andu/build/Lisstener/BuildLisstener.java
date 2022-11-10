package ch.andu.build.Lisstener;

import ch.andu.build.Build;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BuildLisstener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        if(Build.onbuild.containsKey(e.getPlayer().getName())){
            return;
        }
        e.setCancelled(true);
    }

    @EventHandler
    public void onBreak(BlockPlaceEvent e){
        if(Build.onbuild.containsKey(e.getPlayer().getName())){
            return;
        }
        e.setCancelled(true);
    }



}
