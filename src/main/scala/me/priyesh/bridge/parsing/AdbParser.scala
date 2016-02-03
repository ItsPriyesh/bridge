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

package me.priyesh.bridge.parsing

import me.priyesh.bridge.models.Device

object AdbParser {

  val DevicePattern = "(.*)\t([a-zA-z]+)".r
  val FileNotFoundPattern = "remote object '.*' does not exist".r

  def parseDevices(string: String): List[Device] = string.trim.split("\n").toList.drop(1) map {
    case DevicePattern(serialNumber, state) => new Device(serialNumber, state)
  }

 /* def parsePull(string: String): List[File] = {
    string.map {
      case FileNotFoundPattern => List()
      case _ => List()
    }
  }*/
}
