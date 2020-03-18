package com.tboy.domain.interactor.base

import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Single --> We need only one emit on the RX flow
 */
abstract class SingleUseCase<T> : UseCase() {

    fun subscribe(onError: ((Throwable) -> Unit), onSuccess: ((T) -> Unit)): Disposable {
        return build()
            .subscribeOn(Schedulers.from(threadExecutor))
            .subscribe(onSuccess, onError)
    }

    protected abstract fun build(): Single<T>
}