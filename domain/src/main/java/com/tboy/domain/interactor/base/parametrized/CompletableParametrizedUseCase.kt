package com.tboy.domain.interactor.base.parametrized

import com.tboy.domain.interactor.base.UseCase
import io.reactivex.Completable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class CompletableParametrizedUseCase<P> : UseCase() {

    fun subscribe(params: P, onError: ((Throwable) -> Unit), onComplete: (() -> Unit)): Disposable {
        return build(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .subscribe(onComplete, onError)
    }

    protected abstract fun build(params: P): Completable
}