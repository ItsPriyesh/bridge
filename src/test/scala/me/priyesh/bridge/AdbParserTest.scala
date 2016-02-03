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

import me.priyesh.bridge.models.Device
import me.priyesh.bridge.parsing.AdbParser
import org.scalatest.{FunSuite, Matchers}

class AdbParserTest extends FunSuite with Matchers {

  test("Parse adb devices, with multiple devices connected") {
    val device1 = new Device("emulator-5554", "offline")
    val device2 = new Device("07f37d0d00fd6b40", "device")
    val adbDevicesOutput = s"List of devices attached\n${device1.serialNumber}\t${device1.state}\n${device2.serialNumber}\t${device2.state}\n"

    val devices = AdbParser.parseDevices(adbDevicesOutput)
    assert(devices.size == 2)
    assert(devices contains device1)
    assert(devices contains device2)
  }

  test("Parse adb devices, with no devices connected") {
    val adbDevicesOutput = "List of devices attached\n"
    val devices = AdbParser.parseDevices(adbDevicesOutput)
    assert(devices.isEmpty)
  }
}
