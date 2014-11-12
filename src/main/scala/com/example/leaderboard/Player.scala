package com.example.leaderboard.leaderboard
import Countries.{ Value => Country }

object Player {
  type PlayerId = Int
}

import Player.PlayerId

case class Player(id: PlayerId, nickname: String, country: Country)
