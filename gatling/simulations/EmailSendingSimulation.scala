package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import java.util.UUID

class EmailSendingSimulation extends Simulation {

  val EmailCount: Int = 10
  val RepeatCount: Int = 3
  val UsersPerSec: Int = 100
  val DurationInSeconds: Int = 30

  val apiUrls: Map[String, String] = Map(
    "singleThreaded" -> "http://api-singlethreaded:8080/send-emails-single-threaded",
    "reactive" -> "http://api-reactive:8080/send-emails-reactive",
    "multiThreaded" -> "http://api-multithreading:8080/send-emails-multi-threaded"
  )

  def generateEmails(count: Int): Seq[String] = {
    (1 to count).map { _: Int =>
      s""""${UUID.randomUUID()}@example.com""""
    }
  }

  val preGeneratedEmailList: String = generateEmails(EmailCount).mkString("[", ",", "]")

  def emailScenario(scenarioName: String, apiUrl: String) = {
    scenario(scenarioName)
      .repeat(RepeatCount) {
        exec(http(s"Send Email Request - $scenarioName")
          .post(apiUrl)
          .header("Content-Type", "application/json")
          .body(StringBody(preGeneratedEmailList))
          .check(status.is(200))
        )
      }
  }

  val scnReactive = emailScenario("Reactive API", apiUrls("reactive"))
  val scnMultiThreading = emailScenario("MultiThreading API", apiUrls("multiThreaded"))
  val scnSingleThreaded = emailScenario("Single Threaded API", apiUrls("singleThreaded"))

  setUp(
    scnReactive.inject(constantUsersPerSec(UsersPerSec) during (DurationInSeconds.seconds)),
    scnMultiThreading.inject(constantUsersPerSec(UsersPerSec) during (DurationInSeconds.seconds)),
    scnSingleThreaded.inject(constantUsersPerSec(UsersPerSec) during (DurationInSeconds.seconds))
  )
}
