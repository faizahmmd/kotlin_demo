package com.example.kotlin_demo.utils

open class AppException : Exception {
    constructor(message: String? = "Something went wrong", statusCode: Int?=null, response: Any?=null)
}

class ServerException: AppException{
constructor(message: String? = "Something went wrong") : super(message = message)
}

class ClientException: AppException{
constructor(message: String? = "Something went wrong", statusCode: Int?, response: Any?) : super(message = message, statusCode = statusCode, response = response)
}

class HttpException: AppException{
constructor(message: String? = "Something went wrong", statusCode: Int?) : super(message = message, statusCode = statusCode)
}