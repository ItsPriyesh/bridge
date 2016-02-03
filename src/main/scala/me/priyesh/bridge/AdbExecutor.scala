/*
 * Copyright 2016 Priyesh Patel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.priyesh.bridge

import scala.sys.process._
import scala.util.{Failure, Success, Try}

class AdbExecutor(val adb: String = "adb") {

  private val HappyExitCodes = Set(0, 1)

  def run(command: String): Option[String] = Try(adb !) match {
    case Failure(exception) => None
    case Success(exitCode) =>
      if (HappyExitCodes contains exitCode) Some(s"$adb $command" !!)
      else None
  }
}