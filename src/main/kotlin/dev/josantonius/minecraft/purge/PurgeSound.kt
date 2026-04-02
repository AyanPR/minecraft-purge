package dev.josantonius.minecraft.purge

import org.bukkit.Bukkit
import net.kyori.adventure.sound.SoundStop
import net.kyori.adventure.sound.Sound as AdventureSound

class PurgeSound(private val plugin: Main) {
    fun playPurgeSound(customSound: String?) {
        if (customSound == null) return
        for (player in Bukkit.getOnlinePlayers()) {
            player.playSound(player.location, customSound, SoundCategory.MASTER, 1.0f, 1.0f)
        }
    }

    fun playAnnouncePurgeSound() {
        playPurgeSound(plugin.configuration.getAnnouncePurgeSound())
    }

    fun playOngoingPurgeSound() {
        playPurgeSound(plugin.configuration.getOngoingPurgeSound())
    }

    fun playEndPurgeSound() {
        playPurgeSound(plugin.configuration.getEndPurgeSound())
    }

    fun stopMinecraftMusic() {
        for (player in Bukkit.getOnlinePlayers()) {
            player.stopSound(SoundStop.source(AdventureSound.Source.MUSIC))
        }
    }

    fun stopPluginMusic() {
        for (player in Bukkit.getOnlinePlayers()) {
            player.stopSound(SoundStop.source(AdventureSound.Source.MASTER))
        }
    }
}
