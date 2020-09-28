package de.groodian.cosmetics.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

public class ActivatedCosmetics {

	private static boolean isUserExists(Player player) {
		try {
			PreparedStatement ps = MySQLCosmetics.getConnection().prepareStatement("SELECT cosmetics FROM cosmetics WHERE UUID = ?");
			ps.setString(1, player.getUniqueId().toString().replaceAll("-", ""));
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void activate(Player player, String type, String cosmetic) {
		if (isUserExists(player)) {
			try {
				PreparedStatement ps = MySQLCosmetics.getConnection().prepareStatement("UPDATE cosmetics SET " + type + " = ?, playername = ? WHERE UUID = ?");
				ps.setString(1, cosmetic);
				ps.setString(2, player.getName());
				ps.setString(3, player.getUniqueId().toString().replaceAll("-", ""));
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				PreparedStatement ps = MySQLCosmetics.getConnection().prepareStatement("INSERT INTO cosmetics (UUID,playername," + type + ") VALUES (?,?,?)");
				ps.setString(1, player.getUniqueId().toString().replaceAll("-", ""));
				ps.setString(2, player.getName());
				ps.setString(3, cosmetic);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void deactivate(Player player, String type) {
		if (isUserExists(player)) {
			try {
				PreparedStatement ps = MySQLCosmetics.getConnection().prepareStatement("UPDATE cosmetics SET " + type + " = ?, playername = ? WHERE UUID = ?");
				ps.setString(1, null);
				ps.setString(2, player.getName());
				ps.setString(3, player.getUniqueId().toString().replaceAll("-", ""));
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				PreparedStatement ps = MySQLCosmetics.getConnection().prepareStatement("INSERT INTO cosmetics (UUID,playername," + type + ") VALUES (?,?,?)");
				ps.setString(1, player.getUniqueId().toString().replaceAll("-", ""));
				ps.setString(2, player.getName());
				ps.setString(3, null);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static String get(String uuid, String type) {
		try {
			PreparedStatement ps = MySQLCosmetics.getConnection().prepareStatement("SELECT " + type + " FROM cosmetics WHERE UUID = ?");
			ps.setString(1, uuid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
