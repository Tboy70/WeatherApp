package com.tboy.domain.interactor.base.parametrized

import com.tboy.domain.interactor.base.UseCase
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class ObservableParametrizedUseCase<T, P> : UseCase() {

    fun subscribe(
        params: P,
        onError: ((Throwable) -> Unit),
        onComplete: (() -> Unit),
        onNext: ((T) -> Unit)
    ): Disposable {
        return build(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .subscribe(onNext, onError, onComplete)
    }

    protected abstract fun build(params: P): Observable<T>
}