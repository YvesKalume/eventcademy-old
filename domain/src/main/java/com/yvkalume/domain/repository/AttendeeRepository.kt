/*
 * Copyright (c) 2022 EventCademy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yvkalume.domain.repository

import com.yvkalume.domain.entity.Attendee
import com.yvkalume.util.Result
import kotlinx.coroutines.flow.Flow

interface AttendeeRepository {
    fun attendeeToAnEvent(attendee: Attendee)
    fun checkIfIsAttending(docUid: String) : Flow<Result<Boolean>>
    fun getAttendeesByEventUid(eventUid: String) : Flow<Result<List<Attendee>>>
}