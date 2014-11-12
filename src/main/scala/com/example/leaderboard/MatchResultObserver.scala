package com.example.leaderboard.leaderboard
import Player.PlayerId

case class MatchResult(winner: PlayerId, loser: PlayerId)

class MatchResultObserver(
  playerDatabase: PlayerDatabase,
  countryLeaderBoard: CountryLeaderboard) {

  def recordMatchResult(result: MatchResult): Unit = {
    val player = playerDatabase.getPlayerById(result.winner)
    countryLeaderBoard.addVictoryForCountry(player.country)
  }
}

