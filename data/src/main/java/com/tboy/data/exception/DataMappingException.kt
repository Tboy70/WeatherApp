package com.tboy.data.exception

import com.tboy.domain.exception.BaseException

class DataMappingException : BaseException {
    constructor() : super()

    constructor(code: Int) : super(code)

    constructor(message: String, code: Int) : super(message, code)
}