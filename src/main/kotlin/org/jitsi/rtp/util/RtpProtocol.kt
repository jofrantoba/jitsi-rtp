/*
 * Copyright @ 2018 Atlassian Pty Ltd
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
package org.jitsi.rtp.util

import org.jitsi.rtp.Packet
import org.jitsi.rtp.RtpProtocolPacket
import unsigned.toUInt
import java.nio.ByteBuffer

class RtpProtocol {
    companion object {
        private fun getPacketType(buf: ByteBuffer): Int = buf.get(1).toUInt()
        fun isRtp(buf: ByteBuffer): Boolean {
            return when (getPacketType(buf)) {
                in 200..211 -> false
                else -> true
            }
        }
        fun isRtcp(buf: ByteBuffer): Boolean = !isRtp(buf)
    }
}