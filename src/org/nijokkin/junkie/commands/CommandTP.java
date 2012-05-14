/**
 * Junkie is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Junkie is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with Junkie.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.nijokkin.junkie.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.nijokkin.junkie.Junkie;
import org.nijokkin.junkie.utilities.CommandUtil;

public class CommandTP implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(CommandUtil.checkArgs(1, args))
		{
			// Teleport sender to target command start.
			Player target;
			Player pSender;
			Location targetLocation;
			
			// Get the target's object
			target = Bukkit.getPlayer(args[0]);
			
			// Check if target is online
			if(target == null || !target.isOnline())
			{
				if(target == null)
				{
					sender.sendMessage(Junkie.COLOR + "Player is not online!");
					
					return true;
				}
			}
			
			// Check the sender is a player
			if(!(sender instanceof Player))
			{
				sender.sendMessage(Junkie.PREFIX + "Command cannot be run on the console!");
				
				return true;
			} else {
				// Get the player from the sender
				pSender = (Player) sender;
			}
			
			// Check sender has permission
			if(!CommandUtil.playerPermission(sender, "tp.to"))
			{
				// Send permission message to sender
				CommandUtil.sendPermission(sender);
				
				return true;
			}
			
			// Get the target's location
			targetLocation = target.getLocation();
			
			// Teleport the sender to the target
			pSender.teleport(targetLocation);
			
			// Notify players
			pSender.sendMessage(Junkie.COLOR + "Teleported to " + target.getName() + "!");
			target.sendMessage(Junkie.COLOR + pSender.getName() + " teleported to you!");
		}
		
		return true;
	}
	
}