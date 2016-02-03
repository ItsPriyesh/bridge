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

import org.scalatest.{Matchers, FunSuite}

class BridgeTest extends FunSuite with Matchers {

  val ValidAdb = getClass.getResource("/platform-tools/adb").getPath
  val InvalidAdb = "some_invalid_stuff"

  test("Test ADB devices") {
    val validBridge = new Bridge(new AdbExecutor(ValidAdb))
    val invalidBridge = new Bridge(new AdbExecutor(InvalidAdb))

    assert(validBridge devices() isDefined)
    assert(invalidBridge devices() isEmpty)
  }
}
