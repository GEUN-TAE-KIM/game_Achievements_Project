package org.cream.geuntae_hobby.ui.common

import androidx.lifecycle.Observer

// 구글에서 남김 아키텍쳐 코드
class Event<T>(private val content: T) {

    private var hasBeenHandled = false

    // 이전에 Observe한 값은 처리하지 않는 것
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}

class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit) : Observer<Event<T>> {

    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandled()?.let {
            onEventUnhandledContent(it)
        }
    }

}







