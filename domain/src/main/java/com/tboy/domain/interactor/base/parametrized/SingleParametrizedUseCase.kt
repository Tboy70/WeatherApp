package com.tboy.domain.interactor.base.parametrized

import com.tboy.domain.interactor.base.UseCase
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class SingleParametrizedUseCase<T, P> : UseCase() {

    fun subscribe(params: P, onError: ((Throwable) -> Unit), onSuccess: ((T) -> Unit)): Disposable {
        return build(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .subscribe(onSuccess, onError)
    }

    protected abstract fun build(params: P): Single<T>
}