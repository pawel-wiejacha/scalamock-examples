package com.example.leaderboard.leaderboard

import Countries.{ Value => Country }
import Player.PlayerId

trait DbConnectionPool
trait DatabaseConfig
trait SecurityManager
trait TransactionManager

class RealPlayerDatabase(
  dbConnectionPool: DbConnectionPool,
  databaseConfig: DatabaseConfig,
  securityManager: SecurityManager,
  transactionManager: TransactionManager) extends PlayerDatabase {

  override def getPlayerById(playerId: PlayerId) = ???
}

class RealCountryLeaderboard(
  dbConnectionPool: DbConnectionPool,
  databaseConfig: DatabaseConfig,
  transactionManager: TransactionManager) extends CountryLeaderboard {

  override def addVictoryForCountry(country: Country): Unit = ???
  override def getTopCountries(): List[CountryLeaderboardEntry] = ???
}
