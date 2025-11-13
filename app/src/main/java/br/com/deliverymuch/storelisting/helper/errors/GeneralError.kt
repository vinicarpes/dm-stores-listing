package br.com.deliverymuch.storelisting.helper.errors

interface ErrorCode {
    val rawCode: String
    val rawMessage: String? get() = null
}