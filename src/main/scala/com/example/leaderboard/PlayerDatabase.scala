package com.example.leaderboard.leaderboard
import Player.PlayerId

trait PlayerDatabase {
  def getPlayerById(playerId: PlayerId): Player
}
