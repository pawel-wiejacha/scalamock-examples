package com.example.leaderboard

import com.example.leaderboard.leaderboard._
import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec

class MatchResultObserverTest extends FlatSpec with MockFactory {

  val winner = Player(id = 222, nickname = "boris", country = Countries.Russia)
  val loser = Player(id = 333, nickname = "hans", country = Countries.Germany)

  "MatchResultObserver" should "update PlayerLeaderBoard after finished match" in {
    val countryLeaderBoardMock = mock[CountryLeaderboard]
    val userDetailsServiceStub = stub[PlayerDatabase]

    // set expectations
    (countryLeaderBoardMock.addVictoryForCountry _).expects(Countries.Russia)

    // configure stubs
    (userDetailsServiceStub.getPlayerById _) when loser.id returns loser
    (userDetailsServiceStub.getPlayerById _) when winner.id returns winner

    // run system under test
    val matchResultObserver = new MatchResultObserver(userDetailsServiceStub, countryLeaderBoardMock)
    matchResultObserver.recordMatchResult(MatchResult(winner = winner.id, loser = loser.id))
  }
}
