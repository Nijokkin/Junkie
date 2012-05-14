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

package org.nijokkin.junkie;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import org.nijokkin.junkie.commands.CommandTP;
import org.nijokkin.junkie.commands.CommandTPHere;
import org.nijokkin.junkie.utilities.CommandUtil;

public class Junkie extends JavaPlugin {
	
	public static final String PREFIX = ChatColor.GREEN + "[Junkie] " + ChatColor.WHITE;
	public static final ChatColor COLOR = ChatColor.GREEN;
	
	public void onEnable()
	{
		registerCommands();
	}
	
	public void onDisable()
	{
		
	}
	
	public void registerCommands()
	{
		registerCommand("tp", new CommandTP());
		registerCommand("tphere", new CommandTPHere());
	}

	
	public void registerCommand(String command, CommandExecutor ce)
	{
		if(CommandUtil.isRegisterable(command))
		{
			getCommand(command).setExecutor(ce);
		}
	}
	
}