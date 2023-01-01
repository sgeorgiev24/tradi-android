package com.github.sgeorgiev24.tradi.repository.extensions

import com.github.sgeorgiev24.tradi.cache.util.CacheResult
import com.github.sgeorgiev24.tradi.model.state.DataState
import com.github.sgeorgiev24.tradi.model.state.StateEvent
import com.github.sgeorgiev24.tradi.model.state.Success
import com.github.sgeorgiev24.tradi.model.state.buildError
import com.github.sgeorgiev24.tradi.model.state.buildSuccessData
import com.github.sgeorgiev24.tradi.model.state.Error

fun <T> CacheResult<T>.toDataState(
    event: StateEvent,
    // Default, used if we will display data without displaying anything
    successMessage: Success? = null,
): DataState<T> {
    return when (this) {
        is CacheResult.Success -> buildSuccessData(
            data = this.data,
            stateEvent = event,
            messageType = successMessage
        )
        is CacheResult.Error.Timeout -> buildError(
            message = "Request has timed out.",
            stateEvent = event,
            messageType = Error.General.Timeout
        )
        is CacheResult.Error.Generic -> buildError(
            message = "Unable to retrieve storage data.",
            stateEvent = event,
            messageType = Error.General.Unknown
        )
    }
}

fun <T, A> CacheResult<T>.toDataState(
    event: StateEvent,
    // Default, used if we will display data without displaying anything
    successMessage: Success? = null,
    map: (T) -> A
): DataState<A> {
    return when (this) {
        is CacheResult.Success -> buildSuccessData(
            data = map(this.data),
            stateEvent = event,
            messageType = successMessage
        )
        is CacheResult.Error.Timeout -> buildError(
            message = "Request has timed out.",
            stateEvent = event,
            messageType = Error.General.Timeout
        )
        is CacheResult.Error.Generic -> buildError(
            message = "Unable to retrieve storage data.",
            stateEvent = event,
            messageType = Error.General.Unknown
        )
    }
}