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

package org.nijokkin.junkie.utilities;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CommandUtil {
	
	public static boolean isRegisterable(String command)
	{
		// TODO: Add check.
		return true;
	}
	
	public static boolean checkArgs(int requiredArgs, String[] args)
	{
		if(args.length == requiredArgs)
		{
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean playerPermission(CommandSender p, String permission)
	{
		return p.hasPermission("junkie." + permission.toLowerCase());
	}
	
	public static void sendPermission(CommandSender p)
	{
		p.sendMessage(ChatColor.RED + "You do not have permission to perform this command!");
	}
}